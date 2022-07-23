package com.tantao.springcloud.service;

import com.tantao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    //查询payment
    public Payment searchPayment(@Param("id")Long id);

    //添加payment
    public int savePayment(@Param("payment") Payment payment);

}
