package com.syncer.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Value("${rabbit.remote.username}")
    String userName;

    @Value("${rabbit.remote.password}")
    String passWord;

    @Value("${rabbit.remote.server}")
    String server;

    @Value("${rabbit.remote.port}")
    int port;
    
    @Value("${rabbit.remote.sample.routekey}")
    String sampleRouteKey;

    @Value("${rabbit.remote.sample.exchange}")
    String sampleExchange;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(server, port);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(passWord);
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean("rabbitTemplate")
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setExchange(sampleExchange);
        template.setRoutingKey(sampleRouteKey);
        template.setMessageConverter(messageConverter());
        return template;
    }

}
