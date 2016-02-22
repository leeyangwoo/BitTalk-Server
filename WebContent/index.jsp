<%@ page import="dao.ParticipateDAO" %>
<%@ page import="dto.ParticipateDTO" %>
<%@ page import="dao.ChatmsgDAO" %>
<%@ page import="dto.ChatmsgDTO" %>
<%@ page import="dao.ChatroomDAO" %>
<%@ page import="dto.ChatroomDTO" %>
<%@ page import="dao.MemberDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.MemberDTO" %>
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
<script>

</script>
</head>
<body>
<h1>회원목록</h1>
	<table>
	<tr>
		<th>mno</th><th>mid</th><th>mpasswd</th><th>mname</th><th>mtoken</th>
	</tr>
	<%
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> memberList = dao.getMemberList();
		for(int i = 0; i < memberList.size(); i++){
			MemberDTO member = memberList.get(i);
	%><tr>
			<td><%=member.getMno()%></td>
			<td><%=member.getMid() %></td>
			<td><%=member.getMpasswd() %></td>
			<td><%=member.getMname() %></td>
			<td><%=member.getMtoken() %></td>
	</tr>
	<%}//for end %>
</table>
               <!----------  아직 안됨  ---------------  -->
<h1>회원 검색</h1>
<input type="text" id="src"/>
<input type="button" id="srcBtn" value="검색"/> 여기서 검색하는건 아직 안됨.. <a href="src.jsp">/src.jsp?mid=아이디</a>
	<table>
	<tr>
		<th>mno</th><th>mid</th><th>mpasswd</th><th>mname</th>
	</tr>

<%
	String mid = request.getParameter("mid");
	MemberDAO mDAO = new MemberDAO();
	List<MemberDTO> smemberList = mDAO.searchMemberList(mid);
	for(int i = 0; i < smemberList.size(); i++){
		MemberDTO member = memberList.get(i);
%><tr>
		<td><%=member.getMno()%></td>
		<td><%=member.getMid() %></td>
		<td><%=member.getMpasswd() %></td>
		<td><%=member.getMname() %></td>
</tr>
<%}//for end %>
</table>
                                <!-- --------------------- -->
<h1>채팅방목록</h1>
	<table>
	<tr>
		<th>crno</th><th>numparticipant</th>
	</tr>
	<%
		ChatroomDAO crDao = new ChatroomDAO();
		List<ChatroomDTO> chatroomList = crDao.getChatroomList(); 
		for(int i = 0; i < chatroomList.size(); i++){
			ChatroomDTO chatroom = chatroomList.get(i);
	%><tr>
			<td><%=chatroom.getCrno()%></td>
			<td><%=chatroom.getNumparticipant() %></td>
	</tr>
	<%}//for end %>
</table>
<h1>참가목록</h1>
	<table>
	<tr>
		<th>mno</th><th>crno</th>
	</tr>
	<%
		ParticipateDAO pDao = new ParticipateDAO();
		List<ParticipateDTO> partList = pDao.getPartList(); 
		for(int i = 0; i < partList.size(); i++){
			ParticipateDTO part = partList.get(i);
	%><tr>
			<td><%=part.getMno()%></td>
			<td><%=part.getCrno() %></td>
	</tr>
	<%}//for end %>
</table>
 
</body>
</html>