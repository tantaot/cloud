package com.tantao.springcloud.controller;

import com.tantao.springcloud.service.IOtherSendMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherSendMsgController {

    @Autowired
    private IOtherSendMsgService service;

    @GetMapping("/sendOtherMsg")
    public String sendOtherMsg(){
        return service.sendMessage();
    }



}
