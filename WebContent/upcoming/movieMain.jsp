<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

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
	width: 50px;
	height: 80px;
	border: 1px solid black;
	display: inline-block;
}
.short {
	width: 250px;
	height: 90px;
	border: 1px solid red;
	display: inline-block;
	display: none;
}
</style>
<script src="/bts/movies/shortOpener.js" type="text/javascript">
  </script>
</head>


<body>

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
	     		
<form name="searching" action="movieSearch.action" onsubmit="return validation()">
 <input type="hidden" name="MV_TYPE" value="<s:property value="paramClass.MV_TYPE"/>"/>
<input type="hidden" name="MV_GENRE" value="<s:property value="paramClass.MV_GENRE"/>"/> 
<input type="text" name="search" size="15" maxlength="50" /> 
<input type="submit" value="검색" />

</form>
		
<table width="600" border="0" cellspacing="0" cellpadding="2">
	<tr>
		<td align="center"><h2>현재상영작</h2></td>

		<td height="20"></td>
	</tr>
</table>

	  		 <s:iterator value="list" status="stat">
	  		 
<%	String[] testArray = new String[30];
for(int i=0; i < testArray.length; i++){
	testArray[i] = ""+i;
}
int cnt=1;


request.setAttribute("testArray", testArray);

	%>

	<!-- 첫번 쨰 포문 -->
	<% for(int a = 0; a < testArray.length; a+=5){ %>

		<!-- 두번 쨰 포문 -->
		<%for(int b = a; b < a+5 ; b++){%>
		
			&nbsp;
			<div class="line" onclick="sc<%=cnt%>(this)">
			 <s:property value="MV_SUBJECT" />
			</div>
			&nbsp;
		
		<%} %>
	<br>
	<div id="short<%=cnt++%>" class="short">short</div>
	</br>

	<%} %>
	   <s:param name="currentPage">
	  	 	<s:property value="currentPage"/>
	  	  	 </s:param>
	  	  	 
	  	  	 
	  	  	 
        		<br>
        		</br>
        	
        	
        	
      	    <!--  두번째 파티션 -->
      	      
      	       <tr>
        		<td height="1" colspan="5"></td>
      	      </tr>
	  	 
			 </s:iterator>
			 
			 <table width="600" border="0" cellspacing="0" cellpadding="2">
	<tr>
		<td align="center"><h2>상영예정작</h2></td>

		<td height="20"></td>
	</tr>
</table>

	  		 <s:iterator value="list" status="stat">
	  		 
<%	String[] testArray = new String[30];
for(int i=0; i < testArray.length; i++){
	testArray[i] = ""+i;
}
int cnt=1;


request.setAttribute("testArray", testArray);

	%>

	<!-- 첫번 쨰 포문 -->
	<% for(int a = 0; a < testArray.length; a+=5){ %>

		<!-- 두번 쨰 포문 -->
		<%for(int b = a; b < a+5 ; b++){%>
		
			&nbsp;
			<div class="line" onclick="sc<%=cnt%>(this)">
			 <s:property value="MV_SUBJECT" />
			</div>
			&nbsp;
		
		<%} %>
	<br>
	<div id="short<%=cnt++%>" class="short">short</div>
	</br>

	<%} %>
	   <s:param name="currentPage">
	  	 	<s:property value="currentPage"/>
	  	  	 </s:param>
	  	  	 
        		
        	
      	    
      	      
      	       <tr>
        		<td height="1" colspan="5"></td>
      	      </tr>
	  	 
			 </s:iterator>
	  
	  
	  
	  <!-- 등록된 영화가 없을경우 -->
	     
	     <s:if test="list.size()<=0">
	     <table>
	     	<tr align="center">
	     	<td colspan="5">등록된 영화가 없습니다.</td>
                  </tr>						
	      <tr bgcolor="#777777">
      		<td height="1" colspan="5"></td>
    	      </tr>
	     </s:if>
	     
	     <tr align="center">
	     <td colspan="5"><s:property value="pagingHtml" escape="false"/></td>
	     </tr>
	     
	     </table>
	     

  		

  			
  		
</body>
</html>