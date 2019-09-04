package com.powerchen.springcloud.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: powerchen
 * @Date: 2019/8/30 17:11
 */
@RestController
public class ClientController {
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/msg")
    public String msg() {
        return "This port is " + port;
    }
}
