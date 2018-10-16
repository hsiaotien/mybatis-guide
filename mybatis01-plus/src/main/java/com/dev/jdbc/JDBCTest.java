package com.dev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {

	public static void main(String[] args) throws Exception {
		//声明
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		String url = "jdbc:mysql://127.0.0.1:3306/mybatis";
		String user = "root";
		String password = "123";
		conn = DriverManager.getConnection(url, user, password);
		//创建预编译语句对象
		String sql = "select * from tb_user where id=?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, 1);
		//执行语句得到结果集
		rs = ps.executeQuery();
		//遍历结果集
		while(rs.next()){
			String user_name = rs.getString("user_name");
			System.out.println(user_name);
		}
		//释放资源
		rs.close();
		ps.close();
		conn.close();
	}
}