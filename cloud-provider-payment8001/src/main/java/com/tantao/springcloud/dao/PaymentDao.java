package com.tantao.springcloud.dao;

import com.tantao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    //查询payment
    public Payment searchPayment(@Param("id")Long id);

    //添加payment
    public int savePayment(@Param("payment") Payment payment);

}
