<%@ page import="dao.ParticipateDAO" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>
<%

	int mno = Integer.parseInt(request.getParameter("mno"));
	int crno = Integer.parseInt(request.getParameter("crno"));
	
	ParticipateDAO pDao = new ParticipateDAO();
	int result = pDao.invited(mno, crno);
	
	if(result == 1){
		%>{"result":"success"}<%		
	}else if(result == 0){
		%>{"result":"fail"}<%		
	}


%>