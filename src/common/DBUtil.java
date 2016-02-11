package common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() throws Exception{
		String url ="jdbc:mysql://localhost:3306/bittalk?useUnicode=true&characterEncoding=utf8";
		String user = "bit";
		String pw = "qlxm";
		Connection conn = getConnection(url, user, pw);
		return conn;
	}
	
	public static Connection getConnection(String url, String user, String pw) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, pw);
		return conn;
	}
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(conn, ps);
	}
	public static void close(Connection conn, PreparedStatement ps){
		//2.선언한 객체 닫기.
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
