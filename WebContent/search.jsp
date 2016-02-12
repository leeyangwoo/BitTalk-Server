<%@ page import="dao.MemberDAO" %>
<%@ page import="dto.MemberDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>

<%
	String mid = request.getParameter("mid");
	MemberDAO mDAO = new MemberDAO();
	List<MemberDTO> memberList = mDAO.searchMemberList(mid);
	
	MemberDTO[] mArr = new MemberDTO[memberList.size()];
	for(int i=0;i<memberList.size();i++){
		mArr[i] = memberList.get(i);
	}
	String mArrJson = new Gson().toJson(mArr);
		
%>
<%=mArrJson%>