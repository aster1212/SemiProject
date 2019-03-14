<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>스트럿츠2 게시판</title>
</head>
<script type="text/javascript">
function openReport1() {
	var no = ${resultClass.bo_no}
	   var url = "reportForm.action?type=1&bo_no="+no;
	   window.open(
	         url,
	         "신고하기",
	         "toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=570");
	}
function openReport2(boc,orn) {
	var no = ${resultClass.bo_no}
	   var url = "reportForm.action?type=2&bo_no="+no+"&boc_no="+boc+"&boc_originno="+orn;
	   window.open(
	         url,
	         "신고하기",
	         "toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=570");
	}
</script>
<style type="text/css">
#imgContainer {
   border: 1px solid red;
   border-radius: 50%;
   overflow: hidden;
   width: 50px;
   height: 50px;
   text-align: center;
}

#imgWriter {
   display: inline-block;
   border: 1px solid red;
   border-radius: 50%;
   overflow: hidden;
   width: 50px;
   height: 50px;
   text-align: center;
}

#imgWriter img {
   display: inline-block;
   width: 50px;
   height: 50px;
}

#imgContainer img {
   display: inline-block;
   width: 50px;
   height: 50px;
}

.title {
   width: 800px;
   overflow: hidden;
   font-size: 50px;
   text-shadow: 2px 1px 1px #D5D5D5;
   color: gray;
   float: left;
   margin-left: 8px;
   margin-bottom: 8px;
   margin-top: 13px;
}

.title_sub {
   width: 800px;
   overflow: hidden;
   font-size: 15px;
   color: #e3e3e3;
   float: left;
   margin-left: -2px;
   margin-bottom: 10px;
   padding-left: 12px;
}

.title_main {
   width: 500px;
   overflow: hidden;
   font-size: 20px;
   color: #e3e3e3;
   padding-top: 77px;
   padding-left: -155px;
}

.table_sub {
   padding-top: -12px;
   padding-bottom: 20px;
}

.comm_table_m {
   width: 100%;
   border-collapse: collapse;
}

.comm_table_m tr td {
   border-bottom: 1px dashed #d4d4d4;
   padding: 15px;
   font-size: 12px;
   font-family: 'Arial';
   font-weight: normal;
}

.comm_table_m tr td a {
   text-decoration: none;
   color: #666666;
}

.comm_table_m tr td img {
   border-radius: 100px;
   border: 1px solid #bbbbbb;
}

.comm_input {
   width: 100%;
   height: 50px;
   border: 1px solid #e5e5e5;
   background: #ffffff;
}

.comm_btn {
   width: 100%;
   height: 52px;
   background: #ffffff;
   border: 1px solid #cccccc;
   font-size: 12px;
   font-weight: bold;
   color: #666666;
}

