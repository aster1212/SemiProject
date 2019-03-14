<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
</head>
<html>
<body>
<% request.setCharacterEncoding("euc-kr"); %>
<%-- <script>
/* $(document).ready(function(){
	if('${param.chk0}' == "1") $("input:checkbox[id='chk1']").prop("checked", true);
	if('${param.chk1}' == "2") $("input:checkbox[id='chk2']").prop("checked", true);
	if('${param.chk2}' == "3") $("input:checkbox[id='chk3']").prop("checked", true);
	}); */


 var values = '${param.chk}'.split();
for(var i=0; i<values.length; i++){
      $("input:checkbox[value="+values[i]+"]").prop("checked", true);
} 
</script> --%>

으아아아아아
<meta http-equiv="Refresh" content="2;url=NewFile.jsp" >

<%-- 
    int check= manager.userCheck(id,passwd);

    
if(check==1){
session.setAttribute("memId",id);
response.sendRedirect("/WebProgramming/board/list1.jsp");

session.setMaxInactiveInterval(60*15);		//세션 유지시간은 15분으로 설정
											//만약 설정해두지 않으면 세션이 쌓여 메모리 부족현상 발생.
}else if(check==0){%>
<script>
  alert("비밀번호가 맞지 않습니다.");
      history.go(-1);
</script>
<% }else{ %>
<script>
  alert("아이디가 맞지 않습니다..");
  history.go(-1);
</script>
<%} %> --%>
</body>
</html>