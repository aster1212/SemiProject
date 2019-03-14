<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>영화상세보기</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>				
$(document).ready(function(){  
/*   // 링크를 클릭한 경우
  $("a.modal").click(function() {
	// 배경 레이어를 화면에 표시한다.
	$("#glayLayer").fadeIn(300);					
	// 이미지 레이어를 화면에 표시한다.
	$("#overLayer").fadeIn(200);					
	// 링크가 갖는 href 속성의 주소를 <img>태그에 설정하여 이미지 레이어에 출력한다.
	$("#overLayer").html("<img src='" + $(this).attr("href") + "'>");					
	// 링크의 페이지 이동 중단.
	return false;
  });
				
  // (화면에 표시된) 배경 레이어를 클릭한 경우
  $("#glayLayer").click(function() {
	 // 배경 레이어의 숨김
	 $(this).fadeOut(300);					
	 // 이미지 레이어의 숨김
	 $("#overLayer").fadeOut(200);
  }); */
  
  

  $("#st_btn_0").click(function() {
	  $("#st_img_0").fadeIn(300);
	  $("#glayLayer").fadeIn(300);
  });
  $("#st_btn_1").click(function() {
	  $("#st_img_1").fadeIn(300);
	  $("#glayLayer").fadeIn(300);
  });
  $("#st_btn_2").click(function() {
	  $("#st_img_2").fadeIn(300);
	  $("#glayLayer").fadeIn(300);
  });
  $("#st_btn_3").click(function() {
	  $("#st_img_3").fadeIn(300);
	  $("#glayLayer").fadeIn(300);
  });
  $("#st_btn_4").click(function() {
	  $("#st_img_4").fadeIn(300);
	  $("#glayLayer").fadeIn(300);
  });
  

  $("#st_img_0").click(function() {
	  $(this).fadeOut(300);
		 $("#glayLayer").fadeOut(200);
  });
  $("#st_img_1").click(function() {
	  $(this).fadeOut(300);
		 $("#glayLayer").fadeOut(200);
  });
  $("#st_img_2").click(function() {
	  $(this).fadeOut(300);
		 $("#glayLayer").fadeOut(200);
  });
  $("#st_img_3").click(function() {
	  $(this).fadeOut(300);
		 $("#glayLayer").fadeOut(200);
  });
  $("#st_img_4").click(function() {
	  $(this).fadeOut(300);
		 $("#glayLayer").fadeOut(200);
  });
  
/*   $(".st_show").each(function(){
	  var aa = documnet.body.clientHeight;
	  $(this).css("height",aa);
  }); */
   
}); 
function openReport3() {
	var no = ${resultClass.MV_NO}
	   var url = "reportForm.action?type=3&MV_NO="+no;
	   window.open(
	         url,
	         "신고하기",
	         "toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=570");
	}
function openReport4(mvc) {
	var no = ${resultClass.MV_NO}
	   var url = "reportForm.action?type=4&MV_NO="+no+"&MVC_NO="+mvc;
	   window.open(
	         url,
	         "신고하기",
	         "toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=570");
	}
</script>
<style type="text/css">
@font-face{
font-family: HOON;
src: url(/bts/font/HoonGomusinR.ttf);
}

@font-face{
font-family: MAPLE;
src: url(/bts/font/Maplestory-Light.ttf);
}


body {
	color: white;
}

.stars_label input {
	display: none;
}

.stars_label label {
	float: left;
	margin: 0 2px 0 0;
	/* 위 오른쪽 아래 왼쪽 */
	background: url(./images/star_02.png) no-repeat left top;
	display: block;
	border: 0px;
	width: 21px;
	height: 18px;
	overflow: hidden;
}

.stars_label label:hover {
	background: url(./images/star_02.png) no-repeat left top;
}

.stars_label input[type=checkbox]:checked+label {
	background: url(./images/star_01.png) no-repeat left top;
}

.stars_label {
width:100%;
margin:0px;
padding:0px;
overflow:hidden;
}

div.movie_ls {
	float:left;
	position: static;
	padding: 15px;
	width: 550px;
}

