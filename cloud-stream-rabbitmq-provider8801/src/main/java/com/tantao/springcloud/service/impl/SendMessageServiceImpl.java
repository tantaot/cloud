package com.tantao.springcloud.service.impl;

import com.tantao.springcloud.service.ISendMessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class) // 将信道channel和exchange绑定在一起, Source定义消息的推送管到(生产者->Source)
public class SendMessageServiceImpl implements ISendMessageService {

    @Resource(name = "output")
    private MessageChannel output; //消息发送管道

    @Override
    public String sendMessage() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("---------serial:   "  + serial);
        return null;
    }
}
