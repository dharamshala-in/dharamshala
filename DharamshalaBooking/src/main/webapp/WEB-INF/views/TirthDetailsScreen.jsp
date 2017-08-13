<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tirth Detail Page</title>
<script type="text/javascript">
    function getRoomDetails(dsIdvar) {
    	${"searchRoomForm"}.action='/DharamshalaBooking/dsRoomType';	
    	$("#dsId").val(dsIdvar);
    	${"searchRoomForm"}.submit();
    }
</script>
</head>

<body  style="font-size: 12px;" contextmenu="return false" ondragstart="return false" onKeyDown="return disableCtrlKeyCombination(this);" onload="resolution();">
<div style="width: 100%;height: 100%">
<div style="height: 20%">
	<jsp:include page="dsMainHeader.jsp" flush="true">
		<jsp:param name="screenName1" value="Tirth_Detail"/>
	</jsp:include>
</div>
<div style="height: 70%">
	<div id="wrapper" align="center" style="height: 500px;">
			
								    
		<table align="left" width="100%" cellspacing="0" cellpadding="0" border="0">
		
		<tr>
		<c:if test="${tirthDetailsList!=null}">
			
		
				<c:forEach  var="k" items="${tirthDetailsList}" >
				<h1 align="center"><c:out value="${k.tirthName}"></c:out></h1>	
				<tr>
						<td><table width="100%"><font><strong >Importance of Tirth</strong></font>
								   <div class="small_data_black_text1"><c:choose><c:when test="${k.tirthHistory !=null}"><c:out value="${k.tirthHistory}"></c:out></c:when><c:otherwise>-</c:otherwise></c:choose></div>
							</table>
						</td>
					<td><table width="100%">
						<tr>
							<td class="small_data_gray_text_2">Number of Temples</td><td class="small_data_black_text1"><c:choose><c:when test="${k.noOfTemples !=null}"><c:out value="${k.noOfTemples}"></c:out></c:when><c:otherwise>-</c:otherwise></c:choose></td>
						</tr>
						<tr>
							<td class="small_data_gray_text_2">Hills/Mountains</td><td class="small_data_black_text1"><c:choose><c:when test="${k.hillsMountains !=null}"><c:out value="${k.hillsMountains}"></c:out></c:when><c:otherwise>-</c:otherwise></c:choose></td>
						</tr>				
						<tr>
							<td class="small_data_gray_text_2">Other Important Information</td><td class="small_data_black_text1"><c:choose><c:when test="${k.otherInformation !=null}"><c:out value="${k.otherInformation}"></c:out></c:when><c:otherwise>-</c:otherwise></c:choose></td>
						</tr>
						</table>
					</td>
				</tr>

				</c:forEach>
		</c:if>
		</tr>
		<tr>
		<td>
				<table width="100%">
					<font><strong>How to Reach</strong></font>
					<tr height="30" style="color: #FFFFFF;font-weight: bold;" bgcolor="#F58322">
						<td>Railway Station</td>
						<td>Bus Stand</td>
						<td>Airport</td>
						<td>Easiest Way</td>
					</tr>
					<c:if test="${tirthDetailsList!=null}">
						<c:forEach  var="j" items="${tirthDetailsList}">
							<tr>
								<td class="table_value_exception_details"><c:out value="${j.hasRailwayStation}"></c:out></td>
								<td class="table_value_exception_details"><c:out value="${j.hasBusStand}"></c:out></td>
								<td class="table_value_exception_details"><c:out value="${j.hasAirport}"></c:out></td>
								<td class="table_value_exception_details"><c:out value="${j.easiestWay}"></c:out></td>
							</tr>

						</c:forEach>
						</c:if>
				</table>
				
			</td>			
			<td>
				<table width="100%">
					<font><strong>Near by tirth</strong></font>
					<tr height="30" style="color: #FFFFFF;font-weight: bold;" bgcolor="#F58322">
						<td>City</td>
						<td>Distance (km.)</td>
						<td>Railway Station</td>
						<td>Bus Stand</td>
						<td>Airport</td>
						
					</tr>
					<tr>
					<c:if test="${nearByCityList!=null}">
						<c:forEach var="i" items="${nearByCityList}">
							<tr>
								<td class="table_value_exception_details"><c:out value="${i.city}"></c:out></td>
								<td class="table_value_exception_details"><c:out value="${i.distance}"></c:out></td>
								<td class="table_value_exception_details"><c:out value="${i.hasRailwayStation}"></c:out></td>
								<td class="table_value_exception_details"><c:out value="${i.hasBusStand}"></c:out></td>
								<td class="table_value_exception_details"><c:out value="${i.hasAirport}"></c:out></td>
							</tr>

						</c:forEach>
					</c:if>
					</tr>
					<br/>
				</table>
			</td>
		</tr>
		
		
		<tr>
		<table width="100%">
		<font><strong>Available Dharamshala</strong></font>
			<tr height="30" style="color: #FFFFFF;font-weight: bold;" bgcolor="#F58322">
				<td>Serial No</td>
				<td>Dharamshala name</td>
				<td>Address</td>
				<td>City</td>
				<td>Phone No</td>
				<td>Has Bhojan shala</td>
			</tr>
			
			
		<c:if test="${dharamshalaList!=null}">
			<c:forEach var="i" items="${dharamshalaList}" varStatus="loop">
				<tr height="20">
			
					<td class="table_value_exception_details"><a href="#" onclick="getRoomDetails(${i.dsId})" style="text-decoration:underline;color:blue;"><c:out value="${loop.count}"></c:out></a> 
					</td>					
					<td class="table_value_exception_details"><a href="#" onclick="getRoomDetails(${i.dsId})"  style="text-decoration:underline;color:blue;"><c:out value="${i.dsName}"></c:out></a>
					</td>
					<td class="table_value_exception_details"><c:out value="${i.dsAddress}"></c:out>
					</td>
					<td class="table_value_exception_details"><c:out value="${i.dsCity}"></c:out>
					</td>							
					<td class="table_value_exception_details"><c:out value="${i.phoneNo}"></c:out>
					</td>
					<td class="table_value_exception_details"><c:out value="${i.hasBhojanShala}"></c:out></td>
				</tr>
			</c:forEach>
			<form:form method="POST" name="searchRoomForm" commandName="roomSearchForm">
				<form:hidden path="dsId"/>
<%-- 				<form:input path="dsId"/> --%>
			</form:form>
		</c:if>
		<c:if test="${dharamshalaList==null}">
			<tr height="20">
				<td class="table_value_exception_details" colspan="5"> <font color="red"> No Matches Found</font></td>
			</tr>
		</c:if>
		</table>
		</tr>
		</table>
	</div>
	</div>
	</div>
</body>
</html>