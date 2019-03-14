<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배우 관리</title>
<style type="text/css">
* {
   margin: 0 0 0 0;
   padding: 0 0 0 0;
}

body {
   background-color: #151515;
   color: #ffffff;
}

#mainDiv {
   text-align: center;
}

#listTable {
   display: inline-table;
   text-align: center;
   width: 700px;
}

#listTable td {
   border: 1px solid white;
}

#menuTr {
   
}

#header {
   height: 50px;
   width: 100%;
   border-bottom: 1px solid red;
   background-color: #202020;
}

a:link {
   color: white;
   text-decoration: none;
}

a:visited {
   color: white;
   text-decoration: none;
}

a:hover {
   color: white;
   text-decoration: underline;
}

.posters {
   width: 100px;
   height: 160px;
}
#insertBtn{
   width: 1000px;
   height: 20px;
}
.grayLine{
   background-color: #444444;
}
</style>
<script type="text/javascript">
function checker() {
	if(1==2){
		return false;
		alert("작동됨");
	}
}
</script>
</head>
<body>
   <div id="header">
      <strong><a href="admin.action">관리자 페이지</a></strong> 
      <a href="memList.action">회원 목록</a> 
      <a href="adminMvList.action">영화 목록</a>
       <a href="adminActList.action">배우 목록</a>
      <a href="adminRpList.action">신고 목록</a>
   </div>
   
   <div id="mainDiv">
   <s:if test="resultClass2==NULL">
      <form action="adminActInsertAction.action" method="post" enctype="multipart/form-data" onsubmit="return checker()">
   </s:if>
   <s:else>
      <form action="adminActUpdateAction.action" method="post" enctype="multipart/form-data">
         <s:hidden name="ACT_NO" value="%{resultClass2.ACT_NO}" />
         <s:hidden name="old_file" value="%{resultClass2.PROFILE_ORGNAME}" />
   </s:else>
      <table id="listTable">
         <!-- <tr>
            <td colspan=9><input type="button" id="insertBtn" value="영화등록" onclick="window.location='admin.action'"></td>
         </tr> -->
         <tr>
            <td colspan=4><h1>배우 등록하기</h1></td>
         </tr>
         
         
         <!-- 포스터 -->
         <tr class="grayLine"><td colspan=4>배우 프로필 사진</td></tr>
         <tr>
         
            <td><s:file name="poster" theme="simple" /> <s:if test="resultClass2.PROFILE_ORGNAME != NULL">
      &nbsp; * <s:property value="resultClass2.PROFILE_ORGNAME" /> 파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.
   </s:if></td>
   		
   	
         </tr>
         <!-- 배우이름 -->
         <!-- 신선도 -->
         <tr class="grayLine">
            <td colspan=2>배우이름</td>
            <td colspan=2>출연작</td>
         </tr>
         <tr>
            <td colspan=2><input type="text" name="ACT_NAME" placeholder="영화 제목" value="${resultClass2.ACT_NAME}"></td>
        	<td colspan=2><input type="text" name="ACT_MV_NO" placeholder="21,24,67,81..." value="${resultClass2.ACT_MV_NO}"></td>
         </tr>
         
         <!-- 장르/개봉일 -->
         <tr class="grayLine">
            <td colspan="2" style="font-size: 12px">배우타입(배우=1,감독=2)</td>
            <td>배우생일</td>
         </tr>
         <tr>
               <td><select name="ACT_TYPE">
               			<s:if test="resultClass2==NULL">
               				<option value="x">-배우타입-</option>
							<option value="1">배우</option>
							<option value="2">감독</option>
               			</s:if>
               			<c:if test="${resultClass2.ACT_TYPE==1}">
               				<option value="x">-배우타입-</option>
							<option value="1" selected="selected">배우</option>
							<option value="2">감독</option>
               			</c:if>
						<c:if test="${resultClass2.ACT_TYPE==2}">
               				<option value="x">-배우타입-</option>
							<option value="1">배우</option>
							<option value="2" selected="selected">감독</option>
						</c:if>
                   </select>
                   
               </td>
               
               <td>
                     <input type="date" name="ACT_BIRTH" placeholder="ex) yyyy-MM-dd" value="${Sdate }">
               </td>
               
         </tr>
         
     
         <!-- 배우프로필 -->
         <tr class="grayLine"><td colspan=4>배우프로필</td></tr>
         <tr>
            <td colspan=4><textarea cols="95" rows="3" name="ACT_PROFILE">${resultClass2.ACT_PROFILE }</textarea></td>
         </tr>
         
       
         <!-- 버튼 -->
         <tr class="grayLine">
            <td colspan=2><input type="submit" value="영화 등록"></td>
            <td colspan=2><input type="button" value="취소" onclick="window.history.go(-1)"></td>
         </tr>
      </table></form>
   </div>
</body>
</html>