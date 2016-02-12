<%@ page import="dao.MemberDAO" %>
<%@ page import="dto.MemberDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BitTalk 테이블리스트</title>
<style>
th {
margin:5px;
padding:5px;
}
td{
margin:5px;
padding:5px;
}
</style>
</head>
<body>
<h1>회원검색</h1>
	<table>
	<tr>
		<th>mno</th><th>mid</th><th>mpasswd</th><th>mname</th>
	</tr>

<%
	String mid = request.getParameter("mid");
	MemberDAO mDAO = new MemberDAO();
	List<MemberDTO> memberList = mDAO.searchMemberList(mid);
	for(int i = 0; i < memberList.size(); i++){
		MemberDTO member = memberList.get(i);
%><tr>
		<td><%=member.getMno()%></td>
		<td><%=member.getMid() %></td>
		<td><%=member.getMpasswd() %></td>
		<td><%=member.getMname() %></td>
</tr>
<%}//for end %>
</table>

</body>
</html>