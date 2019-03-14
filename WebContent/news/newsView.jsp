<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>영화상세보기</title>
	<script type="text/javascript">
	</script>
<style type="text/css" >
@font-face{
font-family: BMJUA;
src: url(/bts/font/BMJUA_ttf.ttf);
}

@font-face{
font-family: HOON;
src: url(/bts/font/HoonWhitecatR.ttf);
}



body {

}

div.news_sub{
font-family: HOON;
color:white;
text-align:left;
width: 680px;
font-size: 30px;
margin-bottom: 10px;
margin-top: 25px;
}
.hrstyle{
color:#D5D5D5;
border-top: 2px solid;
align:center;
width:680px;
size: 25px;
}

.news_write {
font-size: 13px;
font-family: BMJUA;
color: white;
margin-top: -15px;
margin-bottom: 5px;
text-align: left;
width: 680px;

}

div.news_content {
font-family: BMJUA;
text-align:left;
line-height: 33px;
float:center;
font-weight:normal;
padding: 18px;
 width: 644px;
 background: #EAEAEA;
 color: #242424;
 border-radius: 10px;
 }
 #wrapper{
 	margin-left:120px;
 }
</style>
<script type="text/javascript">
</script>
</head>
<body bgcolor="black">

<div id="wrapper">
	<div class="news_sub">
		<p class="tit"><h3><s:property value="resultClass.NEWS_SUBJECT" /></h3></p>
	</div>
	
	<hr class="hrstyle"><br /></hr>
	<div class="news_write">
	글 <s:property value="resultClass.NEWS_WRITER"/>&nbsp;&nbsp;<s:property value="resultClass.NEWS_DATE"/>
	</div>
	<hr class="hrstyle"><br />
	</hr>

	<div class="news_pic">
		<dt><img src="/bts/image/news/<s:property value='resultClass.NEWS_IMAGE1'/>" width="680" height="800" /></dt>
	</div>
        <br />

		
		
	<div class="news_content">
	   		<dl> <s:property value="resultClass.NEWS_CONTENT1" /></dl>
			<dl> <s:property value="resultClass.NEWS_CONTENT2" /></dl>
			<a href='newsList.action?currentPage=<s:property value="currentPage" />'>
			
	
	</div> <br />
	
<!-- 	<input type="button" value="목록" class="news_list"> </input></a><br /><br /> -->
		
		</div>
</body>
</html>







