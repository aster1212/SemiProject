<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 관리</title>
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

#listTable {
	display: inline-table;
	text-align: center;
	width: 1000px;
}

#listTable td {
	border: 1px solid white;
}

#menuTr {
	
}

#header {
	height: 50px;
	width: 100%;
	border-bottom: 1px solid red;
	background-color: #202020;
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

.posters {
	width: 100px;
	height: 160px;
}
#insertBtn{
	width: 1000px;
	height: 20px;
}
</style>
</head>
<body>
	<div id="header">
		<strong><a href="admin.action">관리자 페이지</a></strong> 
		<a href="memList.action">회원 목록</a> 
		<a href="adminMvList.action">영화 목록</a>
		<a href="adminActList.action">배우 목록</a>
		<a href="adminRpList.action">신고 목록</a>
	</div>
	
	<div id="mainDiv">
		<table id="listTable">
			<tr>
				<td colspan=9><input type="button" id="insertBtn" value="영화등록" onclick="window.location='adminMvInsertForm.action'"></td>
			</tr>
			<tr>
				<td colspan=9><h1>영화 리스트</h1></td>
			</tr>
			<tr>
				<td>포스터</td>
				<td>제목</td>
				<td>상영시간</td>
				<td>장르</td>
				<td>이용등급</td>
				<td>배급사</td>
				<td>평점</td>
				<td colspan="2">옵션</td>
			</tr>
			<s:iterator value="list" status="stat">
				<!-- URL지정 -->
				<s:url id="delURL" action="adminMvDeleteAction">
					<s:param name="MV_NO">
						<s:property value="MV_NO" />
					</s:param>
				</s:url>
				<s:url id="upURL" action="adminMvUpdateForm">
					<s:param name="MV_NO">
						<s:property value="MV_NO" />
					</s:param>
				</s:url>
				<!-- 영화 목록 -->
				<tr id="menuTr">
					<td width="100" height="160"><img class="posters"
						src="/bts/image/poster/<s:property value='MV_NO'/>.jpg"
						alt="이미지 없음" /></td>
					<td><s:property value="MV_SUBJECT" /></td>
					<td><s:property value="MV_TIME" /></td>
					<td><s:property value="MV_GENRE" /></td>
					<td><s:property value="MV_GRADE" /></td>
					<td><s:property value="MV_PROD" /></td>
					<td><s:property value="MV_AVR" /></td>
					<td><s:a href="%{upURL}">수정</s:a></td>
					<td><s:a href="%{delURL}">삭제</s:a></td>
				</tr>
			</s:iterator>
			<s:if test="list.size() <= 0">
				<tr>
					<td colspan=9>등록된 영화가 없습니다.</td>
				</tr>
			</s:if>
				<tr>
					<td colspan="9"><s:property value="pagingHtml" escape="false" /></td>
				</tr>
		</table>
	</div>
</body>
</html>