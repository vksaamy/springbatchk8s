package com.abc.asia.mikohata.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    private static final Logger log =
            LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;
    long startTime = 0;
    long endTime = 0;

    @Autowired private JobRepository jobRepository;
    @Autowired private ConfigurableApplicationContext context;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Before job called with status" + jobExecution.getStatus());
        try {
            if (jobExecution.getStatus() == BatchStatus.STARTED) {
                startTime = System.currentTimeMillis();
                log.info("!!! JOB STARTED !!!");

                //			jdbcTemplate.query("SELECT first_name, last_name FROM people",
                //				(rs, row) -> new Person(
                //					rs.getString(1),
                //					rs.getString(2))
                //			).forEach(person -> log.info("Found <" + person + "> in the database."));
            }
        } catch (Exception e) {
            log.error("Error in begin batch job " + e);
        }
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        log.info("After job called");
        try {
            if (jobExecution.getStatus() == BatchStatus.COMPLETED
                    || jobExecution.getStatus() == BatchStatus.FAILED) {
                log.info("!!! JOB FINISHED! after " + (endTime - startTime) + " milli seconds");
                log.info("Job status " + jobExecution.isRunning());
                jobExecution.setExitStatus(new ExitStatus("0"));
                // context.close();

                //			jdbcTemplate.query("SELECT first_name, last_name FROM people",
                //				(rs, row) -> new Person(
                //					rs.getString(1),
                //					rs.getString(2))
                //			).forEach(person -> log.info("Found <" + person + "> in the database."));
            }
        } catch (Exception e) {
            log.error("Error in after batch job " + e);
        }
    }
}
