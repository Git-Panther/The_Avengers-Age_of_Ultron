<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>회원가입</title>
<style>
	#returnMain, #joinBtn{
			display:inline-block;
			margin:5px;
		}

	.outer{
		border:none;
		margin-top:100px;
		margin-left:700px;;
	}
	.btns{
		border:none;
		margin-left:90px;
	}

</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
	<div class = "outer">
	<h2>회원가입을 환영합니다</h2>
	<form id = "memberJoinForm" method = "post" action = "/mono/memberJoin.do">
		<table>
			<tr>
				<td>회원구분</td>
				<td>
					<input type = "checkbox" id = "user1"  name = "memberType"  value = "일반"/>
					<label for = "user1">일반회원</label>
					<input type = "checkbox" id = "user2"  name = "memberType"  value = "업체"/>
					<label for = "user2">업체회원</label>
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "memberId" id = "memberId" required/></td>
				<td><button>중복확인</button></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "memberPwd" id = "memberPwd" required/></td>
				<td></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type = "password" name = "memberPwd2" id = "memberPwd2" required/></td>
				<td><span id = "pwdCheckSpan"></span></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type = "text" name = "memberName" id = "memberName" required/></td>
				<td></td>
			</tr>
			<tr>
				<td>닉네임(업체이름)</td>
				<td><input type = "text" name = "memberNickname" id = "memberNickname" /></td>
				<td></td>
			</tr>
			<tr>
					<td>우편번호</td>
					<td><input type = "text" name = "addressNum" id = "addressNum"/></td>
					<td><button id = "searchAddressBtn" onclick = "openAddressPopup();">주소 검색</button></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type = "text" name = "address1" id = "address1"/></td>
					<td></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td><input type = "text" name = "address2" id = "address2"/></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type = "email"name = "email"/></td>
					<td></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>
						<input type = "text" name = "tel1" id = "tel1" size = "3"/>-
						<input type = "text" name = "tel2" id = "tel2" size = "3"/>-
						<input type = "text" name = "tel3" id = "tel3" size = "3"/>
					</td>
					<td></td>
				</tr>
		</table>
		<br>
	<div class = "btns">
		<div id = "returnMain" onclick = "returnMainPage();">메인으로</div>
		<div id = "joinBtn" onclick = "MemberJoin();">회원가입</div>
	</div>
	</form>
	</div>
	
<%@ include file="../common/footer.jsp" %>	
</body>
</html>