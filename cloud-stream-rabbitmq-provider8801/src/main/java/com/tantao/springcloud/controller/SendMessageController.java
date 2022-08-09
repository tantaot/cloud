package com.tantao.springcloud.controller;


import com.tantao.springcloud.service.ISendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private ISendMessageService service;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return service.sendMessage();
    }

}
