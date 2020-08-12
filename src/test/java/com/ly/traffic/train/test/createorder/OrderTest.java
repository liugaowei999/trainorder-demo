package com.ly.traffic.train.test.createorder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ly.traffic.train.RunApplication;
import com.ly.traffic.train.domain.order.entity.TrainMainOrder;
import com.ly.traffic.train.domain.order.repository.OrderRepository;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.validation.constraints.AssertTrue;

/**
 * @author liugw
 * @Package com.ly.traffic.train.test.createorder
 * @Description: ${TODO}
 * @date 2020/8/11 13:48
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderTest {
    @Resource
    private OrderRepository orderRepository;

    @Test
    public void loopTest() {
        int count = 100;
        for (int idx = 0; idx<count; idx++) {
            testQueryOrder();
        }

        long start = System.currentTimeMillis();
        testQueryOrder();
        long end = System.currentTimeMillis();
        System.out.println((end-start) + "ms");
    }

    @Test
    public void testCreateOrder() {
        TrainMainOrder mainOrder = new TrainMainOrder();
        mainOrder.setTQueryKey("C3:");
        mainOrder.setOrderno("TR00029");
        mainOrder.setBb(5);
        orderRepository.save(mainOrder);
        mainOrder.save();

        System.out.println("ori:"+JSON.toJSONString(mainOrder));
        System.out.println(mainOrder.toString());

    }

    @Test
    public void testQueryOrder() {
        String byId = orderRepository.getById(18L);
        Assert.assertFalse("订单不存在！", StringUtils.isEmpty(byId));
//        System.out.println(byId);

        TrainMainOrder mainOrder1 = JSONObject.parseObject(byId, TrainMainOrder.class);
        System.out.println(JSON.toJSONString(mainOrder1));
        System.out.println("aa=" + mainOrder1.getOrderno());
        System.out.println("bb=" + mainOrder1.getBb());
        System.out.println("tQueryKey=" + mainOrder1.getTQueryKey());
    }

}
