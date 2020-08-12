package com.ly.traffic.train.domain.order.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order
 * @Description: ${TODO}
 * @date 2020/7/6 15:00
 */
@Deprecated
public class OrderAggregate  {
    private String orderSerialId;
//
//    /**
//     * 订单基本信息 & 客户端信息
//     */
//    private OrderBaseInfo orderBaseInfo;
//    private ClientInfoVO clientInfo;



    /**
     * 优惠信息
     */
//    private List<DiscountInfo> discountInfoList;


    public static void main(String[] args) {

//        String jsonStr = "{\"orderBaseInfo\":{\"isOnlineTicket\":0,\"tQueryKey\":\"KEY1\",\"trainsformPurchaseStatus\":0,\"userName\":\"zhangsan\"},\"userTripInfoList\":[{\"bothTime\":0,\"fromCity\":\"北京\",\"fromCityPy\":\"beijing\"}]}";
//        OrderAggregate orderAggregate1 = JSON.parseObject(jsonStr, OrderAggregate.class);
         System.out.println("============================================");
//        orderAggregate1.create();
    }

}
