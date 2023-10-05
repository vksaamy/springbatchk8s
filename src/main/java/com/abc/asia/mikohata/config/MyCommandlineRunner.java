package com.abc.asia.mikohata.config;

import java.util.Date;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandlineRunner implements CommandLineRunner {

    @Autowired private JobLauncher jobLauncher;

    @Qualifier(BatchJobConfiguration.ADD_PROFILE_JOB)
    @Autowired
    Job job;

    @Override
    public void run(String... args) throws Exception {
        JobParameters jobParameters =
                new JobParametersBuilder().addDate("start-date", new Date()).toJobParameters();
        this.jobLauncher.run(job, jobParameters);
    }
}
