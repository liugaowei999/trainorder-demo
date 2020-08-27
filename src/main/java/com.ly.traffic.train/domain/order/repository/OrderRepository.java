package com.ly.traffic.train.domain.order.repository;

import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.domain.createorder.repository.IUnionOrderRepository;
import com.ly.traffic.middleplatform.utils.ProgressBar;
import com.ly.traffic.train.domain.order.entity.OrderAggregate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.repository
 * @Description: ${TODO}
 * @date 2020/8/11 10:01
 */
@Slf4j
@Service
public class OrderRepository implements IUnionOrderRepository<OrderAggregate, Integer> {

    @Override
    public Integer save(OrderAggregate orderEntity) {
        log.info("======= 业务线内 持久化数据 开始==== {}", orderEntity.getOrderNo());
        try {
            ProgressBar.printProgress("\n业务线内持久化数据进度:");
            System.out.println("\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("======= 业务线内 持久化数据 结束====");

        return 0;
    }
}
