package com.tantao.springcloud.controller;

import com.tantao.springcloud.entities.CommonResult;
import com.tantao.springcloud.entities.Payment;
import com.tantao.springcloud.lb.ILoadBlanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ILoadBlanced loadBlanced;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> searchPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/save")
    public CommonResult savePayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object getDiscovery(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/discovery",Object.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> searchEntity(@PathVariable("id")Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getHeaders().toString());
            return entity.getBody();
        }else{
            log.info("数据查询失败");
            return new CommonResult(400,"数据查询失败");
        }
    }

    @GetMapping("/consumer/payment/saveEntity")
    public  CommonResult<CommonResult> savePaymentByEntity(Payment payment){
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
        return entity.getBody();
    }

    @GetMapping("/consumer/payment/port")
    public String getPort(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBlanced.getInstance(instances);
        return  restTemplate.getForObject(instance.getUri() + "/payment/port",String.class);
    }

}
