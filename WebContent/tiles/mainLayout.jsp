<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<body>
<center>
<table width="1200" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr height="70">
		<!-- <td height="150" width="150">&nbsp;</td>
		<div height="150" width="900"valign="bottom" align="center"></div>
		 -->
		 <caption><tiles:insertAttribute name="header" /></caption>
	
	</tr>
	<tr>
		<td height="20" colspan="3">&nbsp;</td>
	</tr>
	<tr>
		<td width="1200" valign="top" align="center" colspan="3"><tiles:insertAttribute name="body" /></td>
	</tr>
	<tr>
		<td height="150" width="150">&nbsp;</td>
		<td height="200" width="1200" valign="bottom" align="center" colspan="3"><tiles:insertAttribute name="footer" /></td>
	</tr>
</table>
</center>
</body>

</html>