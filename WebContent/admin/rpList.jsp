<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

#formBox{float: right;}
</style>
<script type="text/javascript">
	function opt() {
		var selector = document.getElementById('formBox');
		var sval = selector.options[selector.selectedIndex].value;
		var stext = selector.options[selector.selectedIndex].text;
		/* alert(sval + ', ' + stext); */
		location.href="adminRpList.action?viewType="+sval;
	}
	function fixer() {
		var fixType=${viewType};
		document.getElementById('formBox').selectedIndex=fixType;
	}
</script>
</head>
<body onload="fixer()">
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
				<td colspan=6>

					<h1 id="mark1">신고 리스트</h1>
						<select id="formBox" name="viewType" onchange="opt()">
							<option value="0">전체보기</option>
							<option value="1">게시판</option>
							<option value="2">게시판 댓글</option>
							<option value="3">영화</option>
							<option value="4">영화 댓글</option>
							<option value="5">건의사항</option>
							<option value="6">버그리포트</option>
							<option value="7">이용 관련</option>
						</select>
				</td>
			</tr>
			<tr>
				<td width="150">신고날짜</td>
				<td width="150">신고종류</td>
				<td>신고된 글 제목(내용)</td>
				<td width="200">신고사유</td>
				<td>처리상태</td>
				<td width="180">옵션</td>
			</tr>
			<s:iterator value="list" status="stat"><s:set name="listOne" value="%{list[#stat.index]}"/>
				<tr>
					<td><s:property value="rep_date" /></td>
					<!-- 신고 타입 -->
					<td>
						<s:if test="#listOne.rep_ed_type == 1">게시판:글</s:if>
						<s:elseif test="#listOne.rep_ed_type == 2">게시판:댓글</s:elseif>
						<s:elseif test="#listOne.rep_ed_type == 3">영화:영화</s:elseif>
						<s:elseif test="#listOne.rep_ed_type == 4">영화:댓글</s:elseif>
						<s:elseif test="#listOne.rep_ed_type == 5">건의사항</s:elseif>
						<s:elseif test="#listOne.rep_ed_type == 6">버그리포트</s:elseif>
						<s:elseif test="#listOne.rep_ed_type == 7">이용관련</s:elseif>
						<s:else>알 수 없음</s:else>
					<%-- <s:property value="rep_ed_type" /> --%>
					</td>
					<td>
						<s:if test="#listOne.rep_ed_type >= 5">해당 없음</s:if>
						<s:else><s:property value="rep_ed_content" /></s:else>
					</td>
					<td>
						<%-- <s:if test="#listOne.rep_ed_type >= 5">해당 없음</s:if>
						<s:else> --%><s:property value="rep_content" /><%-- </s:else> --%>
					</td>
					<!-- 처리상태 -->
					<td>
						<s:if test="#listOne.rep_status == 0">
						미처리
						</s:if>
						<s:else>
						처리
						</s:else>
						<%-- <s:property value="rep_status" /> --%>
					</td>
					<td>
					<s:if test="#listOne.rep_ed_type != 0">
						<s:if test="#listOne.rep_ed_type < 5">
							<a onclick="window.open('adminTcAction.action?rep_ed_no=<s:property value="rep_ed_no" />&rep_ed_type=<s:property value="rep_ed_type" />','추적하기','width=480,height=500,location=no,status=no,scrollbars=no')" href="">글보기 </a>
							&nbsp;
						</s:if> 
						<s:if test="#listOne.rep_status == 0">
							&nbsp;<a href="adminRpUpdateAction.action?rep_no=<s:property value="rep_no" />">해결처리</a>
						</s:if>
					</s:if>
					<s:else>
					abnormal&nbsp;<a href="reportDelete.action?rep_no=<s:property value="rep_no" />"> 삭제</a>
					</s:else>
					</td>
				</tr>
			</s:iterator>
			<s:if test="list.size() <= 0">
				<tr>
					<td colspan=6>등록된 신고가 없습니다.</td>
				</tr>
			</s:if>
				<tr>
					<td colspan=6><s:property value="pagingHtml" escape="false" /></td>
				</tr>
		</table>
	</div>
</body>
</html>