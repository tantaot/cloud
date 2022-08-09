package com.tantao.springcloud.service.impl;

import com.tantao.springcloud.channel.MessageSource;
import com.tantao.springcloud.service.IOtherSendMsgService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(MessageSource.class)
public class OtherSendMsgServiceImpl implements IOtherSendMsgService {

    @Resource(name = "output-demo")
    private MessageChannel output; //消息发送管道

    @Override
    public String sendMessage() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("---------serial:   "  + serial);
        return null;
    }
}
