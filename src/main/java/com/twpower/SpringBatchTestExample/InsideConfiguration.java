package com.twpower.SpringBatchTestExample;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@RequiredArgsConstructor
public class InsideConfiguration {

    @Value("${inside.value}")
    private String insideValue;

    public int multiple(int a, int b) {
        return a * b;
    }

}
