<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#userName{ font-size: 20px; font-weight: bold; color: #2F64AA }
</style>
<script type="text/javascript">
window.onload=function() {
	document.getElementById("weekTitle").innerHTML="월요일";
}
</script>
</head>
<body>
<%
String[] names = {"민병조", "조나영", "남지우", "박제영", "김서우"};
String name = names[new Random().nextInt(names.length)];
%>
안녕하세요? <span id = "userName"><%=name%></span>님 로그인 하셨습니다.<br>
오늘은 <span id="weekTitle"></span>입니다.
<br>
안녕하세요?
<div><%=name%></div>
님 로그인 하셨습니다.
</body>
</html>