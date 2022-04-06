package com.twpower.SpringBatchTestExample;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@RequiredArgsConstructor
public class DemoConfiguration {

    @Value("${config.value}")
    private String sampleValue;

    private InsideConfiguration insideConfiguration;

    public int sum(int a, int b) {
        return a + b;
    }

    public int multiple(int a, int b) {
        return insideConfiguration.multiple(a, b);
    }

    public String getInsideValue() {
        return insideConfiguration.getInsideValue();
    }
}
