package com.twpower.SpringBatchTestExample.job;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
public class DemoJobUnitTests {

    @MockBean
    private JobBuilderFactory jobBuilderFactory;

    @MockBean
    private StepBuilderFactory stepBuilderFactory;

    @InjectMocks
    private DemoJob demoJob;

    @Test
    public void testSimple() {
        Assertions.assertTrue(true);
    }

    @Test
    public void testDemoJobIsNull() {
        Assertions.assertNotNull(demoJob);
    }

    @Test
    public void testReturnString() {
        Assertions.assertEquals("test", demoJob.returnString("test"));
    }

}
