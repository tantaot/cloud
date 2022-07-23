package com.tantao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //eureka服务端
public class EurekaServerMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7001.class,args);
    }

}
