package com.tantao.springcloud.lb.Imp;

import com.tantao.springcloud.lb.ILoadBlanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements ILoadBlanced {

    private AtomicInteger num = new AtomicInteger(0);


   public final int getAndIncrement(){
        int current;
        int next;
        for(;;){
            current = num.intValue();
            next = current > 1000 ? 0 : current+1;
            if(this.num.compareAndSet(current,next)){
                System.out.println("当前第" + next + "次访问");
                return next;
            }
        }

    }


    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
        int index = this.getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }


}
