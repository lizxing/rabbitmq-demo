package com.lizxing.order.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lizxing
 * @date 2020/10/22
 */
@Data
public class Order implements Serializable {

    private Integer orderId;

    private Integer shopId;

    private Integer count;
}
