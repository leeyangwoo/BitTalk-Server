<%@ page import="dao.ChatroomDAO" %>
<%@ page import="dto.MemberDTO" %>
<%@ page import="dao.MemberDAO" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>
<%

	String mid = request.getParameter("mid");

	ChatroomDAO crDao = new ChatroomDAO();
	MemberDAO mDao = new MemberDAO();
	MemberDTO member = mDao.getMember(mid);	
	
	int count = crDao.setChatroom(member.getMno());
	

	if(count==1){

		%>{"result":"success"}<%	
	}else{
		%>{"result":"fail"}<%
	}
	
	


%>