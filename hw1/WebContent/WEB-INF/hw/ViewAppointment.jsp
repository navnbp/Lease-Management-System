<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">



<%! @SuppressWarnings("unchecked") %>
<head>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View Appointment</title>
</head>

<%-- <c:set scope="page" var="defaultDate" value="01/01/1900 10:00:00" /> --%>


<body>
<h1 align="center">Lease Management System</h1><br/></br>
<div class="row">
<div class="col-md-10">
<p align='right'>Welcome  ${username}</p> 
</div>
 <div class="col-md-2"><a href="signout">
          <span class="glyphicon glyphicon-off">  Signout</span>
        </a> </div>
</div>
<font color='red'>
<c:if test="${errorDate!=null}">
${errorDate}"
</c:if>
</font>


<c:forEach items="${apartmentLst}" var="apt">

<c:if test="${aptid == apt.id}">

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


		<table class="pure-table pure-table-horizontal" >
		<tr><td>Apartment#</td><td>${apt.apartmentId }</td></tr>
		<tr><td>Apartment Type</td>
		<td>${aptType }
		<%-- <input type='radio' name='apartmentType' ${ apt.apartmentType eq ApartmentType.OneBHK?"checked":"disabled" } readonly="readonly" > 1BHK</input><br>
		<input type='radio' name='apartmentType' ${ apt.apartmentType eq ApartmentType.TwoBHKOneBath?"checked":"disabled" }   readonly="readonly" >2BHK - 1Bath</input><br>
		<input type='radio' name='apartmentType'${ apt.apartmentType eq ApartmentType.TwoBHKTwoBath?"checked":"disabled" }  readonly="readonly" > 2BHK - 2 Bath</input>
		 --%></td></tr>
		<tr><td>Facilites</td><td><textarea rows='2' cols='20'  readonly="readonly" >${apt.facility } </textarea></td></tr>
		<tr><td>Maximum people</td><td><input type="text" value='${ apt.maximumPeople }' readonly="readonly" /></td></tr>
		<tr><td>Rent</td><td><input type="text" value='${  apt.rent }'  readonly="readonly" ></input></td></tr>
		<tr><td>Deposits</td><td><input type="text" value='${  apt.deposit }'  readonly="readonly" ></input></td></tr>
		</table>
</c:if>
</c:forEach>


<table class="table table-striped" >
 <caption>Applications</caption>
<thead><tr><th>Appointment#</th>
<th>Applicant Name</th>
<th>Contact#</th>
<th>#People</th>
<th>Occupation</th>
<th>Preferences</th>
<th>Need from Date</th>
<th>Appointment Date</th>
<th>Status</th>
<th>Rescheduled Date</th>
<th>Ruled out Dates</th>
<th>Rent Out</th></tr>
</thead>
<tbody>
 <c:forEach items="${appointmentLst}" var="app">
 <c:if test="${aptid eq app.apartmentDetails.id}">
 
	<tr>
 	<td>${app.appointmentId }</td>
	<td>${app.userInfo.username}</td>
	<td>${app.userInfo.mobile}</td>
	<td>${app.userInfo.people}</td>
	<td>${app.userInfo.occupation}</td>
	<td>${app.userInfo.preference}</td>
	<td><fmt:formatDate pattern="MM/dd/yyyy" value="${app.userInfo.needFrom}" /></td>
 
 	<c:choose>
 		<c:when test="${app.appointmentStatus eq 'Requested' }">
 		<td></td>
 		</c:when>
 		<%-- <c:when test="${app.appointmentDate eq defaultDate }">
 		<td></td>
 		</c:when> --%>
 		<c:otherwise>
 		<td>	<fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${app.appointmentDate}" /></td>
 		</c:otherwise>
 	</c:choose>
 
 <td>${app.appointmentStatus }</td>
 <td>
 
 <!-- Accepted,Requested,Scheduled,Denied,Rescheduled,RescheduledRequested,RentedOut -->


<c:if test="${app.appointmentStatus eq 'Denied' or app.appointmentStatus eq 'Requested' or app.appointmentStatus.toString() eq 'Rescheduled' }">
	<form id="reappointment" action='createAppointment' method="post">
		<input  type="hidden" name='appointmentId' value='${ app.appointmentId }'  />
		<input type="hidden" name='aptId' value='${ app.apartmentDetails.id }' ></input> 
		<%-- <input type="hidden" name='id' value='${ app.apartmentDetails.id }' ></input> --%> 
		<input type="text" name='appointmentDate' maxlength="25" placeholder='mm/dd/yyyy hh:mm:ss' ></input>
		
 		<c:choose >
 		<c:when test="${app.appointmentStatus eq 'Requested' }">
 		<input type="submit" name="reappointmentSchedule" value="Schedule"/>
 		</c:when>
 		<c:otherwise>
 		<input type="submit" name="reappointmentSchedule" value="ReSchedule"/>
 		</c:otherwise>
 		</c:choose>
 	</form>
</c:if>
</td>
<td>
<%-- <c:if test="${app.ruledOutDate ne defaultDate }"> --%>
	<ul>
		<c:forEach items="${app.ruledOutDate}" var ="d">
			<li><fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${d}" /></li>
		</c:forEach>
	</ul>
<%-- </c:if> --%>
</td>
 
 <td>
 
	 <c:if test="${ app.appointmentStatus eq 'Accepted'}">
		<a href='Rentout?appointmentid=${app.appointmentId}&aptId=${app.apartmentDetails.id}'>Rent</a> 
 	</c:if>

</td>
</c:if>
 </tr>
 </c:forEach>
 </tbody>
</table></br></br> &nbsp; &nbsp;&nbsp; &nbsp;
<a href='ViewApartment' > View Apartments</a>
</body>
</html>