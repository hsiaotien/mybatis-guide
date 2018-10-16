package com.dev.pre_test;

import com.dev.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class MybatisTest {
	public static void main(String[] args) throws IOException {
		SqlSession sqlSession = null;
		try{
			String resource = "mybatis-config.xml";
			//读取配置文件
			InputStream inputStream = Resources.getResourceAsStream(resource);
			//构建对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//获取会话
			sqlSession = sqlSessionFactory.openSession();
			//查表
			User user = sqlSession.selectOne("com.dev.mapper.UserMapper.queryUserById", 1);
			System.out.println(user);
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
}
