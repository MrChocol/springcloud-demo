package com.powerchen.springcloud.member.service.exception;

/**
 * @Author: powerchen
 * @Date: 2019/9/3 17:46
 */
public class MemberNotFoundException extends Exception {

    public MemberNotFoundException(String message) {
        super(message);
    }
}
