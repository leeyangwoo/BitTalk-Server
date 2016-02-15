package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBUtil;
import dto.ChatmsgDTO;

public class ChatmsgDAO {
	public List<ChatmsgDTO> getChatmsgList(){                     //모든 채팅방 목록
		List<ChatmsgDTO> chatmsgList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM chatmsg;");
			rs = stmt.executeQuery();
			while(rs.next()){
				ChatmsgDTO chatmsg = new ChatmsgDTO();
				chatmsg.setCmno(rs.getInt(1));
				chatmsg.setCrno(rs.getInt(2));
				chatmsg.setMsg(rs.getString(4));
				chatmsg.setSenderno(rs.getInt(3));
				chatmsg.setSendtime(rs.getTimestamp(5));
				chatmsgList.add(chatmsg);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		return chatmsgList;
	}
}
