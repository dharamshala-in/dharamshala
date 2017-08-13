<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String filePath = request.getContextPath();
// 	String sessionid = request.getSession().getId(); 
// 	response.setHeader( "SET-COOKIE" , "JSESSIONID=" + sessionid + ";path=" + filePath + "/cookie/; HttpOnly" ); 
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
	String jsPath = filePath + "/resources/static/modular";
	String cssPath = filePath + "/resources/static/css";
	String imagePath = filePath + "/resources/static/images";
	
	
%>

<link href="<%=cssPath %>/adminCreate.css" rel="stylesheet" type="text/css" />    
<link href="<%=cssPath %>/landing_page.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">// <![CDATA[ 
   var mobile = (/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase()));
   if (mobile) { 
       document.write('<style type="text/css">#footer {position:relative; bottom:0px; background:#2b0306; width:100%; height:25px; clear:both; margin-top:5px;}</style>'); 
   } 
   else 
   { 
       document.write('<style type="text/css">#footer {position:absolute; bottom:0px; background:#2b0306; width:100%; height:25px; clear:both; margin-top:5px;}</style>'); 
       } 
// ]]>
   function resolution(){
		
	   var w = screen.availWidth;
	   var h = screen.availHeight;
	   $("#tableID").height(h*.45);
	   //var s = document.getElementById("tableID");
	   //alert(s);
	   $("#content").height(h*.45);
	   }
	   
</script> 

<div align="left" style="height:65px;" id="top">
	 	<div   style="width: 200px;float: left;"><img class="logo1" src="<%=imagePath%>/Dharmashala.svg" alt="Dharamshala" name="Dharamshala"></div>
		 		
</div>
