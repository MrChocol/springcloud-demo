package com.powerchen.springcloud.member.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.powerchen.springcloud.member.client.BookClient;
import com.powerchen.springcloud.member.client.BookDTO;
import com.powerchen.springcloud.member.client.RestResult;
import com.powerchen.springcloud.member.entity.Member;
import com.powerchen.springcloud.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: powerchen
 * @Date: 2019/9/3 17:47
 */
@RestController
// 解决跨域问题 端口不一样也算跨域
@CrossOrigin
@DefaultProperties(defaultFallback = "defaultFallBack")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private BookClient bookClient;

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

    @GetMapping("/info")
//    @HystrixCommand(fallbackMethod = "fallback")
    @HystrixCommand
    public String test(Long bid) {
        // 服务间通信的几种方式
        // 1.通过springcloud内置的RestTemplate进行通信，其底层是Apache的HttpClient组件(写死了不推荐)
//        RestTemplate restTemplate = new RestTemplate();
//        String object = restTemplate.getForObject("http://localhost:9000/book/info?bid=" + bid, String.class);

        // 2. 使用Ribbon进行客户端负载均衡
        // 获取服务列表，提供负载均衡
//        ServiceInstance bookServiceInstance = loadBalancerClient.choose("book");
//        String host = bookServiceInstance.getHost();
//        int port = bookServiceInstance.getPort();
//        RestTemplate restTemplate = new RestTemplate();
//        String object = restTemplate.getForObject(String.format("http://%s:%d/info?bid=%d", host, port, bid), String.class);

        // 3. 利用注解简化URL通信 url的主机名和端口号都要换成server-id
//        String object = restTemplate.getForObject("http://book/info?bid=" + bid, String.class);

        // 4. 使用Feign进行调用
        RestResult<BookDTO> info = bookClient.getInfo(bid);

        return info.getData().getName();
    }

    @GetMapping("/all")
    public String test2() {
        RestResult<List<BookDTO>> all = bookClient.getAll();
        return all.getData().toString();
    }

    // 服务降级的方法要求返回值、参数与目标方法保持一致
    private String fallback(Long bid) {
        return "当前系统正忙,请稍后再试";
    }

    // 全局默认的降级方法,不需要参数，且返回String或者任何可以被JSON序列化的对象
    private String defaultFallBack() {
        return "[默认系统降级]当前系统正忙,请稍后再试";
    }
}
