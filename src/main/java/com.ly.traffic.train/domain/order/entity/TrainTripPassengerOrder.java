package com.ly.traffic.train.domain.order.entity;

import com.ly.traffic.middleplatform.domain.createorder.entity.TripPassengerOrderInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.entity
 * @Description: ${TODO}
 * @date 2020/8/20 19:26
 */
@Getter
@Setter
public class TrainTripPassengerOrder extends TripPassengerOrderInfo {
    private String SpecailInfo;
}

