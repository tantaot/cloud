package com.tantao.springcloud.service.imp;

import com.tantao.springcloud.dao.PaymentDao;
import com.tantao.springcloud.entities.Payment;
import com.tantao.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImp implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Payment searchPayment(Long id) {
        return paymentDao.searchPayment(id);
    }

    @Override
    public int savePayment(Payment payment) {
        return paymentDao.savePayment(payment);
    }
}
