package com.southwind.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.southwind.entity.Order;
import com.southwind.service.ProviderService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ProviderController {

    //SPEL
    @Value("${server.port}")
    private String port;

    int i=0;

    @GetMapping("/index")
    public String index(){
        i++;
        if(i%2==0) throw new RuntimeException();
        return this.port;
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }

    @Autowired
    private ProviderService providerService;

    @GetMapping("/test1")
    public String test1(){
        this.providerService.test();
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(){
        this.providerService.test();
        return "test2";
    }

    @GetMapping("/hot")
    @SentinelResource("hot")
    public String hot(
            @RequestParam(value = "num1",required = false) Integer num1,
            @RequestParam(value = "num2",required = false) Integer num2){
        return num1+"-"+num2;
    }

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/create")
    public Order create(){
        Order order = new Order(
                1,
                "张三",
                "123123",
                "软件园",
                new Date()
        );
        this.rocketMQTemplate.convertAndSend("orderTopic",order);
        return order;
    }

    @GetMapping("/api1/demo1")
    public String demo1(){
        return "demo";
    }

    @GetMapping("/api1/demo2")
    public String demo2(){
        return "demo";
    }

    @GetMapping("/api2/demo1")
    public String demo3(){
        return "demo";
    }

    @GetMapping("/api2/demo2")
    public String demo4(){
        return "demo";
    }
}
