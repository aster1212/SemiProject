<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>뉴스 게시판</title>

<style type="text/css">

@font-face{
font-family: BMJUA;
src: url(/bts/font/BMJUA_ttf.ttf);
}
body{
	background:black;
}
.line {
	width: 250px;
	height: 250px;
	border: 1px solid black;
	display: inline-block;
}

.line .hideClass {
	display: none;
}

.short {
	overflow: hidden;
	width: 318px;
	height: 160px;
	border: 1px solid red;
	display: inline-block;
	text-align: left;
	display: none;
}
.img1 {
	width: 250px;
	height: 250px;
}

.news_grp{
margin:15px;
padding:15px;
text-align: left;
}

.opClass {
	opacity: 0.3;
}

.line:hover {
	border: 1px solid gray;
}

.claer {
	clear: both;
}

.news_content2 {
position: absolute;
	margin-top: -50px;
border:0px;
width:150px;
height:23px;
overflow:hidden;


}

.hovers {

	margin-top: -120px;
	color: white;
	visibility: hidden;
	width:250px;
	height:105px;
	overflow:hidden;
	font-size:13px;
	
}



.button_grp{
float:right;
padding-right:315px;
padding-top: 99px;}

.news_subject{
width : 230px;
background: #D5D5D5;
border-radius: 0 0 12px 12px;
height : 60px;
font-size:18px;
padding: 3px 10px 0 10px;
font-family: BMJUA;
}

a.news_button:link    {font-weight: bold;color:pink;text-decoration:none;} /* 아직 방문하지 않은경우 */ 
a.news_button:visited {font-weight: bold;color:pink; text-decoration:none; } /* 한번 이상 방문한 링크 처리 */ 
a.news_button:hover   {text-decoration:underline; } 

a.news_subject2:link    {font-weight: bold;color:black;text-decoration:none;} /* 아직 방문하지 않은경우 */ 
a.news_subject2:visited {font-weight: bold;color:black; text-decoration:none; } /* 한번 이상 방문한 링크 처리 */ 
a.news_subject2:hover   {text-decoration:underline; } 


.title {
font-size:50px;
text-shadow:2px 1px 1px #F6F6F6;
color:gray;
float:left;
margin-left: 55px;
}
#newTitle{float: left;}
</style>
<script type="text/javascript">
	var src2;
	function mover(obj) {
		src2 = obj.id;
		document.getElementById("image" + src2).classList.add('opClass');
		document.getElementById("hover" + src2).style.visibility = 'visible';
	}
	function mout(obj) {
		document.getElementById("image" + src2).classList.remove('opClass');
		document.getElementById("hover" + src2).style.visibility = 'hidden';
	}
</script>
</head>


<body>
	<div class="news_grp">
		<div id="newTitle"><h3 class="title">NEWS LIST</h3></div>
		<div  class="button_grp">
	<a
		href='news7List.action?currentPage=1' class="news_button">최근 1주일</a>
	<a
		href='news365List.action?currentPage=1' class="news_button" >최근 1년</a>
	<a
		href='newsList.action?currentPage=1' class="news_button">목록</a>
</div>
		<table border="0" align="center" class="news_grp">
		
			<tr height="300">
				<s:iterator value="list" status="stat">

					<c:if test="${cnt eq 3}">
			</tr>
			<tr height="300">
				<c:set var="cnt" value="0" scope="request"></c:set>
				</c:if>


				<td style="padding:15px;" ><s:url id="viewURL" action="newsViewAction">
						<s:param name="NEWS_NO">
							<s:property value="NEWS_NO" />
						</s:param>
						<s:param name="currentPage">
							<s:property value="currentPage" />
						</s:param>
					</s:url>
					
	<a href="moive/newsView.action?NEWS_NO=<s:property value='NEWS_NO'/>&currentPage=<s:property value='currentPage'/>"
							class="news_subject2">					
										
                       <div id="NEWS_NO=<s:property value="NEWS_NO" />" class="line"
                           onclick="go(this)"
                           onmouseover="mover(this)" onmouseout="mout(this)">

                           <!-- 이미지 -->
                           <img id="imageNEWS_NO=<s:property value="NEWS_NO" />" class="img1"
                              src="/bts/image/news/<s:property value='NEWS_IMAGE1'/>"
                              alt="이미지 없음" />

                           <!-- 호버용 -->
                           <div id="hoverNEWS_NO=<s:property value="NEWS_NO" />"
                              class="hovers">
                              <s:property value="NEWS_CONTENT1" />
                              <br />
                           </div>
					</div><br />
					<div class="news_subject"><s:property value="NEWS_SUBJECT" /></div>	
					</a>
					
					
<%-- 					<div id="NEWS_NO=<s:property value='NEWS_NO'/>" class="contents" onmouseover="mover(this)" onmouseout="mout(this)">
						<a
							href="moive/newsView.action?NEWS_NO=<s:property value='NEWS_NO'/>&currentPage=<s:property value='currentPage'/>"
							class="list">
								<img id="image<s:property value="NEWS_NO"/>" class="imgList" src="/bts4/images/<s:property value='NEWS_IMAGE1'/>"/>
							<p class="subject">
								<s:property value="NEWS_SUBJECT" />
							</p>
								
					<div id="hoverNEWS_NO=<s:property value="NEWS_NO" />" class="hovers">
					<s:property value="NEWS_CONTENT1"/><br/>
					평점 4.5
					</div> --%>
							</p>
<%-- 							<div class="hovers">
							<s:property value="NEW_CONTENT1"/>
							</div> --%>
							

							
							

						</a>
					</td>




				<c:set var="cnt" value="${cnt+1}" scope="request"></c:set>


				</s:iterator>
			</tr>
			</center>
		</table>
	</div>
	


	<s:if test="list.size() <= 0 ">
		<p class="tac fz18 mt10 mb20">등록된 매거진이 없습니다.</p>
	</s:if>
	<s:property value="pageHtml" escape="false" />
</body>
</html>