div.movie_ss {
	margin-top: 12px;
	margin-bottom: 25px; 
	position: static;
	float:left;
	padding: 15px;
	width: 550px;
	background: #5f5f5f;
	color: #fff;
	border-radius: 10px;
	font-family: HOON;
}

.view_bg {
border-bottom:2px solid #727272;
width:546px;
margin-bottom:10px;
padding:47px;
overflow:hidden;
}
.view_bg_h {
color:#bebebe;
font-size:16px;
padding:0px;
margin:10px 300px 15px -25px;
overflow:hidden;
}

.view_top_r {
color:#bebebe;
float:right;
width:236px;
margin:0px;
padding:0px;
overflow:hidden;
}
.view_top_r_line {
text-align:left;
margin:10px 0 0 0;
padding-left:12px;
overflow:hidden;
}
.view_top_r_line h1 {
float:left;
width:80px;
font-size:16px;
color:#ffffff;
margin:0px;
padding:0px;
line-height:18px;
overflow:hidden;
}
.view_top_r_line p {
float:left;
font-size:14px;
margin:0px;
padding:0px;
color:#bebebe;
line-height:18px;
}

.view_contents {
float:left;
font-family:'Arial';
color:#bebebe;
font-size:14px;
line-height:20px;
padding:0px;
margin:0px;
overflow:hidden;
text-align: left;
}

div.grp{
padding-right: 500px;
padding-top: 5px;
}

div.comment_textarea{
padding-left: 50px;
}

.more input{
width: 55px;
padding-bottom: 50px;
}
.comment_bg {
width:590px;
overflow:hidden;
}
.comment_left {
float:left;
width:100px;
text-align:center;
font-size:12px;
overflow:hidden;
margin-bottom: 12px;
}
.comment_left img {
border:1px solid #ffffff;
border-radius:50px;
}
#commentListImg{
border:1px solid #ffffff;
border-radius:50px;
width: 40px;
height: 40px;
}
#commentListImg img{
border:1px solid #ffffff;
border-radius:50px;
width: 40px;
height: 40px;
}
.comment_center {
float:left;
width:390px;
overflow:hidden;
}
.comment_center textarea {
border:0px;
background:rgba(246,246,246,0.8);
border-bottom-left-radius:10px;
border-top-left-radius:10px;

width:380px;
height:50px;
padding:5px;
overflow-y:hidden;
z-index: -1000;
}
.clear{clear: both;}
.comment_right {
float:right;
width:100px;
overflow:hidden;
}
.comment_right input {
background:rgba(189,189,189,0.5);
color:black;
width:100px;
height:60px;
border:0px;
border-bottom-right-radius:10px;
border-top-right-radius:10px;
}
.st_list {
list-style:none;
margin-bottom:12px;
margin-top:12px;
padding:0px;
text-align:center;
overflow:hidden;
}
.st_list li {
display:inline-block;
}
.st_list li a {
display:inline-block;
}


.st_show {
position: fixed;
top: 50%; left: 50%;
margin-top: -244px; 
margin-left: -325px;
}

#glayLayer {
display: none;  position: fixed; left: 0; top: 0;
height: 100%;   width: 100%;   background: gray;
filter: alpha(opacity=60);   opacity: 0.60;
}

.table_comment{
font-family : MAPLE;
margin-top: 20px;
border-collapse:collapse;
}
 .table_comment tr {
border-bottom:2px solid #D8D8D8;
}

.paging{
overflow: hidden;
margin-top: 12px;
margin-bottom: 12px;
text-align: center;
width: 640px;
}

.movie_btn_m {
margin:2px;
padding:7px 10px 7px 10px;
background:#ffffff;
border:0px;
font-size:13px;
text-align:center;
color:#000000;
font-weight:light;
border-radius:3px;
}

