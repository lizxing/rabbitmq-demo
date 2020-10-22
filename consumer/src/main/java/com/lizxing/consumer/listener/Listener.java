package com.lizxing.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lizxing
 * @date 2020/10/21
 */
@Component
public class Listener {

    @RabbitListener(queues = "Queue_test1")
    private void receiver(String msg){
        System.out.println("接收到信息：" + msg);
    }

    @RabbitListener(queues = "Queue_test2")
    private void receiver1(String msg){
        System.out.println("接收者1号接收到信息：" + msg);
    }

    @RabbitListener(queues = "Queue_test2")
    private void receiver2(String msg){
        System.out.println("接收者2号接收到信息：" + msg);
    }

    @RabbitListener(queues = "topic.aaa")
    private void receiver3(String msg){
        System.out.println("接收者3号接收到信息：" + msg);
    }

    @RabbitListener(queues = "topic.bbb")
    private void receiver4(String msg){
        System.out.println("接收者4号接收到信息：" + msg);
    }

    @RabbitListener(queues = "fanout.aaa")
    private void receiver5(String msg){
        System.out.println("接收者5号接收到信息：" + msg);
    }

    @RabbitListener(queues = "fanout.bbb")
    private void receiver6(String msg){
        System.out.println("接收者6号接收到信息：" + msg);
    }

    @RabbitListener(queues = "fanout.ccc")
    private void receiver7(String msg){
        System.out.println("接收者7号接收到信息：" + msg);
    }

    @RabbitListener(queues = "direct.aaa")
    private void receiver8(String msg){
        System.out.println("接收者8号接收到信息：" + msg);
    }

    @RabbitListener(queues = "direct.bbb")
    private void receiver9(String msg){
        System.out.println("接收者9号接收到信息：" + msg);
    }
}
