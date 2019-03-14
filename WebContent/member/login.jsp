<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한밤중에 방에서 로그인</title>
<link rel="icon" type="image/gif" href="/bts/image/icon.png" />
<style type="text/css">
* {
	margin: 0 0 0 0;
	padding: 0 0 0 0;
}

body {
	background-color: #121212;
	color: #e3e3e3;
}

#login_box {
	margin-top: 100px;
	text-align: center;
}

#login_box img {
	width: 300px;
}

a:link {
	color: #e3e3e3;
	text-decoration: none;
}

a:visited {
	color: #e3e3e3;
	text-decoration: none;
}

a:hover {
	color: #e3e3e3;
	text-decoration: underline;
}

#cc {
	border-radius: 2px;
	width: 320px;
	height: 40px;
	background-color: #5D5D5D;
	border: 0px;
	margin-bottom: 5px;
	font-size: 23px;
}

.ccc {
	border-style: none;
	border-radius: 5px;
	width: 300px;
	height: 40px;
	padding-left: 20px;
	font-size: 15px;
}
idBox{}
pwBox{}
#login_box img{cursor: pointer;}
#log {
	width: 320px;
	margin-bottom: 15px;
	text-align: center;
	border: 1;
}
#blanker{height: 257px;}
</style>
<script type="text/javascript">

	function loginCheck() {
		var userinput = eval("document.userinput");
		if (!userinput.memId.value) {
			alert("아이디를 입력해주세요.");
			return false;
		}
	}
	function bodyload() {
		var check = $
		{
			isRemember
		}
		;
		if (check == 1) {
			document.userinput.idRemember.checked = true;
		}
	}
	function loginColor() {
		
	}
</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var id = false;
	var pw = false;
	$("#idBox").keyup(function() {
        var i = $(this).val();
        if(i != "")
        	id = true;
        else
        	id = false;
        if(id && pw){
        	$("#cc").css("background-color","#ab47bc");
        	$("#cc").css("color","#e3e3e3");
        	$("#cc").attr("disabled",false);
        }else{
        	$("#cc").css("background-color","#5D5D5D");
        	$("#cc").css("color","#121212");
        	$("#cc").attr("disabled",true);
        }
    })
    $("#pwBox").keyup(function() {
        var p = $(this).val();
        if(p != "")
        	pw = true;
        else
        	pw = false;
        if(id && pw){
        	$("#cc").css("background-color","#ab47bc");
        	$("#cc").css("color","#e3e3e3");
        	$("#cc").attr("disabled",false);
        }else{
        	$("#cc").css("background-color","#5D5D5D");
        	$("#cc").css("color","#121212");
        	$("#cc").attr("disabled",true);
        }
        	
    })
})
</script>
</head>
<body onload="bodyload()">
	<div id="login_box">
		<img src="/bts/image/logo.png"
				onclick="window.location='/bts/main.action'"
				onmouseover="this.src='/bts/image/logo_colored.png'"
				onmouseout="this.src='/bts/image/logo.png'" /><br>
		<br>
		<div style="height: 20px">${errorStr}</div>
		<form name="userinput" action="/bts/loginAction.action" method="post">
			<input type="text" name="memId" value="${ckId}" placeholder="아이디" id="idBox" class="ccc" autocomplete="off" autofocus="autofocus"><br>
			<br> <input type="password" name="memPw" placeholder="비밀번호" id="pwBox" class="ccc"><br>
			<br> <input type=submit value=로그인 id="cc" disabled="true"><br> <input
				type="checkbox" name="idRemember" value="yes">아이디 기억하기 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</form>
		<br>
		<center>
			<hr id="log">
		</center>
		<a href="/bts/findForm.action" class="h2_grey">아이디/비밀번호 찾기</a>&nbsp;|&nbsp;
		<a href="/bts/joinForm.action" class="h2_grey">회원가입</a>

		<!-- 쿠키 테스트용 쿠키 가져오기 -->
		<%-- <%
Cookie[] cookies = request.getCookies() ;

if(cookies != null){
     
    for(int i=0; i < cookies.length; i++){
        Cookie c = cookies[i] ;
         
        // 저장된 쿠키 이름을 가져온다
        String cName = c.getName();
         
        // 쿠키값을 가져온다
        String cValue = c.getValue() ;
        
        %>
        <br><%= i %>.<%=cName %>=<%=cValue %> 
        <%
         
    }
}
%> --%>
	</div>
	<div id="blanker"></div>
<jsp:include page="/tiles/footer.jsp"></jsp:include>
</body>
</html>