.img_star {
padding-top: 5px;
}
.likeOps{display:inline-block; vertical-align:text-top; width: 50px;}
#likeImg{width: 30px; height: 30px;}
#movieFunc{float:left; margin-top: 10px;}
#actMoreImg{width: 40px;height: 20px;}
#viewWraper{margin-left: 120px;}
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
<div  id="viewWraper">
	<div class="view_bg">
	
	<!-- 사진 -->
	<div style="float: left;" class="movie_pic">
		<img
			src="/bts/image/poster/<s:property value='resultClass.MV_FILE_SAVNAME'/>"
			width="300" height="400" />
	</div>
	
	
				<div class="view_top_r">
				<div class="view_top_r_line">
					<h4><s:property value='resultClass.MV_SUBJECT'/></h4>
					<p style="padding-top:1px;">
					<%-- <s:property value="resultClass.MV_SUBJECT" /> --%>
					</p>
				</div>
				<div class="view_top_r_line">
				
      <h1>밤방평점</h1>
               <p>
                  <c:forEach var="i" begin="1" end="${MV_AVR}" step="1">
                  	<img src="./images/star_01.png" alt="star"/>
                  </c:forEach>
                  <c:forEach var="i" begin="1" end="${5-MV_AVR}" step="1">
                  	<img src="./images/star_02.png" alt="star"/>
                  </c:forEach>
                  <font style="padding-left:5px;font-size:15px;font-weight:bold;"><fmt:formatNumber value="${MV_AVR}"  pattern=".0"/>점</font>
               </p>
            </div>
            <div class="view_top_r_line">
            
            
     <h1>나의평점</h1>
               <p>
               		 <c:if test="${session.mem_no==null}">
               			<c:forEach var="i" begin="1" end="5" step="1">
                  			<img src="./images/star_02.png" alt="star"/>
                  		</c:forEach>
               		</c:if>
               		<c:if test="${session.mem_no!=null}">
               			<c:forEach var="i" begin="1" end="${AvgC}" step="1">
                  			<img src="./images/star_01.png" alt="star"/>
                  		</c:forEach>
                  		<c:forEach var="i" begin="1" end="${5-AvgC}" step="1">
                  			<img src="./images/star_02.png" alt="star"/>
                  		</c:forEach>
                  	</c:if>
						<font style="padding-left:5px;font-size:17px;font-weight:bold;">${AvgC}점</font>
					</p>
				</div>
				<div class="view_top_r_line" style="margin-top:30px;">
					<p>
				<s:if test='resultClass.MV_GENRE == "1"'> 액션 </s:if>
				<s:elseif test='resultClass.MV_GENRE == "2"'> 드라마/멜로 </s:elseif>
				<s:elseif test='resultClass.MV_GENRE == "3"'> 코믹 </s:elseif>
				<s:elseif test='resultClass.MV_GENRE == "4"'> 아동/가족 </s:elseif>
				<s:elseif test='resultClass.MV_GENRE == "5"'> 공포/범죄/스릴러 </s:elseif>
				<s:elseif test='resultClass.MV_GENRE == "6"'> SF/판타지 </s:elseif>
				<s:else>다중 장르</s:else>
				<s:if test='resultClass.MV_STATE == "1"'> , 해외 </s:if>
				<s:else>, 국내</s:else>
					
					</p>
				</div>
				<div class="view_top_r_line" style="margin-top:30px;">
					<p>개봉 <s:property value="resultClass.MV_DATE" /> </p>
				</div>
				<div class="view_top_r_line" style="margin-top:30px;">
					<p>등급 
				<s:if test='resultClass.MV_GRADE == "1"'> 전체 관람가 </s:if>
				<s:elseif test='resultClass.MV_GRADE == "2"'> 7세 관람가 </s:elseif>
				<s:elseif test='resultClass.MV_GRADE == "3"'> 12세 관람가 </s:elseif>
				<s:elseif test='resultClass.MV_GRADE == "4"'> 15세 관람가 </s:elseif>
				<s:elseif test='resultClass.MV_GRADE == "5"'> 18세 관람가 </s:elseif>
				<s:else>청소년 관람불가</s:else></p>
				</div><br />
				<div class="view_top_r_line" style="margin-top:30px;">
				<p>
				감독
				<s:property value="resultClass.MV_DIR" /><br />
				주연
				<s:property value="resultClass.MV_MAIN" /><br />
				조연
				<s:property value="resultClass.MV_SUB" /><br />
					</p>
				</div><br />
			</div>
		<div id="movieFunc">
		<!-- 좋아요 ( 찜부분 )  -->
		<c:if test="${islike == 0}">
		<a class="likeOps" href="movieLikeAction.action?MV_NO=<s:property value="resultClass.MV_NO" />&MEM_NO=${MEM_NO}" style="margin-bottom:-5px;">
		<img src="/bts/image/heart_11.png" id="likeImg"/></a>
		</c:if>
		
		<c:if test="${islike != 0}">
		<a class="likeOps" href="movieDeleteLikeAction.action?MV_NO=<s:property value="resultClass.MV_NO" />&MEM_NO=${MEM_NO}">
		<img src="/bts/image/heart_00.png" id="likeImg"/></a>
		</c:if>
		
	   <a class="likeOps" href='movieList.action?currentPage=<s:property value="currentPage" />'>
	   <input type="button" value="목록" class="movie_btn_m"> </input></a>
	<c:if test="${session.mem_name!=null}">
		<input name="report" type="button" value="신고" class="movie_btn_m likeOps"
			onClick="openReport3()">
	</c:if>
		</div>
			<br />
			<br />
			<br />
			<br />


		</dl>


	<br />
	<br />


	<div class="movie_ss">
		<h3>
			<s:property value="resultClass.MV_SS" />
		</h3>
	</div>
