<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("Cache-Control", "no-store"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires",0); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 관리</title>
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
</head>
<body>
   <div id="header">
      <strong><a href="admin.action">관리자 페이지</a></strong> 
      <a href="memList.action">회원 목록</a> 
      <a href="adminMvList.action">영화 목록</a>
   </div>
   
   <div id="mainDiv">
      제목 ${param.MV_SUBJECT}<br>
      fresh ${param.MV_FRESH }<br>
      genre ${param.MV_GENRE }<br>
      type ${param.MV_TYPE }
      <br>date ${param.MV_DATE }
      <br>dir ${param.MV_DIR }
      <br>main ${param.MV_MAIN }
      <br>sub ${param.MV_SUB }
      
   </div>
</body>
</html>