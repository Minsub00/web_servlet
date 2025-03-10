<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
ArrayList<ArrayList<String>> notice = (ArrayList<ArrayList<String>>)request.getAttribute("result");
// 페이지 번호 생성
/*
페이징 생성 방법
1. 한 페이지 당 몇개씩 데이터를 출력할 것인지를 설정.
2. 데이터 총 갯수 / 한 페이지 당 출력할 데이터 갯수 
3. Math.ceil로 소숫점이 나올경우 반올림하여 페이지를 추가 생성
*/
String total_page = notice.get(0).get(5);
int pg = 1;
if(total_page != null || total_page.equals("")){
	float pg2 = Integer.parseInt(total_page) / 3f;
	pg = (int)Math.ceil(pg2);
}
//get page번호를 가져오는 방식
String pno = request.getParameter("pageno");
out.print(pno);
if(pno == null || pno.equals(1)){ // 최초 접근시 페이지 번호가 없음 or 1번 페이지 클릭
	pno = "1";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트</title>
</head>
<body>
<p>현재 등록된 게시물 : <%=notice.get(0).get(5) %></p>
<table border="1" cellpadding="0" cellspacing="0">
<thead>
	<tr>
		<th width="50">번호</th>
		<th width="500">제목</th>
		<th width="100">글쓴이</th>
		<th width="100">조회</th>
		<th width="150">등록일</th>
	</tr>		
</thead>
<tbody>
<%
	int f;

	// 총 데이터 갯수 - ((페이지 번호 - 1) * 페이지 당 출력 갯수)
	int total = Integer.parseInt(total_page) - ((Integer.parseInt(pno) - 1) * 3); // 리스트 출력 번호를 총 데이터 갯수로 처리
	for(f=0; f<notice.size(); f++){
%>
	<tr height="30" align="center">
		<td><%=total %></td>
		<td align="left" onclick="notice_view(<%=notice.get(f).get(0)%>)"><%=notice.get(f).get(1) %></td>
		<td><%=notice.get(f).get(2) %></td>
		<td><%=notice.get(f).get(3) %></td>
		<td><%=notice.get(f).get(4).substring(0,10) %></td>
	</tr>
<%
	total--;
	}
%>
</tbody>
</table>
<br><br><br>
<table>
<tr>
<%
int w = 1;
while (w <= pg){
%>
	<td width=20 height=20 align="center"><a href="./notice_list.do?pageno=<%=w %>"><%=w %></a></td>
<%
	w++;
}
%>
</tr>
</table>
</body>
<script>
function notice_view(no){
	// 해당 게시물의 내용 및 첨부파일을 확인 할 수 있는 view 페이지
	location.href = './notice_view.do?nidx='+no;
}
</script>
</html>