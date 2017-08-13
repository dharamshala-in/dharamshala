<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Confirmation Screen</title>
</head>
<body style="font-size: 12px;"  onload="resolution();">
<div style="width:100%;height:100%">
	<div style="height: 20%">
		<jsp:include page="dsMainHeader.jsp" flush="true">
			<jsp:param name="screenName1" value="Confirmation_screen"/>
		</jsp:include>
	</div>
	<div style="height: 70%">
		<div id="wrapper" align="center" style="height: 500px;">
			<form:form method="POST" commandName="roomSearchForm" action="/DharamshalaBooking/BookRoom">	
				<table align="center" width="100%"  id="summaryTable" border="0"><h2>Reservation Summary</h2>
					<tr height="35px" >								
						<td align="left" width="10%" class="table_label_exception_details">
							Room Type
						</td>
						<td align="left" width="10%" class="table_label_exception_details">
							CheckIn Date
						</td>
						<td align="left" width="10%" class="table_label_exception_details">
							CheckOut Date
						</td>
						<td align="left" width="10%" class="table_label_exception_details">
							Days
						</td>
						<td align="left" width="10%" class="table_label_exception_details">
							Rooms
						</td>
						<td align="left" width="10%" class="table_label_exception_details">
							Occupancy
						</td>
						<td align="left" width="10%" class="table_label_exception_details">
							Deposit
						</td>
					</tr>
					<tr height="20">
						<td class="table_value_exception_details">${roomSearchForm.roomType}
						</td>
						<td class="table_value_exception_details"><spring:eval expression="roomSearchForm.checkIn"></spring:eval>
						</td>
						<td class="table_value_exception_details"><spring:eval expression="roomSearchForm.checkOut"></spring:eval>
						</td>
						<td class="table_value_exception_details">${roomSearchForm.noOfDays}
						</td>
						<td class="table_value_exception_details">${roomSearchForm.noOfRooms}
						</td>
						<td class="table_value_exception_details"> Adults: ${roomSearchForm.noOfAdults}<br>Childs: ${roomSearchForm.noOfChilds}
						</td>
						<td class="table_value_exception_details">${roomSearchForm.price}
						</td>
					</tr>
					<tr>
						<td colspan="6" align="right" width="10%" class="table_label_exception_details">SubTotal
						</td>
						<td class="table_value_exception_details">${roomSearchForm.price}
						</td>
					</tr>
					<tr>
						<td colspan="6" align="right" width="10%" class="table_label_exception_details">Convenience Fee
						</td>
						<td class="table_value_exception_details">${roomSearchForm.convinenceFee}
						</td>
					</tr>
					<tr>
						<td colspan="6" align="right" width="10%" class="table_label_exception_details">Total Amount :
						</td>
						<td class="table_value_exception_details">${roomSearchForm.totalAmount}
						</td>
					</tr>
				</table>
				<div>
					<table width="50%"><h2>Billing Summary</h2>
					<tr>
					<td>
							<table width="50%"><h3>Dharamshala Details</h3>
								
								<c:if test="${dsDetails!=null}">
								<c:forEach var="i" items="${dsDetails}" varStatus="loop">
								<tr>
									<td>Dharamshala Name : </td><td><c:out value="${i.dsName}"></c:out></td>
								</tr>
								<tr>
									<td>Address : </td><td><c:out value="${i.dsAddress}"></c:out></td>
								</tr>
								</c:forEach>
								</c:if>
							
							</table>
						</td>
						<td>
							<table width="50%"><h3>Guest Details</h3>
								
								<c:choose>         
							         <c:when test = "${roomSearchForm.bookingForSelf=='self'}">
							            <c:if test="${selfDetails!=null}">
											<c:forEach var="i" items="${selfDetails}" varStatus="loop">
											<tr>
												<td>Name : </td>
												<td>
													<c:set var = "name1" value = "${i.userFirstName}"/>
													<c:set var = "name2" value = "${i.userLastName}"/>
													<c:set var = "guestName" value = "${name1}${name2}"/>
													<c:out value="${guestName}"></c:out>
												</td>
											</tr>
											<tr>
												<td>City : </td>
												<td>
												<c:out value="${i.city}"></c:out></td>
											</tr>
											<tr>
												<td>Phone No : </td><td><c:out value="${i.mobileNo}"></c:out></td>
											</tr>
											<tr>
												<td>E-mail : </td><td><c:out value="${i.emailId}"></c:out></td>
											</tr>
											</c:forEach>
										</c:if>
							         </c:when>
							        						         
							         <c:otherwise>
							            	<tr>
												<td>Name : </td><td><c:out value="${roomSearchForm.guestName}"></c:out></td>
											</tr>
											<tr>
												<td>City : </td><td><c:out value="${roomSearchForm.city}"></c:out></td>
											</tr>
											<tr>
												<td>Phone No : </td><td><c:out value="${roomSearchForm.mobileNo}"></c:out></td>
											</tr>
											<tr>
												<td>E-mail : </td><td><c:out value="${roomSearchForm.email}"></c:out></td>
											</tr>
							         </c:otherwise>
							      </c:choose>
															
							</table>
						</td>
					</tr>
					<tr>
							<td style="color: #BA5855;font-weight: bold;font-size: 18px;" >
									<div class="footer" style="float: left;margin-left: 5px;" align="center">
										<input type="submit" name="Submit" value="Submit" onclick="validateFields();"  class="button" style="height: 30px"/>
									</div>
							</td>
						</tr>
					</table>
				</div>
				
			</form:form>
		</div>
	</div>
</div>
</body>
</html>