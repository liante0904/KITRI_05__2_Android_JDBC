package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MemberDTO.MemberDTO;


public class MemberDAO {

	
	MemberDTO dto = new MemberDTO();
	ResultSet rs = null;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	
	public MemberDTO daoT01() {
		
		String sql = "select *  from MEMBERT01 ";
		
		try {
			conn =  DbSet.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				dto.setMem_name(rs.getString("mem_name"));
				dto.setMem_id(rs.getString("mem_id"));
				dto.setMem_pwd(rs.getString("mem_pwd"));
				dto.setMem_email(rs.getString("mem_email"));  
				dto.setMem_phone(rs.getString("mem_phone"));
				dto.setMem_addr(rs.getString("mem_addr"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}
	
	
	public int memLogin(MemberDTO dto) {
		int flag =0;
		try {
			String sql = 	"SELECT count(*) FROM MEMBERT01 WHERE MEM_ID = ? AND MEM_PWD= ? ";
			

		
			conn = DbSet.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMem_id());
			pstmt.setString(2, dto.getMem_pwd());
			flag = pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DbClose.Close(conn, pstmt);
			
		}
		return flag;
		
	}
	
	public int memInsert(MemberDTO dto) {
		int flag =0;
		try { 
			String sql = "INSERT INTO MEMBERT01 (MEM_ID, MEM_PWD, MEM_NAME, MEM_EMAIL, MEM_PHONE, MEM_ADDR) VALUES (?,?,?,?,?,?)";
			conn = DbSet.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMem_id());
			pstmt.setString(2, dto.getMem_pwd());
			pstmt.setString(3, dto.getMem_name());
			pstmt.setString(4, dto.getMem_email());
			pstmt.setString(5, dto.getMem_phone());
			pstmt.setString(6, dto.getMem_addr());
			flag = pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DbClose.Close(conn, pstmt);
			
		}
		return flag;
		
	}
	
	public int memUpdate(MemberDTO dto) {
		int flag =0;
		try {
			String sql = "update MEMBERT01 SET  "
					+ "MEM_ID = ? , MEM_PWD = ? , MEM_NAME = ? , MEM_EMAIL = ? , MEM_PHONE = ? , MEM_ADDR = ? "
					+ " WHERE MEM_ID = ?, MEM_PWD = ?";
		
			conn = DbSet.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMem_id());
			pstmt.setString(2, dto.getMem_pwd());
			pstmt.setString(3, dto.getMem_name());
			pstmt.setString(4, dto.getMem_email());
			pstmt.setString(5, dto.getMem_phone());
			pstmt.setString(6, dto.getMem_addr());			
			pstmt.setString(7, dto.getMem_id());
			pstmt.setString(8, dto.getMem_pwd());
			flag = pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DbClose.Close(conn, pstmt);
			
		}
		return flag;
		
	}
	
	public int memDelete(MemberDTO dto) {
		int flag =0;
		try {
			String sql = "delete FROM MEMBERT01 "
					+ " WHERE MEM_ID = ? AND MEM_PWD = ?";
			conn = DbSet.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMem_id());
			pstmt.setString(2, dto.getMem_pwd());
			flag = pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DbClose.Close(conn, pstmt);
			
		}
		return flag;
		
	}

	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO();
		
		System.out.println(dao.daoT01().getMem_id());


	}
}
