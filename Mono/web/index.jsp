<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모노</title>
<style>
	.request{
		background:url("/mono/images/request.jpg") no-repeat;
		width:1100px;
		height:400px;
		margin-left:auto;
		margin-right:auto;
		margin-top:10px;
		text-align:center;
	}
	.requestBtn{
		display:inline-block;
		width:300px;
		background:rgba(48, 49, 56,0.8);
		color:white;
		cursor:pointer;
		border-radius:20px;
		text-align:center;
		padding:10px;
		font-size:20px;
		margin-top:180px;
	}
	.keyword{
		width:1100px;
		height:50px;
		margin-left:auto;
		margin-right:auto;
		margin-top:10px;
		font-size:22px;
		text-aling:center;
		vertical-align:middle;
	}
	.key{
		width:150px;
		display:inline-block;
		background:rgba(48, 49, 56,0.8);
		color:white;
		text-align:center;
		cursor:pointer;
		border-radius:20px;
		font-size:19px;
		padding-top:5px;
		padding-bottom:6px;
	}
	.board{
		width:1100px;
		height:300px;
		margin-left:auto;
		margin-right:auto;
		margin-top:45px;
	}
	.board div{
		width:256px;
		height:300px;
		border:1px solid black;
		margin-left:10px;
		margin-right:auto;
		margin-top:10px;
		display:inline-block;
	}
	.img{padding:0;}
	ul,li{list-style:none;}
	.slide{z-index:1; width:1100px;height:400px; margin-left:auto; margin-right:auto; position:relative;overflow:hidden;}
	.slide ul{width:400%;height:100%;transition:1s;}
	.slide ul:after{content:"";display:block;clear:both;}
	.slide li{float:left;width:25%;height:100%;}
	.slide input{display:none;}
	.slide label{display:inline-block;vertical-align:middle;width:10px;height:10px;border:2px solid #666;background:#fff;transition:0.3s;border-radius:50%;cursor:pointer;}
	.slide .pos{text-align:center;position:absolute;bottom:0px;left:0;width:100%;text-align:center;}
	#pos1:checked~ul{margin-left:0%;}
	#pos2:checked~ul{margin-left:-100%;}
	#pos3:checked~ul{margin-left:-200%;}
	#pos4:checked~ul{margin-left:-300%;}
	#pos1:checked~.pos>label:nth-child(1){background:#666;}
	#pos2:checked~.pos>label:nth-child(2){background:#666;}
	#pos3:checked~.pos>label:nth-child(3){background:#666;}
	#pos4:checked~.pos>label:nth-child(4){background:#666;}
</style>
</head>
<body>
<%@ include file="views/common/header.jsp" %>
<div class="slide">
	<input type="radio" name="pos" id="pos1" checked>
	<input type="radio" name="pos" id="pos2">
	<input type="radio" name="pos" id="pos3">
	<input type="radio" name="pos" id="pos4">
	<ul class="img">
		<li><img src="/mono/images/banner1.png" width="1100px" height="400px"></li>
		<li><img src="/mono/images/request.jpg"></li>
		<li><img src="/mono/images/banner1.png" width="1100px" height="400px"></li>
		<li><img src="/mono/images/request.jpg" ></li>
	</ul>
	<p class="pos">
		<label for="pos1"></label>
		<label for="pos2"></label>
		<label for="pos3"></label>
		<label for="pos4"></label>
	</p>
</div>
<div class="request">
	<div class="requestBtn">무료견적 신청하기</div>
</div>
<div class="keyword">
	<label style="font-weight:bold">BEST 키워드</label>
	<hr>
	<div class="key">모던</div>
	<div class="key">북유럽</div>
	<div class="key">화이트</div>
	<div class="key">우드</div>
	<div class="key">자연주의</div>
	<div class="key">미니멀리즘</div>
	<div class="key">인더스트리얼</div>
</div>
<div class="board">
	<div class="board1"></div>
	<div class="board2"></div>
	<div class="board3"></div>
	<div class="board4"></div>
</div>
<%@ include file="views/common/footer.jsp" %>
</body>
</html>