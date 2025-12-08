<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%> 
<%
//소스보기 하면 공백 존재함. XML에서는 공백은 에러라서 trimDirectiveWhitespaces = true로 공백 없애줌.
//1. JSONObject 생성
JSONObject jsonObj = new JSONObject();
//2. 값 할당
jsonObj.put("name",	 "민병조");//제네릭 안 썼다고 워닝 뜨는데, json에선 에초에 제네릭 못 써서 어쩔 수 없음.
jsonObj.put("age",	 25);
jsonObj.put("flag",	 true);
jsonObj.put("date",	 new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

//3. 출력
//out.print(jsonObj);
out.print(jsonObj.toJSONString()); //이게 JSON이란걸 알기 좋아서 이 방식으로 출력을 많이 함.
%>