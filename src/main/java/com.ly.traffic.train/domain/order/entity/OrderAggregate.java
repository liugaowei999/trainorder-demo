package com.ly.traffic.train.domain.order.entity;

import com.alibaba.fastjson.JSON;
import com.ly.traffic.middleplatform.annotation.ExcludeField;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import lombok.Data;
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
public class OrderAggregate  extends UnionOrderEntity {
    private String tQueryKey;
    private Integer aa;
    private Integer bb;
    private List<String> customerNameList;
    @ExcludeField
    private Integer cc;

}
