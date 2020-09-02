package com.ly.traffic.train.domain.order.entity;

import com.ly.traffic.middleplatform.apt.annotation.Aggregate;
import com.ly.traffic.middleplatform.apt.annotation.ExcludeField;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order
 * @Description: ${TODO}
 * @date 2020/7/6 15:00
 */
@Getter
@Setter
@Aggregate
public class OrderAggregate  extends UnionOrderEntity {
    private String tQueryKey;
    private Integer aa;
    private Integer bb;
    private List<String> customerNameList;
    @ExcludeField
    private Integer cc;

    private final static int constantDd = 666;

//    private Integer sourceType;

    public static void main(String[] args) {
        System.out.println(OrderAggregate.class.getName());
        System.out.println(OrderAggregate.class.getCanonicalName());

        String ww = String.format("hello %s", "ww");
        System.out.println(ww);
    }

}
