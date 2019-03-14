<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>게시판</title>
<style type="text/css">
body{
	
	color:white;
}
tr,td{
vertical-align: text-top;
padding:5px;
}
.t1{
	vertical-align: text-top;
}
.s{
	width:200px;
	height:30px;
	background-color:#353535;
	color:white;
	border:1px;
}
.ss{
	width:100px;
	height:30px;
	background-color:#353535;
	color:white;
	border:1px;
}
.text{
	width:630px;
	height:25px;
	background-color:#353535;
	color:white;
	border:1px;
}
.con{
	width:750px;
	height:400px;
	background-color:#353535;
	color:white;
	border:1px;
	border-color:white;
}
.uu{
	text-align: left;
	padding-top:50px;
	padding-bottom:50px;
}

	#tilesContent{
		background: #222222;
		
		}
#btn{border-radius: 2px; width:150px; height:30px; background-color:#5D5D5D; border:0px;margin-bottom:5px; }
</style>
</head>

<body>

   <s:if test="resultClass == NULL">
      <form action="writeAction.action" method="post"
         enctype="multipart/form-data">
   </s:if>

   <s:else>
      <form action="modifyAction.action" method="post"
         enctype="multipart/form-data">
         <s:hidden name="bo_no" value="%{resultClass.bo_no}" />
         <s:hidden name="currentPage" value="%{currentPage}" />
         <s:hidden name="old_file" value="%{resultClass.bo_savfile}" />
   </s:else>

   <table class="uu" width="750px" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td  width="100"  class="ww">
         <select name="category" class="s">
         				<option value="x" ${c1}>-게시판 선택-</option>
                          <option value="자유" ${c2}>자유게시판</option>
                          <option value="스포" ${c3}>스포게시판</option>
         </select>
         </td>
      </tr>
      <tr>
         <td width="100" >
         <select name="bo_genre" class="ss">
                          <option value="x" ${g1}>-장르선택-</option>
                          <option value="액션" ${g2}>액션</option>
                          <option value="드라마/멜로" ${g2}>드라마/멜로</option>
                          <option value="코미디" ${g3}>코미디</option>
                          <option value="아동/가족" ${g4}>아동/가족</option>
                          <option value="공포/범죄/스릴러" ${g5}>공포/범죄/스릴러</option>
                          <option value="SF판타지" ${g6}>SF판타지</option>
                       </select>
                       &nbsp;
                       <input type="text"  name="bo_subject"   theme="simple" value="${resultClass.bo_subject}"  maxlength="50"  class="text"/>
                       <input type="hidden" name="bo_writer"  value="${session.mem_name}"/>
         </td>
      </tr>
      <tr>
         <td><textarea name="bo_content" theme="simple"  cols="50" rows="10"  class="con">${resultClass.bo_content}</textarea></td>
      </tr>
      <tr>
         <td ><input type=file name="upload" theme="simple"  /> 
         <s:if test="resultClass.bo_orgfile != NULL">
      &nbsp; * <s:property value="resultClass.bo_orgfile"  /> 파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.
   </s:if></td>
      </tr>	
      <tr>
         <td align="right" colspan="2"><input name="submit" type="submit"  value="작성완료" class="inputb" id="btn"> 
         <input name="list" type="button" value="목록" class="inputb"id="btn" onClick="javascript:location.href='listAction.action?currentPage=<s:property value="currentPage" />'">
         </td>
      </tr>

   </table>
   </form>

</body>
</html>