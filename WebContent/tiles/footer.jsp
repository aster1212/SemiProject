<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<style type="text/css">
* {
	margin: 0 0 0 0;
	padding: 0 0 0 0;
}

#footerBox {
	height:100px;
	width: 100%;
	overflow: hidden;
	text-overflow: ellipsis;
	background: #232323;
	color: #e3e3e3;
	text-align: center;
	border-bottom: 2px solid #e3e3e3;
	padding-top: 15px;
}
#footerContent{display: inline-block; text-align: left; width: 60%; height:118px;}
.div{ display: inline-block;  vertical-align: text-top; margin-left: 1px;}
#footerLogoBox{width: 90px; height: 90px; margin-right: 8px;}
#footerLogoBox img{width: 90px; height: 90px;}
.footerTxt{width:auto; height: 60px;}
.clickable{cursor: pointer;}
.sns{display: inline-block;}
#snsBox{width:230px;}
.clear{clear:both;}
.underline{text-decoration: underline;}
#reporter{font-size: 23px; display:inline-block; margin-top:12px;}
#hps{text-align: right;}
</style>
<script type="text/javascript">

function report() {
	alert('로그인을 해주세용');
}
function openReport() {
	   var url = "reportForm.action?type=5"
	   window.open(
	         url,
	         "신고하기",
	         "toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=570");
	}
</script>
</head>

<body>
	<div id="footerBox">
		<div id="footerContent">
			<div id="footerLogoBox" class="div"><img src="/bts/image/icon.png" onclick="window.location='/bts/main.action'"/></div>
			<div class="div"><div class="footerTxt div">Copyright &copy; BTS team<br/>All Right Reserved</div>
			<div id="hps" class="footerTxt div">TEL 010-3080-1190<br/>FAX 050-3080-1190</div>
			<div id="snsBox" class="footerTxt div">
			<img src="/bts/image/icon/facebook.png" onclick="window.location='https://www.facebook.com/profile.php?id=100009241497300'" class="clickable sns"/>
			<img src="/bts/image/icon/twiter.png" onclick="window.location='https://twitter.com/_iuofficial?lang=ko'" class="clickable sns"/>
			<img src="/bts/image/icon/instargram.png" onclick="window.location='https://www.instagram.com/__2zin__3/?hl=ko'" class="clickable sns"/>
			<img src="/bts/image/icon/youtube.png" onclick="window.location='https://www.youtube.com/channel/UCV1amWd3zSP1hElzLNtdFSw'" class="clickable sns"/>
			</div>
			<div class="footerTxt div">
			<c:if test="${session.mem_no!=null}">
			<a onclick="openReport()" id="reporter" class="clickable underline">Please recommend something inconvenient</a>
	  		</c:if>
	  		<c:if test="${session.mem_no==null}">
	  		<a onclick="report()" id="reporter" class="clickable underline">Please recommend something inconvenient</a>
	  		</c:if>
			
			</div>
			<div class="clear"></div>
			<div class="footerTxt div">Create by Lee Cheolseung  Lee Jiin  Kim Taehyeong  Choi Myeonggwan  Kwon Taehoon  Lee JuneHak  with KH Infomation Education Center</div>
			</div>
		</div>
	</div>
</body>
</html>