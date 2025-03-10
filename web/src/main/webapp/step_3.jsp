<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	String userid = (String) request.getAttribute("mid");
	String username = (String) request.getAttribute("mname");
	String useremail = (String) request.getAttribute("mmail");
	String phone = (String) request.getAttribute("mnumber");
	
	if (userid == null) userid = "값 없음";
	if (username == null) username = "값 없음";
	if (useremail == null) useremail = "값 없음";
	if (phone == null) {
	    phone = "00000000000";  // 기본값 설정
	}
	
	String phone1 = phone.substring(0, 3) + "****" + phone.substring(7);
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
</head>
<body>
회원가입이 완료되었습니다.<br>
아이디 <%=userid %><br>
고객명 <%=username %><br>
이메일 <%=useremail %><br>
휴대폰 번호 <%=phone1 %>
<br><br>
<p>아이디 (getAttribute): <%= (String) request.getAttribute("mid") %></p>
<p>아이디 (getParameter): <%= request.getParameter("mid") %></p>
</body>
</html>