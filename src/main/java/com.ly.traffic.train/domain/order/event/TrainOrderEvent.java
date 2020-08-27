package com.ly.traffic.train.domain.order.event;

import com.ly.traffic.middleplatform.demo.OrderEvent;
import com.ly.traffic.middleplatform.event.EventType;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author liugw
 * @Package com.ly.intercity.motor.ddd.order.domain.order.event
 * @Description: 订单领域事件类
 * @date 2020/8/20 13:43
 */
@Data
public class TrainOrderEvent extends OrderEvent {
    private EventType eventType;
    private String orderNo;
    private int version = 1;

    private TrainOrderEvent() {}

    public static TrainOrderEvent create() {
        return create(StringUtils.EMPTY);
    }
    public static TrainOrderEvent create(String module) {
        TrainOrderEvent orderEvent = new TrainOrderEvent();
        orderEvent.setId(UUID.randomUUID().toString());
        orderEvent.setSource("order");
        return orderEvent;
    }
}
