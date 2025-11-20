<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<title>JSP 템플릿</title>
<script src="http://192.168.10.76/jsp_prj/common/js/color-modes.js"></script>
<link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB">
<link rel="shortcut icon" href="http://192.168.10.76/jsp_prj/common/images/favicon2.ico"/>

<!-- bootstrap CDN 시작-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>



<meta name="theme-color" content="#712cf9">
<link href="http://192.168.10.76/jsp_prj/common/css/carousel.css" rel="stylesheet">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: #0000001a;
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em #0000001a, inset 0 .125em .5em #00000026
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh
}

.bi {
	vertical-align: -.125em;
	fill: currentColor
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch
}

.btn-bd-primary {
	--bd-violet-bg: #712cf9;
	--bd-violet-rgb: 112.520718, 44.062154, 249.437846;
	--bs-btn-font-weight: 600;
	--bs-btn-color: var(--bs-white);
	--bs-btn-bg: var(--bd-violet-bg);
	--bs-btn-border-color: var(--bd-violet-bg);
	--bs-btn-hover-color: var(--bs-white);
	--bs-btn-hover-bg: #6528e0;
	--bs-btn-hover-border-color: #6528e0;
	--bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
	--bs-btn-active-color: var(--bs-btn-hover-color);
	--bs-btn-active-bg: #5a23c8;
	--bs-btn-active-border-color: #5a23c8
}

.bd-mode-toggle {
	z-index: 1500
}

.bd-mode-toggle .bi {
	width: 1em;
	height: 1em
}

.bd-mode-toggle .dropdown-menu .active .bi {
	display: block !important
}
</style>
<style type="text/css">
/* 달력 객체의 디자인 */
#calWrap{ font-family: "맑은 고딕", sans-serif; }
#calHeader{ text-align: center; margin-bottom: 20px;}
.calTitle{ font-size:30px; font-weight: bold;}

