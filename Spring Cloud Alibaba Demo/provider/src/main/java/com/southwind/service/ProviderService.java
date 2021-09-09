package com.southwind.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    @SentinelResource("test")
    public void test(){
        System.out.println("test");
    }
}