<div class="clear"></div>

		<h3 style="text-align: left;">상세 줄거리</h3> <br />

		<div class="view_contents">
			<s:property value="resultClass.MV_LS" />  <br />
		</div>
			
			<div>

				<table class="more" name="actorList" border="0">

					배우/제작진 &nbsp;
					<input type="image" id="actMoreImg" src="/bts/image/more.jpg" value="더보기" 
						onClick="javascript:location.href='actMore.action?MV_NO=<s:property value="resultClass.MV_NO"/>';" />

					<c:set var="i" value="0" />
					<c:set var="j" value="5" />
				
					<colgroup>
						<col width="150px" />
						<col width="150px" />
					</colgroup>
					<thead></thead>

					<tbody>
						<c:forEach items="${actList}" var="List">

							<input type="hidden" name="ACT_NO" value="${List.ACT_NO}">
								<td><a href="actView.action?ACT_NO=${List.ACT_NO}"> <img
										id="ACT_NO=${List.ACT_NO}" class="img1"
										src="/bts/image/poster/${List.PROFILE_SAVNAME}" width="100"
										height="150" alt="이미지 없음"
										onClick="javascript:location.href='stealMore.action?MV_NO=<s:property value="resultClass.MV_NO"/>';" />

								</a> <br> ${List.ACT_NAME}</td> <c:set var="i" value="${i+1}" />
						</c:forEach>

					</tbody>
				</table>

			</div> <!-- 영화 스틸컷 나열부분 : movie 테이블에서 List를 뽑아와야함 -->
			<div>

					<h3>스틸컷</h3>
					<div id='glayLayer'></div>
					<c:set var="i" value="0" />
				<c:forEach items="${mvPhotoList}" var="List">
					<div class="st_show" id="st_img_${i}" style="display:none;">
						<img src="/bts/image/poster/${List}" width="650" height="488" alt="이미지가없습니다." />
					</div>
					<c:set var="i" value="${i+1}" />
				</c:forEach>
				
				<c:set var="i" value="0" />
				<ul class="st_list">
					<c:forEach items="${mvPhotoList}" var="List">
						<input type="hidden" name="MV_NO" value="${resultClass.MV_NO}"></input>
