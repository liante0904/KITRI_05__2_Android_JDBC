package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcT02Db {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String sql = "INSERT INTO MEMBERT01 "
				+ " VALUES('apple', 'apple', '�����', 'apple@apple.com', '010-1111-2222', '�̱�')";
		

		int su = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ���� Ȯ��");
			conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("DB���� Ȯ��");
			
			stmt = conn.createStatement();
			stmt.executeQuery(sql);
			System.out.println(su + "�� ȸ������ ����");
			
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