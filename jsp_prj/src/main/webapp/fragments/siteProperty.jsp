<%@page import="kr.co.sist.siteProperty.SiteProperty"%>
<%@page import="kr.co.sist.siteProperty.SitePropertyVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
SitePropertyVO spVO = SiteProperty.spVO;
application.setAttribute("SiteProperty", spVO);
application.setAttribute("CommonURL", spVO.getProtocol()+spVO.getServer_name()+spVO.getContext_root());
%>