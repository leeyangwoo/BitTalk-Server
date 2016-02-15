package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
