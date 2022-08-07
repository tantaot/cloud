package com.tantao.springcloud.service.imp;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tantao.springcloud.service.HystrixService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixServiceImp implements HystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + ",paymentInfo_OK,id:" + id;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int i =  10 / 0;
        return "线程池:" + Thread.currentThread().getName() + ",paymentInfo_TimeOut,id:" + id;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "fallBack_CircuitBreaker",
    commandProperties = {
            @HystrixProperty(name ="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage",value = "60"),//错误率达到多少后跳闸
    })
    public String paymentInfo_CircuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("id不能为负数");
        }else{
            String msg = IdUtil.simpleUUID();
            return "线程池:" + Thread.currentThread().getName() + ",paymentInfo_CircuitBreaker,流水号:" + msg;
        }
    }

    public String fallBack_CircuitBreaker(Integer id){
       return "线程池:" + Thread.currentThread().getName() + ",fallBack_CircuitBreaker,服务熔断";
    }


}
