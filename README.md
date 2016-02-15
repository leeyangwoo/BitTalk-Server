# BitTalk-Server
<br>
<h4>URL</h4>
테이블 상황 URL: <b>192.168.1.35/BitTalkServer/index.jsp</b><br> 
로그인할 URL: <b>192.168.1.35/BitTalkServer/login.jsp</b><br>
Parameter : <b>mid / mpasswd</b><br>
<br>
회원가입 URL: <b>192.168.1.35/BitTalkServer/join.jsp</b><br>
Parameter : <b>mid / mpasswd / mname</b><br>
<br>
대화 시작하기 URL: <b>192.168.1.35/BitTalkServer/talk.jsp</b> (mainsrc에서 id검색 후 대화시작)<br>
Parameter : <b>mno1</b>(대화방개설자)/ <b>mno2</b>(초대받은 사람)<br>
return : {"result":"success"} / {"result":"fail"}<br>
<br>
문자열포함하는 아이디 검색 URL: <b>192.168.1.35/BitTalkServer/search.jsp</b> (mainsrc에서 id검색)<br>
Parameter : <b>mid</b>(mid 정확히 입력하지 않아도 검색가능)<br>
return ex) <br>
값이 2개일때 [{"mno":3,"mid":"dd","mpasswd":"1112","mname":"fff"},{"mno":6,"mid":"asdasd","mpasswd":"1234","mname":"asss"}]<br>
값이 없을때 []<br>
값 가져오는 법 ex) json[0].mno == 3 / json[1].mname.equals("asss")
<hr>
