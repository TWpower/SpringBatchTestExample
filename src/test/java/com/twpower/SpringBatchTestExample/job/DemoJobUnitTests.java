package com.twpower.SpringBatchTestExample.job;

import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.builder.JobFlowBuilder;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {DemoJob.class})
public class DemoJobUnitTests {

    @Mock
    public JobBuilderFactory jobBuilderFactory;

    @Mock
    public StepBuilderFactory stepBuilderFactory;

    @Mock
    private JobBuilder jobBuilder;

    @Mock
    private Step step;

    @Mock
    private StepBuilder stepBuilder;

    @Mock
    private Job job;

    @InjectMocks
    private DemoJob demoJob;

    @Test
    public void testDemoJobIsNull() {
        System.out.println(demoJob.toString());
        Assert.assertNotNull(demoJob);
    }

    @Test
    public void testReturnString() {
        Assert.assertEquals("test", demoJob.returnString("test"));
    }

}
