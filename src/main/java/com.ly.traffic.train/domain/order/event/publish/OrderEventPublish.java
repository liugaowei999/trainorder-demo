package com.ly.traffic.train.domain.order.event.publish;


import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.AsyncEventBus;
import com.ly.traffic.middleplatform.demo.MainProcessorListenerExample;
import com.ly.traffic.train.domain.order.event.TrainOrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;

/**
 * 订单事件发送MQ
 *
 * @author liugw
 * @date 2020/08/21
 */
@Service
public class OrderEventPublish {
    private static final Logger logger = LoggerFactory.getLogger(OrderEventPublish.class);

    private AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(3));

    public OrderEventPublish() {
        this.eventBus.register(new MainProcessorListenerExample());
    }

    public void publish(TrainOrderEvent orderEvent) {
//        eventBus.post(orderEvent);
        eventBus.post(JSON.toJSONString(orderEvent));
    }

}
