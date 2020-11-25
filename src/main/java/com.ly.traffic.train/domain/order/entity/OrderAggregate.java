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
    /**
     * ExcludeField注解标识后，该属性数据不会传送到中台
     */
    @ExcludeField
    private List<String> customerNameList;
    @ExcludeField
    private Integer cc;

    private final static int constantDd = 666;

//    private Integer sourceType;

}
