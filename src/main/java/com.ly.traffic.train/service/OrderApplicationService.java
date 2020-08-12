package com.ly.traffic.train.service;

import com.ly.traffic.train.domain.order.service.OrderDomainService;
import com.ly.traffic.train.infrastructure.common.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.train.service
 * @Description: ${TODO}
 * @date 2020/8/11 14:56
 */
@Service
public class OrderApplicationService {
    @Resource
    OrderDomainService orderDomainService;
    public Result createOrder(Object request) {
        orderDomainService.createOrder(request);
        return null;
    }
}
