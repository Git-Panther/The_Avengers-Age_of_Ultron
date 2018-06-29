<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="ein.mono.profile.model.vo.ProfileVo"%>
<%@ page import="ein.mono.common.PageInfo"%>
<%@ include file="/views/common/header.jsp" %>
<%@ include file="/views/common/footer.jsp" %>
<%
	String listType = (String)request.getAttribute("listType");
	ArrayList<ProfileVo> list = (ArrayList<ProfileVo>)request.getAttribute("list");
	// listType.contains()로 비교하여 분할
	Iterator<ProfileVo> itrList = null;
	ProfileVo ptnPreview = null;
	String condition = null; // 표시 조건	
	int listIndex = 0; // 화면에 표시되는 리스트 인덱스
	PageInfo pi = (PageInfo)request.getAttribute("pi");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/mono/css/partnerList.css" type="text/css"/>
<script type="text/javascript" src="/mono/js/jquery-3.3.1.min.js">
	function movePage(pageNum){ // 여기부터 시작
		<%if(listType.contains("Search")){%>
			var condition = "";
			var keyword = "";
			<%if(listType.contains("ptn_name")){%>
				condition = "ptn_name";
			<%}else if(listType.contains("ptn_location")){%>
				condition = "ptn_location";
			<%}else if(listType.contains("ptn_styles")){%>
				condition = "ptn_styles";
			<%}%>
			keyword = listType.split(':')[1];
			location.href = "/mono/searchPartnersList.do?condition="+condition+"&keyword="+keyword+"&currentPage=" + pageNum;
		<%}else if(listType.contains("Category")){%>
			var category = "All";
			<%if(listType.contains("우수업체")){%>
				category = "우수업체";
			<%}%>
			location.href="/mono/selectPartnersList.do?category="+category+"&currentPage=" + pageNum;
		<%}%>
	}
</script>
</head>
<body>
<%if(null != list){	%>
	<h1>success : <%=listType%>, size : <%=list.size()%></h1>
	<%if(listType.contains("Main")){%>
	<div class="ptnCategory">우수 업체</div>
	<%
	ArrayList<ProfileVo> bestList = (ArrayList<ProfileVo>)request.getAttribute("bestList");
	if(0 != bestList.size()){
	%>
	<table class="ptnList">
		<tr>
		<%
		itrList = bestList.iterator();
		while(itrList.hasNext()){
			ptnPreview = itrList.next();
		%>			
			<td>
				<img class="constPhoto" alt="none" src="/mono/upload/const_photo/<%=ptnPreview.getPtnPhoto().get(0)%>">
				<br/>
				<%=ptnPreview.getMemberName()%>|<%=ptnPreview.getPartnerLocation()%>|<%=ptnPreview.getMetascore()%>
			</td>
		<%		
		}
		%>
		</tr>
	</table>
	<%}else{%>
	<br>
	<h1>검색결과가 존재하지 않습니다.</h1>
	<%}%>
	<div class="ptnCategory">전체</div>
	<%}else if(listType.contains("Search")){
		String listInfo = listType.replace("Search_", "");
		if(listInfo.contains("ptn_name")) {
			listInfo = listInfo.replace("ptn_name", "");
			condition = "업체명";
		}else if(listInfo.contains("ptn_location")){
			listInfo = listInfo.replace("ptn_location", "");
			condition = "지역";
		}else if(listInfo.contains("ptn_styles")){
			listInfo = listInfo.replace("ptn_styles", "");
			condition = "스타일";
		}
	%>
	<div class="ptnCategory">검색 결과(<%=condition+listInfo%>)</div>
	<%}else if(listType.contains("Category")){
		if(listType.contains("All")) condition = "전체";
		else if(listType.contains("우수업체")) condition = "우수 업체";
	%>
	<div class="ptnCategory"><%=condition%></div>	
	<%} 
	if(0 != list.size()){
	%>
	<table class="ptnList">	
		<%		
		itrList = list.iterator();
		while(itrList.hasNext()){
			ptnPreview = itrList.next();
			listIndex++;
			if(1 == listIndex%3){
		%>
		<tr>
		<%} %>
			<td>
				<img class="constPhoto" alt="none" src="/mono/upload/const_photo/<%=ptnPreview.getPtnPhoto().get(0)%>">
				<br/>
				<%=ptnPreview.getMemberName()%>|<%=ptnPreview.getPartnerLocation()%>|<%=ptnPreview.getMetascore()%>
			</td>
			<%if((0 == listIndex%3) || (listIndex == list.size())){%>
				</tr>
			<%} %>
		<%}%>
	</table>
	<%}else{%>
	<br>
	<h1>검색결과가 존재하지 않습니다.</h1>
	<%} %>
<%}else{%>
	<h1><%=(String)request.getAttribute("msg")%></h1>
<%}%>
<%if(null != pi && 0 != list.size()){%>
	<div class="pageArea">
		<button onclick="movePage(1)"> << </button>
		<% for(int i = pi.getStartPage(); i <= pi.getEndPage(); i++){ %>
			<button
			<%if(i != pi.getCurrentPage()){%>
			onclick="movePage(<%=i%>)"
			<%}else{%>
			disabled="disabled"
			<%} %>
			><%=i%></button>		
		<% }%>
		<button onclick="movePage(<%=pi.getMaxPage()%>)"> >> </button>
	</div>
<%}%>
	<br>
	<div class="searchArea">
		<select id="searchCondition">
			<option value="ptn_name">업체명</option>
			<option value="ptn_location">지역</option>
			<option value="ptn_styles">스타일</option>
		</select>		
		<input type="text" id="searchText" placeholder="검색어 입력"/>
		<input type="button" value="검색하기" onclick="searchPartners();"/>
	</div>
	<br><br>
	<a href="/mono/selectPartnersList.do?category=우수업체">Category : Best</a><br/>
	<a href="/mono/selectPartnersList.do?category=All">Category : All</a><br/>
	<a href="/mono/searchPartnersList.do?condition=ptn_name&keyword=sucks">Search : Partner's name = sucks</a><br/>
	<a href="/mono/searchPartnersList.do?condition=ptn_location&keyword=강남">Search : Partner's location = 강남</a><br/>
	<a href="/mono/searchPartnersList.do?condition=ptn_styles&keyword=모던">Search : Partner's style = 모던</a><br/>
	<a href="/mono/selectPartner.do?partnerCode=C1">상세보기 : C1 업체</a>
<script>
	function searchPartners(){
		var condition = $("#searchCondition").val();
		var keyword = $("#searchText").val();
		location.href = "/mono/searchPartnersList.do?condition="+condition+"&keyword="+keyword;
	}
</script>
</body>
</html>