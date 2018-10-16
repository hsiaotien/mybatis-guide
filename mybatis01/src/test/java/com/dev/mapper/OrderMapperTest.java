package com.dev.mapper;

import com.dev.pojo.Order;
import com.dev.pojo.Orderdetail;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class OrderMapperTest {
	
	private OrderMapper orderMapper;

	@Before
	public void setUp() throws Exception {
		
		
		SqlSession sqlSession = new SqlSessionFactoryBuilder().build(
				Resources.getResourceAsStream("mybatis-config.xml"))
				.openSession(true);
		
		orderMapper = sqlSession.getMapper(OrderMapper.class);
	}

	
	@Test
	public void testselectOrderUserDetailItemByOrderNumber(){
		Order order = orderMapper.selectOrderUserDetailItemByOrderNumber("20140921001");
		List<Orderdetail> list = order.getOrderdetailList();
		 System.out.println(order);
		 
	}
	
	
	@Test
	public void testLazy(){
		Order order = orderMapper.queryOrderLazy("20140921001");
		//System.out.println(order);
		System.out.println(order.getOrderNumber());
		System.out.println(order.getUser().getUserName());
	}
	
	@Test
	public void testselectOrderUserDetailByOrderNumber(){
		Order order = orderMapper.selectOrderUserDetailByOrderNumber("20140921001");
		List<Orderdetail> list = order.getOrderdetailList();
		 System.out.println(order);
		for (Orderdetail orderdetail : list) {
			System.out.println(orderdetail);
		}
	}
	
	@Test
	public void test() {
		 
		Order order = orderMapper.selectOrderUserByOrderNumber("20140921001");
		
		System.out.println(order);
	}

}
