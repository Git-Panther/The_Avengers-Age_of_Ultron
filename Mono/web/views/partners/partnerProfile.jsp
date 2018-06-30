<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ein.mono.profile.model.vo.ProfileVo"%>
<%@ page import="ein.mono.member.model.vo.*"%>
<%@ include file="/views/common/header.jsp" %>
<%@ include file="/views/common/footer.jsp" %>
<%
	ProfileVo ptnProfile = (ProfileVo)request.getAttribute("ptnProfile");
	MemberVo user = (MemberVo)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/mono/css/partnerProfile.css" type="text/css"/>
<script type="text/javascript" src="/mono/js/jquery-3.3.1.min.js">
</script>
</head>
<body>
<%if(null != ptnProfile){%>
<div class="aside">
	<img alt="none" src="/mono/upload/partner_logo/<%=ptnProfile.getPartnerLogo()%>"><br>
	<div class="ptnBtn">★<%=Math.floor(ptnProfile.getMetascore()*10)/10%></div>
	<div class="ptnBtn" id="favBtn">즐겨찾기
	<%if(null != user){ // 그리고 ajax로 관계 있는지 확인%>
	♥
	<%}else{%>
	♡
	<%}%><%=ptnProfile.getFavorites()%>
	</div>
	<div class="ptnBtn" id="reqBtn">견적 신청</div>
	<%if(null != user && user.getMemberCode().equals(ptnProfile.getPartnerCode())){%>
	<div class="ptnBtn" id="updatePtnBtn">정보 수정</div>
	<%}%>
</div>
<div class="ptnPhotoList">
	<table>
		<tr>
			<td colspan="4"><img id="mainPhoto" alt="none" src="/mono/upload/const_photo/"></td>
		</tr>
		<tr>
			<td><img id="photoThumnail" alt="none" src="/mono/upload/const_photo/"></td>
			<td><img id="photoThumnail" alt="none" src="/mono/upload/const_photo/"></td>
			<td><img id="photoThumnail" alt="none" src="/mono/upload/const_photo/"></td>
			<td><img id="photoThumnail" alt="none" src="/mono/upload/const_photo/"></td>
		</tr>
	</table>
</div>
<table class="detailInfoTab">
	<tr>
		<td><div class="ptnInfoTab" id="ptnDetail">상세정보</div></td>
		<td><div class="ptnInfoTab" id="ptnContent">소개</div></td>
		<td><div class="ptnInfoTab" id="ptnQnA">Q&A 게시판으로</div></td>
	</tr>
</table>
<div class="detailInfoArea">	
	<table>
		<tr>
			<td>업체명</td>
			<td><%=ptnProfile.getMemberName()%></td>
		</tr>
		<tr>
			<td>시공 지역</td>
			<td><%=ptnProfile.getPartnerLocation()%></td>
		</tr>
		<tr>
			<td>스타일</td>
			<td><%=ptnProfile.getPartnerStyles()%></td>
		</tr>
		<tr>
			<td>상담시간</td>
			<td>평일 <%=ptnProfile.getWeekdaysStart()%> ~ <%=ptnProfile.getWeekdaysEnd()%><br>
				주말 <%=ptnProfile.getWeekendStart()%> ~ <%=ptnProfile.getWeekendEnd()%><br>
			</td>
		</tr>
		<tr>
			<td>문의</td>
			<td>?</td>
		</tr>
	</table>
</div>
<%}else{%>
	<h1>Not found</h1>
<%}%>
</body>
</html>