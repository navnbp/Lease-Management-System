<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Look up Apartment </title>

</head>
<body>

<h1 align="center">Lease Management System</h1><br/><br/>
<table  class="table" align='center'  >
<thead><tr><td></td><td></td><td></td><td></td><td></td><td><p align='right'>Welcome ${username} </p></td><td> <a href="signout">
          <span class="glyphicon glyphicon-off">  Signout</span>
        </a> </td></tr></thead>
</table>
 <font color='red'>
          <c:if test="${errorLookApartment!=null}">
				${errorLookApartment}
			</c:if>
</font>
</br>
<table  class="table table-striped">
<caption>Look Up Apartment</caption>
<thead>
<tr><th>Apartment ID</th>
<th>Apartment Type</th>
<th>Facility</th>
<th>Max People</th>
<th>Rent</th>
<th>Deposit</th>
<th>Operation</th>
<th>Appointment Date(By Manager)</th>
<th>Accept/Deny</th> 
</tr>
</thead>
<tbody>
<c:if test="${apartmentLst!= null and apartmentLst.size()!=0}">

<c:forEach items="${apartmentLst}" var="apt">
<c:set scope="page" var="rented" value="FALSE"/>
<!-- OneBHK, TwoBHKOneBath, TwoBHKTwoBath -->
	<c:choose>
  			<c:when test="${apt.apartmentType eq 'OneBHK'}">
    			<c:set scope="page" var="aptType" value="1 BD, 1 Bath" />
  			</c:when>
  			<c:when test="${apt.apartmentType eq 'TwoBHKOneBath'}">
 				<c:set scope="page" var="aptType" value="2 BD, 1 Bath" />
   			</c:when>
  			<c:otherwise>
  				<c:set scope="page" var="aptType" value="2 BD, 2 Bath" />
  			</c:otherwise>
		</c:choose>

		 <c:choose>
			<c:when test="${apt.vacant}">
				<c:set scope="page" var="vacant" value="TRUE"/>
			</c:when>
			<c:otherwise>
				<c:set scope="page" var="vacant" value="FALSE"/>
			</c:otherwise>
		</c:choose> 
<tr><td>${apt.apartmentId}</td>
<td>${aptType}</td>
<td>${apt.facility}</td>
<td>${apt.maximumPeople}</td>
<td>${apt.rent}</td>
<td>${apt.deposit}</td>

<c:set scope="page" var="found" value="FALSE"/>

<c:forEach items="${appointmentLst}" var="ap">

	<c:if test="${ap.apartmentDetails.apartmentId == apt.apartmentId  and ap.userInfo.emailId == LoggedInUserInfo.emailId}">
	
		<c:set scope="page" var="found" value="TRUE"/>
		<c:set scope="page" var="rented" value="FALSE"/>
		<c:if test="${apt.vacant}">
		<c:choose>
			<c:when test="${ap.appointmentStatus eq 'Requested'}">
			<td><b>${ap.appointmentStatus}</b></td><td></td><td></td>
			</c:when>
			<c:otherwise>
			<td><b>${ap.appointmentStatus}</b></td>
			</c:otherwise>
			</c:choose>
			
		</c:if>
		<c:if test="${apt.isRentedOut}">
		<c:set scope="page" var="rented" value="TRUE"/>
			<td><b>Rented Out</b> </td><td></td><td></td>
		</c:if> 
	</c:if>
 
</c:forEach>
<c:choose>
<c:when test="${found eq 'FALSE' and apt.vacant }">
 <td><a href='RequestMapping?aptid=${apt.id}&aptno=${apt.apartmentId}'>Request for appointment</a></td> 
 <td></td><td></td>
</c:when>
<c:when test="${found eq 'FALSE' and apt.isRentedOut}" >
<td><b>Rented Out</b></td> <td></td><td></td>
</c:when>
<c:when test="${found eq 'FALSE'}">
<td></td> <td></td><td></td>
</c:when>
</c:choose>

	<%-- <c:if test="${ apt.isRentedOut eq  Boolean.FALSE}"> --%> 
<!-- Accepted,Requested,Scheduled,Denied,Rescheduled,RescheduledRequested,RentedOut -->	
 	<c:forEach items="${appointmentLst}" var="ap">
	<c:if test="${ ap.apartmentDetails.id eq apt.id and  ap.userInfo.emailId eq LoggedInUserInfo.emailId}">
		<c:choose>
  			<c:when test="${ap.appointmentStatus eq 'Scheduled' or ap.appointmentStatus eq 'RescheduledRequested'}">
    			<td><fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${ap.appointmentDate}" /> </td>
    			<td>
    				<form action='AcceptDenyAppointment' name='acceptDeny' method="post">
						<input type="hidden" name="appointmentid" value="${ap.appointmentId }"/>
						<input type="hidden" name="aptid" value="${ ap.apartmentDetails.apartmentId}"/>
						<input type="hidden" name="id" value="${ ap.apartmentDetails.id}"/>
						<input  type="submit" name='accept' value='accept'/>
						<input  type="submit" name='deny' value='deny'/>
					</form>
    			</td>
  			</c:when>
  			<c:when test="${ap.appointmentStatus eq 'Denied' or ap.appointmentStatus eq 'Accepted' or ap.appointmentStatus eq 'Rescheduled'}">
    			<td><fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${ap.appointmentDate}" /> </td>
    			<td></td>
  			</c:when>
  			<c:otherwise>
    		<td></td><td></td>
  			</c:otherwise>
			</c:choose>
 
	</c:if>
	
	
	
	</c:forEach>	
	
</tr>
</c:forEach>

</c:if>
</tbody>
</table>
</body>
</html>