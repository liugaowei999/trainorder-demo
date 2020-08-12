package com.ly.traffic.train.domain.order.repository;

import com.ly.traffic.middleplatform.domain.order.repository.IOrderRepository;
import org.springframework.stereotype.Service;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.repository
 * @Description: ${TODO}
 * @date 2020/8/11 10:01
 */
@Service
public class OrderRepository implements IOrderRepository {

    public void save(Object obj) {
        IOrderRepository.save(obj);
    }
}
