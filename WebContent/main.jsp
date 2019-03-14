<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/common.css"/>
<link rel="stylesheet" href="./css/unit.css"/>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/gsap/1.16.1/TweenMax.min.js"></script>
<script src="./js/controller.js"></script>
<style type="text/css">

* {
	margin: 0 0 0 0; /* 위 오른쪽 아래 왼쪽 */
	padding: 0 0 0 0;
} /* 전체사용 스크립트 */
body {
	background-color: #121212;
	color: #e3e3e3;
}

#viewBlack {
	position: absoute;
	width: 1800px;
	height: 400px;
	background-color: black;
} /* div 아이디 */
#viewArea {
	position: relative;
	width: 1000px;
	height: 400px;
	overflow: hidden;
	margin-top: 50px;
}

#imgList {
	position: absolute;
	width: 2000px;
	left: 0px;
	top: 0px;
}

#imgList div {
	float: left;
	margin: 0px;
	padding: 0px;
}

#viewBoard {
	position: relative;
	width: 1000px;
	margin-top: 50px;
}
#tilesContent{
		background: #121212
		;
		}
/* 메인 게시판 메뉴탭 */
</style>
<script>
	/*
	 rolling page
	 */
	var leftCt = 0;
	$(function() {
		$("#album").attr("top", "0");
		imgStart("R");
	});
	function imgStart(tp) {
		clearInterval($("#imgList").attr("timer"));
		if (tp == "R") { // 오른쪽 이동
			imgRight();
			$("#imgList").attr("timer", setInterval("imgRight()", 3000)); // 멈춰있는 시간
		}
	}
	function imgRight() {
		$("#imgList").animate({
			left : parseInt($("#imgList div").eq(0).width() * -1)
		}, 300, function() {
			$("#imgList").css("left", "0px");
			$("#imgList>div").eq(0).clone().appendTo($("#imgList"));
			$("#imgList>div").eq(0).remove();
		});
	}

	/* 탭메뉴 */
	

	//리뷰별컨트롤
	function view_review_star(var1) {
		var i;

		//모든별 흑백
		for (i = 1; i <= 5; i++) {
			document.getElementById("star_img" + i).checked = false;
		}
		//선택별까지 컬러
		for (i = 1; i <= var1; i++) {
			document.getElementById("star_img" + i).checked = true;
		}
		document.getElementById("stars").value = var1;
	}


	
	
	function show(var1) {
		document.getElementById(var1).style.display = "";
	}
	function hide(var1) {
		document.getElementById(var1).style.display = "none";
	}
	function c_class(var1, var2) {
		document.getElementById(var1).setAttribute("class",var2);
	}
</script>
<style type="text/css">
body {
	color: white;
}

.stars_label input {
	display: none;
}

.stars_label label {
	float: left;
	margin: 0 2px 0 0;
	/* 위 오른쪽 아래 왼쪽 */
	background: url(./images/star_02.png) no-repeat left top;
	display: block;
	border: 0px;
	width: 21px;
	height: 18px;
	overflow: hidden;
}

.stars_label label:hover {
	background: url(./images/star_02.png) no-repeat left top;
}

.stars_label input[type=checkbox]:checked+label {
	background: url(./images/star_01.png) no-repeat left top;
}

#imgContainer{
	border: 1px solid red;
	border-radius:50%;
	overflow: hidden;
	width: 50px;
	height: 50px;
	text-align: center;
}
#imgWriter{
	display: inline-block;
	border: 1px solid red;
	border-radius:50%;
	overflow: hidden;
	width: 50px;
	height: 50px;
	text-align: center;
}
#imgWriter img{
	display: inline-block;
	width: 50px;
	height: 50px;
}
#imgContainer img{
	display: inline-block;
	width: 50px;
	height: 50px;
}









.main_list {
background:#232323;
width:49%;
height:330px;
border-left:1px solid #D5D5D5;
border-right:1px solid #D5D5D5;
border-bottom:1px solid #D5D5D5;
margin-top:10px;
float:left;
}
.main_list h1 {
border-top:2px solid #3A79A0;
height:30px;
line-height:30px;
font-size:17px;
color:#e3e3e3;
padding:0 0 0 10px;
}
.main_list h1 div {
float:left;
}
.main_list h1 a {
float:right;
color:#e3e3e3;
font-size:11px;
text-decoration:none;
margin-right:10px;
}
.main_list_tab {
width:100%;
}
.main_list_tab a {
width:50%;
text-align:center;
height:30px;
line-height:30px;
font-weight:bold;
display:block;
float:left;
font-size:14px;
text-decoration:none;
}
.main_list_tab_a {
background:#323232;
color:#000000;
}
.main_list_tab a:hover {
background:#AB47BC;
color:#ffffff;
}
.main_list_tab_a_hover {
background:#AB47BC;
color:#ffffff;
}
.main_list ul {
width:100%;
list-style:none;
margin:0px;
padding:0px;
overflow:hidden;
}
.main_list ul li {
margin:0px;
padding:5px 0 5px 5px;
overflow:hidden;
}
.main_list ul li div {
float:left;
width:2px;
height:2px;
background:#e3e3e3;
margin:8px 0 0 5px;
overflow:hidden;
}
.main_list ul li a {
float:left;
text-decoration:none;
color:#e3e3e3;
margin:0 0 0 10px;
padding:0px;
font-size:12px;
}



