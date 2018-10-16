package com.dev.dao;

import com.dev.pojo.User;

import java.util.List;


public interface IUserDao {
	
	public User queryUserById(Long id);
	
	public List<User> queryUserAll();
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUserById(Long id);
	
}
