# BitTalk-Server
<br>
<h4>URL</h4>
<ul>
  <li>테이블 상황 URL: <b>192.168.1.35/BitTalkServer/index.jsp</b><br> </li><br>
  <li>
    <ul>
      <li>로그인할 URL: <b>192.168.1.35/BitTalkServer/login.jsp</b></li>
      <li>Parameter : <b>mid / mpasswd</b></li>
    </ul>
  </li><br>
  <li>
    <ul>
      <li>회원가입 URL: <b>192.168.1.35/BitTalkServer/join.jsp</b></li>
      <li>Parameter : <b>mid / mpasswd / mname</b></li>
    </ul>
  </li><br>
  <li>
    <ul>
      <li>대화 시작하기 URL: <b>192.168.1.35/BitTalkServer/talk.jsp</b> (mainsrc에서 id검색 후 대화시작)</li>
      <li>Parameter : <b>mno1</b>(대화방개설자)/ <b>mno2</b>(초대받은 사람)</li>
      <li>return : {"result":"success"} / {"result":"fail"}</li>
    </ul>
  </li><br>
  <li>
    <ul>
      <li>문자열포함하는 아이디 검색 URL: <b>192.168.1.35/BitTalkServer/search.jsp</b> (mainsrc에서 id검색)</li>
      <li>Parameter : <b>mid</b>(mid 정확히 입력하지 않아도 검색가능)</li>
      <li>return : 
        <ul>
          <li>값이 2개일때 [{"mno":3,"mid":"dd","mpasswd":"1112","mname":"fff"},{"mno":6,"mid":"asdasd","mpasswd":"1234","mname":"asss"}]</li>
          <li>값이 없을때 []</li>
          <li>값 가져오는 법 ex) json[0].mno == 3 / json[1].mname.equals("asss")</li>
        </ul>
      </li>
    </ul>
  </li><br>
  <li>
    <ul>
      <li>초대하기 URL: <b>192.168.1.35/BitTalkServer/invite.jsp</b> (채팅방참가자수 +1, 참가테이블 레코드 추가)</li>
      <li>Parameter : <b>mno</b>(초대받는 사람)/ <b>crno</b>(대화할 방 번호)</li>
      <li>return : {"result":"success"} / {"result":"fail"}</li>
    </ul>
  </li><br>
  <li>
    <ul>
      <li>Token설정 URL: <b>192.168.1.35/BitTalkServer/settoken.jsp</b> (member token 추가)</li>
      <li>Parameter : <b>mno</b>(member no)/ <b>mtoken</b>(토큰 값)</li>
      <li>return : {"result":"success"} / {"result":"fail"}</li>
    </ul>
  </li>
</ul>
<hr>
