var nameCheck = false;
var val1 = false;
var val2 = false;
var val3 = false;
var val4 = false;
var val5 = false;
var val6 = false;
function idCK() {
	var userinput = eval("document.userinput");
	if (!userinput.memId.value) {
		document.getElementById("memid").innerHTML = "아이디를 입력해주세요";
	} else {
		var userid = userinput.memId.value;
		for (var i = 0; i < userid.length; i++) {
			if (userid[i] == '@')
				val1 = true;
		}
		if (val1 == true) {
			document.getElementById("memid").innerHTML = "사용 가능";
			document.getElementById("memid").style.color = 'blue';
		} else {
			document.getElementById("memid").innerHTML = "이메일 형식이 아닙니다.";
		}
	}
}
function pwCK() {
	var userinput = eval("document.userinput");
	if (!userinput.memPw.value) {
		document.getElementById("mempw").innerHTML = "비밀번호를 입력해주세요";
	} else {
		document.getElementById("mempw").innerHTML = "사용 가능";
		document.getElementById("mempw").style.color = 'blue';
		val2 = true;
	}
}
function pwCCK(){
	var userinput = eval("document.userinput");
	if (userinput.memPw.value != userinput.memPwC.value) {
		document.getElementById("mempwc").innerHTML = "비밀번호가 같지 않습니다.";
	} else {
		if (userinput.memPwC.value != "") {
			document.getElementById("mempwc").innerHTML = "같습니다";
			document.getElementById("mempwc").style.color = 'blue';
			val3 = true;
		} else {
			document.getElementById("mempwc").innerHTML = "비밀번호를 입력해주세요";
		}
	}
}
function nameCK(){
	var userinput = eval("document.userinput");
	if (!userinput.memName.value) {
		document.getElementById("memname").innerHTML = "닉네임을 입력해주세요";
	} else {
		document.getElementById("memname").innerHTML = "사용 가능";
		document.getElementById("memname").style.color = 'blue';
		val4 = true;
	}
}
function genCK(){
	var userinput = eval("document.userinput");
	if (!userinput.memGen.value) {
		document.getElementById("memgen").innerHTML = "성별을 선택해주세요";
	} else {
		document.getElementById("memgen").innerHTML = "확인!";
		document.getElementById("memgen").style.color = 'blue';
		val5 = true;
	}
}
function hpCK(){
	var userinput = eval("document.userinput");
	if (!userinput.memHp.value) {
		document.getElementById("memhp").innerHTML = "핸드폰 번호를 입력해주세요";
	} else {
		var hp = userinput.memHp.value;
		if (hp.length <= 10) {
			document.getElementById("memhp").innerHTML = "핸드폰 번호를 정확히 입력해주세요";
		} else {
			document.getElementById("memhp").innerHTML = "사용 가능";
			document.getElementById("memhp").style.color = 'blue';
			val6 = true;
		}
	}
}
function checkIt() {
	var userinput = eval("document.userinput");

	idCK();
	pwCK();
	pwCCK();
	nameCK();
	genCK();
	hpCK();
	
	if (val1 == false || val2 == false || val3 == false || val4 == false
			|| val5 == false || val6 == false) {
		return false;
	}
}