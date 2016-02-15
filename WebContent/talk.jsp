<%@ page import="dao.ChatroomDAO" %>
<%@ page import="dto.MemberDTO" %>
<%@ page import="dao.MemberDAO" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>
<%

	int mno1 = Integer.parseInt(request.getParameter("mid1"));
	int mno2 = Integer.parseInt(request.getParameter("mid2"));

	ChatroomDAO crDao = new ChatroomDAO();
	
	int count = crDao.setChatroom(mno1, mno2);
	

	if(count==2){

		%>{"result":"exist"}<%	
	}else if(count == 1){
		%>{"result":"success"}<%
	}else{
		%>{"result":"fail"}<%
	}
	
	


%>