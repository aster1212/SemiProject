<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<style type="text/css">
*{
	margin: 0 0 0 0;
	padding: 0 0 0 0;
	align:center;
}
#login_box{
margin-top:100px;
	text-align: center;
}
.finder{
	width: 500px;
	height: 200px;
	margin: 50px 20px 20px 20px;
	display: inline-block;
}
body{
	background-color:black;
	color:white;
	align: center;
}
h5,h3{margin-top:10px;margin-bottom:10px;}
hr{color:"#747474"; margin-bottom:10px;}
.findid{
	font-size:13px;
}
th,td{
padding:10px;
}
#cc{border-radius: 3px;}
#ccc{border-radius: 5px; width:200px; height:20px;}
#check{margin-top:10px;}
</style>
<script type="text/javascript">
	
	function result() {
		var restype = '${findType}';
		var txt = '${resultStr}';
		if(restype == 'idFind')
			document.getElementById('idRes').innerHTML=txt;
		if(restype == 'pwFind')
			document.getElementById('pwRes').innerHTML=txt;
	}
</script>
</head>
<body onload="result()">
<center>
<div id="login_box"><a href="main.action"><image src="./image/hanbang.PNG"/></a><br></div>
<div class="finder" id="id" >

	<form name="idFinder" action="findAction.action" method="get" >
		<input type="hidden" name="findType" value="idFind">
		<h5 align="left">아이디 찾기</h5>
		<hr />
		<table border="0" align="center" width="400px" class="findid">
			<tr>
				<td colspan="3"><h3>◎  닉네임과 핸드폰번호로 찾기</h3></td>
			</tr>
			<tr>
				<td width="70px">닉네임</td>
				
				<td><input type="text" name="memName" width="250px" id="ccc"></td>
				
				<td rowspan="2"><input type="submit" value="확인"  width="60px"></td>
			</tr>
			<tr>
				<td width="150px">핸드폰번호</td>
				
				<td><input type="text" name="memHp" width="250px" placeholder="-를 빼고 입력해주세요"  id="ccc"></td>
			</tr>
			<tr>
				<td colspan="3" align="center" id="check">
					<strong id="idRes"></strong>
				</td>
		</table>
	</form>
	
</div>
<br>
<div class="finder" id="pw">
	<form name="pwFinder" action="findAction.action" method="get">
		<input type="hidden" name="findType" value="pwFind">
		<h5 align="left">비밀번호찾기</h5>
		<hr />
		<table border="0" align="center" width="400px" class="findid">
			<tr>
				<td colspan="3"><h3>◎  아이디와 핸드폰번호로 찾기</h3></td>
			</tr>
			<tr>
				<td width="70px">아이디</td>
				
				<td><input type="text" name="memId" placeholder="ex) example@domain.com" id="ccc"></td>
				
				<td rowspan="2"><input type="submit" value="확인"  width="160px"></td>
			</tr>
			<tr>
				<td width="150px">핸드폰번호</td>
				
				<td> <input type="text" name="memHp" placeholder="-를 빼고 입력해주세요" id="ccc"></td>
			</tr>
			<tr>
				<td colspan="3" align="center" id="check"><strong id="pwRes"></strong></td>
		</table>
	</form>
	
</div>
</center>
</body>
</html>