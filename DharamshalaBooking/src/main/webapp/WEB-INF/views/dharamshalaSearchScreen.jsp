<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tirth Home Page</title>
<script type="text/javascript">
function getRoomDetails(dsIdvar) {
	${"searchRoomForm"}.action='/DharamshalaBooking/dsRoomType';	
	$("#dsId").val(dsIdvar);
	${"searchRoomForm"}.submit();
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
			<jsp:param name="screenName1" value="Dharamshala_Home"/>
		</jsp:include>
	</div>
	<div style="height: 70%">
		<div id="wrapper" align="center" style="height: 500px;">
			<form:form method="POST" commandName="dharamshala" action="/DharamshalaBooking/dsSearch">	
				<form:errors path="*"></form:errors>
				<table align="center" width="100%"  id="SearchTable" border="0">
				<tr height="35px" >
					<td align="center" width="25%"  class="table_label_exception_details"> <form:label path="dsName">Enter Dharamshala Name or city
					</form:label></td>
					<td align="center" width="20%" class="table_value_exception_details"> <form:input path="dsName" onkeypress="return onlyAlphaString(event);" ></form:input>
					<form:errors path="dsName" Class="error"></form:errors>
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
			<table width="100%">
				<h2>Available Dharamshalas are</h2>
				<tr height="30" style="color: #FFFFFF;font-weight: bold;" bgcolor="#F58322">
<!-- 					<td>Serial No</td> -->
					<td>Dharamshala name</td>
					<td>Address</td>
					<td>City</td>
					<td>Phone No</td>
					<td>Has Bhojan shala</td>
					<td>Room Type </td>
				</tr>
				
				
			<c:if test="${dharamshalaList!=null}">
				<c:forEach var="i" items="${dharamshalaList}" varStatus="loop">
					<tr height="20">				
<%-- 						<td class="table_value_exception_details"><a href="#" onclick="getRoomDetails(${i.dsId})" style="text-decoration:underline;color:blue;"><c:out value="${loop.count}"></c:out></a>  --%>
<!-- 						</td>					 -->
						<td class="table_value_exception_details"><a href="#" onclick="getRoomDetails(${i.dsId})" style="text-decoration:underline;color:blue;"><c:out value="${i.dsName}"></c:out></a>
						</td>
						<td class="table_value_exception_details"><c:out value="${i.dsAddress}"></c:out>
						</td>
						<td class="table_value_exception_details"><c:out value="${i.dsCity}"></c:out>
						</td>							
						<td class="table_value_exception_details"><c:out value="${i.phoneNo}"></c:out>
						</td>
						<td class="table_value_exception_details"><c:out value="${i.hasBhojanShala}"></c:out></td>
						<td class="table_value_exception_details">
							<c:forEach var="roomType" items="${i.roomTypes}">
								 ${roomType.value}
								 &nbsp;
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
				<form:form method="POST" name="searchRoomForm" commandName="roomSearchForm">
					<form:hidden path="dsId"/>
	
				</form:form>
			</c:if>
			<c:if test="${dharamshalaList==null}">
				<tr height="20">
					<td class="table_value_exception_details" colspan="5"> <font color="red"> No Matches Found</font></td>
				</tr>
			</c:if>
			</table>
			</div>
		</div>
</div>

</body>
</html>