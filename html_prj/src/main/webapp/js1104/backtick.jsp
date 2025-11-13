<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
String msg="DBMS";
pageContext.setAttribute("msg", msg);
%>
<script type="text/javascript">

var msg="JavaScript";
alert(`오늘은 ${msg} 를 학습하고 있습니다.`);

</script>

</head>
<body>

</body>
</html>