<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
<script type="text/javascript" src="<%=jsPath%>/jquery.js"></script>
<script type="text/javascript" src="<%=jsPath%>/dsCommon.js"></script>

<!--

//-->
</script>
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
		 <div  id="userInfo">
			<span style="line-height: 110px;">
			<sec:authorize access="isAuthenticated()" >
		    Welcome: <sec:authentication property="principal.username" /> 
		    
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ANONYMOUS')" >
		   	 Welcome to Dharamshala.in
		    </sec:authorize>
			
<%-- 				<c:choose><c:when test="${loggedinuser!=null}"> --%>
<%-- 					Welcome: <c:out value="${loggedinuser}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --%>
<%-- 					<%=new SimpleDateFormat("MMMMM dd,yyyy").format(new Date()) %>&nbsp;&nbsp;&nbsp;<span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span> --%>
<%-- 				</c:when> --%>
<%-- 				<c:otherwise> Welcome to Dharamshala.in --%>
<%-- 					<%=new SimpleDateFormat("MMMMM dd,yyyy").format(new Date()) %> --%>
<%-- 				</c:otherwise> --%>
<%-- 				</c:choose> --%>
			</span>
		</div>  
		
</div>
<div align="left" style="margin-left: 0%;height:20%;" >
<table width="99%" align="center" style="text-align: center;text-decoration: none;background-color: #5098CA">
	<tr id="line2">
		<td width="25%" onmouseover="onMouseOverChangeBG(this)" onmouseout="onMouseOutChangeBG(this)"><a href="#">Home</a></td>
		<td width="25%" onmouseover="onMouseOverChangeBG(this)" onmouseout="onMouseOutChangeBG(this)"><a  href="/DharamshalaBooking/tirthSearch">Teerth</a></td>
		<td width="25%" onmouseover="onMouseOverChangeBG(this)" onmouseout="onMouseOutChangeBG(this)"><a  href="/DharamshalaBooking/dsSearch">Dharamshala</a></td>
		<td width="25%" onmouseover="onMouseOverChangeBG(this)" onmouseout="onMouseOutChangeBG(this)">
			<sec:authorize access="isAuthenticated()" >
		    	<a  href="/DharamshalaBooking/logout">Logout</a>	    
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ANONYMOUS')" >
			<a  href="/DharamshalaBooking/login">Login|Register</a>
			</sec:authorize>
		</td>
	</tr>
</table>
</div>
<div align="left" style="margin-left: 0%;height:20%;" >
	<div style="float: left;color: #FFFFFF;margin-left: 10px">
		<%=(String)request.getParameter("screenName1").replace('_',' ')%>
	</div>
	
</div>