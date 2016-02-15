<%@ page import="dao.ChatroomDAO" %>
<%@ page import="dto.MemberDTO" %>
<%@ page import="dao.MemberDAO" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>
<%
	int mno1=0, mno2=0;
	
	try{
		mno1 = Integer.parseInt(request.getParameter("mno1"));
		mno2 = Integer.parseInt(request.getParameter("mno2"));
		
		ChatroomDAO crDao = new ChatroomDAO();
		
		int count = crDao.setChatroom(mno1, mno2);
		

		if(count==2){

			%>{"result":"success",
				"detail":"exist"}<%	
		}else if(count == 1){
			%>{"result":"success",
				"detail":"new"}<%
		}else{
			%>{"result":"fail"}<%
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
	}
	
	
	


%>