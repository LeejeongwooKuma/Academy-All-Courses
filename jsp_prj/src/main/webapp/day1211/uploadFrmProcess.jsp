<%@page import="java.nio.file.FileSystemNotFoundException"%>
<%@page import="java.nio.file.FileSystem"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../fragments/siteProperty.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<title>JSP 템플릿</title>
<script src="${CommonURL}/common/js/color-modes.js"></script>

<link rel="shortcut icon" href="${CommonURL}/common/images/favicon2.ico"/>

<!-- bootstrap CDN 시작-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>



<meta name="theme-color" content="#712cf9">
<link href="${CommonURL}/common/css/carousel.css" rel="stylesheet">
<jsp:include page="../fragments/bootstrap_css.jsp"/>


<style type="text/css">
#wrap{  margin: 0px auto; width: 1200px; height: 1000px;}
#header{  height: 150px; }/* 부모창 크기 따라가서 width은 안 줘도 괜찮음. */
#container{  height: 700px; }
#footer{  height: 150px; }
</style>
<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script type="text/javascript">
$(function(){

});//ready


</script>
</head>
<body>
	<header data-bs-theme="dark">
	<jsp:include page="../fragments/header.jsp"/>
	</header>
	<main>
		
		<!-- Marketing messaging and featurettes
  ================================================== -->
		<!-- Wrap the rest of the page in another container to center all the content. -->
		<div class="container marketing">
			<!-- Three columns of text below the carousel -->
			<!-- /.row -->
			<!-- START THE FEATURETTES -->
			<hr class="featurette-divider">
			<div class="row featurette">
				<div class="col-md-7">
					
					<%-- <%
					//enctype="multipart/form-data"였을때는 기존방식으로 web parameter처리가 될 수 없다. => 파일업로드 컴포넌트를 사용.(cos.jar안에 있음)
					String uploader=request.getParameter("uploader");
					%>					
					<%=uploader %>,${ param.uploader }  --%>
					
					<%
					
					//1. 업로드된 파일을 저장할 경로 설정
					File saveDir = new File("C:/Users/doraemong/git/Academy-All-Courses/jsp_prj/src/main/webapp/upload");//실사용 할 때는 경로는 이렇게 하면 안되고 서비스 경로를
					//siteProperty에 넣어서 쓰자.
					//2. 최대 크기 설정.
					int maxSize=1024 * 1024 * 10;//10MByte로 제한.
					//업로드 크기를 설정(최대크기 이상 파일 업로드할 때 걸러낼려고). 일단 업로드 사이즈 크게 잡아서 받고, 받은 다음에 내가 설정한 크기(10메가)랑 비교해서 더 크면 삭제시켜버리자.
					//만약 600보다 크면? ㅈㅈ치고 포기;;;
					int uploadSize=1024 * 1024 * 600;//얘는 크게 잡아둠. 600MByte
					//3. FileUpload 객체 ( MultipartRequest )를 생성. => 생성하자마자 업로드가 된다.
					MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(),
							uploadSize,"UTF-8",new DefaultFileRenamePolicy());
					
					
					String uploader=mr.getParameter("uploader");
					String[] ageArr=mr.getParameterValues("age");//MultipartRequest로는 배열을 반복시킬 수 없음. 그래서 밑에서 처럼 setAttribute로 만들어줘야함.
					//파일명은 파라메터로 받을 수 없다.
					//String fileName=mr.getParameter("upfile");
					String originalName = mr.getOriginalFileName("upfile");//원본 파일명
					String fileSystemName = mr.getFilesystemName("upfile");//변경된 이름. <쓸거면 이걸 쓰는게 맞음. 만약 오리지널 쓰면, 다른 사람꺼가 보여질 수도 있음.
					
					System.out.println("-----------["+fileSystemName+"]----------------");
					
					//업로드된 파일의 크기를 얻어서, 업로드 가능 크기와 비교한다.
					//파일이 크다면 사용자에게 "에러메시지를 보여준다." 파일을 삭제한다.
					File compareFile=new File(saveDir.getAbsolutePath()+File.separator+fileSystemName);
					
					boolean flag=false;
					if( flag=(compareFile.length() > maxSize)) {
						compareFile.delete();
					}//end if
					
					
					
					//EL에서 써야하니 setAttribute해주자.
					pageContext.setAttribute("flag", flag);
					
					
					pageContext.setAttribute("uploader", uploader);
					pageContext.setAttribute("ageArr", ageArr);
					pageContext.setAttribute("originalName", originalName);
					pageContext.setAttribute("fileSystemString", fileSystemName);
					
					%>
					<c:choose>
					<c:when test="${flag}">
					 파일은 최대 10MByte(10,485,760byte)까지만 업로드 가능합니다.
					</c:when>
					<c:otherwise>
					업로더 : <c:out value="${ uploader }"/><br>
					대상층 연령 : 
					<c:forEach var="age" items="${ageArr }">
					<c:out value="${ age }"/> 
					</c:forEach>
					<br>
					파일명 : <c:out value="${ fileSystemString }"/>
					(원본명 : <c:out value="${ originalName }"/>)
					<a href="view_img.jsp?img=${ fileSystemString }">이미지 보기</a>
					</c:otherwise>
					</c:choose>
						
				</div>
			</div>
			<hr class="featurette-divider">
			<!-- /END THE FEATURETTES -->
		</div>
		<!-- /.container -->
		<!-- FOOTER -->
		<footer class="container">
			<jsp:include page="../fragments/footer.jsp"/>
		</footer>
	</main>

</body>
</html>