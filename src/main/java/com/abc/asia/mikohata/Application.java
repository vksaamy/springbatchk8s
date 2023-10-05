package com.abc.asia.mikohata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.abc.asia.mikohata.config.ApplicationProperties;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan({"com.abc.asia.mikohata.config", "com.abc.asia.mikohata.fillbagbatchjob.security"})
@EnableConfigurationProperties({ApplicationProperties.class})
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    // @Autowired private JobLauncher jobLauncher;

    // @Qualifier(BatchJobConfiguration.ADD_PROFILE_JOB)
    // @Autowired    Job job;

    @Autowired private ConfigurableApplicationContext context;

    //@Autowired PrometheusPushGatewayManager prometheusPushGatewayManager;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    /*

        @Override
        public void run(String... args) {
            try {
                log.debug("Job runner called");
                JobParameters jobParameters =
                        new JobParametersBuilder().addDate("start-date", new Date()).toJobParameters();
                this.jobLauncher.run(job, jobParameters);
            } catch (Exception e) {
                log.error("Error running batch job " + e);
            } finally {
                System.exit(SpringApplication.exit(context));
            }
        }
    */
    public int getExitCode() {
        return 0;
    }
}
