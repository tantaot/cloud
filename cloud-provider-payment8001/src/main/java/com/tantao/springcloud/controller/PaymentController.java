package com.tantao.springcloud.controller;

import com.tantao.springcloud.entities.CommonResult;
import com.tantao.springcloud.entities.Payment;
import com.tantao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> searchPayment(@PathVariable("id")Long id){
        Payment payment = paymentService.searchPayment(id);
        log.info("查询结果:{}",payment);
        if(payment != null){
            return  new CommonResult<Payment>(200,"查询数据成功,端口:" + serverPort,payment);
        }
        return  new CommonResult<Payment>(404,"未查询id为" + id + "的数据,端口:" + serverPort);
    }

    @PostMapping("/payment/save")
    public CommonResult savePayment(@RequestBody Payment payment){
        int result = paymentService.savePayment(payment);
        log.info("插入结果:{}",result);
        if(result > 0){
            return  new CommonResult(200,"插入数据成功,端口:" + serverPort,result);
        }
        return  new CommonResult(404,"插入数据失败,端口:" + serverPort);
    }

    @GetMapping("/payment/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*****" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t"
            + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/port")
    public String getPort() {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String getTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