.comm_list {
margin-top:10px;
background:#232323;
width:49%;
height:480px;
border:1px solid #D5D5D5;
float:left;
}
.comm_list_top {
width:100%;
height:140px;
overflow:hidden;
}
.comm_list_top div {
position:absolute;
margin:140px 0 0 0;
font-size:17px;
color:#e3e3e3;
background: #323232;
}
.comm_list h1 {
font-size:17px;
color:#e3e3e3;
text-align:center;
padding:15px 0 15px 0;
margin:0 20px 0 20px;
border-bottom:2px solid #FFA5A0;
}
.comm_list h1 span {
margin:5px;
color:#e3e3e3;
margin-left:-5px;
}
.comm_list h1 span img {
display:inline-block;
margin-bottom:-2px;
}
.comm_list ul {
list-style:none;
margin:0 20px 0 20px;
padding:0px;
overflow:hidden;
}
.comm_list ul li {
margin:0px;
padding:10px 0 10px 0;
font-size:14px;
color:#e3e3e3;
overflow:hidden;
}
.comm_list_l {
float:left;
width:80%;
font-weight:bold;
font-size:12px;
}
.comm_list_l span {
font-size:12px;
}
.comm_list_r {
float:right;
width:20%;
text-align:right;
}
.comm_list_r img {
display:inline-block;
margin-bottom:-2px;
}
.comm_list_r span {
font-size:16px;
font-weight:bold;
}
</style>

</head>
<body>
<div id="opDiv"></div>
<div class="slide_bg">
	<div class="slide_bgbg">
		<button class="prev" type="button">
			<img src="./image/left.jpg" alt="" />
		</button>
	<div class="slide">
		<ul>
		<a href="fullViewAction.action?MV_NO=${gm1[0]}"><li><img src="/bts/image/poster/${gm1[0]}.jpg" alt="" width="150px" height="250px" /></li></a>
		<a href="fullViewAction.action?MV_NO=${gm1[1]}"><li><img src="/bts/image/poster/${gm1[1]}.jpg" alt="" width="150px" height="250px" /></li></a>
		<a href="fullViewAction.action?MV_NO=${gm1[2]}"><li><img src="/bts/image/poster/${gm1[2]}.jpg" alt="" width="150px" height="250px" /></li></a>
		<a href="fullViewAction.action?MV_NO=${gm1[3]}"><li><img src="/bts/image/poster/${gm1[3]}.jpg" alt="" width="150px" height="250px" /></li></a>
		<a href="fullViewAction.action?MV_NO=${gm1[4]}"><li><img src="/bts/image/poster/${gm1[4]}.jpg" alt="" width="150px" height="250px" /></li></a>
			
		<a href="fullViewAction.action?MV_NO=${gm1[5]}"><li><img src="/bts/image/poster/${gm1[5]}.jpg" alt="" width="150px" height="250px" /></li></a>
		<a href="fullViewAction.action?MV_NO=${gm1[6]}"><li><img src="/bts/image/poster/${gm1[6]}.jpg" alt="" width="150px" height="250px" /></li></a>
		<a href="fullViewAction.action?MV_NO=${gm1[7]}"><li><img src="/bts/image/poster/${gm1[7]}.jpg" alt="" width="150px" height="250px" /></li></a>
		<a href="fullViewAction.action?MV_NO=${gm1[8]}"><li><img src="/bts/image/poster/${gm1[8]}.jpg" alt="" width="150px" height="250px" /></li></a>
		<a href="fullViewAction.action?MV_NO=${gm1[9]}"><li><img src="/bts/image/poster/${gm1[9]}.jpg" alt="" width="150px" height="250px" /></li></a>
		</ul>
	</div>
		<button class="next" type="button">
			<img src="./image/right.jpg" alt="" />
		</button>
	</div>
