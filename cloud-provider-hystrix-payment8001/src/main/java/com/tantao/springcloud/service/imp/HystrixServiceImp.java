package com.tantao.springcloud.service.imp;

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
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + ",paymentInfo_TimeOut,id:" + id;
    }
}
