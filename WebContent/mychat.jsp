<%@ page import="dao.ChatroomDAO" %>
<%@ page import="dto.ChatroomDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>
<%	
	int mno = Integer.parseInt(request.getParameter("mno"));
	ChatroomDAO crDao = new ChatroomDAO();
	List<ChatroomDTO> mychatList = crDao.getMyChatroom(mno);
	
	ChatroomDTO[] crArr = new ChatroomDTO[mychatList.size()];
	for(int i=0;i<mychatList.size();i++){
		crArr[i] = mychatList.get(i);
	}
	String crArrJson = new Gson().toJson(crArr);
		
%>
<%=crArrJson%>