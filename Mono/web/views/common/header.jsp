<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>MONO</title>
<link href="https://fonts.googleapis.com/css?family=Rubik" rel="stylesheet">
<style>
 .menu{
 	width:1200px;
	margin-left:auto;
	margin-right:auto;
 }
  .null{
	width:1200px;
	height:20px;
  }
  .loginArea{
  	float:right;
  	font-size:15px;
  }
  #loginBtn, #joinBtn{
  	display:inline-block;
  	margin-left:20px;
  	cursor:pointer;
  }
  .menuList{
 	margin-top:10px;
  	font-family: 'Rubik', sans-serif;
  }
  .left{
	width:500px;
	border-top:1px solid #939393;
	border-bottom:1px solid #939393;
	float:left;
	font-size:20px;
  }
  .logo{
	width:200px;
	float:left;
	cursor:pointer;
	
  }
  .right{
	width:500px;
	border-top:1px solid #939393;
	border-bottom:1px solid #939393;
	float:left;
	font-size:20px;
  }
 .left li{
	float:left;
	margin-left:30px;
	margin-right:40px;
	vertical-algin:middle;
	list-style:none;
	padding-bottom:13px;
	padding-left:0px;
 }
 .right li{
	float:left;
	margin-left:43px;
	margin-right:40px;
	vertical-algin:middle;
	list-style:none;
	padding-bottom:13px;
 }
 li{
 	cursor:pointer;
 }

 .navi li ul{
 	z-index:2;
 	opacity:0;
 	position:absolute; 
 	width:230px;
 	text-align:center;
 	margin:0px;
 	padding:0px;
 	margin-top:13px;
 }
 .navi li:hover ul{
 	opacity:1;
 }
 .navi li ul li{
 	float:none;
 	position:static;
 	height:0;
 	line-height:0;
 	bakcgorund:none;
 }
 .navi li:nth-child(2) ul{
 	margin-left:-68px;
 }
 .navi li:nth-child(3) ul{
 	margin-left:-78px;
 }
 .navi li:hover ul li{
 	height:30px;
 	line-height:40px;
 	background:rgba(48, 49, 56,0.8);
 	color:white;
 }
 .navi li ul{
 	transition:all 0.5s;
 }
 .navi li ul li{
 	transition:all 0.5s;
 }
  </style>
  <script>
  function mainPage(){
	  location.href="/mono/index.jsp";
  }
  
  function monoPage(){
	  location.href="/mono/views/common/mono.jsp";
  }
  
  function joinPage(){
	  location.href="/mono/views/member/MemberJoin.jsp";
  }
  function faqPage(){
	  location.href="/mono/views/faq/faq.jsp";
  }
  </script>
</head>
<body>
	<header>
	<div class="menu">
		<div class="null">
		</div>
		<div class="loginArea">
			<div id="loginBtn" onclick="loginPage();">LOGIN</div>
			<div id="joinBtn" onclick="joinPage();">JOIN</div>
		</div>
		<br>
		<div class="menuList" >
			<nav>
				<div class="left">
					<ul class="navi">
						<li onclick="monoPage();">MONO?</li>
						<li>
							REQUEST
							<ul>
								<li>경매</li>
								<li>업체지정</li>			
							</ul>
						</li>
						<li>
							BOARD
							<ul>
								<li>자유게시판</li>
								<li>마이룸</li>
								<li>오픈마켓</li>
								<li>후기게시판</li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="logo" onclick="mainPage();">
					<img src="/mono/images/logo3.png" width="200px" height="60px"/>
				</div>
				<div class="right">
					<ul>
						<li onclick="faqPage();">FAQ</li>
						<li>NOTICE</li>
						<li>EVENT</li>
					</ul>
	   			</div>
			</nav>
		</div>
	</div>
	</header>
</body>
</html>