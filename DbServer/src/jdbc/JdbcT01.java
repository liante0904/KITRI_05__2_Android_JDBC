package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcT01 {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 접속 확인");
			DriverManager.getConnection(url, "hr", "hr");
			System.out.println("DB접속 확인");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
