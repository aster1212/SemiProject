<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (request.getProtocol().equals("HTTP/1.1"))
		response.setHeader("Cache-Control", "no-cache");
%>
<%request.setCharacterEncoding("UTF-8"); %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>게시판</title>
<style type="text/css">
body {
	background-color: #151515;
	color: #ffffff;
}

#mainDiv {
	text-align: center;
}

.board_list {
	text-align: center;
	color: white;
	border-collapse: collapse;
	width: 100%;
}

.board_list tr {
	border-bottom: 1px solid #ffffff;
}
/* .board_list tr th {
border:1px solid #ffffff;
}  */
.hrs {
	color: #D5D5D5;
	border-top: 1px solid;
	align: center;
	width: 100%;
	size: 20px;
}

.board_search {
	text-align: center;
	width: 835px;
	margin-top: 0px; margin-bottom 12px;
	overflow: hidden;
}

.board_search2 {
	text-align: center;
	width: 1000px;
	margin-top: 10px;
	overflow: hidden;
}

.write_button {
	overflow: hidden;
	text-align: right;
	width: 100%;
	margin-bottom: 20px;
}

.grp_button {
	float: left;
	width: 612px;
	overflow: hidden;
}

.title {
	width: 666px;
	overflow: hidden;
	font-size: 50px;
	text-shadow: 2px 1px 1px #F6F6F6;
	color: gray;
	float: left;
	margin-left: 16px;
	margin-bottom: 8px;
}

.title_sub {
	width: 666px;
	overflow: hidden;
	font-size: 13px;
	color: white;
	float: left;
	margin-left: 16px;
	margin-bottom: 10px;
	padding-left: 52px;
}

#test1 {
	width: 100%;
	padding:130px 0 ;
}
#searchSelect{margin-top:15px;}
 .searchBox{vertical-align: baseline;}
a.board_button:link {
	font-weight: bold;
	color: white;
	text-decoration: none;
} /* 아직 방문하지 않은경우 */
a.board_button:visited {
	font-weight: bold;
	color: white;
	text-decoration: none;
} /* 한번 이상 방문한 링크 처리 */
a.board_button:hover {
	text-decoration: underline;
}

.grp_button2 {
	margin-left: 5px;
	float:right;
	text-align: right;
	padding-left: 0px;
	padding-bottom: 12px;
	width: 800px;
	overflow: hidden;
	font-size: 14px;
}
</style>
</head>
<body>
	<div id="test1">
	<div class="grp_button">
				<h3 class="title">BOARD</h3>
				<h3 class="title_sub">영화에 관한 글을 자유롭게 남기는 공간입니다.</h3>
			</div>


			<div class="grp_button2">
				<a href="listActionfree.action" class="board_button">자유게시판</a> <a
					href="listActionspo.action" class="board_button">스포게시판</a> <a
					href="listAction.action" class="board_button">전체</a>
			</div>
		<table class="board_list" height="30" cellspacing="0" cellpadding="0">

			<tr height="45" align="center">
				<td style="font-size: 13px;" width="35"><strong>번호</strong></td>
				<td style="font-size: 13px;" width="140"><strong>장르</strong></td>
				<td style="font-size: 13px;" width="250"><strong>제목</strong></td>
				<td style="font-size: 13px;" width="100"><strong>글쓴이</strong></td>
				<td style="font-size: 13px;" width="120"><strong>날짜</strong></td>
				<td style="font-size: 13px;" width="50"><strong>조회</strong></td>
			</tr>


			


			<hr class="hrs"></hr>
			<s:iterator value="list" status="stat">

				<s:url id="viewURL" action="viewAction">
					<s:param name="bo_no">
						<s:property value="bo_no" />
					</s:param>
					<s:param name="currentPage">
						<s:property value="currentPage" />
					</s:param>
				</s:url>
				<c:if test="${session.mem_name!=resultClass.bo_writer }">
					<s:url id="takeURL" action="messageWriteForm">
						<s:param name="bo_writer">
							<s:property value="bo_writer" />
						</s:param>
						<s:param name="bo_no">
							<s:property value="bo_no" />
						</s:param>
						<s:param name="currentPage">
							<s:property value="currentPage" />
						</s:param>
					</s:url>
				</c:if>

				<tr height="35" align="center">

					<td style="font-size: 10px;"><s:property value="bo_no" /></td>
					<td style="font-size: 12px;" align="center"><s:property
							value="bo_genre" /></td>
					<td style="font-size: 12px; text-align: left" align="center">&nbsp;<s:a
							href="%{viewURL}">
							<s:property value="bo_subject" />
						</s:a></td>

					<td style="font-size: 11px;" align="center">&nbsp;<s:a
							href="%{takeURL}">
							<s:property value="bo_writer" />
						</s:a></td>

					<td style="font-size: 11px;" align="center"><s:property
							value="bo_date" /></td>
					<td style="font-size: 11px;" align="center"><s:property
							value="bo_cnt" /></td>
				</tr>

			</s:iterator>

			<s:if test="list.size()<=0">

				<tr align="center">
					<td colspan="5">등록된 게시물이 없습니다.</td>
				</tr>
				<tr>
					<td height="1" colspan="6"></td>
				</tr>

			</s:if>
		</table>

		<c:if test="${session.mem_no!=null}">
			<div class="write_button">
				<input type="image" src="/bts/image/board_write.jpg" value="글쓰기"
					class="inputb"
					onClick="javascript:location.href='writeForm.action?currentPage=<s:property value="currentPage" />';">
		
			</div>
		</c:if>


	<div class="board_search">
		<form>
			<select id="searchSelect" name="SearchNum" class="searchBox">
				<option value="99">검색</option>
				<option value="0">액션</option>
				<option value="1">드라마/멜로</option>
				<option value="2">코미디</option>
				<option value="3">아동/가족</option>
				<option value="4">공포/범죄/스릴러</option>
				<option value="5">SF판타지</option>
				<option value="6">작성자</option>
				<option value="7">제목</option>
				<option value="8">내용</option>
			</select> 
			<input class="searchBox" type="text" name="SearchKeyword" value="" /> <input
				name="submit" type="submit" value="검색" />
		</form>
	</div>
	<div class="board_search2">
		<s:property value="pagingHtml" escape="false" />
	</div>
	</div>
</body>
</html>