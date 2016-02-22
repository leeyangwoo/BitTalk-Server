<%@ page import="dao.MemberDAO" %>
<%@ page import="dto.MemberDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>
    
    
<%
	int crno = Integer.parseInt(request.getParameter("crno"));
	MemberDAO mDao = new MemberDAO();
	List<String> tokens = mDao.getTokens(crno);
	
	String[] tokenArr = new String[tokens.size()];
	for(int i=0;i<tokens.size();i++){
		tokenArr[i] = tokens.get(i);
	}
	String tokenArrJson = new Gson().toJson(tokenArr);
	
	
%>
<%=tokenArrJson%>