import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {

	
	public static void main(String[] args) throws Exception {
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.获得连接对象
		String url = "jdbc:mysql://localhost:3306/mybatis_test";
		String user = "root";
		String password  = "123";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//3.创建语句对象
		String sql ="select * from tb_user where id = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		
		//3.1 设置语句参数
		stat.setLong(1, 1L);
 
		//4.发送sql语句
		ResultSet rs = stat.executeQuery();
		//5.处理结果集
		while(rs.next()){
			
			System.out.println(rs.getString("user_name"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("password"));
			
		}
		
		//6.释放资源
		rs.close();
		stat.close();
		conn.close();

		
	}
}
