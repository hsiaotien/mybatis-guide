package com.dev.pre_test;

import com.dev.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Mybatis入门第一站. 此示例是mybatis的基本实现原理.
 */
public class MybatisTest {
	
	public static void main(String[] args) throws Exception {
		SqlSession sqlSession = null;
		try {
			//指定mybatis全局配置文件
			String resource = "mybatis-config.xml";

			InputStream inputStream = Resources.getResourceAsStream(resource);

			//SqlSessionFactory加载配置文件
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream );

			//获得和数据库连接的会话对象
			sqlSession = sqlSessionFactory.openSession();

//			User user = sqlSession.selectOne("UserMapper.selectUserById",2L);
			//脚下留心:后续因为要遵守mybatis框架的自动映射规则，改了命名空间所以命名空间不一致了！！！
			User user = sqlSession.selectOne("com.dev.mapper.UserMapper.selectUserById",2L);

			System.out.println(user);
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}

}
