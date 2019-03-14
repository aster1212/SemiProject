<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="movie.movieVO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 추가된 부분 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0 0 0 0;
	padding: 0 0 0 0;
	text-align: center;
}

.line {
	width: 150px;
	height: 240px;
	border: 1px solid black;
	display: inline-block;
	background-color: #121212;
}

.line .hideClass {
	display: none;
}

.short {
	overflow: hidden;
	width: 620px;
	height: 240px;
	border: 1px solid #ab47bc;
	display: inline-block;
	text-align: left;
	display: none;
}
.short p {
	text-overflow: "더보기";
	white-space: inherit;
	width: 150px;
	height: 150px;
	float: left;
	text-align: left;
}

.img1 {
	width: 150px;
	height: 240px;
	float: left;
}

.opClass {
	opacity: 0.1;
}
.claer {
	clear: both;
}

#content {
	width: 650px;
	text-align: center;
	display: inline-block;
}

.hovers {
	width: 150px;
	height: 180px;
	text-align:center;
	position: absolute;
	margin-top: 70px;
	color: #e3e3e3;
	visibility: hidden;
}
#searchBox{
	float: right;
}
#checkBoxs{font-size: 15px; float: left; margin-left: 20px; margin-top: 20px; margin-bottom: 30px;}
#searchBtn{text-align: left; border-style: none;border-radius: 5px; width: 100px; height:20px;}
#genreButtons{float:right; margin-right: 10px;}
#genreButtons input{ background: #121212; color: #e3e3e3; border-style: none;}
#genBtn{ background: #121212; color: #e3e3e3; border-style: none; margin-left: 20px; font-size: 16px;}
#searchSubmit{background: #121212; border-style: none; color: #e3e3e3;}
#listBox{float: left; text-align: left;} 	
</style>
<script src="/bts/movies/shortOpener.js" type="text/javascript">
</script>
</head>
<body onload="bodyload()">
	<div id="content" style="padding-top: 30px;">

		<div id="searchBox">
			<script language="javascript">
			function validation(){
				if(document.searching.search.value==""){
					alert("검색내용을 입력하세요.");
					document.searching.search.value.focus();
					return false;
				}
				return true;
			}
			</script>
			<form name="searching" action="movieSearch.action"
				onsubmit="return validation()">
				<input type="hidden" name="MV_TYPE" value="3" />
				<%-- <input type="hidden" name="MV_GENRE" value="<s:property value="MV_GENRE"/>" />  --%>
				<input id="searchBtn" type="text" name="search" size="15" maxlength="50" height="25" placeholder="Search..." /> <input id="searchSubmit" type="submit"
					value="검색" />
			</form>
		</div>
		
		<div id="genreButtons">
			<!-- 장르가 선택되지 않았을 때 -->
			<s:if test="MV_GENRE==NULL">
				<input type="button" value="해외"
					onclick="javascript:location.href='movieList.action?MV_TYPE=3&MV_STATE=1';" />
				<input type="button" value="국내"
					onclick="javascript:location.href='movieList.action?MV_TYPE=3&MV_STATE=2';" />
				<input type="button" value="모든국가"
					onclick="javascript:location.href='movieList.action?MV_TYPE=3';" />
			</s:if>
			<!-- 장르가 선택되었을 때 -->
			<s:else>
				<input type="button" value="해외"
					onclick="javascript:location.href='movieList.action?MV_TYPE=3&MV_STATE=1&MV_GENRE=<s:property value="paramClass.MV_GENRE"/>';">
					</option> <input type="button" value="국내"
					onclick="javascript:location.href='movieList.action?MV_TYPE=3&MV_STATE=2&MV_GENRE=<s:property value="paramClass.MV_GENRE"/>';">
						</option> <input type="button" value="모든국가"
						onclick="javascript:location.href='movieList.action?MV_TYPE=3&MV_GENRE=<s:property value="paramClass.MV_GENRE"/>';">
							</option>
			</s:else>
		</div>
		<div id="checkBoxs">
		
			<form name="selectGenre" action="movieList.action">
				<input type="hidden" name="MV_TYPE" value="3" /> 액션 <input
					type="checkbox" name="MV_GENRE" value="1" /> 드라마/멜로 <input
					type="checkbox" name="MV_GENRE" value="2" /> 코미디 <input
					type="checkbox" name="MV_GENRE" value="3" /> 아동/가족 <input
					type="checkbox" name="MV_GENRE" value="4" /> 공포/범죄/스릴러 <input
					type="checkbox" name="MV_GENRE" value="5" /> SF판타지 <input
					type="checkbox" name="MV_GENRE" value="6" /> <INPUT id="genBtn" type="submit"
					value="분류" />
			</form>
			<%
				String[] a = request.getParameterValues("MV_GENRE");
				String b = "";

				if (request.getParameterValues("MV_GENRE") != null) {
					for (int i = 0; i < (a.length); i++) {
						b += (a[i] + ",");
					}
				}
			%>
			<script>
