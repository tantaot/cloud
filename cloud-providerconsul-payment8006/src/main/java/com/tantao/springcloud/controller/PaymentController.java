package com.tantao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Value("server.port")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String getMsg(){
        return "使用consul作为注册中心，端口号:" + serverPort + ",随机生成码:" + UUID.randomUUID().toString();
    }

}
