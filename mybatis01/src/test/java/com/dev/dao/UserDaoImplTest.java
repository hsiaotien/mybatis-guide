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

public class UserDaoImplTest {

	
	private IUserDao userDao;
	
	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		 InputStream inputStream  = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		userDao = new UserDaoImpl(sqlSession);
	}

	@Test
	public void testSelectUserById() {
		User user = userDao.selectUserById(1L);
		System.out.println(user);
	}

	@Test
	public void testSelectAllUser() {
		List<User> list = userDao.selectAllUser();
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testInsertUser() {
		 User user = new User();
		 
		 user.setAge(18);
		 user.setBirthday(new Date());
		 user.setName("柳岩");
		 user.setUserName("yanyan");
		 user.setPassword("123456");
		 user.setSex(0);
		 
		 userDao.insertUser(user);
		 
	}

	@Test
	public void testUpdateUser() {
		
		 User user = new User();
		 user.setAge(18);
		 user.setBirthday(new Date());
		 user.setName("柳岩");
		 user.setUserName("yanyanplus");
		 user.setPassword("123456");
		 user.setSex(0);
		 
		 user.setId(8l);
		
		 userDao.updateUser(user);
	}

	@Test
	public void testDeleteUserById() {
		 userDao.deleteUserById(8L);
	}

}
