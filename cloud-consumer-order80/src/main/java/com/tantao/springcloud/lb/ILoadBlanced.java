package com.tantao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ILoadBlanced {

    ServiceInstance getInstance(List<ServiceInstance> serviceInstances);

}
