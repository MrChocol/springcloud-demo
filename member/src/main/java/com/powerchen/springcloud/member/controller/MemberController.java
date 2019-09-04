package com.powerchen.springcloud.member.controller;

import com.powerchen.springcloud.member.entity.Member;
import com.powerchen.springcloud.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: powerchen
 * @Date: 2019/9/3 17:47
 */
@RestController
// 解决跨域问题 端口不一样也算跨域
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/check")
    public Map checkMobiles(String mobile) {
        Map result = new HashMap();
        try {
            result.put("code", "0");
            result.put("message", "success");
            Member member = memberService.checkByMobile(mobile);
            result.put("data", member);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", e.getClass().getSimpleName());
            result.put("message", e.getMessage());
        }
        return result;
    }
}
