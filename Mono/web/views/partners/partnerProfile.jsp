<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="ein.mono.profile.model.vo.*"%>
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
<link rel="stylesheet" href="/mono/css/partnerProfile.css?ver=2" type="text/css"/>
<script type="text/javascript" src="/mono/js/jquery-3.3.1.min.js">
</script>
</head>
<body>
<%if(null != ptnProfile){
	HashMap<Integer, String> ptnPhoto = ptnProfile.getPtnPhoto();
%>
<div class="aside">
	<img class="ptnLogo" alt="none" src="/mono/upload/partner_logo/<%=ptnProfile.getPartnerLogo()%>"><br>
	<div class="ptnBtn">★<%=Math.floor(ptnProfile.getMetascore()*10)/10%></div>
	<%if((null == user) || (null != user && user.getMemberCode().charAt(0) != 'C')){%>
	<div class="ptnBtn" id="favBtn"></div>
	<div class="ptnBtn" id="reqBtn">견적 신청</div>
	<%}%>
	<%if(null != user && user.getMemberCode().equals(ptnProfile.getPartnerCode())){%>
	<div class="ptnBtn" id="updatePtnBtn">정보 수정</div>
	<%}%>
</div>
<div class="ptnPhotoList">
	<table>
		<tr>
			<td colspan="4"><img id="mainPhoto" alt="none" src="/mono/upload/const_photo/<%=ptnPhoto.get(0)%>"></td>
		</tr>
		<tr>
			<%for(int index = 0; index < 4; index++){%>
				<td>
				<%if(ptnPhoto.size() > index){%>
				<img class="photoThumnail" alt="none" src="/mono/upload/const_photo/<%=ptnPhoto.get(index)%>"/>
				<%}else{%>
				<div class="photoThumnail blank"></div>
				<%}%>
				</td>
			<%}%>
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
			<td>
			<% 
				ArrayList<PtnContact> ptnContacts = ptnProfile.getPtnContacts();
				if(0 < ptnContacts.size()){
					for(PtnContact contact : ptnContacts){
			%>
				<%=contact.getContactType()%> : <%=contact.getContactInfo()%><br>
			<%		}
				}else{
			%>
				연락처 정보가 존재하지 않습니다.
			<%	}%>
			</td>
		</tr>
		<%
			ArrayList<PtnUpdate> ptnUpdates = ptnProfile.getPtnUpdates();
			if(0 < ptnUpdates.size()){
				for(PtnUpdate updateInfo : ptnUpdates){
		%>
		<tr>
			<td><%=updateInfo.getUpdateName()%></td>
			<td><%=updateInfo.getUpdateContent()%></td>
		</tr>	
		<%
				}
			}
		%>
	</table>
</div>
<%}%>
<script>
	$(function(){
		<%if(null != ptnProfile && null != user && user.getMemberCode().charAt(0) != 'C'){ // 로그인 중이고 업체 아니면 검사%>
			$.ajax({
				 url : "/mono/checkFavPtn.do"
				 , type : "post"
				 , data : {memberCode : <%=user.getMemberCode()%>, partnerCode : <%=ptnProfile.getPartnerCode()%>}
				 , success : function(data){
					 var content = "즐겨찾기 ";
					if(data == "true"){
						content += "♥";
					}else{
						content += "♡";
					}
					content += "<%=ptnProfile.getFavorites()%>";
					$("#favBtn").text(content);
				 }
				 , error : function(e){
					 console.log(e, "failed.");
				 }
				 , complete : function(data){
					 console.log(data, "아무튼 처리됨");
				 }
			 });
		<%}else{%>
			$("#favBtn").text("즐겨찾기 ♡<%=ptnProfile.getFavorites()%>");
		<%}%>
	});
</script>
</body>
</html>