package com.tantao.springcloud.controller;

import com.tantao.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("result :" + result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("result :" + result);
        return result;
    }

}
