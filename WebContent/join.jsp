<%@ page import="dto.MemberDTO" %>
<%@ page import="dao.MemberDAO" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("utf-8");

	MemberDTO member = new MemberDTO();
	MemberDAO dao = new MemberDAO();

	member.setMno(0);
	member.setMid(request.getParameter("mid"));
	member.setMpasswd(request.getParameter("mpasswd"));
	member.setMname(request.getParameter("mname"));
	member.setMtoken(request.getParameter("mtoken"));

	int count = dao.setMember(member);

	if(count==1){

		%>{"result":"success"}<%	
	}else{
		%>{"result":"fail"}<%
	}

%>
