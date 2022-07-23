package com.tantao.springcloud.controller;

import com.tantao.springcloud.entities.CommonResult;
import com.tantao.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> searchPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/save")
    public CommonResult savePayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object getDiscovery(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/discovery",Object.class);
    }


}
