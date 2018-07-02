<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="ein.mono.profile.model.vo.ProfileVo"%>
<%@ page import="ein.mono.profile.model.vo.PtnContact"%>
<%@ page import="ein.mono.profile.model.vo.PtnUpdate"%>
<%@ page import="ein.mono.member.model.vo.*"%>
<%@ include file="/views/common/header.jsp" %>
<%@ include file="/views/common/footer.jsp" %>
<%
	ProfileVo ptnProfile = (ProfileVo)request.getAttribute("ptnProfile");
	MemberVo user = (MemberVo)session.getAttribute("user");
	boolean isMember = (null != user) && ('B' == user.getMemberCode().charAt(0));
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
<div class="ptnProfileArea">
	<%if(null != ptnProfile){
		HashMap<Integer, String> ptnPhoto = ptnProfile.getPtnPhoto();
	%>
	
	<table class="ptnInfo">
		<tr>
			<td colspan="2"><div class="ptnCategory">업체 정보</div></td>
		</tr>
		<tr>
			<td>
				<table class="ptnDefaultInfo">
					<tr><td><img class="ptnLogo" alt="none" src="/mono/upload/partner_logo/<%=ptnProfile.getPartnerLogo()%>"></td></tr>
					<tr><td><div class="ptnBtn">★<%=Math.floor(ptnProfile.getMetascore()*10)/10%></div></td></tr>
					<%if((null == user) || (null != user && user.getMemberCode().charAt(0) != 'C')){%>
					<tr><td><div class="ptnBtn" id="favBtn"></div></td></tr>
					<tr><td><div class="ptnBtn" id="reqBtn">견적 신청</div></td></tr>
					<%}%>
					<%if(null != user && user.getMemberCode().equals(ptnProfile.getPartnerCode())){%>
					<tr><td><div class="ptnBtn" id="updatePtnBtn">정보 수정</div></td></tr>
					<%}%>	
				</table>
			</td>
			<td>
				<div class="ptnPhotoList">
					<table>
						<tr>
							<td colspan="6"><img id="mainPhoto" alt="none" src="/mono/upload/const_photo/<%=ptnPhoto.get(0)%>"></td>
						</tr>
						<tr>
							<td><div id="prevImgBtn"> < </div></td>
							<%for(int index = 0; index < 4; index++){%>
								<td>
								<%if(ptnPhoto.size() > index){%>
								<a href="#<%=index%>" class="photoThumnail"><img alt="none" src="/mono/upload/const_photo/<%=ptnPhoto.get(index)%>"/></a>
								<%}else{%>
								<div class="photoBlank"></div>
								<%}%>
								</td>
							<%}%>
							<td><div id="nextImgBtn"> > </div></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
	<table class="detailInfoTab">
		<tr>
			<td><div class="ptnInfoTab" id="ptnDetail">상세정보</div></td>
			<td><div class="ptnInfoTab" id="ptnContent">소개</div></td>
			<td><div class="ptnInfoTab" id="ptnQnA" onclick="qnaPage();">Q&A게시판</div></td>
		</tr>
	</table>
	<div id="detailInfoArea">	
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
	<div id="introArea">
		<%=ptnProfile.getPartnerIntro()%>
	</div>
</div>
<%}%>
<script>
	var startIndex = 0;
	var photoList;

	$(function(){	
		$(".photoThumnail:first").click();
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
		
		$(".photoThumnail img").click(function(){
			$("#mainPhoto").attr("src", $(this).attr("src"));
			$(".photoThumnail img:not(this)").css("border", "");
			$(this).css("border", "3px solid #3c3f44");
		});
		
		$(".photoThumnail img:eq(0)").click();
		
		$("#favBtn").click(function(){
			if(<%=isMember%>){
				
			}else{
				alert("즐겨찾기로 등록하기 위해서는 로그인을 먼저 하십시오.");
			}
		});
		
		$("#reqBtn").click(function(){
			if(<%=isMember%>){
				
			}else{
				alert("즐겨찾기로 등록하기 위해서는 로그인을 먼저 하십시오.");
			}
		});
		<%if(null != ptnProfile){
			HashMap<Integer, String> ptnPhoto = ptnProfile.getPtnPhoto();
		%>
			photoList = {
			<%for(int index = 0; index < ptnPhoto.size(); index++){%>		
				<%=index%> : "<%=ptnPhoto.get(index)%>"
				<%if(index < ptnPhoto.size() - 1){%>
				,
				<%}%>
			<%}%>
			};
		$("#prevImgBtn").click(function(){
			var photoIndex = parseInt(location.href.charAt(location.href.length - 1));
			var imgSelector = ".photoThumnail img:eq(";
			var linkSelector = ".photoThumnail:eq(";
			var photoTotal = <%=ptnPhoto.size()%>;
			//console.log(photoIndex);
			if(photoIndex == 0 && 4 < photoTotal && 0 < startIndex){
				startIndex--;
				for(var index = startIndex; index < 4 + startIndex; index++){
					$(".photoThumnail img:eq("+(index - startIndex).toString()+")").attr("src", "/mono/upload/const_photo/"+photoList[index.toString()]);
				}
			}
			
			if(photoIndex > 1){
				imgSelector += (photoIndex-1).toString();
				linkSelector += (photoIndex-1).toString();
			} else{
				imgSelector += (0).toString();
				linkSelector += (0).toString();
			}
			
			imgSelector += ")";
			linkSelector += ")";
			
			$(imgSelector).click();
			$(linkSelector).click();
		});
		
		$("#nextImgBtn").click(function(){
			var photoIndex = parseInt(location.href.charAt(location.href.length - 1));
			var imgSelector = ".photoThumnail img:eq(";
			var linkSelector = ".photoThumnail:eq(";
			var photoTotal = <%=ptnPhoto.size()%>;
			//console.log(photoIndex);
			if(photoIndex == 3 && 4 < photoTotal && photoTotal - 4 > startIndex){
				startIndex++;
				for(var index = startIndex; index < 4 + startIndex; index++){
					$(".photoThumnail img:eq("+(index - startIndex).toString()+")").attr("src", "/mono/upload/const_photo/"+photoList[index.toString()]);
				}
			}
			
			if(photoIndex < 2){
				imgSelector += (photoIndex+1).toString();
				linkSelector += (photoIndex+1).toString();
			} else{
				imgSelector += (3).toString();
				linkSelector += (3).toString();
			}
			
			imgSelector += ")";
			linkSelector += ")";
			
			$(imgSelector).click();
			$(linkSelector).click();
		});
		<%}%>
		$("#ptnDetail").click(function(){
			
		});
	});
	
	function qnaPage(){
		location.href = "selectQnAList?partnerCode=<%=ptnProfile.getPartnerCode()%>";
	}
</script>
</body>
</html>