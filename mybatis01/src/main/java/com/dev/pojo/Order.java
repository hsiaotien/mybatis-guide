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
    
    //一对一关联
    private User user;
    
    //一对多
    private List<Orderdetail> orderdetailList;
    
    
    
    

    public List<Orderdetail> getOrderdetailList() {
		return orderdetailList;
	}

	public void setOrderdetailList(List<Orderdetail> orderdetailList) {
		this.orderdetailList = orderdetailList;
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
				+ orderNumber + ", user=" + user + ", orderdetailList="
				+ orderdetailList + "]";
	}

	 

    
}
