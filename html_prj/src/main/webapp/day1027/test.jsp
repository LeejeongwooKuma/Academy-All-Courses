<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
오늘은 <strong><%= sdf.format(new Date()) %></strong>입니다.
이름 : ${param.name2}님 어서오고<br>
아이디 : ${param.id}님 어서오고<br>
주소 : ${param.addr}에 거주중이군요.<br>

<a href = "#void" onclick = "history.back()">뒤로</a>
</body>
</html>