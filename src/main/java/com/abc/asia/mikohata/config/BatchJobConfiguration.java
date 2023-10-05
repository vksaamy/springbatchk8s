package com.abc.asia.mikohata.config;

import com.abc.asia.mikohata.fillbagbatchjob.model.AgentExtApi;
import com.abc.asia.mikohata.fillbagbatchjob.model.AgentExtApiPage;
import com.abc.asia.mikohata.fillbagbatchjob.model.AgentSite;
import com.abc.asia.mikohata.fillbagbatchjob.security.TokenManager;
import com.abc.asia.mikohata.utils.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BatchJobConfiguration {

    //	public static void main(String[] args) throws Exception {
    //		//System.exit(SpringApplication.exit(SpringApplication.run(BatchJobConfiguration.class,
    // args)));
    //		SpringApplication.run(BatchJobConfiguration.class, args);
    //	}
    private static final Logger log = LoggerFactory.getLogger(BatchJobConfiguration.class);

    @Autowired private ApplicationContext context;
    @Autowired private Environment environment;

    @Autowired private JobCompletionNotificationListener completionListener;
    public static final String ADD_PROFILE_JOB = "addProfileJob";
    public static final int GRID_SIZE = 5;

    private ArrayList<AgentExtApi> agentExtApiList;
    public static final String PAGE_LIMIT = "50";
    public static final String AUTHORIZATION = "Authorization";

    private static final String AGENTEXTAPI_URL = "http://agentextapi";

    @Autowired private DiscoveryClient discoveryClient;
    @Autowired private TokenManager tokenManager;
    @Autowired ProfileUpdateWriter itemWriter;
    @Autowired private RestTemplate restTemplate;
    /*@Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncexecutoer = new SimpleAsyncTaskExecutor("spring_batch");
        asyncexecutoer.setConcurrencyLimit(1);
        return new SimpleAsyncTaskExecutor("spring_batch");
    }*/
    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncexecutoer = new SimpleAsyncTaskExecutor();
        // asyncexecutoer.setCorePoolSize(10);
        // asyncexecutoer.setConcurrencyLimit(1);
        return asyncexecutoer;
    }

    @Bean
    @StepScope
    public ItemReader reader(
            @Value("#{stepExecutionContext['minValue']}") int minValue,
            @Value("#{stepExecutionContext['maxValue']}") int maxValue) {
        log.debug("FillBagItemReader is called");
        String index = System.getenv("JOB_COMPLETION_INDEX");
        log.debug("JOB COMPLETION INDEX " + index);
        // int startrow=(Integer.parseInt(index)+1)*10-9;
        // FillBagItemReader cursorItemReader = new FillBagItemReader();
        ItemReader<ArrayList<AgentExtApi>> cursorItemReader = null;
        try {
            cursorItemReader =
                    new ItemReader<ArrayList<AgentExtApi>>() {

                        @Override
                        public ArrayList<AgentExtApi> read()
                                throws Exception, UnexpectedInputException, ParseException,
                                        NonTransientResourceException {
                            if (agentExtApiList.size() > 0) {
                                ArrayList<AgentExtApi> partitionedAgentExtApis =
                                        new ArrayList<AgentExtApi>();
                                // TODO Auto-generated method stub
                                log.debug("Min value" + minValue + " Max value " + maxValue);
                                for (int i = minValue; i <= maxValue; i++) {
                                    log.debug("inside forloop");
                                    AgentExtApi agentExtApi = agentExtApiList.get(i);
                                    partitionedAgentExtApis.add(agentExtApi);
                                    log.debug("uin : " + agentExtApi.getAppRefNo());
                                }
                                for (int i = minValue; i <= maxValue; i++) {
                                    agentExtApiList.remove(0);
                                    log.debug("Remove the item");
                                }
                                return partitionedAgentExtApis;
                            } else return null;
                        }
                    };
        } catch (Exception e) {
            log.error("Error in creating reader");
        }

        log.debug("Reader completed");
        /*try {
        	Thread.sleep(180000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }*/
        return cursorItemReader;
    }

    @Bean
    @StepScope
    public AddProfileItemProcessor processor() {

        log.debug("AddProfileItemProcessor Start");
        AddProfileItemProcessor processor = null;
        try {
            processor = new AddProfileItemProcessor();
            // String hostName = System.getenv("HOSTNAME");
            String threadName = Thread.currentThread().getName();
            log.debug("Thread name " + threadName);
            processor.setHostname(threadName);
            log.debug("AddProfileItemProcessor completed");
            /*try {
            	Thread.sleep(180000);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }*/
        } catch (Exception e) {
            log.error("Error in processor" + e);
        }
        return processor;
    }

    @Bean
    @StepScope
    public ProfileUpdateWriter profileUpdateWriter() throws Exception {
        try {
            ProfileUpdateWriter itemWriter = new ProfileUpdateWriter();
            return itemWriter;
        } catch (Exception e) {
            log.error("Error in writer " + e);
            return null;
        }
    }

    // slave step
    @Bean
    public Step slaveStep(
            JobRepository jobRepository, PlatformTransactionManager transactionManager)
            throws Exception {
        log.debug("Slave step called");
        TaskletStep step = null;
        try {
            step =
                    new StepBuilder("slaveStep", jobRepository)
                            .<ArrayList<AgentExtApi>, AgentSite>chunk(10, transactionManager)
                            .reader(reader(0, 0))
                            .processor(processor())
                            .writer(profileUpdateWriter())
                            .build();
            return step;
        } catch (Exception e) {
            log.error("Error in executing batch job");
            return null;
        }
    }

    @Bean(name = ADD_PROFILE_JOB)
    public Job partitionerJob(
            JobRepository jobRepository, PlatformTransactionManager transactionManager)
            throws Exception {
        log.debug("Partition job started");
        Job job = null;
        try {
            job =
                    new JobBuilder("partitioningJob", jobRepository)
                            .listener(completionListener)
                            .start(partitionStep(jobRepository, transactionManager))
                            .build();
            return job;
        } catch (Exception e) {
            return null;
        }
    }

    // Master step
    @Bean
    public Step partitionStep(
            JobRepository jobRepository, PlatformTransactionManager transactionManager)
            throws Exception {
        Step step = null;
        try {
            step =
                    new StepBuilder("partitionStep", jobRepository)
                            .partitioner("slaveStep", partitioner())
                            .step(slaveStep(jobRepository, transactionManager))
                            .gridSize(GRID_SIZE)
                            .taskExecutor(taskExecutor())
                            .build();
            return step;
        } catch (Exception e) {
            log.error("Error in partition step creation" + e);
            return null;
        }
    }

    @Bean
    public CustomRecordPartitioner partitioner() {

        CustomRecordPartitioner partitioner = new CustomRecordPartitioner();
        try {
            log.debug("Partitioner called");
            // agentExtApiList = getAgentExtApiList();
            agentExtApiList = new ArrayList<AgentExtApi>();
            agentExtApiList.add(getAgentExtApi(1));
            agentExtApiList.add(getAgentExtApi(2));

            /*agentExtApiList.add(getAgentExtApi(3));

            agentExtApiList.add(getAgentExtApi(4));

            agentExtApiList.add(getAgentExtApi(5));*/

            partitioner.setTotalRecords(agentExtApiList.size());
            partitioner.partition(GRID_SIZE);
        } catch (Exception e) {
            log.error("Error in partitioner" + e);
        }

        return partitioner;
    }

    private AgentExtApi getAgentExtApi(int count) {
        AgentExtApi agentExtApi = new AgentExtApi();
        agentExtApi.setAppRefNo("S4342342J" + count);
        return agentExtApi;
    }

    public ArrayList<AgentExtApi> getAgentExtApiList() throws Exception {

        log.debug("inside getAgentExtApiList");
        // RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        String page = "1";
        String token = "";
        if (tokenManager != null) {
            token = tokenManager.getAccessToken();
        }
        headers.set("Accept", "application/json");
        // log.debug("Bearer token" + token);
        headers.add(AUTHORIZATION, "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<AgentExtApiPage> response = null;
        String baseUrl = "";
        ArrayList<AgentExtApi> agentExtApis = new ArrayList<AgentExtApi>();

        if (Arrays.asList(environment.getActiveProfiles()).contains("test")
                || (Arrays.asList(environment.getActiveProfiles()).contains("local"))) {
            baseUrl =
                    AppConstants.WIREMOCK_URL + "/agentextapi/list/add/" + PAGE_LIMIT + "/" + page;
            try {
                log.debug("Calling agentextapi service through wiremock");
                response =
                        restTemplate.exchange(
                                baseUrl, HttpMethod.POST, entity, AgentExtApiPage.class);
                log.debug("Response from agentextapi from WIREMOCK " + response);
            } catch (Exception e) {
                log.error("Cant find server" + e);
            }

        } else {
            baseUrl = AGENTEXTAPI_URL + "/list/add/" + PAGE_LIMIT + "/" + page;
            try {
                response =
                        restTemplate.exchange(
                                baseUrl, HttpMethod.POST, entity, AgentExtApiPage.class);
                log.debug("Response from agentextapi" + response);
            } catch (Exception e) {
                log.error("Cant find server" + e);
            }
        }
        if (response != null) {
            ArrayList<AgentExtApi> agentExtApisRes = response.getBody();
            Iterator<AgentExtApi> itr = agentExtApisRes.iterator();
            while (itr.hasNext()) agentExtApis.add(itr.next());
        }
        /* while (response != null) {
            page = String.valueOf(Integer.parseInt(page) + 1);
            baseUrl = "http://agentextapi" + "/list/add/" + PAGE_LIMIT + "/" + page;
            response =
                    restTemplate.exchange(baseUrl, HttpMethod.POST, entity, AgentExtApiPage.class);
            if (response != null) {
                ArrayList<AgentExtApi> agentExtApisRes = response.getBody();
                Iterator<AgentExtApi> itr = agentExtApisRes.iterator();
                while (itr.hasNext()) agentExtApis.add(itr.next());
            }
        }*/
        if (agentExtApis != null) log.debug("agentExtApis size" + agentExtApis.size());
        return agentExtApis;
    }
}
