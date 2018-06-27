<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Rubik" rel="stylesheet">
<script type="text/javascript" src="/mono/js/jquery-3.3.1.min.js"></script>
<style>
	.faqMenu{
		font-family: 'Rubik', sans-serif;
		font-size:60px;
		margin-top:90px;
		margin-left:auto;
		margin-right:auto;
		width:1100px;
		padding-left:55px;
	}
	.accordionMenu{
		background:#fff;
		padding:10px;
		width:60%;
		margin-left:auto;
		margin-right:auto;	
	}
	.accordionMenu h2{
		text-align:center;
		margin:5px 0;
		padding:0;
	}
	.accordionMenu h2 a{
		font-size:25px;
		display:block;
		font-weight:normal;
		text-decoration:none;
		margin:0;
		padding:10px;
		background:rgb(48, 49, 56);
		color:white;
		border-radius:25px;
	}

	.accordionMenu :target h2 a,
	.accordionMenu h2 a:focus,
	.accordionMenu h2 a:hover,
	.accordionMenu h2 :active {
		background:rgba(48, 49, 56,0.8);
		color:white;
		text-weight:bold;
	}
	a{
		text-decoration:none;
		color:gray;
	}
	.accordionMenu p {
		font-size:20px;
		padding:0 10px;
		margin:0;
		height:0;
		overflow:hidden;
		transition:height 0.5s ease-in;
		text-align:center;
	}

	.accordionMenu :target p{
		overflow: auto;
		height:50px;
		/*box-shadow:2px 2px 1px gray;*/
	}


  </style>

<body>
<%@ include file="../common/header.jsp" %>
	<div class="faqMenu">
	<label>  FAQ</label>
	</div>
	<hr width="1100px;">
	<div class="accordionMenu">
		<div id="a1" class="menuSection">
			<h2><a href="#a1">회원만 견적신청이 가능한가요?</a></h2>
			<p>
				네, 다소 불편하시더라도 정확한 정보를 위해 회원가입을 해주시기 바랍니다.
			</p>
		</div>
		<div id="a2" class="menuSection">
			<h2><a href="#a2">경매신청방법</a></h2>
			<p>
				알아서하세요~
				블라ㅡㅂ아르방르방르방릅알
			</p>
		</div>
		<div id="a3" class="menuSection">
			<h2><a href="#a3">회원탈퇴</a></h2>
			<p>
				하즤마세여
			</p>
		</div>
		<div id="a4" class="menuSection">
			<h2><a href="#a4">차단한사람푸는법</a></h2>
			<p>
				해제하세여
			</p>
		</div>
		<div id="a5" class="menuSection">
			<h2><a href="#a5">프로젝트를 성공적으로 끝낼것같은지</a></h2>
			<p>
				넹그렇슴다
			</p>
		</div>
	</div>
 <%@ include file="../common/footer.jsp" %>
</body>
</html>