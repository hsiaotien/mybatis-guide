package com.dev.mapper;

import com.dev.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
	
	//根据订单号查询订单信息以及对应的下单人信息
	Order selectOrderUserByOrderNumber(@Param("orderNumber") String orderNumber);

	//根据订单号查询订单信息以及对应的下单人信息和订单详情信息
	Order selectOrderUserDetailByOrderNumber(@Param("orderNumber") String orderNumber);

	//根据订单号查询订单信息以及对应的下单人信息和订单详情信息和商品信息
	Order selectOrderUserDetailItemByOrderNumber(@Param("orderNumber") String orderNumber);
	
	//延迟加载查询
	Order queryOrderLazy(@Param("orderNumber") String orderNumber);
}
