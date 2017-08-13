<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guest Information Screen</title>
<%	
	String filePath = request.getContextPath();
	String jsPath = filePath + "/resources/static/modular";
	String cssPath = filePath + "/resources/static/css";
	String imagePath = filePath + "/resources/static/images";
		
%>
<script type="text/javascript" src="<%=jsPath%>/jquery.js"></script>
<script>
 $(document).ready(function() {
 // hide the table as soon as the DOM is ready
 $("#id_data").hide();
 // shows the table on clicking the noted link
  $("#id_radio1").click(function() {
   $("#id_data").show("slow");
  });
 // hides the table on clicking the noted link
   $("#id_radio2").click(function() {
   $("#id_data").hide("fast");
   });
 });
 </script>
</head>
<body style="font-size: 12px;"  onload="resolution();">
<div style="width:100%;height:100%">
	<div style="height: 20%">
		<jsp:include page="dsMainHeader.jsp" flush="true">
			<jsp:param name="screenName1" value="Room_Type_Details"/>
		</jsp:include>
	</div>
	<div style="height: 70%">
		<div id="wrapper" align="center" style="height: 500px;">
			<form:form method="POST" commandName="roomSearchForm" action="/DharamshalaBooking/dsShowBookSummary">	
				<table align="center" width="100%"  id="summaryTable" border="0"><h2>Reservation Summary</h2>
					<tr height="35px" >								
<!-- 						<td align="left" width="10%" class="table_label_exception_details"> -->
<!-- 							Room Type -->
<!-- 						</td> -->
						<td align="left" width="10%" class="table_label_exception_details">
							CheckIn Date
						</td>
						<td align="left" width="10%" class="table_label_exception_details">
							CheckOut Date
						</td>
						
						<td align="left" width="10%" class="table_label_exception_details">
							Room Numbers
						</td>
						<td align="left" width="10%" class="table_label_exception_details">
							Occupancy
						</td>
					</tr>
					<tr>
<%-- 						<td class="table_value_exception_details">${roomSearchForm.roomType} --%>
<!-- 						</td> -->
						<td class="table_value_exception_details">
							<spring:eval expression="roomSearchForm.checkIn"></spring:eval>
						</td>
						<td class="table_value_exception_details"><spring:eval expression="roomSearchForm.checkOut"></spring:eval>
						</td>
						
						<td class="table_value_exception_details">
						<c:forEach var="i" items="${roomSearchForm.roomNumbers}" varStatus="loop">
						<c:out value=" ${i}"></c:out>&nbsp;
						</c:forEach>
						</td>
						<td class="table_value_exception_details"> Adults: ${roomSearchForm.noOfAdults}<br>Childs: ${roomSearchForm.noOfChilds}
						</td>
					</tr>
				</table>
				
				<table align="center" width="100%"  id="guestTable" border="0"><h2>Guest Details</h2>
					<tr height="35px" >								
						<td align="left" width="10%" class="table_label_exception_details">
							Booking for Self?
						</td>
						<td><form:radiobutton path="bookingForSelf" id="id_radio1" value="other"/> No
							<form:radiobutton path="bookingForSelf" id="id_radio2" value="self" /> Yes
						</td>
					</tr>		
					
				</table>
				<div align="center" id="id_data">
						<table align="center" width="100%" >
						<tr height="35px">
							<td align="left" width="10%" class="table_label_exception_details">
							<form:label path="guestName">Guest Name</form:label></td>
							<td align="center" width="20%" class="table_value_exception_details">
								<form:input path="guestName"/>
							</td>
						</tr>
						<tr height="35px">
							<td align="left" width="10%" class="table_label_exception_details">
							<form:label path="dob">Age</form:label></td>
							<td align="center" width="20%" class="table_value_exception_details">
								<form:input path="dob"/>
							</td>
						</tr>
						<tr height="35px">
							<td align="left" width="10%" class="table_label_exception_details">
							<form:label path="mobileNo">Mobile Number</form:label></td>
							<td align="center" width="20%" class="table_value_exception_details">
								<form:input path="mobileNo"/>
							</td>
						</tr>
						<tr height="35px">
							<td align="left" width="10%" class="table_label_exception_details">
							<form:label path="email">Email Id</form:label></td>
							<td align="center" width="20%" class="table_value_exception_details">
								<form:input path="email"/>
							</td>
						</tr>
						<tr height="35px">
							<td align="left" width="10%" class="table_label_exception_details">
							<form:label path="idType">ID Type</form:label></td>
							<td align="center" width="20%" class="table_value_exception_details">
								<form:select path="idType">
					               <form:option value="0" label="Select"/>
					               <form:options items="${idTypeLst}" />
					            </form:select> 
							</td>
						</tr>
						<tr height="35px">
							<td align="left" width="10%" class="table_label_exception_details">
							<form:label path="idCardNo">Id card Number</form:label></td>
							<td align="center" width="20%" class="table_value_exception_details">
								<form:input path="idCardNo"/>
							</td>
						</tr>
						<tr height="35px">
							<td align="left" width="10%" class="table_label_exception_details">
							<form:label path="city">City</form:label></td>
							<td align="center" width="20%" class="table_value_exception_details">
								<form:input path="city"/>
							</td>
						</tr>
						<tr height="35px">
							<td align="left" width="10%" class="table_label_exception_details">
							<form:label path="country">Country</form:label></td>
							<td align="center" width="20%" class="table_value_exception_details">
								<form:input path="country"/>
							</td>
						</tr>
						
					</table>
				</div>
				<div class="footer" style="float: left;margin-left: 5px;" align="center">
						<input type="submit" name="Submit" value="Submit" class="button" style="height: 30px"/>
				</div>
				<form:hidden path="dsId"/>
				<form:hidden path="checkOut"/>
				<form:hidden path="checkIn"/>
				<form:hidden path="roomTypeId"/>
				<form:hidden path="roomNumbers"/>
				<form:hidden path="noOfAdults"/>
				<form:hidden path="noOfChilds"/>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>