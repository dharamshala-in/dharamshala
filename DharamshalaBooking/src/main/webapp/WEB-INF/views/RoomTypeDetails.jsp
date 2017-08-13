<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Type Page</title>
<%	
	String filePath = request.getContextPath();
	String jsPath = filePath + "/resources/static/modular";
	String cssPath = filePath + "/resources/static/css";
	String imagePath = filePath + "/resources/static/images";
		
%>
<script type="text/javascript" src="<%=jsPath%>/datetimepicker_new.js"></script>
<script type="text/javascript" src="<%=jsPath%>/jquery.js"></script>
<script type="text/javascript" src="<%=jsPath%>/dsCommon.js"></script>
<script type="text/javascript">
function showSummary(){
	${"roomSearchForm"}.action='/DharamshalaBooking/dsGuestInfo';    	
	    	
	${"roomSearchForm"}.submit();
}


</script>
</head>

<body style="font-size: 12px;"  onload="resolution();">
<div style="width:100%;height:100%;">
	<div style="height: 20%">
		<jsp:include page="dsMainHeader.jsp" flush="true">
			<jsp:param name="screenName1" value="Room_Type_Details"/>
		</jsp:include>
	</div>
	<div style="height: 70%">
		<div id="wrapper" align="center" style="height: 500px;">
			<form:form method="POST" commandName="roomSearchForm" action="/DharamshalaBooking/dsRoomList">	
				<table align="center" width="100%"  id="SearchTable" border="0">
					<tr height="35px" >
									
						<td align="left" width="10%" class="table_label_exception_details"><form:label path="roomTypeId">Room Type</form:label></td>
				         <td align="center" width="20%" class="table_value_exception_details">
				            <form:select path="roomTypeId">
				               <form:option value="0" label="Select"/>
				               <form:options items="${roomTypeList}" />
				            </form:select>     	
				         </td>
				         <td align="left" width="10%" class="table_label_exception_details"><form:label path="checkIn">Check In </form:label></td>		         
				         <td class="table_value_exception_details" width="20%">
								<div style="width: 80%; float: left;"><form:input  path="checkIn" maxlength="10" onkeyup="return manualDate(event,this);"/><b id="astric">*</b></div> 
								<div style="float: left;width: 20%;">
								<img id="meetingDate3" src="<%=imagePath%>/cal.gif" style="padding-top:2%;" width="17" height="17" border="0" align="left" onClick="javascript:NewCal('<%="checkIn"%>','ddmmyyyy',false,24)"> </div>
								<br><b id="errorMessage"><form:errors property="checkIn" /></b>
							</td>   
				   		<td align="left" width="10%" class="table_label_exception_details"><form:label path="checkOut">Check Out </form:label></td>
				        <td class="table_value_exception_details" width="20%">
								<div style="width: 80%; float: left;"><form:input path="checkOut" maxlength="10" onkeyup="return manualDate(event,this);"/><b id="astric">*</b></div> 
								<div style="float: left;width: 20%;">
								<img id="meetingDate4" src="<%=imagePath%>/cal.gif" style="padding-top:2%;" width="17" height="17" border="0" align="left" onClick="javascript:NewCal('<%="checkOut"%>','ddmmyyyy',false,24)"> </div>
								<br><b id="errorMessage"><form:errors property="checkOut" /></b>
							</td>
						<td style="color: #BA5855;font-weight: bold;font-size: 18px;" >
							<div class="footer" style="float: left;margin-left: 5px;" align="center">
											<input type="submit" name="Submit" value="Submit" onclick="validateFields();"  class="button" style="height: 30px"/>
							</div>
						</td>
						  </tr>									  
						  <tr>&nbsp;</tr>
					</table>
					<form:hidden path="dsId"/>
						    
			<table align="left" width="100%" id="priceList">
				<tr height="30" style="color: #FFFFFF;font-weight: bold;" bgcolor="#F58322">
					<td>Room Type</td>
					<td>Price</td>
				</tr>
				
				
			<c:if test="${roomTypeDtls!=null}">
				<c:forEach var="i" items="${roomTypeDtls}" varStatus="loop">
					<tr height="20">
									
						<td class="table_value_exception_details" id="roomCat"><c:out value="${i.roomCategory}"></c:out>
						</td>
						<td class="table_value_exception_details" id="roomPrice">
						<c:choose>
							<c:when test="${i.dsRoomPriceCollection!= null && i.dsRoomPriceCollection.size() > 0}">
								<c:forEach var="j" items="${i.dsRoomPriceCollection}" varStatus="loop2">
									<c:out value="${j.price}"></c:out>
<%-- 									<c:if test="(${roomTypeId}.equals(${i.roomTypeId}))"> --%>
<%-- 										<input type="hidden" id="price" value="${j.price}"/> --%>
<%-- 									</c:if> --%>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:out value="N/A"></c:out>
							</c:otherwise>
						</c:choose>
						</td>
						
					</tr>
				</c:forEach>
			</c:if>
			</table>
	<%-- 		</form:form> --%>
			<c:if test="${roomNoList!=null}">
	<%-- 		<form:form method="POST" id="RoomNoFormId" commandName="roomSearchForm" action="/DharamshalaBooking/dsShowBookSummary"> --%>
				<table align="center" width="100%"  id="RoomDetails" border="0">
					<tr height="30" style="color: #FFFFFF;font-weight: bold;" bgcolor="#F58322">					
						<td width="100%" colspan="2">Available Room Numbers are:</td>
					</tr>
					<tr>
	<%-- 					<c:forEach var="i" items="${roomNoList}"> --%>
							
	<%-- 							<td class="table_value_exception_details"><form:checkbox path="roomNumber" id="${i.roomNumber}RNo"  value="${i.roomNumber}"/><c:out value="${i.roomNumber}"></c:out></td> --%>
								
							
	<%-- 					</c:forEach> --%>
							<td><form:checkboxes items="${roomNoList}" path="roomNumbers" element="ol" itemLabel="roomNumber" itemValue="roomNumber" /></td>
							<td><form:errors path="roomNumbers" cssClass="error" /></td>
						
					</tr>
					<tr>
						<td>Capacity Adults 3/Child:2 per room</td>
					</tr>
					<tr>
					<td>
						<form:select path="noOfAdults">
							<form:option value="0">Number Of Adults</form:option>
							<form:options items="${numOfAdultsList}" />
						</form:select></td>
						<td><form:select path="noOfChilds">
							<form:option value="0">Number Of Childs</form:option>
							<form:options items="${numOfChildsList}"/>
						</form:select></td>
					</tr>
					
					<tr>
						<td style="color: #BA5855;font-weight: bold;font-size: 18px;" >
								<div class="footer" style="float: left;margin-left: 5px;" align="center">
											<input type="submit" name="Proceed" value="Proceed" onclick="showSummary()"  class="button" style="height: 30px"/>
								</div>
						</td>
					</tr>	
				</table>
				<form:hidden path="dsId"/>
	<%-- 			</form:form> --%>
			</c:if>
			</form:form>
		
	</div>
</div>
</div>
</body>
</html>