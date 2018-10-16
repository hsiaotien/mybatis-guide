package com.dev.mapper;

import com.dev.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;


public class UserMapperTest {
	
	private UserMapper userMapper;

	@Before
	public void setUp() throws Exception {

		SqlSession sqlSession = new SqlSessionFactoryBuilder().build(
				Resources.getResourceAsStream("mybatis-config.xml"))
				.openSession(true);
	 
		
		userMapper = sqlSession.getMapper(UserMapper.class);

	}
	
	@Test
	public void testSelectByIds(){
		List<User> list = userMapper.selectUsersByIds(new Long[]{1L,2L,3L,4L});
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void testUpdateSelective(){
		User user = new User();
		user.setId(10L);
		user.setSex(3);
		userMapper.updateSelectvice(user);
	}
	
	
	@Test
	public void testSelectUsersByUserNameLikeAndAge(){
		List<User> list = userMapper.selectUsersByUserNameLikeAndAge("yan",null);
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testsSelectUserBySexAndUserNameLikeOrAge(){
		List<User> list = userMapper.selectUserBySexAndUserNameLikeOrAge(null, null);
		
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	
	@Test
	public void testSelectUserBySexAndNameLike(){
		List<User> list = userMapper.selectUserBySexAndNameLike(null);
		
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void testSelectUserByNameLike(){
	 
		List<User> list = userMapper.selectUserByNameLike("zhang");
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testLoginMap(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("userName", "lisi");
		map.put("password", "123456");
		
		User user = userMapper.loginMap(map);
		
		System.out.println(user);
	}
	
	
	@Test
	public void testLogin(){
		//String name = "zhangsan";
		//String sql = "select * from tb_user where user_name = ?";
		
		User user = userMapper.login("zhangsan", "123456");
		
		System.out.println(user);
	}
	
	
	@Test
	public void testSelectUserByTableName(){
		List<User> list = userMapper.selectUserByTableName("tb_user");
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	

	@Test
	public void testSelectUserById() {
		User user = userMapper.selectUserById(1L);
		
		System.out.println(user);
	}

	@Test
	public void testSelectAllUser() {
		fail("Not yet implemented");
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
		 
		 userMapper.insertUser(user);
		 
		 System.out.println("id:"+user.getId());
		 
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUserById() {
		fail("Not yet implemented");
	}

}
