<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

JSONObject jsonObj = new JSONObject();
jsonObj.put("resultFlag", !flag);
jsonObj.put("uploadName", fileSystemName);
%>
<%= jsonObj.toJSONString() %>