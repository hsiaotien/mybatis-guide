package com.dev.mapper;

import com.dev.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
	
	//1查询订单,并查询出下单人的信息
	public Order selectOneToOne(@Param("orderNumber") String orderNumber);
	
	//2 查询订单，查询出下单人信息并且查询出订单详情。
	public List<Order> selectOneToMore(@Param("orderNumber") String orderNumber);
	
	//3 查询订单，查询出下单人信息并且查询出订单详情中的商品数据。
	public List<Order> selectMoreToMore(@Param("orderNumber") String orderNumber);
}
