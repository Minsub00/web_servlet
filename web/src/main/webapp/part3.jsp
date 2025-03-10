<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String mid = (String) request.getAttribute("mid");
	String mname = (String) request.getAttribute("mname");
	String mtel = (String) request.getAttribute("mtel");
	String memail = (String) request.getAttribute("memail");
	String image = (String) request.getAttribute("image");
	//substring(문자배열0부터 시작, 문자열1부터 시작)
	if(mtel.length() == 11){
		mtel = mtel.substring(0,3) + "****" + mtel.substring(7);
	} else if (mtel.length() == 10){
		mtel = mtel.substring(0,3) + "***" + mtel.substring(7);		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료 페이지</title>
</head>
<body>
<p>회원가입이 완료되었습니다.</p>
아이디 : <%=mid %><br>
고객명 : <%=mname %><br>
이메일 : <%=memail %><br>
전화번호 : <%=mtel %><br>
<%
if(image != ""){
%>
<img src="./user/<%=image %>" style="width:100px; height:100px;">
<%
}
%>
</body>
</html>