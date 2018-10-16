package com.dev.dao.impl;

import com.dev.dao.IUserDao;
import com.dev.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements IUserDao {
	
	private SqlSession sqlSession;
	
	//注入sqlsession
	public UserDaoImpl(SqlSession sqlSession) {
		 this.sqlSession = sqlSession;
	}

	@Override
	public User selectUserById(Long id) {
		return  sqlSession.selectOne("UserDaoMapper.selectUserById", id);
	}

	@Override
	public List<User> selectAllUser() {
		 
		return  sqlSession.selectList("UserDaoMapper.selectAllUser");
	}

	@Override
	public void insertUser(User user) {
		 sqlSession.insert("UserDaoMapper.insertUser", user);
		 sqlSession.commit();
		
	}

	@Override
	public void updateUser(User user) {
		 sqlSession.update("UserDaoMapper.updateUser", user);
		 sqlSession.commit();
	}

	@Override
	public void deleteUserById(Long id) {
		sqlSession.delete("UserDaoMapper.deleteUserById", id);
		 sqlSession.commit();
	}
}
