package com.powerchen.springcloud.book.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 16:33
 */
@FeignClient(name = "member")
public interface MemberClient {

    @GetMapping("/check")
    RestResult<MemberDTO> checkMobiles(@RequestParam("mobile") String mobile);

}
