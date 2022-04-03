package com.twpower.SpringBatchTestExample.job;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoJob.class, DemoJobTestConfig.class})
@TestPropertySource("classpath:application-demo-job-test.properties")
public class DemoJobTests {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private ApplicationContext applicationContext;

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
