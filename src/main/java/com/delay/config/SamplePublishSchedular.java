package com.delay.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// Message가 Publish 되는 상황을 가정한 스케쥴러
@Component
public class SamplePublishSchedular {

    @Value("${rabbit.remote.sample.routekey}")
    String sampleRouteKey;

    @Value("${rabbit.remote.sample.queue}")
    String sampleQueue;

    @Value("${rabbit.remote.sample.exchange}")
    String sampleExchange;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 5000)
    public void publishTest() {
        // 메시지 예시 객체
        Map<String, Object> test = new HashMap<>();
        test.put("name", "seol");
        test.put("age", 10);

        // delay 시간 이후에 메시지를 수신할 수 있다
        // x초 후 재시도 등의 상황 시 지연 된 메시지가 필요할 수 있음
        int delay = 15000;

        // 메시지 전송
        rabbitTemplate.convertAndSend(sampleExchange, sampleRouteKey, test, m -> {
            m.getMessageProperties().getHeaders().put("x-delay", delay);
            return m;
        });
    }
}
