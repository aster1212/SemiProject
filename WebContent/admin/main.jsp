<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0 0 0 0;
	padding: 0 0 0 0;
}

body {
	background-color: #151515;
	color: #ffffff;
}

#mainDiv {
	text-align: center;
}

#header {
	height: 50px;
	width: 100%;
	border-bottom: 1px solid red;
	background-color: #202020;
}

#mainTab {
	display: inline-block;
}

a:link {
	color: white;
	text-decoration: none;
}

a:visited {
	color: white;
	text-decoration: none;
}

a:hover {
	color: white;
	text-decoration: underline;
}

.menuClass {
	font-size: 24px;
}
</style>
</head>
<body>
	<div id="mainDiv">
		<table id="mainTab">
			<tr>
				<td width="500" colspan="4">
					<h1>관리자 페이지</h1> <c:if test="${session.mem_no!=null}">
                  상태 : 로그인 <br>
						<a href="/bts/logoutAction.action">로그아웃 하기</a>
					</c:if> <c:if test="${session.mem_no==null}">
                  상태 : 로그아웃<br>
						<a href="/bts/loginForm.action">로그인 하기</a>
						<br>
					</c:if>
				</td>
			</tr>
			<tr>
				<td height="30" colspan="4"></td>
			</tr>
			<tr>
				<td colspan="4">기능</td>
			</tr>
			<tr>
				<td><a class="menuClass" href="memList.action">회원_목록</a></td>
				<td><a class="menuClass" href="adminMvList.action">영화_목록</a></td>
				<td><a class="menuClass" href="adminActList.action">배우_목록</a></td>
				<td><a class="menuClass" href="adminRpList.action">신고_목록</a></td>
			<tr>
				<td></td>
				<td><a href="adminMvInsertForm.action">영화 등록</a></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="4"><br><br>기능2</td>
			</tr>
			<tr>
				<td colspan="4">
					<a class="menuClass" onclick="window.open('validationForBo.action','유효성검사','width=480,height=500,location=no,status=no,scrollbars=no')" href="">
					validation:boardc</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>