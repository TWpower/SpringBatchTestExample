package com.twpower.SpringBatchTestExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DemoConfigurationUnitTest {

    @InjectMocks
    private DemoConfiguration demoConfiguration;

    @Test
    public void testSum() {
        Assertions.assertSame(demoConfiguration.sum(1, 2), 1 + 2);
    }

}