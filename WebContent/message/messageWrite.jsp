<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Msg_writeForm</title>
<script type="text/javascript">
	function check() {

		var content = msg_take.msg_content.value;
		var recive = msg_give.msg_take.value;

		if (content.length == 0) {
			alert("내용을 입력하세요.");
			msg_take.msg_content.value();
			return false;
		}
		if (recive.length == 0) {

			alert("받는사람을 입력하세요.");

			msg_give.msg_take.value();
			return false;
		}
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

</style>
</head>
<body>
<div id="mes">
	<table width="500px" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="center">
				<h2>메시지 보내기</h2>
			</td>
		</tr>
	</table>



	<form action="Msg_writeAction.action" method="post"
		enctype="multipart/form-data" onsubmit="return validation();"
		name="msg_give" onsubmit="return check()">



		<table width="500px" border="0" cellspacing="0" cellpadding="0">
			

			
			<tr>
				<!-- 쪽지 보내기 -->
				<td bgcolor="#F4F4F4" style="font-size: 1px; border-bottom:1px solid black;">
				<input type="hidden"	name="msg_give" value="${session.mem_name}" />
				<font size="2">받는 사람</font>
				</td>
				<td bgcolor="#E1E1E1" style="font-size: 1px; border-bottom:1px solid black;"><input type="text" name="msg_take" width="500px"/></td>
			</tr>
			<tr>
				<td bgcolor="#F4F4F4" style="font-size: 1px; border-bottom:1px solid black;"><font size="2">&nbsp;내용</font></td>
				<td bgcolor="#E1E1E1" style="font-size: 1px; border-bottom:1px solid black;">&nbsp;<s:textarea name="msg_content"
						theme="simple" cols="50" rows="15" /></td>
			</tr>

			

			<tr>
				<td>&nbsp;${errorMsg }</td>
				<td align="right" colspan="1"><input name="submit"
					type="submit" value="보내기" class="inputb" width="150px"> <input
					name="list" type="button" value="취소" class="inputb" width="150px"
					onClick="self.close();" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>