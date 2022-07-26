package com.tantao.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallBackService paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallBackService paymentInfo_TimeOut";
    }
}
