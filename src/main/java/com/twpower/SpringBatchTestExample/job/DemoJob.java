package com.twpower.SpringBatchTestExample.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
//@ConditionalOnExpression("'${type}' == 'demo'")
public class DemoJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job demo() {
        return jobBuilderFactory.get("demo-job")
                .start(demoStep1())
                .next(demoStep2())
                .build();
    }

    public String returnString (String sample) {
        return sample;
    }

    public Step demoStep1() {
        return stepBuilderFactory.get("demo-step-1")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Do Something 1");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    public Step demoStep2() {
        return stepBuilderFactory.get("demo-step-2")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Do Something 2");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
