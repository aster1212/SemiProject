<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%   
response.setHeader("Cache-Control","no-store");   
response.setHeader("Pragma","no-cache");   
response.setDateHeader("Expires",0);   
if (request.getProtocol().equals("HTTP/1.1")) 
        response.setHeader("Cache-Control", "no-cache"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>밤방 회원 되기</title>
<link rel="icon" type="image/gif" href="/bts/image/icon.png" />
<link rel="stylesheet" href="/bts/css/join.css" />
<script type="text/javascript">
var val1 = false;
var val2 = false;
var val3 = false;
var val4 = false;
var val5 = false;
var val6 = false;

	var ids = new Array();
	<c:forEach items="${idArray}" var="item">
	ids.push("${item}");
	</c:forEach>
	var names = new Array();
	<c:forEach items="${nameArray}" var="item2">
	names.push("${item2}");
	</c:forEach>

	function idCK() {
		var userinput = eval("document.userinput");
		if (!userinput.memId.value) {
			document.getElementById("memid").innerHTML = "아이디를 입력해주세요";
			 
		} else {
			var userid = userinput.memId.value;
			var userEmail = false;
			for (var i = 0; i < userid.length; i++) {
				if (userid[i] == '@')
					userEmail = true;
			}
			if (userEmail == true) {
				var sameid = true;
				for (var i = 0; i < ids.length; i++) {
					if (ids[i] == userinput.memId.value)
						sameid = false;
				}
				if (sameid == true) {
					document.getElementById("memid").innerHTML = "사용 가능";
					document.getElementById("memid").style.color = '#b594ff';
					val1 = true;
				} else {
					document.getElementById("memid").innerHTML = "아이디가 중복됩니다.";
					document.getElementById("memid").style.color = '#ff6060';
					 
				}

			} else {
				document.getElementById("memid").innerHTML = "이메일 형식이 아닙니다.";
				document.getElementById("memid").style.color = '#ff6060';
				 
			}
		}
		afterFunc();
	}
	function pwCK() {
		var userinput = eval("document.userinput");
		if (!userinput.memPw.value) {
			document.getElementById("mempw").innerHTML = "비밀번호를 입력해주세요";
			 
		} else{
			var tempPw = userinput.memPw.value;
			if(tempPw.length < 6){
				document.getElementById("mempw").innerHTML = "비밀번호가 너무 짧아요..";
			}else{
				var strV = false;
				var intV = false;
				for(var p=0; p < tempPw.length; p++){
					
					for(var cs=65; cs<123; cs++){
						if(tempPw[p] == String.fromCharCode(cs))
							strV = true;
						if(cs==90)
							cs=96;
					}
					for(var ci=49; ci<58; ci++){
						if(tempPw[p] == String.fromCharCode(ci))
							intV = true;
					}
				}
				if(strV==true && intV==true){
					document.getElementById("mempw").innerHTML = "사용 가능";
					document.getElementById("mempw").style.color = '#b594ff';
					val2 = true;
				}else{
					document.getElementById("mempw").innerHTML = "문자와 숫자를 조합해주세요!!";
					document.getElementById("mempw").style.color = '#ff6060';
				}
			}
		}
		afterFunc();
	}
	function pwCCK() {
		var userinput = eval("document.userinput");
		if (userinput.memPw.value != userinput.memPwC.value) {
			document.getElementById("mempwc").innerHTML = "비밀번호가 같지 않습니다.";
			 
		} else {
			if (userinput.memPwC.value != "") {
				document.getElementById("mempwc").innerHTML = "같습니다";
				document.getElementById("mempwc").style.color = '#b594ff';
				val3 = true;
			} else {
				document.getElementById("mempwc").innerHTML = "비밀번호를 입력해주세요";
				document.getElementById("mempwc").style.color = '#ff6060';
				 
			}
		}
		afterFunc();
	}
	function nameCK() {
		var userinput = eval("document.userinput");
		if (!userinput.memName.value) {
			document.getElementById("memname").innerHTML = "닉네임을 입력해주세요";
			 
		} else {
			var samename = true;
			for (var i = 0; i < names.length; i++) {
				if (names[i] == userinput.memName.value)
					samename = false;
			}
			if (samename == true) {
				document.getElementById("memname").innerHTML = "사용 가능";
				document.getElementById("memname").style.color = '#b594ff';
				val4 = true;
			} else {
				document.getElementById("memname").innerHTML = "중복된 닉네임 입니다.";
				document.getElementById("memname").style.color = '#ff6060';
				 
			}
		}
		afterFunc();
	}
	function genCK() {
		var userinput = eval("document.userinput");
		if (!userinput.memGen.value) {
			document.getElementById("memgen").innerHTML = "성별을 선택해주세요";
			document.getElementById("memgen").style.color = '#ff6060';
			 
		} else {
			document.getElementById("memgen").innerHTML = "확인!";
			document.getElementById("memgen").style.color = '#b594ff';
			val5 = true;
		}
		afterFunc();
	}
	function hpCK() {
		var userinput = eval("document.userinput");
		if (!userinput.memHp.value) {
			document.getElementById("memhp").innerHTML = "핸드폰 번호를 입력해주세요";
			 
		} else {
			var hp = userinput.memHp.value;
			if (hp.length != 11) {
				document.getElementById("memhp").innerHTML = "핸드폰 번호를 정확히 입력해주세요";
				 
			} else {
				document.getElementById("memhp").innerHTML = "사용 가능";
				document.getElementById("memhp").style.color = '#b594ff';
				val6 = true;
			}
		}
		afterFunc();
	}
	function checkIt() {
		var userinput = eval("document.userinput");
		idCK();
		pwCK();
		pwCCK();
		nameCK();
		genCK();
		hpCK();
		if(!val1 || !val2 || !val3 || !val4 || !val5 || !val6)
			return false;
		afterFunc();
	}
	function afterFunc() {
		if(val1 && val2 && val3 && val4 && val5 && val6){
			document.getElementById('joinSubmit').style.color = '#e3e3e3';
			document.getElementById('joinSubmit').style.backgroundColor = '#ab47bc';
		}
	}
</script>
</head>
<body>
<div id="container">
	<div id="login_box">
		<img src="/bts/image/logo.png"
			onclick="window.location='/bts/loginForm.action'"
			onmouseover="this.src='/bts/image/logo_colored.png'"
			onmouseout="this.src='/bts/image/logo.png'" /><br>
	</div>
	<div class="join">
		<form name="userinput" action="joinAction.action" onsubmit="return checkIt()" method="post">
			
			<div class="pointer">아이디</div>
			<input onblur="idCK();" type="text" name="memId" placeholder="이메일 형식 ex)user@email.com" class="ccc" autocomplete="off"> 
			<div class="checkPointer"><strong id="memid" class="errorMSG"></strong></div>
			
			<div class="pointer">비밀번호</div>
			<input onblur="pwCK();" type="password" name="memPw" placeholder="영문 숫자 조합 6~15자" class="ccc"> 
			<div class="checkPointer"><strong id="mempw" class="errorMSG"></strong></div>
				
			<div class="pointer">비밀번호 확인</div>
			<input onblur="pwCCK();" type="password" name="memPwC" placeholder="동일한 비밀번호를 입력 해주세요" class="ccc"> 
			<div class="checkPointer"><strong id="mempwc" class="errorMSG"></strong></div>
			
			<div class="pointer">닉네임</div>
			<input onblur="nameCK();" type="text" name="memName" placeholder="사용할 닉네임을 입력해주세요" class="ccc" autocomplete="off"> 
			<div class="checkPointer"><strong id="memname" class="errorMSG"></strong></div> 
				
			<div class="pointer">성별</div> 
			<select onchange="genCK()" name="memGen" id="genderSelect">
				<option value="" selected="selected">선택</option>
				<option value="1">남자</option>
				<option value="2">여자</option>
			</select> 
			<div class="checkPointer"><strong id="memgen" class="errorMSG"></strong></div> 
			
			<div class="pointer">좋아하는 장르</div>
				<div class="genreBoxs">
					<input type="checkbox" name="memFavor1" value="1">액션 <br><br>
					<input type="checkbox" name="memFavor2" value="2">드라마/멜로 
				</div>
				<div class="genreBoxs">
					<input type="checkbox" name="memFavor5" value="5">공포/범죄/스릴러 <br><br>
					<input type="checkbox" name="memFavor4" value="4">아동/가족 
				</div>
				<div class="genreBoxs">
					<input type="checkbox" name="memFavor3" value="3">코미디 <br><br>
					<input type="checkbox" name="memFavor6" value="6">SF/판타지 
				</div>
			<div class="pointer">휴대전화</div>
			<input onblur="hpCK();" type="text" name="memHp" class="ccc" autocomplete="off"> 
			<div class="checkPointer"><strong id="memhp" class="errorMSG"></strong></div> 
				<input type=submit value=가입하기 id="joinSubmit"><br>
		</form>
	</div>
</div>
<jsp:include page="/tiles/footer.jsp"></jsp:include>
</body>
</html>