#calTab{ margin: 0px auto; border: 1px solid #C7C8C9;}
th,td { border: 1px solid #C7C8C9; }
.sunTitle { width: 120px; text-align: center;  color: #C7C8C9; background-color: #DE4F44; }
.weekTitle { width: 120px; text-align: center; font-weight: normal;}
.satTitle { width: 120px; text-align: center; color: #C7C8C9; background-color: #327EEF;}

a {text-decoration: none; color: #000000 ;}
a:hover { color: #C7C8C9 ; }
td {height: 80px; text-align: left; vertical-align: top;}
.blankTd{ background-color: #EFEFEF;}

.sunText{ color: #DA3F35; }
.weekText{ color: #293048; }
.satText{ color: #307DEF; }

.toDayTd{ background-color: #BACEE0; } /* 오늘 */
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
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">메인</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
					aria-controls="navbarCollapse" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<ul class="navbar-nav me-auto mb-2 mb-md-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item"><a class="nav-link disabled"
							aria-disabled="true">Disabled</a></li>
					</ul>
					<form class="d-flex" role="search">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>
	</header>
	<main>
		<div id="myCarousel" class="carousel slide mb-6"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#myCarousel"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#myCarousel"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#myCarousel"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<svg aria-hidden="true" class="bd-placeholder-img " height="100%"
						preserveAspectRatio="xMidYMid slice" width="100%"
						xmlns="http://www.w3.org/2000/svg">
						<rect width="100%" height="100%" fill="var(--bs-secondary-color)"></rect></svg>
					<div class="container">
						<div class="carousel-caption text-start">
							<h1>Example headline.</h1>
							<p class="opacity-75">Some representative placeholder content
								for the first slide of the carousel.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#">Sign up today</a>
							</p>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<svg aria-hidden="true" class="bd-placeholder-img " height="100%"
						preserveAspectRatio="xMidYMid slice" width="100%"
						xmlns="http://www.w3.org/2000/svg">
						<rect width="100%" height="100%" fill="var(--bs-secondary-color)"></rect></svg>
					<div class="container">
						<div class="carousel-caption">
							<h1>Another example headline.</h1>
							<p>Some representative placeholder content for the second
								slide of the carousel.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#">Learn more</a>
							</p>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<svg aria-hidden="true" class="bd-placeholder-img " height="100%"
						preserveAspectRatio="xMidYMid slice" width="100%"
						xmlns="http://www.w3.org/2000/svg">
						<rect width="100%" height="100%" fill="var(--bs-secondary-color)"></rect></svg>
					<div class="container">
						<div class="carousel-caption text-end">
							<h1>One more for good measure.</h1>
							<p>Some representative placeholder content for the third
								slide of this carousel.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#">Browse gallery</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#myCarousel" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#myCarousel" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
		<!-- Marketing messaging and featurettes
  ================================================== -->
		<!-- Wrap the rest of the page in another container to center all the content. -->
		<div class="container marketing">
			<!-- Three columns of text below the carousel -->
			<!-- /.row -->
			<!-- START THE FEATURETTES -->
			<hr class="featurette-divider">
			<div class="row featurette">
				<div id="calWrap">
				<%
				Calendar cal=Calendar.getInstance();
				int nowYear = cal.get(Calendar.YEAR);
				int nowMonth = cal.get(Calendar.MONTH)+1;
				int nowDay = cal.get(Calendar.DAY_OF_MONTH);
				
				StringBuilder flagDate = new StringBuilder();
				flagDate.append(nowYear).append(nowMonth).append(nowDay);
				%>
				<div id="calHeader">
					<a href="#void">
					<span class="calTitle" title="이전월">&lt;</span>
					</a>
					<span class="calTitle"><%=nowYear%>-<%=nowMonth%></span>
					<a href="#void">
					<span class="calTitle" title="다음월">&gt;</span>
					</a>
				</div>
				<div id="calBody">
					<table id="calTab">
					<thead>
					<tr>
					<th class="sunTitle">일</th>
					<th class="weekTitle">월</th>
					<th class="weekTitle">화</th>
					<th class="weekTitle">수</th>
					<th class="weekTitle">목</th>
					<th class="weekTitle">금</th>
					<th class="satTitle">토</th>
					</tr>
					</thead>
					<tbody>
					<tr>
					<%
					cal.set(Calendar.DAY_OF_MONTH, 1); //1일로 설정
					//1일의 요일을 얻어와서 1일을 출력하기 전에 공백을 넣는다.
					int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1일이 무슨 요일인가?
							
					//요일별 글자색 설정할 변수
					String dayColorCss = "";
				 	//오늘을 강조하는 CSS를 설정할 변수
				 	String toDayTd="";
							
					for(int i=1; i<dayOfWeek; i++) {
						
					%>
					<td class="blankTd"></td>
					<%
					}//end for
					
					for(int tempDay=1;;tempDay++) {//마지막날을 모름
						//증가하는 임시 일자로 달력 객체 설정. (현재월에 없는 날짜가 입력되면 자동으로 다음달 1일이 된다.)
						cal.set(Calendar.DAY_OF_MONTH, tempDay); 
						//임시일자와 설정된 날짜가 다르면 (다음달 1일)
						if( tempDay != cal.get(Calendar.DAY_OF_MONTH)){
							dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1일이 무슨 요일인가?
							
							for(int i=dayOfWeek; i<8; i++) {
							%>
							<td class="blankTd"></td>
							<%
							}//end for
							//반복문을 빠져 나간다.
							%>
							</tr><%
							break;
						}//end if
						
						dayColorCss="weekText";
								
						switch(cal.get(Calendar.DAY_OF_WEEK)) {
						case Calendar.SATURDAY: dayColorCss="satText"; break; 
						case Calendar.SUNDAY: dayColorCss="sunText"; break; 
						}//end switch
						
						//오늘을 강조하는 CSS
						toDayTd="";
						if( flagDate.toString().equals(nowYear+""+nowMonth+tempDay)) {
							toDayTd=" toDayTd";
						}//end if
						%>
						<!-- 요일을 출력 -->
						<td class="<%=dayColorCss%><%=toDayTd %>">
						<div>
						<%=tempDay %>
						</div>
						</td>
						<%
						//토요일이면 줄 변경
						switch(cal.get(Calendar.DAY_OF_WEEK)) {
						case Calendar.SATURDAY : 
							%>
							</tr><tr>
							<%
						}//end switch
						
					}//end for
					%>
					
					</tbody>
					
					</table>
				</div>
				</div>
			</div>
			<hr class="featurette-divider">
			<!-- /END THE FEATURETTES -->
		</div>
		<!-- /.container -->
		<!-- FOOTER -->
		<footer class="container">
			<p class="float-end">
				<a href="#">위로</a>
			</p>
			<p>
				&copy; SIST class2 &middot; <a href="#">개인정보보호정책</a>
				&middot; 개인정보관리 책임자 너
			</p>
		</footer>
	</main>

</body>
</html>