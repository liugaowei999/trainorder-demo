package com.ly.traffic.train.domain.order.entity;

import com.ly.traffic.middleplatform.domain.order.entity.MainOrder;
import com.ly.traffic.middleplatform.domain.order.repository.IOrderRepository;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.entity
 * @Description: ${TODO}
 * @date 2020/8/10 22:12
 */
@Getter
@Setter
public class TrainMainOrder extends MainOrder implements IOrderRepository {
    private String tQueryKey;
    private Integer aa;
    private Integer bb;
}
