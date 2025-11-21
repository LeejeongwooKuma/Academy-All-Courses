<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="입력 폼에 입력된 값을 받아서 처리하는 일."%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//request 내장객체를 사용하여 HTML Form Control에 입력된 값을 받기.
//id=testsdfg&pass=minjo123&birth=2025-11-06&loc=서울&intro=내소개&code=U3881
//위에 보니 parameter명이 전부 유일하다 => String 변수명 = request.getParameter("파라메터명"); 사용하자.
String id = request.getParameter("id");
String pass = request.getParameter("pass");
String birth= request.getParameter("birth");
String location= request.getParameter("loc");
String intro = request.getParameter("intro");
String code = request.getParameter("code");
//입력한 값을 유효성검증 ( back-end ) > 서비스객체 > DAO > 리턴값 서비스 받아 > jsp로 리턴 > 리턴된 값을 받아서 이쁘게 만들어서 사용자에게 응답.
%>
<strong><%= request.getMethod() %>방식 입력값</strong>
<div>
<ul>
<li><strong>아이디</strong> : <%=id %> </li>
<li><strong>비번</strong> : <%=pass %> </li>
<li><strong>생년월일</strong> : <%=birth %> </li>
<li><strong>거주지</strong> : <%=location %> </li>
<li><strong>자기소개</strong> : <%=intro %> </li>
<li><strong>code</strong> : <%=code %> </li>
</ul>
</div>
</body>
</html>