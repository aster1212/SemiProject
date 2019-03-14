<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#contentMy {
	height:800px;
	padding-top: 30px;
   /* padding-left: 90px;
   padding-right: 90px; */
   text-align: center;
}
#myMvList{
	margin: 0 90px 0 90px;
}
#menuPointer{
	height: 27px; background: #343434; margin:20px 0 40px 0;
}
#menuPointer img{ width:20px; height: 20px; float: left; margin-left: 180px; cursor: pointer;}
#menuPointer font{font-size: 18px; float: right; margin-right: 180px;}
.line {
	width: 150px;
	height: 240px;
	border: 1px solid black;
	display: inline-block;
}

.img1 {
	width: 150px;
	height: 240px;
	float: left;
}

.opClass {
	opacity: 0.1;
}

.hovers {
	width: 150px;
	height: 240px;
	text-align:center;
	position: absolute;
	margin-top: 70px;
	color: white;
	visibility: hidden;
}
.clear{clear: both;}
</style>
<script type="text/javascript">
var src2;
function mover(obj){
	src2 = obj.id;
	obj.style.background='black';
	document.getElementById("poster"+src2).classList.add('opClass');
	document.getElementById("hover"+src2).style.visibility='visible';
}
function mout(obj){
	document.getElementById("poster"+src2).classList.remove('opClass');
	document.getElementById("hover"+src2).style.visibility='hidden';
}
var src;
function go(obj) {
	src=obj.id;
	location.href="fullViewAction.action?"+src;
}
</script>
</head>
<body>
<div id="contentMy">
      <h2>마이페이지</h2>
      <div id="menuPointer"><img src="/bts/image/icon/back.png" onclick="history.back();"/><font>관심있는영화</font></div>
      <div id="myMvList">
	<s:if test="mvList.size() <= 0">
		<font color="gray">관심있는 영화가 없습니다.</font>
	</s:if>
	<%int cnt=1; %>
	<s:else>
		<s:iterator value="mvList" status="stat">
			<div id="MV_NO=<s:property value="MV_NO" />" class="line"
				onclick="go(this)" onmouseover="mover(this)" onmouseout="mout(this)">

				<!-- 이미지 -->
				<img id="posterMV_NO=<s:property value="MV_NO" />" class="img1"
					src="/bts/image/poster/<s:property value='MV_NO'/>.jpg" alt="이미지 없음" />


				<!-- 호버용 -->
				<div id="hoverMV_NO=<s:property value="MV_NO" />" class="hovers">
					<s:property value="MV_SUBJECT" />
					<br /> 평점 : <fmt:formatNumber value="${MV_AVR}"  pattern=".0"/>점
				</div>
			</div>
			<%if(cnt%4 == 0){ %>
			<div class="clear"></div>
			<%} %>
		</s:iterator>
	</s:else>
	</div>
</div>
</body>
</html>