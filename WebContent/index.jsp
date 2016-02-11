<%@ page import="dao.MemberDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>

	<%
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> memberList = dao.getMemberList();
		for(int i = 0; i < memberList.size(); i++){
			MemberDTO member = memberList.get(i);
	%>
			<%=member.getMno() %><br>
			<%=member.getMid() %><br>
			<%=member.getMpasswd() %><br>
			<%=member.getMname() %><br>
	
	<%}//for end %>

</body>
</html>