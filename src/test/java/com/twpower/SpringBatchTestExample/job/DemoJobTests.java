package com.twpower.SpringBatchTestExample.job;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoJob.class, DemoJobTestConfig.class})
@TestPropertySource("classpath:application-demo-job-test.properties")
public class DemoJobTests {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testDemoJobDemoStep1() {
        JobExecution jobExecution = jobLauncherTestUtils.launchStep("demo-step-1");
        Assert.assertSame(jobExecution.getStatus(), BatchStatus.COMPLETED);
    }

    @Test
    public void testDemoJobComplete() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder(jobLauncherTestUtils.getUniqueJobParameters()).toJobParameters();

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
        Assert.assertSame(jobExecution.getStatus(), BatchStatus.COMPLETED);
    }
}
