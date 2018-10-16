package com.dev.mapper;

import com.dev.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

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

	//根据表名查询用户信息
	List<User> selectUserByTableName(@Param("tableName") String tableName);

	//登录方法,根据用户名和密码查询用户信息
	User login(@Param("userName") String userName, @Param("password") String password);

	//登录方法,通过HashMap传参
	User loginMap(Map<String, String> map);

	//根据用户名模糊查询用户信息
	List<User> selectUserByNameLike(@Param("userName") String userName);
	
	//案例：查询男性用户，如果输入了用户名，按用户名模糊查询
	List<User> selectUserBySexAndNameLike(@Param("userName") String userName);
	
	//查询男性用户，如果输入了用户名则按照用户名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找用户名为“zhangsan”的用户。
	List<User> selectUserBySexAndUserNameLikeOrAge(@Param("userName") String userName, @Param("age") Integer age);
	
	//查询所有用户，如果输入了用户名按照用户名进行模糊查询，如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立。
	List<User> selectUsersByUserNameLikeAndAge(@Param("userName") String userName, @Param("age") Integer age);
	
	//修改用户信息，如果参数user中的某个属性为null，则不修改。
	void updateSelectvice(User user);
	
	//根据多个用户id查询用户列表
	List<User> selectUsersByIds(@Param("ids") Long[] ids);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
