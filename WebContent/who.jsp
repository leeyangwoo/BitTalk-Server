<%@ page import="dao.MemberDAO" %>
<%@ page import="dto.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int mno = Integer.parseInt(request.getParameter("mno"));
	MemberDAO mDao = new MemberDAO();
	MemberDTO member = mDao.getMember(mno);
	if(member != null){
		%>{"result":"success",
			"mno":<%=member.getMno()%>,
			"mid":<%=member.getMid()%>,
			"mpasswd":<%=member.getMpasswd()%>,
			"mname":<%=member.getMname()%>}<%
	}else{
		%>{"result":"fail"}<%
	}



%>