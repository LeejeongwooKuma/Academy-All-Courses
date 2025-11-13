/**
 * 
 */
/* function setEvt(){ */ //기명함수
window.onload=function(){
//익명함수로 이벤트를 등록
//1.태그를 찾고 > 2.태그에 이벤트 등록 > 3.이벤트발생시 사용자에게 제공할 코드를 익명함수로 작성
alert(document.getElementById("btn"));
document.getElementById("btn").onclick=function(){
	alert("버튼이 클릭되었습니다");
	}//onclick
}//setEvt