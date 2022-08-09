package com.tantao.springcloud.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageSink {

    @Input("input-demo")
    SubscribableChannel input();

}
