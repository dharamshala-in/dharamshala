<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tirth Home Page</title>
<script type="text/javascript">
    function getTeerthDetails(tirthIdvar) {    	
    	${"searchTirthForm"}.action='/DharamshalaBooking/dstirthDetails';    	
    	$("#tirthId").val(tirthIdvar);    	
    	${"searchTirthForm"}.submit();    	
    }
//     function fillForm(){
//     	$("#tirthName").val("Enter Tirth Name or City");
//     }
</script>
</head>

<body  style="font-size: 12px;" contextmenu="return false" ondragstart="return false" onKeyDown="return disableCtrlKeyCombination(this);" onload="resolution(),fillForm();">
<div style="width: 100%;height: 100%">
<div style="height: 20%">
	<jsp:include page="dsMainHeader.jsp" flush="true">
		<jsp:param name="screenName1" value="Tirth_Home"/>
	</jsp:include>
</div>
<div style="height: 70%">
	<div id="wrapper" align="center" style="height: 500px;">
		<form:form method="POST" commandName="tirth" action="/DharamshalaBooking/tirthSearch">	
			<form:errors path="*"></form:errors>
			<table align="center" width="100%"  id="SearchTable" border="0">
			<tr height="35px" >
				<td align="center" width="25%"  class="table_label_exception_details"> <form:label path="tirthName">Enter Tirth Name
				</form:label></td>
				<td align="center" width="20%" class="table_value_exception_details"> <form:input path="tirthName" onkeypress="return onlyAlphaString(event);" ></form:input>
				<form:errors path="tirthName" Class="error"></form:errors>
				</td>
				<td align="center" width="25%"  class="table_label_exception_details"> <form:label path="city">Enter City
				</form:label></td>
				<td align="center" width="20%" class="table_value_exception_details"> <form:input path="city" onkeypress="return onlyAlphaString(event);" ></form:input>
				<form:errors path="city" Class="error"></form:errors>
				</td>
				<td align="center" width="25%" class="table_label_exception_details"><form:label path="kshetra">Kshetra</form:label></td>
		         <td align="center" width="20%" class="table_value_exception_details">
		            <form:select path="kshetra">
		               <form:option value="BOTH" label="Select"/>
		               <form:options items="${kshetraTypeList}" />
		            </form:select>     	
		         </td>
				<td style="color: #BA5855;font-weight: bold;font-size: 18px;" >
					<div class="footer" style="float: left;margin-left: 5px;" align="center">
									<input type="submit" name="Submit" value="Submit"   class="button" style="height: 30px"/>
								</div>
							</td>
				  </tr>									  
				  <tr>&nbsp;</tr>										  
											     									 										
			</table>
			</form:form>					    
		<table align="left" width="100%">
			<tr height="30" style="color: #FFFFFF;font-weight: bold;" bgcolor="#F58322">
				<td>Serial No</td>
				<td>Tirth name</td>
				<td>Tirth Kshetra type</td>
				<td>City</td>
			</tr>
			
			
		<c:if test="${kshetraList!=null}">
			<c:forEach var="i" items="${kshetraList}" varStatus="loop">
				<tr height="20">
					
					<td class="table_value_exception_details">

					<a href="#" onclick="getTeerthDetails(${i.tirthId});" style="text-decoration:underline;color:blue;"><c:out value="${loop.count}"></c:out></a> 
					</td>
					
					<td class="table_value_exception_details">
					<a href="#" onclick="getTeerthDetails(${i.tirthId});" style="text-decoration:underline;color:blue;"><c:out value="${i.tirthName}"></c:out></a>
					</td>
					<td class="table_value_exception_details"><c:out value="${i.kshetra}"></c:out>
					</td>
					<td class="table_value_exception_details"><c:out value="${i.city}"></c:out>
					</td>
							
				</tr>
			</c:forEach>
			<form:form method="POST" name="searchTirthForm" commandName="tirth">
				<form:hidden path="tirthId"/>
			</form:form>
		</c:if>
		<c:if test="${kshetraList==null}">
			<tr height="20">
				<td class="table_value_exception_details" colspan="5"> <font color="red"> No Matches Found</font></td>
			</tr>
		</c:if>
		</table>
	
	</div>
</body>
</html>