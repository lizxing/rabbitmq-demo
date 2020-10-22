package com.lizxing.order.controller;

import com.lizxing.order.pojo.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizxing
 * @date 2020/10/22
 */
@RestController
public class OrderController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/order")
    private String order(Order order){
        for (int i = 1; i <= 5; i++){
            order.setOrderId(i);
            rabbitTemplate.convertAndSend("exchange.order", "order", order);
            System.out.println("已生成订单，订单号：" + order.getOrderId());
        }
        return "order success";
    }
}
