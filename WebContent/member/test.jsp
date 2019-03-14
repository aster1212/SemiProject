<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setAttribute("asd", "asdzxc");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function forBody() {
		if(getCookie('tester')==null){
			document.getElementById('btn1').value='밤하늘로';
		}else{
			if(getCookie('tester')=='2'){
				document.getElementById('paint').classList.add('addSky');
				document.getElementById('paint').classList.remove('addBasic');
				document.getElementById('btn1').value='초록으로';
			}else{
				document.getElementById('paint').classList.add('addBasic');
				document.getElementById('paint').classList.remove('addSky');
				document.getElementById('btn1').value='밤하늘로';
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
			document.getElementById('paint').classList.add('addSky');
			document.getElementById('paint').classList.remove('addBasic');
			document.getElementById('btn1').value='초록으로';
		}else{
			document.getElementById('paint').classList.add('addBasic');
			document.getElementById('paint').classList.remove('addSky');
			document.getElementById('btn1').value='밤하늘로';
		}
	}
</script>
<style type="text/css">
body {
	color: black;
}

#paint {
	border: 1px solid red;
	width: 300px;
	height: 300px;
}

.addSky {
	background-image: url("/bts/image/starback.png");
}

.addBasic {
	background: #121212;
}
</style>
</head>
<body onload="forBody()">
	쿠키값 :
	<a id="test1"></a>
	<input type="button" id="btn1" onclick="changeCookie()" value="바꾸기" />
	<div id="paint" class="addBasic"></div>
	<%
		String str = request.getContextPath();
		str += request.getRequestURI();
		String str1 = request.getRequestURL().toString();
	%>
	<%=str1%>
	${asd}
	<%
		for (int i = 49; i < 123; i++) {
	%>
	<br /><%=i%>번
	<br />
	<%
		if (i == 57)
				i = 64;
			if (i == 90)
				i = 96;
	%>
	<%} %>
</body>
</html>