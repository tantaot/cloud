package com.tantao.springcloud.service;

public interface HystrixService {

    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);

}
