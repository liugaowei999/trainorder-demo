package com.ly.traffic.train.test.createorder;
import com.ly.traffic.middleplatform.domain.createorder.entity.ResourceConsumerOrder;
import com.ly.traffic.middleplatform.domain.createorder.entity.RevenueOrderInfo;
import com.ly.traffic.middleplatform.domain.createorder.entity.TripOrderInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;
import com.ly.traffic.middleplatform.domain.createorder.entity.TripPassengerOrderInfo;
import com.ly.traffic.middleplatform.domain.createorder.vo.TrainTripInfoVO;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ly.traffic.train.domain.order.entity.OrderAggregate;
import com.ly.traffic.train.domain.order.entity.TrainTripOrder;
import com.ly.traffic.train.domain.order.entity.TrainTripPassengerOrder;
import com.ly.traffic.train.domain.order.repository.OrderRepository;
import com.ly.traffic.train.infrastructure.common.Result;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
        // 行程信息
        TrainTripInfoVO trainTripInfoVO = new TrainTripInfoVO();
        trainTripInfoVO.setTrainNo("G183");
        trainTripInfoVO.setSeatClass(1);
        trainTripInfoVO.setStartStationCode("bjn");
        trainTripInfoVO.setStartStationName("北京南站");
        trainTripInfoVO.setStartStationState(0);
        trainTripInfoVO.setEndStationCode("szb");
        trainTripInfoVO.setEndStationName("苏州北站");
        trainTripInfoVO.setEndStationState(1);
        trainTripInfoVO.setPlaceOrderForNight(0);
        trainTripInfoVO.setUserName("");
        trainTripInfoVO.setPassword("");
        trainTripInfoVO.setBindPhone("");
        trainTripInfoVO.setChooseSeats("");
        trainTripInfoVO.setAcceptnoseat(0);
        trainTripInfoVO.setGrabEndTime(new Date());
        trainTripInfoVO.setBeginSaleTime("");
        trainTripInfoVO.setSelfSelect(0);
        trainTripInfoVO.setFromCity("");
        trainTripInfoVO.setToCity("");
        trainTripInfoVO.setStartDateTime(new Date());
        trainTripInfoVO.setEndDateTime(new Date());
        trainTripInfoVO.setFromCityId(0);
        trainTripInfoVO.setToCityId(0);
        trainTripInfoVO.setTrafficNo("");
        trainTripInfoVO.setCreateDate(new Date());
        trainTripInfoVO.setCreateUser("");
        trainTripInfoVO.setUpdateDate(new Date());
        trainTripInfoVO.setUpdateUser("");

        // 乘客信息
        List<TripPassengerOrderInfo> tripPassengerOrderInfoList = new ArrayList<>();
        TrainTripPassengerOrder tripPassengerOrderInfo1 = new TrainTripPassengerOrder();
        tripPassengerOrderInfo1.setTicketFlag(0);
        tripPassengerOrderInfo1.setPassengerName("张三");
        tripPassengerOrderInfo1.setPassengerType(1);
        tripPassengerOrderInfo1.setCertificateType(1);
        tripPassengerOrderInfo1.setCertificateNo("1102238494577383747");
        tripPassengerOrderInfo1.setSex(0);
        tripPassengerOrderInfo1.setSpecailInfo("订单乘客1纬度扩展信息");
        tripPassengerOrderInfoList.add(tripPassengerOrderInfo1);

        TrainTripPassengerOrder tripPassengerOrderInfo2 = new TrainTripPassengerOrder();
        tripPassengerOrderInfo2.setTicketFlag(0);
        tripPassengerOrderInfo2.setPassengerName("李四");
        tripPassengerOrderInfo2.setPassengerType(1);
        tripPassengerOrderInfo2.setCertificateType(1);
        tripPassengerOrderInfo2.setCertificateNo("2102238494577383747");
        tripPassengerOrderInfo2.setSex(0);
        tripPassengerOrderInfo2.setSpecailInfo("订单乘客2纬度扩展信息");
        tripPassengerOrderInfoList.add(tripPassengerOrderInfo2);



        // 行程订单信息
        TrainTripOrder trainTripOrder = new TrainTripOrder();
        trainTripOrder.setTripInfoVO(trainTripInfoVO);
        trainTripOrder.setTripPassengerOrderInfoList(tripPassengerOrderInfoList);
        trainTripOrder.setIndexNo(0);
        trainTripOrder.setOrderType(1);
        trainTripOrder.setPayStatus(0);
        trainTripOrder.setOrderStatus(1);
        trainTripOrder.setTravelFlag(0);
        trainTripOrder.setTicketUnitPrice(120.0D);
        trainTripOrder.setTicketTotalPrice(240.0D);
        trainTripOrder.setServiceUnitPrice(10.0D);
        trainTripOrder.setServiceTotalPrice(20.0D);
        trainTripOrder.setSupplierId("");
        trainTripOrder.setUnionPay(0);
        trainTripOrder.setPlanCode("场景code");

        // 营收商品
        List<RevenueOrderInfo> revenueOrderInfoList = Lists.newArrayList();

        // 权益消费申请信息
        List<ResourceConsumerOrder> resourceConsumerOrderList = Lists.newArrayList();

        OrderAggregate mainOrder = new OrderAggregate();
        mainOrder.setPlatId(987);
        mainOrder.setSourceType(10);
        mainOrder.setMemberId(5365463);
        mainOrder.setSupplierOrderNo("");
        mainOrder.setCheckStatus(0);
        mainOrder.setOrderStatus(0);
        mainOrder.setMailStatus(0);
        mainOrder.setPayStatus(0);
        mainOrder.setContactName("王五");
        mainOrder.setContactPhone("13789287372");
        mainOrder.setContactEmail("wangwu@qq.com");
        mainOrder.setCustomerTotalAmount(260.0D);
        mainOrder.setCustomerTotalPaid(0.0D);
        mainOrder.setTicketTotalPrice(240.0D);
        mainOrder.setReduceAmount(0.0D);
        mainOrder.setDiscountAmount(0.0D);
        mainOrder.setBookFlag(0);
        mainOrder.setIssueFlag(0);
        mainOrder.setPayMode(0);
        mainOrder.setValidPayTime(new Date());
        mainOrder.setPaymentType(0);
        mainOrder.setUnionPay(0);
        mainOrder.setDirectPay(0);
        mainOrder.setProductType(0);
        mainOrder.setRefId(123456);
        mainOrder.setUnionId("USKDFJ-wejfksd");
        mainOrder.setOpenId("Qjfsdjakfklsdafl");
        mainOrder.setUserCreateDate(new Date());
        mainOrder.setCreateDate(new Date());
        mainOrder.setCreateUser("system");
        mainOrder.setUpdateDate(new Date());
        mainOrder.setUpdateUser("");
        mainOrder.setTripOrderInfo(trainTripOrder);
        mainOrder.setResourceConsumerOrderList(resourceConsumerOrderList);
        mainOrder.setRevenueOrderInfoList(revenueOrderInfoList);

        mainOrder.setTQueryKey("F3:");
        mainOrder.setOrderNo("MD" + System.currentTimeMillis());
        mainOrder.setBb(5);
        mainOrder.setCc(99);


//        orderRepository.save(mainOrder);
        mainOrder.save();

        System.out.println("ori:"+JSON.toJSONString(mainOrder));
        System.out.println(mainOrder.toString());

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQueryOrder() {
        String byId = orderRepository.getById(23L);
        Assert.assertFalse("订单不存在！", StringUtils.isEmpty(byId));

        OrderAggregate mainOrder1 = JSONObject.parseObject(byId, OrderAggregate.class);
        System.out.println(JSON.toJSONString(mainOrder1));
        System.out.println("aa=" + mainOrder1.getOrderNo());
        System.out.println("cc=" + mainOrder1.getCc());
        System.out.println("tQueryKey=" + mainOrder1.getTQueryKey());
    }

}
