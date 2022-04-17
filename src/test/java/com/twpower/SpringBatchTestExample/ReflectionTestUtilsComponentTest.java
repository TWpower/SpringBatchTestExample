package com.twpower.SpringBatchTestExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class ReflectionTestUtilsComponentTest {

    @InjectMocks
    ReflectionTestUtilsComponent reflectionTestUtilsComponent;

    @Test
    public void testPrivateValue() {
        ReflectionTestUtils.setField(reflectionTestUtilsComponent, "privateValue", 100);
        // ReflectionTestUtils.setField(target object, "variable name", target value);

        Assertions.assertEquals(100, reflectionTestUtilsComponent.getPrivateValue());
    }

    @Test
    public void testPrivateMethod() {
        ReflectionTestUtils.setField(reflectionTestUtilsComponent, "privateValue", 100);
        // ReflectionTestUtils.setField(target object, "variable name", target value);

        Assertions.assertEquals(103, (Integer) ReflectionTestUtils.invokeMethod(reflectionTestUtilsComponent, "privateMethod", 1, 2));
        // ReflectionTestUtils.invokeMethod(target object, "method(function) name", arguments);

        Assertions.assertEquals(103, reflectionTestUtilsComponent.getPrivateValue());
    }
}