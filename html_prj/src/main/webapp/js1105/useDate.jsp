<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function() {
		var date=new Date();//접속자의 시간
		
		let output =`${date.getFullYear()}년 ${ date.getMonth()}월 ${date.getDate()}일`;
		output += `${date.getHours()}시 ${date.getMinutes()}분 ${date.getSeconds()}초`;
		//document.getElementById("dateOut").innerHTML=date;
		document.getElementById("dateOut").innerHTML=output;
	}
</script>
</head>
<body>
<div>
<%
	//여기서(JSP) 시간을 설정해야지 동일한 시간을 뿌려줄 수 있음.위에 JS 스크립트에서 하면 에러!!
	Date date=new Date();
	String output= new SimpleDateFormat("yyyy년MM월dd일").format(date);
	
%>
<strong>서버의 시간</strong> : <%= new Date() %><br><!-- 모든 접속자에게 동일한 시간 -->
<strong>접속자의 시간</strong> : <span id="dateOut"></span><!-- 모든 접속자에게 동일한 시간이 아닐 수도 있다. -->
</div>
</body>
</html>