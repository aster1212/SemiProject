<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#contentMy {
	padding:50px;
	padding-top: 30px;
   /* padding-left: 90px;
   padding-right: 90px; */
   text-align: center;
}
#menuPointer{
	height: 27px; background: #343434; margin:20px 0 40px 0;
}
#menuPointer img{ width:20px; height: 20px; float: left; margin-left: 180px; cursor: pointer;}
#menuPointer font{font-size: 18px; float: right; margin-right: 180px;}
#modyForm{text-align: left; padding-left: 200px;}
.pointer{display:block; font-size: 18px; font-weight:bold; margin-bottom: 2px;}
.valView{font-size: 18px; display: block; margin-bottom: 20px;}
.genreOpts{display: inline-block; margin: 15px;}
#submit{width: 270px; height: 50px; margin-right: 10px; border-style:none; border-radius: 10px; background:#ab47bc; 
font-size:25px; color: #e3e3e3; cursor: pointer;}
#cancel{width: 130px; height: 50px;  border-style:none; border-radius: 10px;
font-size:25px; cursor: pointer;}
#leaverUs{margin-top: 250px;}
.inputc{ height:30px; background: none; border-style: none; border-bottom: 2px solid #e3e3e3; 
color:#e3e3e3; font-size:16px;}
</style>
<script type="text/javascript">
	function modiValid() {
		var hp = document.getElementById('hpo');
		var pwo = document.getElementById('pwo');
		var pwc = document.getElementById('pwc');
		if((hp.value).length != 11){
			alert('핸드폰 번호를 확인해 주세요!');
			return false;
		}
		if(pwo.value != pwc.value){
			alert('비밀번호확인을 정확히 입력해주세요~!');
			return false;
		}
		if((pwo.value).length > 1 && (pwo.value).length < 6){
			alert('비밀 번호가 너무 짧아요!');
			return false;
		}
	}
</script>
</head>
<body>
	<s:if test="resultClass != NULL">
		<div id="contentMy">
			<h2>마이페이지</h2> 
			<div id="menuPointer"><img src="/bts/image/icon/back.png" onclick="history.back()"/><font>내 정보 수정</font></div>
			<div id="modyForm">
			<form name="modify" action="/bts/myModifyAction.action" method="post" enctype="multipart/form-data" onsubmit="return modiValid();">
				<input type="hidden" name="memNo" value="<s:property value="resultClass.memNo"/>"> 
				<input type="hidden" name="oldProfile" value="<s:property value="resultClass.memProfilePhoto"/>">
				<!-- 프로필 사진 -->
				 
				<div id="profile">
					<font class="pointer">프로필 사진</font>
					<font class="valView"><s:file name="upload" theme="simple" />
					<s:if test="resultClass.memProfilePhoto!=null">*<s:property value="resultClass.memProfilePhoto"/></s:if></font>
				</div>
				<!-- unchangeable -->
				<div id="id">
					<font class="pointer">아이디  </font>
					<font class="valView"><s:property value="resultClass.memId" /></font>
				</div>
				 
				<div id="name">
					<font class="pointer">닉네임  </font> 
					<input name="memName" type="text" style="display: none;">
					<font class="valView"><s:property value="resultClass.memName" /></font>
				</div>
				<!-- <input type="button" value="바꾸기">  -->
				 
				<div id="gender">
					<font class="pointer">성별 </font>
					<font class="valView"><s:if test="resultClass.memGen == 1">남자
         </s:if>
					<s:else>여자</s:else></font>
				</div>
				 


				<!-- changeable -->
				<div id="number">
					<font class="pointer">전화번호 </font> 
					<font class="valView"><input id="hpo" type="text" class="inputc" name="memHp" value="<s:property value="resultClass.memHp"/>"></font>  
					<font class="pointer">비밀번호 </font> 
					<font class="valView"><input id="pwo" type="password" class="inputc" name="memPw"></font>   
					<font class="pointer">비밀번호 확인 </font> 
					<font class="valView"><input id="pwc" type="password" class="inputc" name="memPw2"></font>
				</div>
				 

				<div class="genre">
					<font class="pointer">좋아하는 장르 </font> 
					<div class="genreOpts">
						<input type="checkbox" name="memFavor1" value="1" ${checker1}>액션
						<br/><br/><input type="checkbox" name="memFavor2" value="2" ${checker2}>드라마/멜로
					</div>
					<div class="genreOpts">
						<input type="checkbox" name="memFavor3" value="3" ${checker3}>코미디
						<br/><br/><input type="checkbox" name="memFavor4" value="4" ${checker4}>아동/가족 
					</div>
					<div class="genreOpts">
						<input type="checkbox" name="memFavor5" value="5" ${checker5}>공포/범죄/스릴러 
						<br/><br/><input type="checkbox" name="memFavor6" value="6" ${checker6}>SF/판타지
					</div>
				</div>
				 
				 
					<input type="submit" id="submit" value="확인">
					<input type="button" id="cancel" onclick="history.back();" value="취소">
			</form>
			  <div id="leaverUs"><a href="myMemQuit.action">회원 탈퇴</a></div>
			</div>
		</div>
	</s:if>
</body>
</html>