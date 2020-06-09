# Spring-rabbitmq sample

##### - 설명

###### rabbitmq 활용 하면서 재시도 관련 로직 적용이 필요했음
###### delayed 시간 이후에 메시지 전달 받는 exchange에 대한 샘플 프로젝트를 담음


##### - 지연 플러그인 설치

`https://www.rabbitmq.com/community-plugins.html` 에서 
`rabbitmq-delayed-message-exchange` 다운로드

###### 다운받은 ez 파일을 /plugins 폴더 안에 넣는다.

##### - 플러그인 적용

```bash
rabbitmq-plugins enable rabbitmq_delayed_message_exchange
```