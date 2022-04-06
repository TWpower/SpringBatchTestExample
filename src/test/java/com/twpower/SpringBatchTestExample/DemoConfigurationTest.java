package com.twpower.SpringBatchTestExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class DemoConfigurationTest {

    @Mock
    InsideConfiguration insideConfiguration;

    @InjectMocks
    DemoConfiguration demoConfiguration;

    @Test
    public void testGetter() {

        when(insideConfiguration.getInsideValue()).thenReturn("test");
        Assertions.assertSame(demoConfiguration.getInsideValue(), "test");

    }
}