</div>
<div class="slide_blank"></div>



	<div id="viewArea">

		<div id="imgList">
			<div>
				<a href="fullViewAction.action?MV_NO=${gm1[0]}"><img src="/bts/image/poster/${gm1[0]}_1.jpg" width="1000px" /></a>
			</div>
			<div>
				<a href="fullViewAction.action?MV_NO=${gm1[4]}"><img src="/bts/image/poster/${gm1[4]}_2.jpg" width="1000px" /></a>
			</div>
			<div>
				<a href="fullViewAction.action?MV_NO=${gm1[1]}"><img src="/bts/image/poster/${gm1[1]}_3.jpg" width="1000px" /></a>
			</div>
			<div>
				<a href="fullViewAction.action?MV_NO=${gm1[7]}"><img src="/bts/image/poster/${gm1[7]}_4.jpg" width="1000px" /></a>
			</div>
		</div>

	</div>
	
	<div class="main_list">
		<h1>
			<div>게시판</div>
			<a href="listAction.action">More</a>
		</h1>
		<div class="main_list_tab">
			<a href="#100" id="l_tab1" onclick="show('list_tab_1');hide('list_tab_2');c_class('l_tab1','main_list_tab_a_hover');c_class('l_tab2','main_list_tab_a');" class="main_list_tab_a_hover">자유게시판</a>
			<a href="#100" id="l_tab2" onclick="show('list_tab_2');hide('list_tab_1');c_class('l_tab2','main_list_tab_a_hover');c_class('l_tab1','main_list_tab_a');" class="main_list_tab_a">스포게시판</a>
		</div>
		
		
		<ul id="list_tab_1">
		<li>
		<s:iterator value="list_free" status="stat">
			<s:url id="smallURL" action="viewAction">
				<s:param name="bo_no">
					<s:property value="bo_no" />
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage" />
				</s:param>
			</s:url>
			<li>
				<div></div>
				<s:a href="%{smallURL}">[<s:property value="bo_genre" />]
				&nbsp;<s:property value="bo_subject" /></s:a>
			</li>
		</s:iterator>
		</li>
		<s:if test="list_free.size()<=0" >
			<li>등록된 게시물이 없습니다.</li>
		</s:if>
		</ul>
		
		
		
		<ul id="list_tab_2" style="display:none;">
		<li>
		<s:iterator value="list_spo" status="stat">
			<s:url id="small2URL" action="viewAction">
				<s:param name="bo_no">
					<s:property value="bo_no" />
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage" />
				</s:param>
			</s:url>
			<li>
				<div></div>
				<s:a href="%{small2URL}">[<s:property value="bo_genre" />]
				&nbsp;<s:property value="bo_subject" /></s:a>
			</li>
		</s:iterator>
		</li>
		<s:if test="list_spo.size()<=0" >
			<li>등록된 게시물이 없습니다.</li>
		</s:if>
		</ul>
	</div>
	
	
	<div class="main_list" style="float:right;">
		<h1 style="border-bottom:1px solid #eeeeee;">
			<div>뉴스</div>
			<a href="newsList.action">More</a>
		</h1>
		<ul>
			<s:iterator value="newsList" status="stat">
			<s:url id="viewURL" action="newsViewAction">
				<s:param name="NEWS_NO">
					<s:property value="NEWS_NO" />
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage" />
				</s:param>
			</s:url>
			<li><div></div>
				<a href="newsView.action?NEWS_NO=<s:property value='NEWS_NO'/>&currentPage=<s:property value='currentPage'/>"
					class="list"> <s:property value="NEWS_SUBJECT" /></a>
			</li>
			</s:iterator>
		</ul>
	</div>
	
	
	
	<div class="comm_list">
		<div class="comm_list_top">
			<div>${s1}</div>
		<img src="/bts/image/poster/${m1}.jpg" alt="이미지 없음" width="100%" />
		
		</div>
		<h1>
			네티즌
			<br />
			<span><img src="./images/star_01.png" alt="하트" /> 
				<fmt:formatNumber value="${mavr1}" pattern=".0"/></span>
		</h1>
		<ul>
			<s:iterator value="moviecommentList" status="stat">
			<li>
				<div class="comm_list_l">
					<s:property value="MVC_CONTENT"/>
					<br />
					<span><s:property value="MVC_WRITER"/></span>
				</div>
				<div class="comm_list_r">
					<img src="./images/star_01.png" alt="하트" />
					<s:property value="MVC_AVR"/>
				</div>
			</li>
			</s:iterator>
			<s:if test="moviecommentList.size()<=0" >
			<li>등록된 댓글이 없습니다.</li>
		</s:if>
		</ul>
	</div>
	
	
	
	
	<div class="comm_list" style="float:right;">
		<div class="comm_list_top">
			<div>${s2}</div>
		
		<img src="/bts/image/poster/${m2}.jpg" alt="이미지 없음" width="100%" />
		</div>
		<h1>
			네티즌
			<br />
			<span><img src="./images/star_01.png" alt="하트" />
			<fmt:formatNumber value="${mavr2}" pattern=".0"/></span>
		</h1>
		<ul>
			<s:iterator value="moviecommentList2" status="stat">
			<li>
				<div class="comm_list_l">
					<s:property value="MVC_CONTENT"/>
					<br />
					<span><s:property value="MVC_WRITER"/></span>
				</div>
				<div class="comm_list_r">
					<img src="./images/star_01.png" alt="하트" />
					<s:property value="MVC_AVR"/>
				</div>
			</li>
			</s:iterator>
			<s:if test="moviecommentList2.size()<=0" >
			<li>등록된 댓글이 없습니다.</li>
		</s:if>
		</ul>
	</div>
	
</body>
</html>