<li><a href="#100" class="modal" id="st_btn_${i}"><img src="/bts/image/poster/${List}" width="120" height="120" alt="이미지가없습니다." /></a></li>
						
							
							
							
							
								<%-- <td><img id="stealCut" src="/bts/image/${List}" width="150" height="200"
									onclick="javascript:location.href='stealDetail.action?MV_NO=<s:property value="resultClass.MV_NO"/>&MV_FILE_SAVNAME=${List}'"
									alt="이미지 없음" /></td> --%> 
					<c:set var="i" value="${i+1}" />
					</c:forEach>
				</ul>
			
			</div>
			
	
		<c:if test="${session.mem_name!=null}">
			<!-- 별점주기 부분 -->
			<form action="movieCommentWrite.action" method="post">
				<input type="hidden" name="mem_no" value="${session.mem_no }" /> 
				<input type="hidden" name="MVC_WRITER" value="${session.mem_name}" /> 
				<input type="hidden" name="MV_NO" value="<s:property value="resultClass.MV_NO" />" /> 
				<input type="hidden" name="MVC_NO" value="<s:property value="resultClass.MVC_NO"/>" />  
				<s:hidden name="currentPage" value="%{currentPage}" />
				

			<div class="comment_bg">
				<div class="comment_left">
					<img style="width: 40px; height: 40px;" src="/bts/image/profile/${session.mem_profile}" onerror="this.src='/bts/image/icon/user.png'" alt="" /><br />
					${session.mem_name }
				</div>
				<div class="comment_center">
					<s:textarea cols="60" rows="1"  name="MVC_CONTENT" value="" />
				</div>
				<div class="comment_right">
						<input type="image" style="" src="/bts/image/comment.jpg"  value="작성완료" class="inputb">
				</div>
				<div class="stars_label">
					<input type="checkbox" name="MVC_AVR" id="star_img1"
						onchange="view_review_star(1)" /><label for="star_img1"></label>
					<input type="checkbox" name="MVC_AVR" id="star_img2"
						onchange="view_review_star(2)" /><label for="star_img2"></label>
					<input type="checkbox" name="MVC_AVR" id="star_img3"
						onchange="view_review_star(3)" /><label for="star_img3"></label>
					<input type="checkbox" name="MVC_AVR" id="star_img4"
						onchange="view_review_star(4)" /><label for="star_img4"></label>
					<input type="checkbox" name="MVC_AVR" id="star_img5"
						onchange="view_review_star(5)" /><label for="star_img5"></label>
				</div>
					<input type="hidden" name="MVC_" id="stars" value="0" />
			</div>
			
		</form>
	</c:if>
		
		
		
		
		
		
			<table class="table_comment" width="630" border="0" cellspacing="0" cellpadding="0">

				<s:iterator value="commentlist" status="stat">
					<tr aling="center">
						
						<td height="100" style="font-size: 11px;" align="center">
						<div id="commentListImg">
						<img src="/bts/image/profile/profile_<s:property value="mem_no"/>.jpg" alt="F1.jpeg" onerror="this.src='/bts/image/icon/user.png'" />
						</div>
						<s:property value="MVC_WRITER" />
						</td>
						<td  width="160" align="center"><c:forEach var="i" begin="1" end="${MVC_AVR}" step="1">
								<img src="./images/star_01.png" />

							</c:forEach>
							<c:forEach var="i" begin="1" end="${5-MVC_AVR}" step="1">
								<img src="./images/star_02.png" />

							</c:forEach>
							</td>
						<td  width="380" style="font-size: 10px;" align="left">
							<!-- @@@@@@@@@@@@코멘트 삭제@@@@@@@@@@@@ --> 
							<s:property
								value="MVC_CONTENT" /><br /><br />
							<s:property value="MVC_DATE"/>  <c:if
								test="${session.mem_name==MVC_WRITER}">
								<a href="javascript:location.href='commentDelete.action?MVC_NO=<s:property value="MVC_NO"/>&MV_NO=<s:property value="MV_NO"/>&currentPage=<s:property value="currentPage"/>'" align="left">[삭제]</a>
							</c:if> &nbsp; &nbsp; &nbsp; &nbsp; 
							<c:if test="${session.mem_name!=MVC_WRITER}">
								<a onclick="openReport4(<s:property value="MVC_NO"/>)" href="" align="left">[신고]</a>
							</c:if>


						</td>
					</tr>
				</s:iterator>



			</table>
			<div class="paging">
			<s:if test="commentlist.size() <= 0">
			</s:if>
			<s:property value="pagingHtml" escape="false" />
			</div>
	
			</div>
	</body>
</html>






