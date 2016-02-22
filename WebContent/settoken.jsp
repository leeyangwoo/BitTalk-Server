<%@ page import="dao.MemberDAO" %>
<%@ page import="dto.MemberDTO" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>

    
<%

	int mno = Integer.parseInt(request.getParameter("mno"));
	String mtoken = request.getParameter("mtoken");
	MemberDAO mDao = new MemberDAO();
	int count = mDao.setToken(mno, mtoken);
	
	if(count == 1){
		%>{"result":"success"}<%
	}else{
		%>{"result":"fail"}<%
	}




%>