package com.dev.mapper;

import com.dev.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class OrderMapperTest {
	
	private OrderMapper orderMapper;
	@Before
	public void setUp() throws Exception {
		//获取sqlSession对象
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		orderMapper = sqlSession.getMapper(OrderMapper.class);
	}

	@Test
	public void testSelectOneToOne() {
		Order order = orderMapper.selectOneToOne("20140921001");
		System.out.println(order);
	}
	
	@Test
	public void testSelectOneToMore() {
		List<Order> list = orderMapper.selectOneToMore("20140921001");
		for (Order order : list) {
			System.out.println(order);
		}
	}
	@Test
	public void testSelectMoreToMore() {
		List<Order> list = orderMapper.selectMoreToMore("20140921001");
		for (Order order : list) {
			System.out.println(order);
		}
	}
}
