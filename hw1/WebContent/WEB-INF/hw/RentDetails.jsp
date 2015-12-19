<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Rent Details</title>
</head>
<body>


<h1 align="center">Lease Management System</h1><br/>
<table  class="table" align='center'  >
<thead><tr><td></td><td></td><td></td><td></td><td></td><td><p align='right'>Welcome ${username} </p></td><td> <a href="signout">
          <span class="glyphicon glyphicon-off">  Signout</span>
        </a> </td></tr></thead>
</table>

  <font color='red'>
          <c:if test="${errorPayRent!=null}">
				${errorPayRent}
			</c:if>
          </font>

<br/>


<table class="table table-striped">
 <caption>Pay Rent</caption>
 
 <tr><th>Apartment ID#</th>
<th>User Name </th>
<th>Rent</th>
<th>Rent Paid </th>
<th>Month</th>
<th>Year</th>
<th>Operation</th>
</tr>

<c:forEach items="${rentDetails}" var="rd">
<tr>

<form action="PayRent" method="post">



<td>${rd.aptId}</td>
<td>${rd.userName}</td>
<td>${rd.rent}</td>

<td>
<input type="hidden" name="appointmentId" value="${rd.appointmentId}"/>
<input type="hidden" name="aptId" value="${rd.aptId}"/>
<input type="hidden" name="userName" value="${rd.userName}"/>
<input type="hidden" name="rent" value="${rd.rent}"/>
<input type="text" name="rentPaid"  maxlength="10" required />
</td>
<td>

<select name="month">
  <option value="January">January</option>
  <option value="February">February</option>
  <option value="March">March</option>
  <option value="April">April</option>
  <option value="May">May</option>
  <option value="June">June</option>
  <option value="July">July</option>
  <option value="August">August</option>
  <option value="September">September</option>
  <option value="October">October</option>
  <option value="November">November</option>
  <option value="December">December</option>
</select>


</td>
<td>

<select name="year">
  <option value="2014">2014</option>
  <option value="2015"  selected="selected">2015</option>
  <option value="2016">2016</option>
  <option value="2017">2017</option>
 </select>

</td>
<td>
<input type="submit" value="done"  name="done">

</input>
<%-- <a href="AddRent?amount=${rentPaid}&month=${month}&year=${year}">Done</a> --%>

</td>
</form>
 </tr>
</c:forEach> 
</table>
</br>
<a href="ViewApartment">View Apartment</a>
</body>
</html>