.board_btn_m {
   margin: 0px;
   padding: 5px 10px 5px 10px;
   background: #515151;
   border: 0px;
   font-size: 12px;
   color: #ffffff;
   font-weight: bold;
   border-radius: 3px;
}
#addImg{max-height: 200px;}
</style>
<script type="text/javascript">
function toggles(var1) {
   if(document.getElementById(var1).style.display == "none")
      document.getElementById(var1).style.display = "";
   else
      document.getElementById(var1).style.display = "none";
}
</script>
<body>

   <table width="950" border="0" cellspacing="0" cellpadding="2">
      <tr>
         <td>
            <h3 class="title">Board View</h3>
            <h3 class="title_sub">영화에 관한 글을 자유롭게 남기는 공간입니다.</h3>
            <h2 class="title_main">
               &nbsp;&nbsp;
               <s:property value="resultClass.bo_subject" />
            </h2>
         </td>
      </tr>
      <tr>
         <td height="20" colspan="4"></td>

      </tr>
   </table>

   <table class="table_sub" width="100%" height="320" border="0"
      cellspacing="0" cellpadding="0">

      <tr style="font-size: 15px;" height="35"; bgcolor:#F4F4F4;">
         <td style="width: 90px; font-size:1ex; padding-left: 20px; border-bottom: 1px solid #D5D5D5; border-top: 1px solid #D5D5D5;" >
         <s:a href="%{take2URL}"><img src="/bts/image/icon/writer.png" width="12px" height="12px"/><s:property value="resultClass.bo_writer" /></s:a></td>

         <td
            style="font-size: 13px; border-bottom: 1px solid #D5D5D5; border-top: 1px solid #D5D5D5;"
            width="120"><s:property value="resultClass.bo_genre" /></td>

         <td
            style="font-size: 13px; border-bottom: 1px solid #D5D5D5; border-top: 1px solid #D5D5D5;"
            width="50"><s:property value="resultClass.category" /></td>

         <td style="font-size: 13px; border-bottom: 1px solid #D5D5D5; border-top: 1px solid #D5D5D5;" width="30px">
         <img src="/bts/image/icon/boardCount.png" style="width: 13px; height: 13px; display: inline-block;"/>
         <div style="display: inline-block;"><s:property value="resultClass.bo_cnt" /></div>
         </td>

         <td align="right"
            style="font-size: 13px; padding-right: 10px; border-bottom: 1px solid #D5D5D5; border-top: 1px solid #D5D5D5;"
            width="550"><s:property value="resultClass.bo_date" /></td>
      </tr>
      <tr height="24">
         <td style="font-size: 13px; /* border-bottom: 1px solid #D5D5D5; */ border-top: 1px solid #D5D5D5;"
            colspan="5" height="20px" align="center">&nbsp;&nbsp; <s:if
               test="resultClass.bo_orgfile == null">
               <s:property value="resultClass.bo_orgfile" />
            </s:if> <s:else>
               <img src="/bts/image/board/${resultClass.bo_savfile }" id="addImg" />
            </s:else>
         </td>
      </tr>
      <tr height="250">
         <td colspan="5" style="font-size: 14px;"><s:property
               value="resultClass.bo_content" /></td>

      </tr>

      <tr height="5">
         <td align="right" colspan="5"><s:url id="modifyURL"
               action="modifyForm">
               <s:param name="bo_no">
                  <s:property value="bo_no" />
               </s:param>
            </s:url> <s:url id="deleteURL" action="deleteAction">
               <s:param name="bo_no">
                  <s:property value="bo_no" />
               </s:param>
            </s:url> <c:if test="${session.mem_name==resultClass.bo_writer}">
               <input name="list" type="button" value="수정" class="board_btn_m"
                  onClick="location.href='modifyForm.action?bo_no=<s:property value="bo_no" />&currentPage=<s:property value="currentPage" />'" />

               <input name="list" type="button" value="삭제" class="board_btn_m"
                  onClick="location.href='deleteAction.action?bo_no=<s:property value="bo_no" />&currentPage=<s:property value="currentPage" />'">
            </c:if> <input name="list" type="button" value="목록" class="board_btn_m"
            onClick="javascript:location.href='listAction.action?currentPage=<s:property value="currentPage" />'">
            <c:if test="${session.mem_no!=null}">
               <c:if test="${session.mem_name!=resultClass.bo_writer}">
                  <input name="report" type="button" value="신고" class="board_btn_m"
                     onClick="openReport1()">
               </c:if></td>
               </c:if>
      </tr>
   </table>

   <c:if test="${session.mem_no!=null}">



      <form action="writeCommentAction.action" method="post">
         <table border="0" cellpadding="0" cellspacing="0"
            class="comm_table_m">
            <tr>

               <td style="width: 50px; text-align: center; padding-left: 25px;">
                  <img style="width: 40px; height: 40px; margin-bottom: 5px;"
                  src="/bts/image/profile/${session.mem_profile}" alt=""
                  onerror="this.src='/bts/image/icon/user.png'" /> <input type="hidden"
                  name="mem_no" value="${session.mem_no}" /> <br /> <input
                  type="hidden" name="boc_writer" value="${session.mem_name}" />
                  ${session.mem_name }
               </td>
               <td style="padding-right: 2px;"><textarea name="boc_content"
                     class="comm_input"></textarea> <s:hidden name="boc_originno"
                     value="%{resultClass.bo_no}" /> <!-- !!!!!!!!!!!!!!!!!!!!!!!!수정!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                  <s:hidden name="bo_no" value="%{resultClass.bo_no}" /> <s:hidden
                     name="currentPage" value="%{currentPage}" /> <!-- !!!!!!!!!!!!!!!!!!!!!!!!수정!!!!!!!!!!!!!!!!!!!!!!!!!!! -->

               </td>
               <td style="width: 80px; padding-left: 2px;"><input
                  name="submit" type="submit" value="작성완료" class="comm_btn" /></td>

            </tr>
         </table>
      </form>
   </c:if>

   <table border="0" cellpadding="0" cellspacing="0" class="comm_table_m">
      <s:iterator value="commentlist" status="stat">


         <tr>
            <td rowspan="2" style="width: 50px; text-align: right;"><img
               src="/bts/image/profile/profile_<s:property value="mem_no"/>.jpg"
               alt="" onerror="this.src='/bts/image/icon/user.png'" width="40px"
               height="40px" /></td>
            <td style=" padding-bottom: 2px; border: 0px;"><span
               style="font-weight: bold;"><s:property value="boc_writer" /></span>
               <s:property value="boc_date" /></td>
            <td rowspan="2"
               style="width: 80px; text-align: center; line-height: 20px;"><c:if
                  test="${session.mem_name==boc_writer}">
                  <a
                     href="javascript:location.href='deleteAction2.action?boc_no=<s:property value="boc_no"/>&bo_no=<s:property value="bo_no"/>&boc_originno=<s:property value="boc_originno" />&currentPage=<s:property value="currentPage"/>'"
                     align="left">[삭제]</a>
                  <br />
               </c:if> <c:if test="${session.mem_no!=null}">
                  <c:if test="${session.mem_name!=boc_writer}">
                     <a onclick="openReport2(<s:property value="boc_no"/>,<s:property value="boc_originno" />)" href=""
                        align="left">[신고]</a>
                     <br />
                  </c:if>
               </c:if> <a href="#100"
               onclick="toggles('comm_rt_<s:property value='boc_no'/>')">[답글]</a>
            </td>
         </tr>
         <tr>
            <td style="padding-top: 2px;"><c:forEach var="i" begin="1"
                  end="${boc_relevel}"> ▶
                  </c:forEach> <s:property value="boc_content" /></td>
         </tr>

         <tr id="comm_rt_<s:property value="boc_no"/>" style="display: none;">
            <form action="writeCommentAction.action" method="post">
               <input type="hidden" name="mem_no" value="${session.mem_no}" /> <input
                  type="hidden" name="boc_writer" value="${session.mem_name}" />
               <td style="text-align: center; font-weight: bold;">${session.mem_name}</td>
               <td style="padding-right: 2px;"><textarea name="boc_content"
                     class="comm_input"></textarea></td>
               <s:hidden name="boc_originno" value="%{resultClass.bo_no}" />
               <input type="hidden" name="boc_ref"
                  value="<s:property value="boc_ref"/>"></input> <input
                  type="hidden" name="boc_relevel"
                  value="<s:property value="boc_relevel"/>"></input> <input
                  type="hidden" name="boc_restep"
                  value="<s:property value="boc_restep"/>"></input>
               <!-- !!!!!!!!!!!!!!!!!!!!!!!!수정!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
               <s:hidden name="bo_no" value="%{resultClass.bo_no}" />
               <s:hidden name="currentPage" value="%{currentPage}" />

               <!-- !!!!!!!!!!!!!!!!!!!!!!!!수정!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
               <td style="padding-left: 2px;"><input name="submit"
                  type="submit" value="등록" class="comm_btn"></td>
            </form>
            </td>
         </tr>



      </s:iterator>
      <%--          <s:if test="commentlist.size() <= 0">
               <tr>
                  <td colspan="3" height="10">
                     댓글없음
                  </td>
               </tr>
            </s:if> --%>
   </table>
   <div style="width: 100%; text-align: center; margin: 30px 0 30px 0;">
      <s:property value="pagingHtml" escape="false" />
   </div>

   <tr bgcolor="#777777">
      <td colspan="2" height="1"></td>
   </tr>
   <tr>
      <td colspan="2" height="10"></td>
   </tr>
   </table>



</body>
</html>