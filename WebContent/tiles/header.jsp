<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8");%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>메인 페이지</title>
<style type="text/css">
* {
	margin: 0 0 0 0;
	padding: 0 0 0 0;
}

#header {
	position: fixed;
	width: 100%;
	height: 60px;
	background: #232323;
	font-size: 20px;
	color: #e3e3e3;
	text-align: center;
	overflow: hidden;
	opacity: 0.9;
	z-index: 5;
}

.ropClass {
	opacity: 1.0;
}

a:link {
	text-decoration: none;
	color: #e3e3e3;
}

a:visited {
	text-decoration: none;
	color: #e3e3e3;
}

a:hover {
	text-decoration: underline;
	color: #e3e3e3;
}

a:active {
	text-decoration: none;
	color: #e3e3e3;
}

.headerContent {
	height: 40px;
	width: 10%;
	display: inline-block;
	float: left;
	padding-top: 20px;
}

.headerContent:hover {
	/* background: #444444; */
	cursor: pointer;
	text-decoration: underline;
}

.menu {
	margin-left: 3%;
}

#logo {
	height: 40px;
	width: 10%;
	display: inline-block;
	float: left;
	margin-right: 11%;
	text-align: left;
}

#logo img {
	height: 60px;
	cursor: pointer;
}

#loginer {
	float: right;
	text-align: right;
	display: inline-block;
	height: 60px;
	width: 14%;
}
/* #loginer:hover{background: #444444;} */
#loginIcon {
	width: 50px;
	height: 50px;
	border: 1px solid #ab47bc; border-radius : 50%;
	display: inline-block;
	margin: 2% 10% 0 0;
	text-align: center;
	overflow: hidden;
	border-radius: 50%;
}

#loginImg {
	width: 50px;
	height: 50px;
	cursor: pointer;
}

.icons {
	width: 45px;
	height: 45px;
	display: inline-block;
	margin: 2% 10% 0 0;
	text-align: center;
	overflow: hidden;
}
#themeImg{
	width: 40px;
	height: 40px;
	cursor: pointer;
}
#messageImg {
	width: 43px;
	height: 43px;
	cursor: pointer;
}

#userMenuForm{
	width: auto;
	height: auto;
	background: black;
	margin: 3% 0 0 85%;
	padding: 0 10px 20px 10px; 
	position : fixed;
	visibility: hidden;
	text-align: left;
	position: fixed;
}
#userInfoBox{
	display: inline-block;
}
#userImg {
	width: 60px;
	height: 60px;
	border: 1px solid #ab47bc;
	border-radius: 50%;
	display: inline-block;
	overflow: hidden;
}
#userInfo{display: inline-block;}
.clear{clear: both;}
.userOpt{border-bottom: 1px solid #444444; text-align: left;}
</style>
<script type="text/javascript">
	function menuover(obj) {
		obj.style.color = '#ab47bc';
	}
	function menuout(obj) {
		obj.style.color = '#e3e3e3';
	}
	var userMenuToggle = true;
	function userMenuOpen() {
		if (userMenuToggle) {
			document.getElementById('userMenuForm').style.visibility = 'visible';
			userMenuToggle = false;
		} else {
			document.getElementById('userMenuForm').style.visibility = 'hidden';
			userMenuToggle = true;
		}

	}

	function openMessage2() {
		var url = "Msg_Rec_list.action"
		window.open(url,"받은쪽지함","toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=1010, height=635");
	}
</script>
</head>

<body>
	<div id="header">
		<div id="logo">
			<img src="/bts/image/logo.png"
				onclick="window.location='/bts/main.action'"
				onmouseover="this.src='/bts/image/logo_colored.png'"
				onmouseout="this.src='/bts/image/logo.png'" />
		</div>

		<div class="headerContent menu"
			onclick="window.location='/bts/movieList.action'"
			onmouseover="menuover(this)" onmouseout="menuout(this)">
			<!-- 영화- -->
			영화
		</div>
		<div class="headerContent menu"
			onclick="window.location='/bts/npMovieList.action'"
			onmouseover="menuover(this)" onmouseout="menuout(this)">
			<!-- 최신상영관 -->
			극장
		</div>
		<div class="headerContent menu"
			onclick="window.location='/bts/listAction.action'"
			onmouseover="menuover(this)" onmouseout="menuout(this)">
			<!-- 게시판 -->
			게시판
		</div>
		<div class="headerContent menu"
			onclick="window.location='/bts/newsList.action'"
			onmouseover="menuover(this)" onmouseout="menuout(this)">
			<!-- 뉴스 -->
			뉴스
		</div>
		<div id="loginer">
		<!-- 아이콘 -->
			<div class="icons">
				<img id="themeImg" onclick="changeCookie()"  src="/bts/image/icon/theme.png"/>
			</div>
			<c:if test="${session.mem_no!=null}">
			<div class="icons">
				<img id="messageImg" onclick="openMessage2()" src="/bts/image/icon/message.png" />
			</div>
			</c:if>
			<div id="loginIcon">
				<!-- 로그인 체크 (무) -->
				<c:if test="${session.mem_no==null}">
					<img id="loginImg" src="/bts/image/login.png"
						onclick="window.location='/bts/loginForm.action'" />
				</c:if>
				<!-- 로그인 체크 (유) -->
				<c:if test="${session.mem_no!=null}">
					<!-- 프사체크 (유) -->
					<c:if test="${session.mem_profile!=null}">
						<img id="loginImg" src="/bts/image/profile/${session.mem_profile}" onclick="userMenuOpen()" onerror="this.src='/bts/image/icon/user.png'"/>
					</c:if>
					<!-- 프사체크 (무) -->
					<c:if test="${session.mem_profile==null}">
						<img id="loginImg" src="/bts/image/icon/user.png"
							onclick="userMenuOpen()" onerror="this.src='/bts/image/icon/user.png'"/>
					</c:if>
				</c:if>
			</div>
		</div>
		<div id="userMenuForm">
			<div id="userInfoBox">
				<!-- 프사체크 (유) -->
				<c:if test="${session.mem_profile!=null}">
					<img id="userImg" src="/bts/image/profile/${session.mem_profile}" onerror="this.src='/bts/image/icon/user.png'"/>
				</c:if>
				<!-- 프사체크 (무) -->
				<c:if test="${session.mem_profile==null}">
					<img id="userImg" src="/bts/image/icon/user.png"
						onclick="userMenuOpen()" onerror="this.src='/bts/image/icon/user.png'"/>
				</c:if>
				<div id="userInfo">
					<font>${session.mem_name }</font>
					<br/>
					<font>${session.mem_id }</font>
				</div>
			</div>
			<div class="clear"></div>
			<div class="userOpt"><a href="/bts/MyPageAction.action">마이페이지</a></div>
			<div class="clear"></div>
			<div class="userOpt"><a href="/bts/myModifyForm.action">내 정보수정</a></div>
			<div class="clear"></div>
			<div class="userOpt"><a href="/bts/moreMyLike.action">관심있는 영화</a></div>
			<div class="clear"></div>
			<div class="userOpt"><a href="/bts/logoutAction.action">로그아웃</a></div>
			<div class="clear"></div>
		</div>
	</div>
</body>

</html>