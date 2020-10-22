package com.lizxing.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lizxing
 * @date 2020/10/22
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue orderQueue() {
        return new Queue("queue.order");
    }

    @Bean
    DirectExchange orderExchange() {
        return new DirectExchange("exchange.order");
    }

    @Bean
    Binding bindingOrderExchange(Queue orderQueue, DirectExchange orderExchange) {
        return BindingBuilder.bind(orderQueue).to(orderExchange).with("order");
    }

}
