package com.tantao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    private static final String URL="http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/zk")
    public String consumerMsg(){
        return restTemplate.getForObject(URL + "/payment/zk",String.class);
    }

}
