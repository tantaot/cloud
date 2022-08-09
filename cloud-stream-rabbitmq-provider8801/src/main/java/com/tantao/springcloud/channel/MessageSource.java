package com.tantao.springcloud.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageSource {

    @Output("output-demo")
    MessageChannel output();

}
