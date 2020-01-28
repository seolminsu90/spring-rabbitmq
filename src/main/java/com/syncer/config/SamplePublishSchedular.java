package com.syncer.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SamplePublishSchedular {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    // 데이터 publish 테스트를 위한 작업 스케쥴러
    @Scheduled(fixedDelay = 5000)
    public void publishTest() {
        rabbitTemplate.convertAndSend("Publish Message !!!");
    }
}
