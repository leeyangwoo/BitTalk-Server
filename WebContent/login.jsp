<%@ page import="dao.MemberDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.MemberDTO" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>

<%
	String mid = request.getParameter("mid");
	String mpasswd = request.getParameter("mpasswd");
	
	MemberDAO dao = new MemberDAO();
	MemberDTO loginMember = dao.getMember(mid);
	
	if(loginMember == null){
		%>{"result":"fail"}<%
		System.out.println(mid+mpasswd);
	}else if(loginMember != null && loginMember.getMpasswd().equals(mpasswd)){
		%>{"result":"success"}<%
		System.out.println(mid+mpasswd);
	}else{
		%>{"result":"fail"}<%
		System.out.println(mid+mpasswd);
	}


%>