<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View Apartment </title>
</head>
<body>
<form action='ViewApartment' method='post'>
<h1 align="center">Lease Management System</h1><br/></br>
 
 
<table class="table" cellspacing='12' text-align='center'>
<thead><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td><p align='right'>Welcome  ${username} </p></td><td><a href="signout">
          <span class="glyphicon glyphicon-off">  Signout</span>
        </a>
        </a> </td></tr></thead>
</table>

<div align="right">
<a style="color:red" href='PayRent'>Pay Rent  </a>  <span style="padding-left: 150px;padding-right :100px;color:red">  <a  href="RentHistory"  style="color:red" >Show Rent History</a> </span>   
</div>



<table  class="table table-striped">
<caption>Apartment Details</caption>
<thead><tr><th>Apartment ID</th><th>Apartment Type</th><th>Facility</th><th>Max People</th><th>Rent</th><th>Deposit</th><th>Vacant</th><th>Change Availability</th><th>Appointment</th></tr></thead>

 <tbody>
<c:if test="${apLst!=null && apLst.size()!=0 }">
<c:forEach items="${apLst}" var="apt">

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

<tr>

<td>${apt.apartmentId}</td>
<td>${aptType}</td>
<td>${ apt.facility}</td>
<td>${apt.maximumPeople}</td>
<td>${apt.rent}</td>
<td>${apt.deposit}</td>


<c:choose>
	<c:when test="${not apt.vacant }">
		<c:set scope="session" var="aptid" value="${ apt.getApartmentId()}" />
		<td>NO</td>
		<td><a href="makeAvailable?aptid=${apt.id}" >Make Available </a></td>
			<td><a href="ViewAppointment?aptid=${apt.id}" >View </a></td>
	</c:when>
	<c:when test="${apt.vacant}">
		<c:set scope="session" var="aptid" value="${apt.getApartmentId()}" />
		<td>YES</td>
		<td></td>
		<td><a href="ViewAppointment?aptid=${apt.id}" >View </a></td>
	</c:when>
	<c:otherwise>
	<td></td>
	<td></td>
	</c:otherwise>
</c:choose>

</tr>
</c:forEach>

</c:if>
</tbody>
</table>
<br/><br/><br/>&nbsp; &nbsp;&nbsp; &nbsp;<a href='ManagerHome'>Home</a>
&nbsp; &nbsp;&nbsp; &nbsp;

</html>
</form>
</body>
</html>