package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBUtil;
import dto.ChatroomDTO;
import dto.ParticipateDTO;

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
	
	public List<ChatroomDTO> getMyChatroom(int mno){
		List<ChatroomDTO> chatroomList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt =null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM chatroom WHERE crno IN (SELECT crno FROM participate WHERE mno = ?);");
			stmt.setInt(1, mno);
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
	
	
	public int setChatroom(int mno1, int mno2){            //id받아 채팅방 개설
		int isSuccess = 0;
		int goStop = checkTalk(mno1,mno2);
		
		if(goStop == 1){
			
			isSuccess = 2;
			
		}else if(goStop == 0){
			Connection conn = null;
			PreparedStatement stmt = null;
			try{
				conn = DBUtil.getConnection();
				stmt = conn.prepareStatement("SELECT * FROM participate;");  //임시 문장
				
				conn.setAutoCommit(false); // 트랜잭션 시작
				stmt.executeUpdate("INSERT INTO chatroom(numparticipant) VALUES(1);"); //chatroom 테이블에 인원수 2 레코드 추가
				stmt.executeUpdate("INSERT INTO participate VALUES("+mno1+","
						+ "(SELECT crno FROM chatroom ORDER BY crno DESC LIMIT 1));"); // 가장 최근에 개설된 crno 가져와 participate 테이블에 추가
				
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
		}
		return isSuccess;
	}
	
	public int checkTalk(int mno1, int mno2){     //대화중인 방이 있는지 확인
		int numOfRoom = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT count(*) FROM participate "
					+ "WHERE crno IN (SELECT A.crno FROM chatroom as A INNER JOIN participate as B "
					+ "WHERE A.crno = B.crno AND numparticipant=2 AND mno=?) AND mno=?;");
			// chatroom 테이블과 participate 조인 후 참가자수 2명이고 두 명이 참가하고 있는 채팅방 수 조회, 방이 있다면 1 없다면 0
			stmt.setInt(1, mno1);
			stmt.setInt(2, mno2);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				numOfRoom = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		return numOfRoom;
	}
	
	public ParticipateDTO getParticipate(int mno1, int mno2){    //대화중인 경우 대화상대번호와 방번호 리턴
		ParticipateDTO partInfo = new ParticipateDTO();
		partInfo.setMno(mno2);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT crno FROM participate "
					+ "WHERE crno IN (SELECT A.crno FROM chatroom as A INNER JOIN participate as B "
					+ "WHERE A.crno = B.crno AND numparticipant=2 AND mno=?) AND mno=?;");
			// chatroom 테이블과 participate 조인 후 참가자수 2명이고 두 명이 참가하고 있는 채팅방 번호 조회
			stmt.setInt(1, mno1);
			stmt.setInt(2, mno2);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				partInfo.setCrno(rs.getInt(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		return partInfo;
	}
	
	public ParticipateDTO makeParticipate(int mno1, int mno2){
		ParticipateDTO partInfo = new ParticipateDTO();
		partInfo.setMno(mno2);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT pa.crno FROM chatroom AS ch INNER JOIN "
					+ "participate AS pa ON ch.crno = pa.crno ORDER BY ch.crno DESC LIMIT 1;");
			//	가장 최근에 추가된 방번호 조회
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				partInfo.setCrno(rs.getInt(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		return partInfo;
	}
}
