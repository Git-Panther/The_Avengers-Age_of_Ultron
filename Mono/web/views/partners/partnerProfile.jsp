<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ein.mono.profile.model.vo.ProfileVo"%>
<%@ include file="/views/common/header.jsp" %>
<%@ include file="/views/common/footer.jsp" %>
<%
	ProfileVo ptnProfile = (ProfileVo)request.getAttribute("ptnProfile");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(null != ptnProfile){%>
	<h1>success</h1>
<%}else{%>
	<h1>failed</h1>
<%}%>
</body>
</html>