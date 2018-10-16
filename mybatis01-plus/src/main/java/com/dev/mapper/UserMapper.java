package com.dev.mapper;

import com.dev.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UserMapper {
	
	public User queryUserById(Long id);
	
	public List<User> queryUserAll();
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUserById(Long id);
	
	//根据表名查询用户信息
	public List<User> queryUserAllByTable(String tableName);
	
	//第二种方式查询,引入注解,不用默认的value来接收
	public List<User> queryUserByTable(@Param("tableName") String tableName);
	//根据用户名和密码登陆
	public User loginByUsernameAndPassword(@Param("userName") String userName, @Param("password") String password);
	//登陆hashmap方式
	public User loginByHashMap(Map<String, Object> map);
	//登陆pojo方式
	public User loginByPojo(User user);
	//根据用户名模糊查询
	public List<User> queryUserLike(@Param("keyName") String keyName);
	//查找男性(1)中,模糊查询
	public List<User> queryBoyUserLike(@Param("sex") int sex, @Param("keyName") String keyName);
	
	/**
	 * 5月21日 continue
	 */
	// 查询男性用户，如果输入了用户名，按用户名模糊查询
	public List<User> selectUserByUserName(@Param("userName") String userName);
	//查询男性用户，如果输入了用户名则按照用户名模糊查找，
	//否则如果输入了年龄则按照年龄查找，否则查找用户名为“zhangsan”的用户。
	public List<User> selectUserByUserNameOrAge(@Param("age") int age, @Param("userName") String userName);
	//查询所有用户，如果输入了用户名按照用户名进行模糊查询，
	//如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立。
	public List<User> selectUserByUserNameAndAge(@Param("userName") String userName, @Param("age") int age);
	//测试跟上面类似的条件, 两个条件任意一个就成立, 即在where中套choose
	public List<User> selectUserByWhereAndChoose(@Param("userName") String userName, @Param("age") int age);
	//set的用法
	//修改用户信息，如果参数user中的某个属性为null，则不修改。(意思一下,找两个参数即可)
	public void updateUserByNotNull(User user);
	//按照多个id查询用户信息 foreach的用法, 本质也是一个拼接
	public List<User> selectUserByForeach(@Param("ids") Long[] ids);

}
