<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del() {
			var op1 = ${rep_ed_no};
			var op2 = ${rep_ed_type};
			location.href="adminSuperDelete.action?rep_ed_no="+op1+"&rep_ed_type="+op2;
			alert('삭제됩니다.');
	}
	function out() {
		window.close();
	}
</script>
</head>
<body>
	<div id="wrapper">
		<div id="content">
			<h1>추적된 글</h1>
			<s:if test="resultClass != NULL">
				<s:url id="delthis" action="adminSuperDelete">
					<s:param name="rep_ed_no"><s:property value="rep_ed_no"/></s:param>
					<s:param name="rep_ed_type"><s:property value="rep_ed_type"/></s:param>
				</s:url>
				<div id=typearea>타입 ${resultClass.tableName }</div>

				<div id="reporter">${rep_writer }</div>

				<div id="repedSubject">
					<c:choose>
						<c:when test="${resultClass.tableName eq 'BOARD' }">제목 : ${resultClass.bo_subject }</c:when>
						<c:when test="${resultClass.tableName eq 'BOARDC' }">내용 : ${resultClass.boc_content }</c:when>
						<c:when test="${resultClass.tableName eq 'MOVIE' }">제목 : ${resultClass.MV_SUBJECT }</c:when>
						<c:when test="${resultClass.tableName eq 'MOVIEC' }">내용 : ${resultClass.MVC_CONTENT }</c:when>
						<c:otherwise>알 수 없음</c:otherwise>
					</c:choose>
				</div>

				<div id="repedWriter">
					<c:choose>
						<c:when test="${resultClass.tableName eq 'BOARD' }">글쓴이 : ${resultClass.bo_writer }</c:when>
						<c:when test="${resultClass.tableName eq 'BOARDC' }">글쓴이 : ${resultClass.boc_writer }</c:when>
						<c:when test="${resultClass.tableName eq 'MOVIE' }">글쓴이 : 영화 관리부</c:when>
						<c:when test="${resultClass.tableName eq 'MOVIEC' }">글쓴이 : ${resultClass.MVC_WRITER }</c:when>
						<c:otherwise>알 수 없음</c:otherwise>
					</c:choose>
				</div>

				<div id="repedContent">
					<c:choose>
						<c:when test="${resultClass.tableName eq 'BOARD' }">내용 : ${resultClass.bo_content }</c:when>
						<c:when test="${resultClass.tableName eq 'MOVIE' }">간단 스토리 : ${resultClass.MV_SS }</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</div>
				<!-- 부모글이 있으면 ++ -->
				<s:if test="resultParent != NULL">
				<br/>
				<div id="parentSubjects">
					<c:choose>
						<c:when test="${resultParent.tableName eq 'BOARD' }">부모글 제목 : ${resultParent.bo_subject }</c:when>
						<c:when test="${resultParent.tableName eq 'MOVIE' }">부모영화 제목 : ${resultParent.MV_SUBJECT }</c:when>
						<c:otherwise>알 수 없음</c:otherwise>
					</c:choose>
				</div>
				</s:if>
			<br/>
			<br/>
				&nbsp;&nbsp;<button onclick="del()">신고된 글삭제</button>
			</s:if>
			<s:else>삭제 된 글입니다.</s:else>
			&nbsp;&nbsp;<button onclick="out()">닫기</button>
		</div>
	</div>
</body>
</html>