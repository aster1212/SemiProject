<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%
	request.setAttribute("abcd", "short1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0 0 0 0;
	padding: 0 0 0 0;
	text-align: center;
}

.line {
	width: 50px;
	height: 80px;
	border: 1px solid black;
	display: inline-block;
}
.short {
	width: 250px;
	height: 90px;
	border: 1px solid red;
	display: inline-block;
	display: none;
}
</style>
<script src="/bts/member/shortOpener.js" type="text/javascript">
  </script>
</head>
<body>

	<%
	//연습용 배열
	String[] testArray = new String[30];
	for(int i=0; i < testArray.length; i++){
		testArray[i] = ""+i;
	}
	int cnt=1;
	request.setAttribute("testArray", testArray);
	%>

	<!-- 첫번 쨰 포문 -->
	<% for(int a = 0; a < testArray.length; a+=5){ %>

		<!-- 두번 쨰 포문 -->
		<%for(int b = a; b < a+5 ; b++){%>
		
			&nbsp;
			<div class="line" onclick="sc<%=cnt%>(this)">
				<%=b%>
			</div>
			&nbsp;
		
		<%} %>
	<br>
	<div id="short<%=cnt++%>" class="short">short</div>

	<br>

	<%} %>
</body>
</html>