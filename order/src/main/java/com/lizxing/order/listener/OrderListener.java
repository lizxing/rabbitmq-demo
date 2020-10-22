package com.lizxing.order.listener;

import com.lizxing.order.pojo.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lizxing
 * @date 2020/10/22
 */
@Component
public class OrderListener {

    @RabbitListener(queues = "queue.order")
    private void orderReceiver(Order order){
        System.out.println("订单接收者接收到信息：" + order.toString());
        handle(order);
    }

    private void handle(Order order){
        // 模拟写入数据库
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("库存系统已扣减");
    }
}
