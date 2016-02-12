package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DBUtil;

public class ChatRoomDAO {
	public int setChatroom(){
		int resultCount = 0;	
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO chatroom(numparticipant) VALUES(2);";
			stmt = conn.prepareStatement(sql);
			
			resultCount = stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt);
		}
		return resultCount;
	}
}
