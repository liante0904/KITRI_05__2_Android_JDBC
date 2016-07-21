package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcT03Db {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String sql = "select *  from MEMBERT01 ";
				

		int su = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs= null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 접속 확인");
			conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("DB접속 확인");
			
			stmt = conn.createStatement();
			rs =stmt.executeQuery(sql);
			
		
			
			String vName , vId, vPwd, vEmail, vPhone, vAddr;
			while (rs.next()) {
				vName  = rs.getString("mem_name") ;
				vId = rs.getString("mem_id") ;
				vPwd = rs.getString("mem_pwd") ;
				vEmail = rs.getString("mem_email") ;
				vPhone = rs.getString("mem_phone") ;
				vAddr = rs.getString("mem_addr") ;
				
				System.out.println(vName +" \n  "+ vId+" \n  "+ vPwd+" \n  "+ vEmail+" \n  "+ vPhone+" \n  "+ vAddr);

			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
				DbClose.Close(conn, stmt, rs);
				
/*				rs.close();
				stmt.close();
				conn.close();		
*/			
			}
		}
	}

