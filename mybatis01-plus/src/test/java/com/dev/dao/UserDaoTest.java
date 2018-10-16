package com.dev.dao;

import com.dev.dao.impl.UserDaoImpl;
import com.dev.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
	
	private IUserDao userDaoImpl;
	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource );
		//获取
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//初始化userdaoimpl对象
		userDaoImpl = new UserDaoImpl(sqlSession);
	}
	@Test
	public void testQueryUserById() {
		User user = userDaoImpl.queryUserById(1L);
		System.out.println(user);
		System.out.println("******************************");
	}

	@Test
	public void testQueryUserAll() {
		List<User> user_list = userDaoImpl.queryUserAll();
		for (User user : user_list) {
			System.out.println(user);
		}
		System.out.println("******************************");
	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setAge(18);
		user.setName("柳岩");
		user.setPassword("123456");
		user.setUserName("yan");
		user.setSex(3);
		user.setBirthday(new Date());
		userDaoImpl.insertUser(user);
		System.out.println("******************************");
	}

	@Test
	public void testUpdateUser() {
		//查询
		User user = userDaoImpl.queryUserById(4L);
		//更新
		user.setAge(26);
		user.setName("LYY");
		userDaoImpl.updateUser(user);
		System.out.println("******************************");
	}

	@Test
	public void testDeleteUserById() {
		userDaoImpl.deleteUserById(12L);
		System.out.println("******************************");
	}

}
