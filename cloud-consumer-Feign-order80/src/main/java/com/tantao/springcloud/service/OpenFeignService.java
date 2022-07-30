package com.tantao.springcloud.service;


import com.tantao.springcloud.entities.CommonResult;
import com.tantao.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OpenFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> searchPayment(@PathVariable("id")Long id);

    @GetMapping("/payment/feign/timeout")
    public String getTimeOut();

}
