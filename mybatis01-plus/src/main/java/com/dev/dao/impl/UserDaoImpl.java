package com.dev.dao.impl;

import com.dev.dao.IUserDao;
import com.dev.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class UserDaoImpl implements IUserDao {
	private SqlSession sqlSession;
	//组合关系导入对象
	public UserDaoImpl(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	@Override
	public User queryUserById(Long id) {
		
		return sqlSession.selectOne("UserDaoMapper.queryUserById", id);
	}

	@Override
	public List<User> queryUserAll() {
		
		return sqlSession.selectList("UserDaoMapper.queryUserAll");
	}

	@Override
	public void insertUser(User user) {
		sqlSession.insert("UserDaoMapper.insertUser", user);
		//要提交
		sqlSession.commit();//事务默认是设置为自提交的
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
