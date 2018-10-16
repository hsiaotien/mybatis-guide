package com.dev.mapper;


import com.dev.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
	//声明接口的实例
	private UserMapper userMapper;
	private SqlSession sqlSession;
	@Before
	public void setUp() throws Exception {
		//读取mybatis全局配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//获取sqlsessionfactory
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "test");
		//获取sqlsession会话
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//对于接口的动态实例
		userMapper = sqlSession.getMapper(UserMapper.class);
		this.sqlSession = sqlSession;
	}

	@Test
	public void testQueryUserById() {
		User user = userMapper.queryUserById(1L);
		System.out.println(user);
	}
	@Test
	public void testQueryUserAll() {
		List<User> list = userMapper.queryUserAll();
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setAge(19);
		user.setName("波多野结衣");
		user.setPassword("123456");
		user.setUserName("boduo");
		user.setSex(2);
		user.setBirthday(new Date());
		userMapper.insertUser(user );
		System.out.println(user.getId());
	}
	@Test
	public void testQueryUserAllByTable(){
		List<User> list = userMapper.queryUserAllByTable("tb_user");
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void testQueryUserByTable(){//用了注解,更符合开发习惯,增强可读性
		List<User> list = userMapper.queryUserAllByTable("tb_user");
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void testLoginByUsernameAndPassword(){//用了注解,更符合开发习惯,增强可读性
		User user = userMapper.loginByUsernameAndPassword("liuyan","123456");
		if(user!=null){
			System.out.println("ok");
			System.out.println(user);
		}
	}
	@Test
	public void testLoginByHashMap(){//hashmap参数  paramterType
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		hashMap.put("username", "tongyanjuru");
		hashMap.put("password", "123456");
		User user = userMapper.loginByHashMap(hashMap);
		if(user!=null){
			System.out.println("ok");
			System.out.println(user);
		}
	}
	@Test
	public void testLoginByPojo(){// paramterType 三种类型,pojo 基本类型, hashmap
		User preUser = new User();
		preUser.setUserName("liuyan");
		preUser.setPassword("123456");
		User user = userMapper.loginByPojo(preUser);
		if(user!=null){
			System.out.println("ok");
			System.out.println(user);
		}
	}
	@Test
	public void testQueryUserLike(){
		List<User> list = userMapper.queryUserLike("li");
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void testQueryBoyUserLike(){
		List<User> list = userMapper.queryBoyUserLike(1, "li");
		for (User user : list) {
			System.out.println(user);
		}
	}
	/**
	 * 5月23日,continue
	 */
	@Test
	public void testSelectUserByUserName(){
		List<User> list = userMapper.selectUserByUserName("zhang");
		for (User user : list) {
			System.out.println(user);
		}
	}
	////查询男性用户，如果输入了用户名则按照用户名模糊查找，
	//否则如果输入了年龄则按照年龄查找，否则查找用户名为“zhangsan”的用户。
	@Test
	public void testSelectUserByUserNameOrAge(){
		List<User> list = userMapper.selectUserByUserNameOrAge(28, "lilei");
		for (User user : list) {
			System.out.println(user);
		}
	}
	//测试where标签中放入if标签,达到两者都
	@Test
	public void testSelectUserByUserNameAndAge(){
		List<User> list = userMapper.selectUserByUserNameAndAge(null, 18);
		if(list.isEmpty()){
			System.out.println("没有符合条件的用户");
			return;
		}
		for (User user : list) {
			System.out.println(user);
		}
	}
	//测试where套choose(单行) 加where
	@Test
	public void testSelectUserByWhereAndChoose(){
		List<User> list = userMapper.selectUserByWhereAndChoose("liu", 18);
		if(list.isEmpty()){
			System.out.println("没有符合条件的用户");
			return;
		}
		for (User user : list) {
			System.out.println(user);
		}
	}
	//测试set
	@Test
	public void testUpdateUserByNotNull(){
		User user = new User();
		user.setId(25L);
		user.setUserName(null);
		user.setAge(18);
		userMapper.updateUserByNotNull(user);
	}
	//测试foreach
	@Test
	public void testSelectUserByForeach(){
		Long[] arr = new Long[]{1L,2L};
		List<User> list = userMapper.selectUserByForeach(arr);
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	//测试一级缓存....执行相同的sql语句和参数，mybatis不重复发送执行sql，而是从缓存中命中返回。
	@Test
	public void testCache(){
		User user1 = this.userMapper.queryUserById(1l);
		System.out.println(user1);
		sqlSession.clearCache();//也可以清空缓冲, 对象sqlsession有清空缓存的方法
		System.out.println("=================第二次查询======================");
		User user2 = this.userMapper.queryUserById(1l);
		System.out.println(user2);
	}
	//此外还有二级缓存的概念
	
	
}
