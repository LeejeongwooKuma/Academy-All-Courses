<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
//업무처리할 결과 > List는 절대 (web parameter로 전달될 수 없다.)
List<String> names=new ArrayList<String>();
names.add("루피");	
names.add("쵸파");	
names.add("샹디");	
names.add("조로");

//scope객체에 데이터를 할당 > scope객체를 사용하여 값 받기.
request.setAttribute("names", names);

String name="민병조";//scope객체에 넘겨도 되지만, parameter로 넘기고 싶다면,
int age = 20;
%>
<!-- parameter가 없는 경우 -->
<%-- <jsp:forward page="forward_action_b.jsp"/> --%>

<!-- parameter가 있는 경우 -->
<jsp:forward page="forward_action_b.jsp">
<jsp:param value="<%=name%>" name="name"/>
<jsp:param value="<%=age%>" name="age"/>
</jsp:forward>