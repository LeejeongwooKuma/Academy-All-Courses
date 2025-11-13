<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="http://192.168.10.76/html_prj/common/images/favicon2.ico"/>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 내가 만든 CSS
<link rel="stylesheet" type="text/css" href="http://192.168.10.76/html_prj/common/css/main_20251031.css"/> -->
<!-- bootstrap CDN 시작-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
<!-- bootstrap CDN 끝-->
<style type="text/css">
#wrap{  margin: 0px auto; width: 480px; height: 380px;}
#container{  height: 380px; position:relative; 
	background: #FFFFFF url(images/id_background.png) no-repeat;}
#searchForm{position: absolute; top:180px; left: 100px;}
#searchResult{position: absolute; top:230px; left: 100px;}
.fail{ color: #FF0000;}
.success{ color: #186292;}
</style>
<script type="text/javascript">
window.onload=function() {
	document.getElementById("btnSearch").addEventListener("click",findId);
}
function findId() {
	let num=parseInt(Math.random()*2);
	let id=document.popupFrm.id.value;
	let useCss='fail';
	let resultMsg="사용 불 가능";
	if(num == 1) {//사용가능한 경우
		useCss='success';
		resultMsg="사용가능";
	}
	let msg=`[<span class='${useCss}'>${id}</span>]는<span class='${useCss}'>${resultMsg}`
	if(useCss == 'success'){
		msg +=`<a href='javascript:sendId("${id}")'>사용</a>`
	}
	//처리 결과를 div에 출력	
	document.getElementById("searchResult").innerHTML=msg;
}//findId

function sendId(id) {
	//부모창(opener)으로 값 전달
	opener.window.document.joinFrm.id.value=id;
	//자식창 닫기
	self.close();
}

</script>
</head>
<body>
<div id="wrap">
	<div id="container">
	<div id="searchForm">
	<form name="popupFrm">
	<!-- param.id =>이게 밑에 request.getParameter("id")랑 같음. 짧아서 좋음. 근데 EL방식이라서 js의 ``랑 싸우면 둘 중 하나 포기 해야함;그래서 이번엔 걍 request씀.-->
		<input type="text" name="id" value="<%= request.getParameter("id")%>" style="width:200px;"/> 
		<input type="button" value="중복확인" class="btn btn-success btn-sm"
		id="btnSearch"/>
	</form>
	</div>
	<%-- <div id="searchResult"><%= request.getQueryString() %></div> --%>
	<%-- <div id="searchResult"><%= request.getParameter("id")%></div> --%>
	<div id="searchResult"></div>
	</div>
</div>
</body>
</html>