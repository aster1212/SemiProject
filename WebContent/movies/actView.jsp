<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>


   <title>배우상세보기</title>
   <script type="text/javascript">
   
   function photoClick(obj) {
      var src = obj.id;
      location.href="actDetail.action?"+src;
      
      
      }
   
   </script>
   
<style type="text/css" >

body {
color:white;
margin:0px;
padding:0px;
font-family:'Arial';
}



div.ACT_MV_NO {
 position: static;
 padding: 15px;
 width: 400px;
 background: #5f5f5f;
 color: #fff;
 border-radius: 10px;
 }
 
 .view_contents_h {
text-align:left;
color:#ffffff;
font-size:16px;
width:600px;
padding:0px;
margin:25px 0 25px 0;
overflow:hidden;
}
 
 div.act_profile {
 position: static;
 padding: 15px;
 width: 550px;
 background: #5f5f5f;
 color: #fff;
 border-radius: 10px;
 }
 
 .act_mv{
 width: 600px;
 margin: 5px;
 overflow: hidden;
 padding-top: 10px;
 padding-bottom: 10px;
 
 }
 
 .graphy{
 width: 600px;
 overflow: hidden;
 text-align: left;
 font-size:16px;
 }
 

#agrp:link    {color:white;text-decoration:none;} /* 아직 방문하지 않은경우 */ 
#agrp:visited {color:gray; text-decoration:none; } /* 한번 이상 방문한 링크 처리 */ 
#agrp:hover   {text-decoration:underline; } 


#wrapper{margin-left: 170px;}
</style>

</head>


<body bgcolor="black">
<div id="wrapper">
   <table class="grp" width="600" border="0" cellspacing="0" cellpadding="0" >
   <tr  >
      <td style="padding-top:15px;" rowspan="4" width="200">
      
      <img src="/bts/image/poster/<s:property value='resultClass.PROFILE_SAVNAME'/>" width="200" height="300" />
      </td>
      <td style="font-size: 13px; padding-left:10px;">
      <br /><s:property value="resultClass.ACT_NAME" /></td>
   </tr>
   <tr height="5">
      <td style="font-size: 13px; padding-left:10px;">출생&nbsp;&nbsp;
         <s:property value="resultClass.ACT_BIRTH" /></td>
      
   </tr>
   <tr height="5">
      <td style="font-size: 13px; padding-left:10px; ">작품<br /><br />
      <c:forEach items="${movieList}" var="List">
      <a id="agrp" href="javascript:location.href='fullViewAction.action?MV_NO=${List.MV_NO}'">#${List.MV_SUBJECT}</a>&nbsp;&nbsp;             
      <c:set var="i" value="${i+1}" />
      </c:forEach>
           <s:iterator value="movieList" status="stat">
           <s:property value="MV_NAME" />
           </s:iterator>
      </td>
   </tr>
   <tr height="60">
   <td></td>
   </tr>
   
   
   
   </table>

         
      <!-- 프로필  -->
      <h4 class="view_contents_h">프로필</h4>
      <div class="act_profile">
      <h5><s:property value="resultClass.ACT_PROFILE" /></h5>
      </div>

      <br>
      <br>
      
      <!-- 출연작(필몰그래피)  -->
      <h4 class="graphy">필모그래피</h4>
      <div class="act_mv" style="width:600px; overflow:hideen;">   
             <c:forEach items="${movieList}" var="List">
   <a href="javascript:location.href='fullViewAction.action?MV_NO=${List.MV_NO}'">
   
   <img src="/bts/image/poster/${List.MV_NO}.jpg" width="125" height="180"
   alt="이미지 없음"/>   </a>
       
         <c:set var="i" value="${i+1}" />
             </c:forEach>
      </div>
      
<div>
<br>
<br>
</div>

</div>
     </div>
</body>
</html>






