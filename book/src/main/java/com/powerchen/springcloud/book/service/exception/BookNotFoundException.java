package com.powerchen.springcloud.book.service.exception;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 13:48
 */
public class BookNotFoundException extends  RuntimeException{

    public BookNotFoundException(String message) {
        super(message);
    }
}
