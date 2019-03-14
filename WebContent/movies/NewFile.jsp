<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
 <head>
 <script>
   window.onload=function(){
    arr= [c1,c2,c3];
    len= arr.length;
    for(var i =0 ; i<len; i++)
     arr[i].attachEvent("onclick",click);
   }
   function click(){
    var sum=0;
    for( var i =0 ; i<len ; i++){
      if(arr[i].checked){
       sum+= parseInt(arr[i].value);
      }
    }
    txt1.value=sum;
   }
 </script>
 </head>
 <body>
  <input type ="checkbox" id = "c1" value ="1000"> ¶ó¸é 1000
  <input type ="checkbox" id = "c2" value="2000">  ¿ìµ¿ 2000
  <input type ="checkbox" id = "c3" value="3000">  ¶±ººÀÌ 3000
  °è»ê: <input type="text" id ="txt1">
 </body>
 </html>
 