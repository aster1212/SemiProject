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
	width: 700px;
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

#insertBtn {
	width: 1000px;
	height: 20px;
}

.grayLine {
	background-color: #444444;
}
.filer{
	text-align: left;
}
.alreadyHas{
	float: right;
}
</style>
<script type="text/javascript">
	function checker() {
		if (1 == 2) {
			return false;
			alert("작동됨");
		}
	}
</script>
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
		<s:if test="resultClass==NULL">
			<form action="adminMvInsertAction.action" method="post"
				enctype="multipart/form-data" onsubmit="return checker()">
		</s:if>
		<s:else>
			<form action="adminMvUpdateAction.action" method="post"
				enctype="multipart/form-data">
				<s:hidden name="MV_NO" value="%{resultClass.MV_NO}" />
				<s:hidden name="old_file" value="%{resultClass.MV_FILE_SAVNAME}" />
		</s:else>
		<table id="listTable">
			<!-- <tr>
            <td colspan=9><input type="button" id="insertBtn" value="영화등록" onclick="window.location='admin.action'"></td>
         </tr> -->
			<tr>
				<td colspan=4><h1>영화 등록하기</h1></td>
			</tr>
			<!-- 포스터 -->
			<tr class="grayLine">
				<td colspan=4>영화 포스터 및 스틸컷</td>
			</tr>
			<tr>
				<td colspan=4><s:if test="resultClass.MV_FILE_ORGNAME != NULL">
      &nbsp; * <s:property value="resultClass.MV_FILE_ORGNAME" /> (MV_NO.jpg=포스터)
   </s:if></td>
			</tr>
			<tr>
				<td class="filer" colspan=4>포스터(필)<s:file name="upload" theme="simple" />
				<s:if test="posterST.hasMoreTokens()">
					<font class="alreadyHas">*<s:property value="posterST.nextToken()" /></font>
				</s:if>
				</td>
			</tr>
			<tr>
				<td class="filer" colspan=4>스틸컷(1)<s:file name="upload" theme="simple" />
				<s:if test="posterST.hasMoreTokens()">
					<font class="alreadyHas">*<s:property value="posterST.nextToken()" /></font>
				</s:if>
				</td>
			</tr>
			<tr>
				<td class="filer" colspan=4>스틸컷(2)<s:file name="upload" theme="simple" />
				<s:if test="posterST.hasMoreTokens()">
					<font class="alreadyHas">*<s:property value="posterST.nextToken()" /></font>
				</s:if>
				</td>
			</tr>
			<tr>
				<td class="filer" colspan=4>스틸컷(3)<s:file name="upload" theme="simple" />
				<s:if test="posterST.hasMoreTokens()">
					<font class="alreadyHas">*<s:property value="posterST.nextToken()" /></font>
				</s:if>
				</td>
			</tr>
			<tr>
				<td class="filer" colspan=4>스틸컷(4)<s:file name="upload" theme="simple" />
				<s:if test="posterST.hasMoreTokens()">
					<font class="alreadyHas">*<s:property value="posterST.nextToken()" /></font>
				</s:if>
				</td>

			</tr>
			<!-- 영화제목 -->
			<!-- 신선도 -->
			<tr class="grayLine">
				<td colspan=2>영화제목</td>
				<td colspan=2>신선도</td>
			</tr>
			<tr>
				<td colspan=2><input type="text" name="MV_SUBJECT"
					placeholder="영화 제목" value="${resultClass.MV_SUBJECT}"></td>
				<td colspan=2><input type="number" name="MV_FRESH"
					placeholder="0~100" value="${resultClass.MV_FRESH}"></td>
			</tr>
			<!-- 장르/개봉일 -->
			<tr class="grayLine">
				<td colspan="2" style="font-size: 12px">장르(액션=1,드라마=2,코미디=3,가족=4,공포=5,SF=6)</td>
				<td>영화 상영상태</td>
				<td>개봉일</td>
			</tr>
			<tr>
				<td colspan=2><input type="text" name="MV_GENRE"
					value="${resultClass.MV_GENRE }"></td>
				<td><select name="MV_TYPE">
						<s:if test="resultClass==NULL">
							<option value="x">-영화 상태-</option>
							<option value="1">상영 예정</option>
							<option value="2">상영 중</option>
							<option value="3">상영 종료</option>
						</s:if>
						<c:if test="${resultClass.MV_TYPE==1}">
							<option value="x">-영화 상태-</option>
							<option value="1" selected="selected">상영 예정</option>
							<option value="2">상영 중</option>
							<option value="3">상영 종료</option>
						</c:if>
						<c:if test="${resultClass.MV_TYPE==2}">
							<option value="x">-영화 상태-</option>
							<option value="1">상영 예정</option>
							<option value="2" selected="selected">상영 중</option>
							<option value="3">상영 종료</option>
						</c:if>
						<c:if test="${resultClass.MV_TYPE==3}">
							<option value="x">-영화 상태-</option>
							<option value="1">상영 예정</option>
							<option value="2">상영 중</option>
							<option value="3" selected="selected">상영 종료</option>
						</c:if>
				</select></td>
				<td><input type="date" name="MV_DATE"
					placeholder="ex) yyyy-MM-dd" value="${Sdate }"></td>

			</tr>
			<!-- 감독 -->
			<!-- 주연 -->
			<!-- 조연 -->
			<tr class="grayLine">
				<td colspan=4>출연</td>
			</tr>
			<tr>
				<td>감독<input type="text" name="MV_DIR"
					value="${resultClass.MV_DIR }"></td>
				<td>주연<input type="text" name="MV_MAIN"
					value="${resultClass.MV_MAIN }"></td>
				<td colspan=2>조연<br> <input value="${resultClass.MV_SUB }"
					style="width: 344px; height: 15px;" type="text" name="MV_SUB"
					placeholder="ex) asd,zxc,qwe"></td>
			</tr>
			<!-- 등급 -->
			<!-- 국내/해외 -->
			<!-- 상영시간 -->
			<!-- 배급사 -->
			<tr class="grayLine">
				<td colspan=4>등급및 분류</td>
			</tr>
			<tr>
				<td><select name="MV_GRADE">
						<s:if test="resultClass==NULL">
							<option value="x">-등급선택-</option>
							<option value="1">전체</option>
							<option value="2">7세</option>
							<option value="3">12세</option>
							<option value="4">15세</option>
							<option value="5">18세</option>
							<option value="6">청소년 관람불가</option>
							<option value="7">상영 금지</option>
						</s:if>
						<c:if test="${resultClass.MV_GRADE==1}">
							<option value="x">-등급선택-</option>
							<option value="1" selected="selected">전체</option>
							<option value="2">7세</option>
							<option value="3">12세</option>
							<option value="4">15세</option>
							<option value="5">18세</option>
							<option value="6">청소년 관람불가</option>
							<option value="7">상영 금지</option>
						</c:if>
						<c:if test="${resultClass.MV_GRADE==2}">
							<option value="x">-등급선택-</option>
							<option value="1">전체</option>
							<option value="2" selected="selected">7세</option>
							<option value="3">12세</option>
							<option value="4">15세</option>
							<option value="5">18세</option>
							<option value="6">청소년 관람불가</option>
							<option value="7">상영 금지</option>
						</c:if>
						<c:if test="${resultClass.MV_GRADE==3}">
							<option value="x">-등급선택-</option>
							<option value="1">전체</option>
							<option value="2">7세</option>
							<option value="3" selected="selected">12세</option>
							<option value="4">15세</option>
							<option value="5">18세</option>
							<option value="6">청소년 관람불가</option>
							<option value="7">상영 금지</option>
						</c:if>
						<c:if test="${resultClass.MV_GRADE==4}">
							<option value="x">-등급선택-</option>
							<option value="1">전체</option>
							<option value="2">7세</option>
							<option value="3">12세</option>
							<option value="4" selected="selected">15세</option>
							<option value="5">18세</option>
							<option value="6">청소년 관람불가</option>
							<option value="7">상영 금지</option>
						</c:if>
						<c:if test="${resultClass.MV_GRADE==5}">
							<option value="x">-등급선택-</option>
							<option value="1">전체</option>
							<option value="2">7세</option>
							<option value="3">12세</option>
							<option value="4">15세</option>
							<option value="5" selected="selected">18세</option>
							<option value="6">청소년 관람불가</option>
							<option value="7">상영 금지</option>
						</c:if>
						<c:if test="${resultClass.MV_GRADE==6}">
							<option value="x">-등급선택-</option>
							<option value="1">전체</option>
							<option value="2">7세</option>
							<option value="3">12세</option>
							<option value="4">15세</option>
							<option value="5">18세</option>
							<option value="6" selected="selected">청소년 관람불가</option>
							<option value="7">상영 금지</option>
						</c:if>
						<c:if test="${resultClass.MV_GRADE==7}">
							<option value="x">-등급선택-</option>
							<option value="1">전체</option>
							<option value="2">7세</option>
							<option value="3">12세</option>
							<option value="4">15세</option>
							<option value="5">18세</option>
							<option value="6">청소년 관람불가</option>
							<option value="7" selected="selected">상영 금지</option>
						</c:if>
				</select></td>
				<td><select name="MV_STATE">
						<s:if test="resultClass==NULL">
							<option value="x">-국내/해외-</option>
							<option value="2">국내</option>
							<option value="1">해외</option>
						</s:if>
						<c:if test="${resultClass.MV_STATE==1}">
							<option value="x">-국내/해외-</option>
							<option value="2">국내</option>
							<option value="1" selected="selected">해외</option>
						</c:if>
						<c:if test="${resultClass.MV_STATE==2}">
							<option value="x">-국내/해외-</option>
							<option value="2" selected="selected">국내</option>
							<option value="1">해외</option>
						</c:if>
				</select></td>
				<td>상영시간(분) <input type="number" name="MV_TIME"
					value="${resultClass.MV_TIME }">
				</td>
				<td>배급사 <input type="text" name="MV_PROD"
					value="${resultClass.MV_PROD }"></td>
			</tr>
			<!-- 짧은 줄거리 -->
			<tr class="grayLine">
				<td colspan=4>짧은 줄거리</td>
			</tr>
			<tr>
				<td colspan=4><textarea cols="95" rows="3" name="MV_SS">${resultClass.MV_SS }</textarea></td>
			</tr>
			<!-- 긴 줄거리 -->
			<tr class="grayLine">
				<td colspan=4>전체 줄거리</td>
			</tr>
			<tr>
				<td colspan=4><textarea cols="95" rows="3" name="MV_LS">${resultClass.MV_LS }</textarea></td>
			</tr>
			<!-- 시리즈물 -->
			<!-- 유입어 -->
			<tr class="grayLine">
				<td colspan=2>시리즈(있다면 적으시오)</td>
				<td colspan=2>유입 유도 단어</td>
			</tr>
			<tr>
				<td colspan=2><input type="text" name="MV_CHAIN"
					placeholder="시리즈물인 것만" value="${resultClass.MV_CHAIN }"></td>
				<td colspan=2><input type="text" name="MV_HASH"
					placeholder="예)#총" value="${resultClass.MV_HASH }"></td>
			</tr>
			<!-- 버튼 -->
			<tr class="grayLine">
				<td colspan=2><input type="submit" value="영화 등록"></td>
				<td colspan=2><input type="button" value="취소"
					onclick="window.history.go(-1)"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>