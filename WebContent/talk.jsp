<%@ page import="dao.ChatroomDAO" %>
<%@ page import="dto.MemberDTO" %>
<%@ page import="dto.ParticipateDTO" %>
<%@ page import="dao.MemberDAO" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>
<%
	int mno1=0, mno2=0;
	
	try{
		mno1 = Integer.parseInt(request.getParameter("mno1"));
		mno2 = Integer.parseInt(request.getParameter("mno2"));
		
		ChatroomDAO crDao = new ChatroomDAO();
		
		int isSuccess = crDao.setChatroom(mno1, mno2);
		

		if(isSuccess==2){
			ParticipateDTO partInfo = crDao.getParticipate(mno1, mno2);
			%>{"result":"success",
				"detail":"exist",
				"mno": <%=partInfo.getMno()%>,
				"crno":<%=partInfo.getCrno()%>}<%	
		}else if(isSuccess == 1){
			ParticipateDTO partInfo = crDao.makeParticipate(mno1, mno2);
			%>{"result":"success",
				"detail":"new",
				"mno":<%=partInfo.getMno()%>,
				"crno":<%=partInfo.getCrno()%>}<%
		}else{
			%>{"result":"fail"}<%
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
	}
	
	
	


%>