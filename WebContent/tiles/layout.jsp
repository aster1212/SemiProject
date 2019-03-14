<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<style type="text/css">
body {
	font-family: "맑은 고딕", "돋음";
	overflow-y: scroll;
	background: #121212;
}

#tilesBody {
	width: 100%;
	height: 100%;
	padding-top: 60px;
}

#tilesContent {
	background: #232323;
	color: #e3e3e3;
	width: 50%;
	margin-left: 23%;
	overflow: hidden;
}

.addSky {
	background-image: url("/bts/image/starback.png");
}

.addBasic {
	background: #121212;
}
</style>
<script type="text/javascript">
function forBody() {
	if(getCookie('tester')==null){
		document.getElementById('btn1').value='밤하늘로';
	}else{
		if(getCookie('tester')=='2'){
			document.getElementById('tilesBody').classList.add('addSky');
			document.getElementById('tilesBody').classList.remove('addBasic');
			document.getElementById('themeImg').src='/bts/image/icon/theme_ed.png';
		}else{
			document.getElementById('tilesBody').classList.add('addBasic');
			document.getElementById('tilesBody').classList.remove('addSky');
			document.getElementById('themeImg').src='/bts/image/icon/theme.png';
		}
	}
}
function setCookie(cookie_name, value, days) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + days);
	// 설정 일수만큼 현재시간에 만료값으로 지정

	var cookie_value = escape(value)
			+ ((days == null) ? '' : ';    expires=' + exdate.toUTCString());
	document.cookie = cookie_name + '=' + cookie_value;
}
function getCookie(cookie_name) {
	var x, y;
	var val = document.cookie.split(';');

	for (var i = 0; i < val.length; i++) {
		x = val[i].substr(0, val[i].indexOf('='));
		y = val[i].substr(val[i].indexOf('=') + 1);
		x = x.replace(/^\s+|\s+$/g, ''); // 앞과 뒤의 공백 제거하기
		if (x == cookie_name) {
			return unescape(y); // unescape로 디코딩 후 값 리턴
		}
	}
}
function changeCookie() {
	if(getCookie('tester')==null){
		setCookie('tester','2','1');
	}else{
		if(getCookie('tester')=='2'){
			setCookie('tester','1','1');
		}else{
			setCookie('tester','2','1');
		}
	}
	if(getCookie('tester')=='2'){
		document.getElementById('tilesBody').classList.add('addSky');
		document.getElementById('tilesBody').classList.remove('addBasic');
		document.getElementById('themeImg').src='/bts/image/icon/theme_ed.png';
	}else{
		document.getElementById('tilesBody').classList.add('addBasic');
		document.getElementById('tilesBody').classList.remove('addSky');
		document.getElementById('themeImg').src='/bts/image/icon/theme.png';
	}
}
</script>
<link rel="icon" type="image/gif" href="/bts/image/icon.png" />
</head>
<body onload="forBody()">
	<tiles:insertAttribute name="header" />
	<div id="tilesBody" class="addBasic">
		<div id="tilesContent">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<footer> <tiles:insertAttribute name="footer" /> </footer>
</body>
</html>