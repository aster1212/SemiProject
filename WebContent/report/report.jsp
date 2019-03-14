<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>신고하기</title>
	<style type="text/css">
* {
	margin: 0 0 0 0;
	padding: 0 0 0 0;
}
.tt{
	margin-top:30px;
	
}
.t1{
	vertical-align: text-top;
}
td{
padding:5px;
}
body{
	background-color:#BDBDBD;
}

#mainDiv {
	text-align: center;
}
.r{
	height:20px;
	
}
.rr{
	height:250px;
	width:350px;
}
#cc{margin-top:5px;border-radius: 2px; width:150px; height:30px; background-color:#818181; border:0px;margin-bottom:5px; } 	
</style>
</head>

<body>
<center>
      <form action="reportAction.action" method="post" class="tt">
   <table align="center" width="450px" border="0" cellspacing="0" cellpadding="2">
      <tr>
         <td align="center" ><h2>신고하기</h2></td>
      </tr>
      <tr><td>&nbsp;</td></tr>
   </table>



   <table align="center" width="450px"  height="450px" border="0" cellspacing="0" cellpadding="0" class="t1">
   <tr>
   		<td height="100px"  style="border-bottom:1px solid black;"align="center" class="r" bgcolor="#F4F4F4">신고내용</td>
   		<td bgcolor="#E1E1E1"  style="border-bottom:1px solid black;">
   			<c:if test="${typenumber==1 || typenumber==2 || typenumber==3 || typenumber==4}">
   			  	 ${TableName}<input type="hidden" name="rep_ed_content" value="${TableName}"/>
   				<input type="hidden" name="rep_ed_type" value="${typenumber}"/>
   				<c:if test="${typenumber==1}"> <!-- 게시판상세보기신고 -->
   				<input type="hidden" name="rep_ed_no" value="${bo_no}"/>
   				</c:if>
   				<c:if test="${typenumber==2}"><!-- 게시판댓글신고 -->
   				<input type="hidden" name="rep_ed_no" value="${boc_no}"/>
   				</c:if>
   				<c:if test="${typenumber==3}"><!-- 영화상세보기신고 -->
   				<input type="hidden" name="rep_ed_no" value="${MV_NO}"/>
   				</c:if>
   				<c:if test="${typenumber==4}"><!-- 영화댓글신고 -->
   				<input type="hidden" name="rep_ed_no" value="${MVC_NO}"/>
   				</c:if>
   				
   			</c:if>
   			<c:if test="${typenumber==5}">
   				<select name="ed_content">
                          <option value="">-선택-</option>
                          <option value="5">건의사항</option>
                          <option value="6">버그리포트</option>
                          <option value="7">이용관련</option>
                 </select>
                 <input type="hidden" name="rep_ed_type" value="${typenumber}"/>
                 <input type="hidden" name="rep_ed_no" value=""/>   
   			</c:if>
   		</td>
   	</tr>
	<tr>
    	<td height="5px" align="center" bgcolor="#F4F4F4" style="border-bottom:1px solid #422700;">신고자</td>
        <td bgcolor="#E1E1E1"  style="border-bottom:1px solid #422700;">
        	${session.mem_name }<input type="hidden" name="rep_writer" value="${session.mem_name}"/>
        </td>
    </tr>
    <tr>
         <td align="center"  bgcolor="#F4F4F4">신고이유</td>
         <td height="230px" bgcolor="#E1E1E1"><input type="text" name="rep_content" theme="simple"
         
               value="${resultClass.rep_cotent}"  class="rr"/></td>
      </tr>

      <tr>
         <td height="30px" align="center" colspan="2">
         	<input name="submit" type="submit" id="cc"value="작성완료"/>
         	<input name="main" type="button" id="cc" value="메인으로" class="inputb" onclick="self.close();">
         </td>
      </tr>

   </table>
   </form>

</body>
</html>