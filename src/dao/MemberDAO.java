package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBUtil;
import dto.MemberDTO;

public class MemberDAO {
	public List<MemberDTO> getMemberList(){
		List<MemberDTO> memberList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM member;");
			rs = stmt.executeQuery();
			while(rs.next()){
				MemberDTO member = new MemberDTO();
				member.setMno(rs.getInt(1));
				member.setMid(rs.getString(2));
				member.setMpasswd(rs.getString(3));
				member.setMname(rs.getString(4));
				memberList.add(member);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn,stmt,rs);
		}
		
		return memberList;
	}
	
	public MemberDTO getMember(String mid){
		MemberDTO member = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM member WHERE mid=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mid);
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				member = new MemberDTO();
				member.setMno(rs.getInt(1));
				member.setMid(rs.getString(2));
				member.setMpasswd(rs.getString(3));
				member.setMname(rs.getString(4));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		
		return member;
	}
	
	public MemberDTO getMember(int mno){
		MemberDTO member = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM member WHERE mno=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, mno);
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				member = new MemberDTO();
				member.setMno(rs.getInt(1));
				member.setMid(rs.getString(2));
				member.setMpasswd(rs.getString(3));
				member.setMname(rs.getString(4));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		
		return member;
	}
}