package com.powerchen.springcloud.book.service.exception;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 13:48
 */
public class NotEnoughStockException extends  RuntimeException{

    public NotEnoughStockException(String message) {
        super(message);
    }
}