var a ='<%=b%>';
var b = a.split(',');

 for(i=0; i<(b.length); i++){
selectGenre.MV_GENRE[(b[i])-1].checked = true;
 }
 </script>
		</div>
		<div id="listBox">
			<!-- 리스트 뿌리기 -->
			<s:iterator value="list" status="stat">
				<div id="MV_NO=<s:property value="MV_NO" />" class="line"
					onclick="sc<s:property value="(#stat.index+4)/4"/>(this)"
					onmouseover="mover(this)" onmouseout="mout(this)">
					<!-- 이미지 -->
					<img id="posterMV_NO=<s:property value="MV_NO" />" class="img1"
						src="/bts/image/poster/<s:property value='MV_NO'/>.jpg" alt="이미지 없음" />
					<!-- 호버용 -->
					<div id="hoverMV_NO=<s:property value="MV_NO" />" class="hovers">
						<s:property value="MV_SUBJECT" />
						<br /> <!-- 수정된 부분 -->
					평점 : <fmt:formatNumber value="${MV_AVR}"  pattern=".0"/>점
					</div>
					<!-- 숏컷 정보 -->
					<div id="spMV_NO=<s:property value="MV_NO" />" class="hideClass">
						<img src="/bts/image/poster/<s:property value='MV_NO'/>.jpg" class="img1"
							alt="이미지 없음" />
						<p>
							<br /> 제목 :
							<s:property value="MV_SUBJECT" />
							<br /> 장르 :
							<s:if test='MV_GENRE == "1"'> 액션 </s:if>
							<s:elseif test='MV_GENRE == "2"'> 드라마/멜로 </s:elseif>
							<s:elseif test='MV_GENRE == "3"'> 코믹 </s:elseif>
							<s:elseif test='MV_GENRE == "4"'> 아동/가족 </s:elseif>
							<s:elseif test='MV_GENRE == "5"'> 공포/범죄/스릴러 </s:elseif>
							<s:elseif test='MV_GENRE == "6"'> SF/판타지 </s:elseif>
							<s:else>다중 장르
   				 </s:else>
							<br /> 등급 :
							<s:if test='MV_GRADE == "1"'> 전체 관람가 </s:if>
							<s:elseif test='MV_GRADE == "2"'> 7세 관람가 </s:elseif>
							<s:elseif test='MV_GRADE == "3"'> 12세 관람가 </s:elseif>
							<s:elseif test='MV_GRADE == "4"'> 15세 관람가 </s:elseif>
							<s:elseif test='MV_GRADE == "5"'> 18세 관람가 </s:elseif>
							<s:else>청소년 관람불가</s:else>
							<br /> 내용 :
							<s:property value="MV_SS" />
						</p>
					</div>
				</div>
				<!-- 숏컷  -->
				<s:if test="(#stat.index+1) % 4 == 0">
					<div class="clear"></div>
					<div id="short<s:property value="(#stat.index+1)/4"/>"
						class="short" onclick="shortClick(this)">short</div>
					<div class="clear"></div>
				</s:if>

				<s:if test="list.size()==(#stat.index+1)">
					<br />
					<div id="short<s:property value="((#stat.index+1)/4)+1"/>"
						class="short" onclick="shortClick(this)">short</div>
					<br />
				</s:if>
			</s:iterator>
			<!-- 등록된 영화가 없을경우 -->
			<s:if test="list.size()<=0">
				등록된 영화가 없습니다.
					  
					</s:if>
			<s:property value="pagingHtml" escape="false" />
		</div>
	</div>
</body>
</html>