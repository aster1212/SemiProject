<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>영화상세보기</title>

<style type="text/css">

.actorOne{display: inline-block; width: 150px; height: 250px; vertical-align: top;}
#actors{text-align: left; display: inline-block;}
.actorImg{width:150px; height: 250px;}
#actorTitle{margin: 20px 0 30px 0;}
#wrapper{margin-left: 170px;}
</style>
<script type="text/javascript">
	//리뷰별컨트롤
	function view_review_star(var1) {
		var i;

		//모든별 흑백
		for (i = 1; i <= 5; i++) {
			document.getElementById("star_img" + i).checked = false;
		}
		//선택별까지 컬러
		for (i = 1; i <= var1; i++) {
			document.getElementById("star_img" + i).checked = true;
		}
		document.getElementById("stars").value = var1;
	}
</script>
</head>
<body>
<div id="wrapper">
	<!-- 배우리스트 나열부분 -->
	<h2 id="actorTitle">배우 및 감독</h2>
	<table id="actors" border="0">
		<!-- 배우만 출력 -->
		<tr>
			<s:iterator value="actList" status="stat">
				<td>
					<div class="actorOne">
						<a href="actView.action?ACT_NO=<s:property value="ACT_NO"/>">
						<img class="actorImg" id="ACT_NO=<s:property value="ACT_NO"/>" class="img1"
							src="/bts/image/poster/<s:property value="PROFILE_SAVNAME"/>"
							width="150" height="200" alt="이미지 없음" />
							</a>
					</div>
					<div class="actorOne">
						<s:property value="ACT_NAME"/><br/>
						<s:property value="ACT_BIRTH"/>생<br/>
						<s:if test="ACT_TYPE==1">배우</s:if>
						<s:else>감독</s:else>
					</div>
				</td>
				<s:if test="(#stat.index+1) % 2 == 0">
				</tr><tr>
				</s:if>
			</s:iterator>
		</tr>
	</table>
	<!-- 감독 상세정보 -->
	<!-- 사진 -->
	<br/><br/><br/>
	<h2>감독 상세정보</h2>
	<div class="movie_pic">

		<br> <img
			src="/bts/image/poster/<s:property value='resultClass.PROFILE_SAVNAME'/>"
			width="300" height="400" />
	</div>
	<div style="margin: auto;" class="actor_txt">
		<p class="tit">
			<h3>
				<s:property value="resultClass.ACT_NAME" />
			</h3>
		</p>

		<dl>
			<dt>
				<h4>출생</h4>
				<h4>
					<s:property value="resultClass.ACT_BIRTH" />
				</h4>
			</dt>
			<br>
				<dt>
					<h4>작품</h4>
					<c:forEach items="${movieList}" var="List">
						<a
							href="javascript:location.href='fullViewAction.action?MV_NO=${List.MV_NO}'">#${List.MV_SUBJECT}</a>&nbsp;&nbsp;			    
			<c:set var="i" value="${i+1}" />
					</c:forEach>
				</dt> <br /> <br />
		</dl>
	</div>
	<br/>
	<!-- 프로필  -->
	<h4>
		프로필
		</h4>
		<div class="ACT_PROFILE" style="width: 800px; overflow: hideen;">
			<h5>
				<s:property value="resultClass.ACT_PROFILE" />
			</h5>
		</div>
		
		</div>
</body>
</html>







