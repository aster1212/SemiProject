<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<style type="text/css">
#myPageContent{text-align: center;}
#contentMy {
	padding-top: 30px;
	height:700px;
   padding-left: 90px;
   padding-right: 90px;
   text-align: center;
}

#imgContainer {
   border: 1px solid #ab47bc;
   border-radius: 50%;
   overflow: hidden;
   width: 250px;
   height: 250px;
   margin-bottom: 10px;
}

#imgContainer img {
   display: inline-block;
   width: 250px;
   height: 250px;

}

#infoText {
   font-weight: bold;
   text-align: left;
}

#userName {
   font-size: 23px;
}

#userFunc {
   margin-left: 75px;
   margin-top: 50px;
   text-align: right;
   float: right;
}

.content {
   float: left;
   margin-left: 28px;
   margin-top: 50px;
}

.imgText {
   display: inline-block;
   margin-top: 40px;
   
   }

#forHover {
   position: absolute;
   margin-left: 10px;
   visibility: hidden;
}
.line {
   width: 80px;
   height: 120px;
   border: 1px solid black;
   display: inline-block;
}
.img1 {
   width: 80px;
   height: 120px;
   float: left;
}
.opClass{
   
   opacity: 0.1;
}
.hovers {
	width:80px;
	height:80px;
	text-align:center;
   position: absolute;
   margin-top: 40px;
   color: white;
   visibility: hidden;
   font-size: 10px;
}

ul{
   list-style:none;
   }

a{
   text-decoration: none;
}
 .myList{
 	margin: 16px 0 4px 0;
 	display: block;
 	width: 350px;
 	height: 27px;
 	background: #343434;
 	text-align: left;
 	font-size: 18px;
 }
 .myList img{width: 20px; height: 20px;}
 #myMore:link { color: #ab47bc; }
#myMore:visited { color: #ab47bc; }
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
function openMessage2() {
	var url = "Msg_Rec_list.action"
	window.open(url,"받은쪽지함","toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=1010, height=635");
}
</script>
</head>
<body>

   <!-- 마이페이지 컨텐츠 -->
   <s:if test="resultClass != NULL">
      <div id="contentMy">
      <h2>마이페이지</h2>
         <div id="userInfomation" class="content" onmouseover="imgover()"
            onmouseout="imgout()">
            <div id="imgContainer">
               <s:if test="resultClass.memProfilePhoto != NULL">
                  <!-- <p id="forHover" class="imgText">
               <br>
               <button>바꾸기</button> <button>기본으로</button>
               </p> -->
                  <img alt="x" src="/bts/image/profile/<s:property value="resultClass.memProfilePhoto"/>" onerror="this.src='/bts/image/icon/user.png'"/>
               </s:if>
               <s:else>
                  <img src="/bts/image/icon/user.png" onerror="this.src='/bts/image/icon/user.png'">
               </s:else>
            </div>
            <p id="infoText">
               <font id="userName"><s:property value="resultClass.memName" /></font>
               <br /> <font id="userId"><s:property
                     value="resultClass.memId" /></font>
            </p>
         </div>

         <div id="userFunc" class="content">
            <ul>
               <li class="myList"><img src="/bts/image/icon/cart.png"/>&nbsp;&nbsp;관심있는영화 <s:if test="mvList.size() > 0">
                     <a id="myMore" href="moreMyLike.action">더 보기</a>
                  </s:if>
               </li>
               <li><s:if test="mvList.size() <= 0">
                     <font color="gray">관심있는 영화가 없습니다.</font>
                  </s:if> <s:else>
                     <s:iterator value="mvList" status="stat">
                        <div id="MV_NO=<s:property value="MV_NO" />" class="line"
                           onclick="go(this)"
                           onmouseover="mover(this)" onmouseout="mout(this)">

                           <!-- 이미지 -->
                           <img id="posterMV_NO=<s:property value="MV_NO" />" class="img1"
                              src="/bts/image/poster/<s:property value='MV_NO'/>.jpg"
                              alt="이미지 없음" />


                           <!-- 호버용 -->
                           <div id="hoverMV_NO=<s:property value="MV_NO" />"
                              class="hovers">
                              <s:property value="MV_SUBJECT" />
                              <br /> 평점 : <fmt:formatNumber value="${MV_AVR}"  pattern=".0"/>점
                           </div>
                        </div>
                     </s:iterator>
                  </s:else></li>
                  
               <li class="myList"><img src="/bts/image/icon/message.png"/>&nbsp;&nbsp;<a onclick="openMessage2()" href="">쪽지함</a></li>
               <li class="myList"><img src="/bts/image/icon/setting.png"/>&nbsp;&nbsp;<a href="myModifyForm.action">내 정보 수정</a></li>
               <li class="myList"><img src="/bts/image/icon/out.png"/>&nbsp;&nbsp;<a href="/bts/logoutAction.action">로그아웃</a></li>
            </ul>
         </div>
      </div>
   </s:if>
</body>
</html>