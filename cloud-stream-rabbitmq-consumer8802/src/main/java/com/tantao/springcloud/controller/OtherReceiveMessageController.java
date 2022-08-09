package com.tantao.springcloud.controller;

import com.tantao.springcloud.channel.MessageSink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(MessageSink.class)
public class OtherReceiveMessageController {

    @Value("${server.port}")
    private String port;

    @StreamListener("input-demo")
    public void input(Message<String> msg){
        System.out.println("消费者input-demo接受到消息:" + msg.getPayload() + ",端口:" + port);
    }


}
