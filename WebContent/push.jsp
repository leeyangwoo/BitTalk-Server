<%@ page import="dao.MemberDAO" %>
<%@ page import="dto.MemberDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>
    
    
<%
	int crno = Integer.parseInt(request.getParameter("crno"));
	MemberDAO mDao = new MemberDAO();
	List<MemberDTO> partMemberList= mDao.getPartMemberList(crno);
	
	MemberDTO[] partMemberArr = new MemberDTO[partMemberList.size()];
	for(int i=0;i<partMemberList.size();i++){
		partMemberArr[i] = partMemberList.get(i);
	}
	String partMemberArrJson = new Gson().toJson(partMemberArr);
	
	
%>
<%=partMemberArrJson%>