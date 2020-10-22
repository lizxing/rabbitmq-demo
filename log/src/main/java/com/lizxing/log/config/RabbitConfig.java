package com.lizxing.log.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lizxing
 * @date 2020/10/22
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue logQueue() {
        return new Queue("queue.log");
    }

    @Bean
    DirectExchange logExchange() {
        return new DirectExchange("exchange.log");
    }

    @Bean
    Binding bindingLogExchange(Queue logQueue, DirectExchange logExchange) {
        return BindingBuilder.bind(logQueue).to(logExchange).with("log");
    }
}
