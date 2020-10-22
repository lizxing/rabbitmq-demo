package com.lizxing.log.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lizxing
 * @date 2020/10/22
 */
@Data
public class UserOperation implements Serializable {

    private String username;

    private String ip;

    private String operation;

    private Date date;

    public UserOperation(String username, String ip, String operation, Date date) {
        this.username = username;
        this.ip = ip;
        this.operation = operation;
        this.date = date;
    }
}
