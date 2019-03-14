<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메시지 박스</title>
	<script language="javascript">  

    function closeWindow() {  
            setTimeout(function() {  
        window.close();  
            }, 0);  
        }  
  

    window.onload = closeWindow();  
 
</script>
</head>
<body>
  
  
<center><h2>성공적으로 보내졌습니다.<br> 이 창은 5초후에 닫힙니다.</h2>
<a href="#" onClick="self.close();">닫기</a>   
<a href="#" onClick="javascript:closeWindow();"></a>  
</center> 


</body>
</html>