package com.twpower.SpringBatchTestExample;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@RequiredArgsConstructor
public class DemoConfiguration {

    public int sum(int a, int b) {
        return a + b;
    }
}
