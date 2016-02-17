package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBUtil;
import dto.ParticipateDTO;

public class ParticipateDAO {
	public List<ParticipateDTO> getPartList(){                      //참가 목록
		List<ParticipateDTO> partList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM participate ORDER BY crno ASC;");
			rs = stmt.executeQuery();
			while(rs.next()){
				ParticipateDTO part = new ParticipateDTO();
				part.setMno(rs.getInt(1));
				part.setCrno(rs.getInt(2));
				partList.add(part);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		return partList;
	}
	
	public int invited(int mno, int crno){
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM participate");
			
			conn.setAutoCommit(false);
			stmt.executeUpdate("UPDATE chatroom SET numparticipant = numparticipant+1"
					+ " WHERE crno="+crno+";");
			stmt.executeUpdate("INSERT INTO participate VALUES("+mno+","+crno+");");
			conn.commit();
			result = 1;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				conn.setAutoCommit(true);
				DBUtil.close(conn, stmt);
			}catch(SQLException sqle){}
		}
		return result;
	}
}
