<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 로그인 유효성 검사 방법 1. 이렇게하면 alert못 띄움. -->
<c:if test="${ sessionScope.userId == null}">
<c:redirect url="${CommonURL}/login/loginFrm.jsp"/>
</c:if>

<!-- 로그인 유효성 검사 2 -->
<%-- if( ${ sessionScope.userId == null }) {
	alert("로그인한 사용자만 글을 쓸 수 있습니다. ");
	location.href="${CommonURL}/login/loginFrm.jsp";
}//end if --%>