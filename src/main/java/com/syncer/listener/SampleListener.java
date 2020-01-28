package com.syncer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SampleListener {
    //설정해놓은 exchange -> route key 로부터 데이터를 읽어옴
    @Async
    @RabbitListener(queues = "${rabbit.remote.sample.queue}")
    public void sampleDataConsumer(@Payload Object data) {
        log.info("Get {} ", data);
    }
}
