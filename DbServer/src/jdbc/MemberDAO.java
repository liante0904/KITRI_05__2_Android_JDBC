package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MemberDTO.MemberDTO;


public class MemberDAO {

	public MemberDTO daoT01() {
		String sql = "select *  from MEMBERT01 ";
		MemberDTO dto = new MemberDTO();
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
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

	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO();
		
		System.out.println(dao.daoT01().getMem_id());


	}
}
