package com.delay.listener;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SampleListener {
    @Async
    @RabbitListener(queues = "${rabbit.remote.sample.queue}")
    public void sampleDataConsumer(@Payload Map<String, Object> data) { // Publish된 데이터 형식과 맞게 Payload 객체 설정
        log.info("Get {} ", data);
    }
}
