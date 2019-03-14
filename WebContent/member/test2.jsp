<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
<script type="text/javascript">
</script>
</head>
<body>
<%
	String str = "123123,123123,232,3,2,4,5,6,8,712,3,222.22,";
	String test1 = "'asd'";
	StringTokenizer st = new StringTokenizer(str,",");
	String[] strArray = new String[st.countTokens()];
	int i=0;
	while(st.hasMoreElements()){
		strArray[i++] = st.nextToken();
	}
	
	for(i=0; i < strArray.length; i++){
%>
	<%=strArray[i]%><br>
<%} %>
<%=test1 %>
<form>
	<input type="checkbox" value=1 checked="checked">1 
	<input type="checkbox" value=2 >2 
	<input type="checkbox" value=3 checked='checked'>3 
	<input type="checkbox" value=3 checked=''>4 
</form>
</body>
</html>