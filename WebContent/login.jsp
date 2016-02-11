<%@ page import="dao.MemberDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = request.getParameter("mid");
	String mpasswd = request.getParameter("mpasswd");
	
	MemberDAO dao = new MemberDAO();
	MemberDTO loginMember = dao.getMember(mid);
	
	if(loginMember == null){
		%>0<%
	}else if(loginMember != null && loginMember.getMpasswd().equals(mpasswd)){
		%>1<%
	}else{
		%>0<%
	}


%>