<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Date a = new Date("Mon Nov 19 00:00:00 KST 2018");
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	String strDate = sf.format(a);
%>
<h1>영화 입력 폼<%= strDate %></h1>
<form action="adminMvInsertAction.action" method="post">
<div>
	subject : <input type="text" name="MV_SUBJECT">
</div>
<div>
	genre : <input type="text" name="MV_GENRE">
</div>
<div>
	date : <input type="text" name="MV_DATE">
</div>
<div>
	DIR : <input type="text" name="MV_DIR">
</div>
<div>
	main : <input type="text" name="MV_MAIN">
</div>
<div>
	sub : <input type="text" name="MV_SUB">
</div>
<div>
	grade : <input type="text" name="MV_GRADE">
</div>
<div>
	STATE : <input type="text" name="MV_STATE">
</div>
<div>
	TIME : <input type="text" name="MV_TIME">
</div>
<div>
	PROD : <input type="text" name="MV_PROD">
</div>
<div>
	MV_SS : <textarea rows="12" cols="3" name="MV_SS"></textarea>
</div>
<div>
	MV_LS : <textarea rows="12" cols="3" name="MV_LS"></textarea>
</div>
<div>
	chain : <input type="text" name="MV_CHAIN">
</div>
<div>
	hash : <input type="text" name="MV_HASH">
</div>
<div>
	type : <input type="text" name="MV_TYPE">
</div>
<div>
	fresh : <input type="number" name="MV_FRESH">
</div>

<div>
	AVR : <input type="number" name="MV_AVR">
</div>
<div>
	<input type="submit">
</div>
<div></div>
<div></div>

</form>



</body>
</html>