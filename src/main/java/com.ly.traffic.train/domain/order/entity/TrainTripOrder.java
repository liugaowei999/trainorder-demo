package com.ly.traffic.train.domain.order.entity;

import com.ly.traffic.middleplatform.domain.createorder.entity.TripOrderInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.entity
 * @Description: ${TODO}
 * @date 2020/8/19 13:58
 */
@Getter
@Setter
public class TrainTripOrder extends TripOrderInfo {
    /**
     * 场景编号
     */
    private String planCode;

    /**
     * 方案数据来源
     */
    private String dataSource;
}
