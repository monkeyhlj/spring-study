package com.southwind.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@Slf4j
public class ConsumerController {

    //自动转载，所以直接用
    @Autowired
    private DiscoveryClient discoveryClient;
    //不会自动装载，不能直接用
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/instances")
    public List<ServiceInstance> instances(){
        List<ServiceInstance> provider = this.discoveryClient.getInstances("provider");
        return provider;
    }

//    @GetMapping("/index")
//    public String index(){
//        //调用provider服务的index方法
//        //1、找到provider实例
//        List<ServiceInstance> list = this.discoveryClient.getInstances("provider");
//        int index = ThreadLocalRandom.current().nextInt(list.size());
//        ServiceInstance serviceInstance = list.get(index);
//        String url = serviceInstance.getUri()+"/index";
//        //2、调用
//        log.info("调用的端口是，{}", serviceInstance.getPort());
//        return "调用了端口为："+serviceInstance.getPort()+"的服务，返回结果是："+this.restTemplate.getForObject(url, String.class);
//    }

    @GetMapping("/index")
    public String index(){
        return this.restTemplate.getForObject("http://provider/index", String.class);
    }

}
