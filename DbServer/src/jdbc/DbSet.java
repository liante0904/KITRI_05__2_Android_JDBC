package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSet {
	
	
	public static Connection getConnection() throws SQLException{
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ���� Ȯ��");
			conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("DB���� Ȯ��");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
