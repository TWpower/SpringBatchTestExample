package com.twpower.SpringBatchTestExample;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ReflectionTestUtilsComponent {

    private int privateValue;

    private int privateMethod(int a, int b) {
        privateValue += a;
        privateValue += b;
        return privateValue;
    }
}
