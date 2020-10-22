package com.lizxing.log.controller;

import com.lizxing.log.pojo.UserOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author lizxing
 * @date 2020/10/22
 */
@RestController
public class UserController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/login")
    private String login(String username, String password, HttpServletRequest httpServletRequest){
        if (login(username)){
            UserOperation userOperation = new UserOperation(username, httpServletRequest.getRemoteAddr(), "用户登录", new Date());
            rabbitTemplate.convertAndSend("exchange.log","log", userOperation);
            return "login success";
        }
        return "login fail";
    }

    @PutMapping("/nickname")
    private String modifyNickname(String username, String nickname, HttpServletRequest httpServletRequest){
        if (modifyNickname(nickname)){
            UserOperation userOperation = new UserOperation(username, httpServletRequest.getRemoteAddr(), "修改昵称", new Date());
            rabbitTemplate.convertAndSend("exchange.log", "log", userOperation);
            return "modify nickname success";
        }
        return "modify nickname fail";
    }

    private boolean login(String username){
        // 模拟数据库操作
        return !StringUtils.isEmpty(username);
    }

    private boolean modifyNickname(String nickname){
        // 模拟数据库操作
        return !StringUtils.isEmpty(nickname);
    }
}
