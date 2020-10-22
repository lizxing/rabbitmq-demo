package com.lizxing.log.listener;

import com.lizxing.log.pojo.UserOperation;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lizxing
 * @date 2020/10/22
 */
@Component
public class LogListener {

    @RabbitListener(queues = "queue.log")
    private void logReceiver(UserOperation userOperation){
        System.out.println("日志接收者接收到信息：" + userOperation.toString());
        writingLog(userOperation);
    }

    private void writingLog(UserOperation userOperation){
        // 模拟写入数据库
        System.out.println("写入数据库成功");
    }
}
