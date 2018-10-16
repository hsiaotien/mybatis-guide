package com.dev.dao;

import com.dev.pojo.User;

import java.util.List;


public interface IUserDao {

	// 根据id查询
	User selectUserById(Long id);

	// 查询全部
	List<User> selectAllUser();

	// 新增用户
	void insertUser(User user);

	// 修改用户
	void updateUser(User user);

	// 删除用户
	void deleteUserById(Long id);

}
