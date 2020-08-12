package com.ly.traffic.train.domain.order.service;

import com.ly.traffic.train.domain.order.entity.TrainMainOrder;
import com.ly.traffic.train.domain.order.repository.OrderRepository;
import com.ly.traffic.train.infrastructure.common.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.service
 * @Description: ${TODO}
 * @date 2020/8/11 14:55
 */
@Service
public class OrderDomainService {
    @Resource
    private OrderRepository orderRepository;

    public Result createOrder(Object request) {
        TrainMainOrder mainOrder = new TrainMainOrder();
        mainOrder.setTQueryKey("C3:");
        mainOrder.setOrderno("TR00022");
        mainOrder.save();
//        orderRepository.save(mainOrder);

        // 发布事件

        return null;
    }
}
