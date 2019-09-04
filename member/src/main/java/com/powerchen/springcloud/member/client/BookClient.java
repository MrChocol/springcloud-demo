package com.powerchen.springcloud.member.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 16:03
 */
@FeignClient(name = "book") //name是server-id，指明这是Book微服务的调用客户端
public interface BookClient {

    @GetMapping("info")
    RestResult<BookDTO> getInfo(@RequestParam("bid") Long bid);

    @GetMapping("/list")
    RestResult<List<BookDTO>> getAll();
}
