package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBUtil;
import dto.ChatroomDTO;

public class ChatroomDAO {
	public List<ChatroomDTO> getChatroomList(){                     //모든 채팅방 목록
		List<ChatroomDTO> chatroomList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM chatroom;");
			rs = stmt.executeQuery();
			while(rs.next()){
				ChatroomDTO chatroom = new ChatroomDTO();
				chatroom.setCrno(rs.getInt(1));
				chatroom.setNumparticipant(rs.getInt(2));
				chatroomList.add(chatroom);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		return chatroomList;
	}
	
	
	public int setChatroom(int id){                                    //id받아 채팅방 개설
		int isSuccess = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM participate;");
			
			conn.setAutoCommit(false); // 트랜잭션 시작
			stmt.executeUpdate("INSERT INTO chatroom(numparticipant) VALUES(2);");
			stmt.executeUpdate("INSERT INTO participate VALUES("+id+","
					+ "(SELECT crno FROM chatroom ORDER BY crno DESC LIMIT 1));");
			
			conn.commit(); // 트랜잭션 종료
			isSuccess = 1;
		}catch(Exception e){
			e.printStackTrace();
			if(conn!=null){
				try{
					conn.rollback();
				}catch(SQLException sqle){}
			}
		}finally{
			try{
				conn.setAutoCommit(true);
				DBUtil.close(conn, stmt);
			}catch(SQLException sqle){}
			
		}
		return isSuccess;
	}
}