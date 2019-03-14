<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Msg_viewlist</title>
<script type="text/javascript">
function openMessage() {
	var url = "MsgWriteForm.action"
	window.open(
			url,
			"메시지 보내기",
			"toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=620, height=450");
}
</script>
<style type="text/css">

td{
padding:5px;
}
body{
	background-color:#BDBDBD;
}
#mes{
			margin-left:10px}
.tt{
	vertical-align: top;
}

</style>
</head>
<body>
<div id="mes">
	<table width="500px" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="center">
				<h2>메시지 보기</h2>
			</td>
		</tr>
	</table>
	

	<table width="570px" border="0" cellspacing="0" cellpadding="0">
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
			<td bgcolor="#F4F4F4" style=" border-bottom:1px solid black;">
				&nbsp;<font size="2">보내는 사람</font>
			</td>
			<td bgcolor="#FFFFFF" style="border-bottom:1px solid black;">
			&nbsp;
			<s:property value="resultClass.msg_give" />
			</td>
		
		
		
		<tr>
			<td bgcolor="#F4F4F4" class="tt" style="border-bottom:1px solid black;">&nbsp;<font size="2">내용</font>
			</td>
			<td bgcolor="#FFFFFF"  height="150px" class="tt" style=" border-bottom:1px solid black;">
				&nbsp;${resultClass.msg_content}
			</td>
		</tr>
		
		</tr>
		<tr>
			<td bgcolor="#F4F4F4" style=" border-bottom:1px solid black;">
				&nbsp;<font size="2">받는 사람</font>
			</td>
			<td bgcolor="#FFFFFF"style="border-bottom:1px solid black;">
			
			&nbsp;${resultClass.msg_take }

			</td>
		</tr>
		<tr>
			<td height="10" colspan="2">
			</td>
		</tr>
		
		<tr>
			<td align="right" colspan="2">
			    <input name="list" type="button" value="창 닫기" onClick="self.close();" />
			</td>
		</tr>
	</table>
	</div>
</body>
</html>


























