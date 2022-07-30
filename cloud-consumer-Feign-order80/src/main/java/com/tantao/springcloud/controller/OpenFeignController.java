package com.tantao.springcloud.controller;

import com.tantao.springcloud.entities.CommonResult;
import com.tantao.springcloud.entities.Payment;
import com.tantao.springcloud.service.OpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class OpenFeignController {

    @Autowired
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> searchPayment(@PathVariable("id")Long id){
        return openFeignService.searchPayment(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String getTimeOut(){
        return openFeignService.getTimeOut();
    }

}
