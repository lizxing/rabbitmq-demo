package com.lizxing.producer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void send1(){
        String msg = "msg_test1";
        rabbitTemplate.convertAndSend("Queue_test1", msg);
    }

    @Test
    void send2(){
        String msg = "msg_test2_";
        for (int i = 1; i <= 30; i++){
            rabbitTemplate.convertAndSend("Queue_test2", msg + i);
        }
    }

    @Test
    void send3(){
        String msg = "msg_test3";
        rabbitTemplate.convertAndSend("topic","topic.abcd", msg);
    }

    @Test
    void send4(){
        String msg = "msg_test4";
        rabbitTemplate.convertAndSend("topic","topic.abcd.efg", msg);
    }

    @Test
    void send5(){
        String msg = "msg_test5";
        rabbitTemplate.convertAndSend("fanout","", msg);
    }

    @Test
    void send6(){
        String msg = "msg_test6";
        rabbitTemplate.convertAndSend("fanout","fanout.aaa", msg);
    }

    @Test
    void send7(){
        String msg = "msg_test7";
        rabbitTemplate.convertAndSend("fanout","xxx", msg);
    }

    @Test
    void send8(){
        String msg = "msg_test8";
        rabbitTemplate.convertAndSend("direct","xxx", msg);
    }

    @Test
    void send9(){
        String msg = "msg_test9";
        rabbitTemplate.convertAndSend("direct","aaa", msg);
    }
}
