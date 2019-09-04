package com.powerchen.springcloud.book.client;

import lombok.Data;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 16:13
 */
@Data
public class RestResult<T> {
    private String code;
    private String message;
    private T data;
}
