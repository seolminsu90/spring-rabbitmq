package com.delay.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Exchange, Queue Bind 초기화. Rabbit 서버에 생성되있지 않은 경우 생성, 연결해준다.
@Configuration
public class SampleExchangeConfig {

    @Value("${rabbit.remote.sample.routekey}")
    String sampleRouteKey;

    @Value("${rabbit.remote.sample.queue}")
    String sampleQueue;

    @Value("${rabbit.remote.sample.exchange}")
    String sampleExchange;

    @Bean
    public Binding sampleBinding() {
        return BindingBuilder.bind(sampleQueue()).to(sampleExchange()).with(sampleRouteKey).noargs();
    }

    @Bean
    public Queue sampleQueue() {
        return QueueBuilder.durable(sampleQueue).withArgument("x-message-ttl", 10 * 60 * 1000).build(); // 10분 유효
    }

    @Bean
    public Exchange sampleExchange() {
        return ExchangeBuilder.directExchange(sampleExchange).delayed().build(); // delayed 설정 된 direct exchange

    }

}
