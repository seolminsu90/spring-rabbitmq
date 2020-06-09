package com.delay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class DelayExchangeApplication {

    /**
     * [rabbitmq-delayed-message-exchange] 플러그인을 설치해야 한다.
     * 
     * 다운 받은 후 ez 파일을 /plugins 폴더에 넣어주고 다음 명령어 실행
     * 
     * rabbitmq-plugins enable rabbitmq_delayed_message_exchange
     * 
     * 참조 :
     * https://www.diycode.cc/projects/rabbitmq/rabbitmq-delayed-message-exchange
     */
    public static void main(String[] args) {
        SpringApplication.run(DelayExchangeApplication.class, args);
    }

}
