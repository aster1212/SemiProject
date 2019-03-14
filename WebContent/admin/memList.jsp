<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 관리</title>
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
#listTable{
	display: inline-table;
	text-align: center;
	width: 1000px;
}
#listTable td{
	border: 1px solid white;
}
#menuTr{
	
}
#header {
	height: 50px;
	width: 100%;
	border-bottom: 1px solid red;
	background-color: #202020;
}
 a:link { color: white; text-decoration: none;}
 a:visited { color: white; text-decoration: none;}
 a:hover { color: white; text-decoration: underline;}
.grey{
	background: #303030;
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
				<td colspan=7><h1>회원 리스트</h1></td>
			</tr>
			<tr>
				<td>고유번호</td>
				<td width="250">아이디</td>
				<td width="150">비밀번호</td>
				<td width="200">닉네임</td>
				<td>전화번호</td>
				<td>성별</td>
				<td>옵션</td>
			</tr>
			<%int cnt=0; %>
			<s:iterator value="list" status="stat">
				<!-- URL지정 -->
				<s:url id="delURL" action="adminMemDel">
					<s:param name="memNo"><s:property value="memNo"/></s:param>
				</s:url>
				<!-- 회원 목록 -->
				<%if(cnt%2 == 1){ %>
				<tr id="menuTr">
				<%}else{ %>
				<tr id="menuTr" class="grey">
				<%} cnt++;%>
					<td><s:property value="memNo" /></td>
					<td><s:property value="memId" /></td>
					<td><s:property value="memPw" /></td>
					<td><s:property value="memName" /></td>
					<td><s:property value="memHp" /></td>
					<td><s:if test="memGen == 1">남자	</s:if>
						<s:else>여자</s:else></td>
					<td>
						<s:a href="%{delURL}">삭제</s:a>
					</td>
				</tr>
			</s:iterator>
			<s:if test="list.size() <= 0">
				<tr>
					<td colspan=6>등록된 회원이 없습니다.</td>
				</tr>
			</s:if>
				<tr>
					<td colspan=7><s:property value="pagingHtml" escape="false" /></td>
				</tr>
		</table>
	</div>
</body>
</html>