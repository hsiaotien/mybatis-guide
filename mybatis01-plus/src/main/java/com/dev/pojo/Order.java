package com.dev.pojo;

import java.util.List;



/**
 * 订单表
 * 
 */
public class Order {

    private Integer id;

    private Long userId;

    private String orderNumber;
    
    private User user;//添加用户信息
    
    private List<Orderdetail> orderDetailList;//一个订单有多个商品,中间表详情表,对应有多个

    public List<Orderdetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<Orderdetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", orderNumber="
				+ orderNumber + ", user=" + user + ", orderDetailList="
				+ orderDetailList + "]";
	}


}
