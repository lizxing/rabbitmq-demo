package com.lizxing.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lizxing
 * @date 2020/10/21
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue Queue2() {
        return new Queue("Queue_test2");
    }


    /**
     * ------以下测试Topic模式
     * @return
     */
    @Bean
    public Queue topicQueue1() {
        // 创建一个名为topic.aaa的队列
        return new Queue("topic.aaa");
    }

    @Bean
    public Queue topicQueue2() {
        // 创建一个名为topic.bbb的队列
        return new Queue("topic.bbb");
    }

    @Bean
    TopicExchange topicExchange() {
        // 创建一个名为topic的交换机，类型为TopicExchange模型
        return new TopicExchange("topic");
    }

    @Bean
    Binding bindingExchangeA(Queue topicQueue1, TopicExchange topicExchange) {
        // 生产者向名为topic.xxx的路由键发送的消息都可以转发到topicQueue1队列
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("topic.*");
    }

    @Bean
    Binding bindingExchangeB(Queue topicQueue2, TopicExchange topicExchange) {
        // 生产者向名为topic.xxx、topic.xxx.xxx等等的路由键发送的消息都可以转发到topicQueue2队列
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("topic.#");
    }



    /**
     * ------以下测试Fanout模式
     * @return
     */
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout.aaa");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout.bbb");
    }

    @Bean
    public Queue fanoutQueue3() {
        return new Queue("fanout.ccc");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout");
    }

    @Bean
    Binding bindingExchange1(Queue fanoutQueue1,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchange2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchange3(Queue fanoutQueue3, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange);
    }



    /**
     * ------以下测试Direct模式
     * @return
     */
    @Bean
    public Queue directQueue1() {
        return new Queue("direct.aaa");
    }

    @Bean
    public Queue directQueue2() {
        return new Queue("direct.bbb");
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("direct");
    }

    @Bean
    Binding bindingExchange4(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("aaa");
    }

    @Bean
    Binding bindingExchange5(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("bbb");
    }
}
