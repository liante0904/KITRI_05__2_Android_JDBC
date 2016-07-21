package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcT02Db {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String sql = "INSERT INTO MEMBERT01 "
				+ " VALUES('apple', 'apple', '사과맨', 'apple@apple.com', '010-1111-2222', '미국')";
		

		int su = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 접속 확인");
			conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("DB접속 확인");
			
			stmt = conn.createStatement();
			stmt.executeQuery(sql);
			System.out.println(su + "명 회원가입 성공");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
					DbClose.Close(conn, stmt);
			}
		}
	}