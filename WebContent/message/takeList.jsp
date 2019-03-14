<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Message</title>
<script language="javascript">
function openMessage() {
	var url = "MsgWriteForm.action"
	window.open(
			url,
			"쪽지 보내기",
			"toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=530, height=400");
}
function open_win_noresizable(url, name){

	var oWin = window.open(url,name,"toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=620, height=350" );
	
}
</script>
<style type="text/css">


#mes{margin-top:70px;
			margin-bottom:70px;	}
#hh{
	margin-top:0px;
}
.black{
	border-color: black;
}
#log{width:20	0px; margin-bottom:15px; 	text-align: center; border:1;}
a:visited {text-decoration:none;color:#747474}
a:link {text-decoration:none;color:#1E2026}
a.h_grey:visited {text-decoration:none;color:#000000}
a.h2_grey:hover {text-decoration:none;color:#898A8D}
a.h2_grey:hover {text-decoration:none;color:#898A8D}
.t1{
	vertical-align: text-top;
}
</style>
</head>

<body>
	<table width="1000px" border="0		" bgcolor="#D8D8D8" class="msgb">
	<tr>
		<td colspan="2" align="center"><h2>받은 쪽지함</h2></td>
	</tr>
		<tr height="450px">
			<td class=t1 width="200px">
				<table border="0" width="100%" id="hh" >
					<tr>
					<td align="center">
					<input type="button" id="log"value="쪽지 보내기" onClick="return openMessage()" />
					<input type="hidden" name="msg_give" value="${session_ID }" />
				</td>
					</tr>
					<tr>
					<td align="center"><a href="javascript:location.href='Msg_Rec_list.action'" id="h2_grey"> <img src="/bts/icon/msg.png" width="20px"/><strong> 받은쪽지함</strong></a></td>
					</tr>
					<tr>
					<td  align="center"><a href="javascript:location.href='Msg_Wrt_list.action'" id="h2_grey"><img src="/bts/icon/msg.png" width="20px"/> 보낸쪽지함</a></td>
					</tr>
					<tr>
					<td height="450px">
					</td>
					</tr>
				</table>
			</td>
			<td class=t1 width="800px">
				<table width="100%" border="0" cellspacing="0" cellpadding="2" class="msgt">
		<tr align="center" bgcolor="#f3f3f3">
			<td width="9%">
				<strong>번호</strong>
			</td>
			<td width="12%">
				<strong>보낸 사람</strong>
			</td>
			<td width="66%">
				<strong>내용</strong>
			</td>

			<td width="13%">
				<strong>날짜</strong>
			</td>
			
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="4"></td>
		</tr>
		
		<s:iterator value="list" status="stat">
		
			
			
			<tr bgcolor="#EAEAEA" 	>
				<td>
					<s:property value="msg_no"/>
				</td>
				<td align="center">
					<s:property value="msg_give"/>
				</td>
				<td align="left">&nbsp;
					<a href="#" onClick="javascript:open_win_noresizable('MsgviewAction.action?msg_no=<s:property value="msg_no" />')">
						<s:property value="msg_content"/>
					</a>
				</td>
				<td align="center">
					<s:property value="msg_date"/>
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td height="1" colspan="4">
				</td>
			</tr>
		</s:iterator>
		
		<s:if test="list.size()<=0">
		
			<tr bgcolor="#FFFFFF" align="center">
				<td colspan="4">받은 쪽지 가(이) 없습니다.
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td height="1" colspan="4">
				</td>
			</tr>
			
		</s:if>
			<tr align="right">
			<td colspan="4">
				&nbsp;
				</td>	
			</tr>
			<tr align="center">
				<td colspan="4">
					<s:property value="pagingHtml" escape="false"/>
				</td>
			</tr>
			</table>
			</td>
			<td width="30px">
				&nbsp;
			</td>
			</tr>
			</table>
</body>
</html>























