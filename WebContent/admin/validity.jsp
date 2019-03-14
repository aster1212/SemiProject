<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
</head>
<body>
	<s:if test="nullList.size() > 0">
		<h2>${delName }</h2>
		<br>
		찾은 유효성 오류 수 : <s:property value="nullList.size()"/><br>
		지운 유효성 오류 행 : ${param.delCount}
	</s:if>
	<s:else>
		<s:if test="delName==NULL">
			<h2>유효성 검사 메뉴</h2>
		</s:if>
		<s:else>
			유효성에 문제가 없습니다.
		</s:else>
	</s:else>
</body>
</html>