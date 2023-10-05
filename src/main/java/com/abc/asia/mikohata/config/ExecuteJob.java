package com.abc.asia.mikohata.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ExecuteJob {
    @Autowired JobLauncher jobLauncher;

    @Autowired
    @Qualifier(BatchJobConfiguration.ADD_PROFILE_JOB)
    Job job;

    public void execute() throws Exception {
        JobParameters params =
                new JobParametersBuilder()
                        .addString("JobID", String.valueOf(System.currentTimeMillis()))
                        .toJobParameters();
        jobLauncher.run(job, params);
    }
}
