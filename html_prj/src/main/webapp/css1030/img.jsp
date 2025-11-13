<%@page import="html_prj.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* 공통속성은 tag selector */
div {border: 1px solid #333; width: 500px; height: 300px}
/* 개별속성은 그외 selector */

/* body{background: #FFFFFF url(../common/images/test_img.png)} */
/* 성적테이블 */
#numTitle {width: 80px;}
#nameTitle {width: 100px;}
#scoreTitle {width: 500px;}

table{ border: 1px solid #333; border-spacing: 0px;}
th, td{ border: 1px solid #333}
</style>
</head>
<body>
<%
StudentDTO[] sDTO= {
	new StudentDTO(1,450,30,"민병조"),	
	new StudentDTO(2,400,80,"김서우"),	
	new StudentDTO(3,350,130,"임성우"),	
		
		
};
%>
<table>
<thead>
<tr>
	<th id = "numTitle">번호</th>
	<th id = "nameTitle">이름</th>
	<th id = "scoreTitle">성적</th>
</tr>
</thead>
<tbody>
<% for(StudentDTO temp : sDTO){ %>
<tr>
	<td><%=temp.getNum() %></td>
	<td><%=temp.getName() %></td>
	<td><img src="images/success.png" style="width: <%= temp.getsScore() %>px; height: 10px;"
	title="98점"><img style="width: <%=temp.getfScore()%>px; height: 10px;" src="images/fail.png" title="2점"></td>
</tr>
<%}//end for %>
</tbody>

</table>
</body>
</html>