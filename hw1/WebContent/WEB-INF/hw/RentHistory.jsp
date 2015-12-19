
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>


<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Rent History</title>
</head>
<body>


<h1 align="center">Lease Management System</h1><br/>
<table  class="table" align='center'  >
<thead><tr><td></td><td></td><td></td><td></td><td></td><td><p align='right'>Welcome ${username} </p></td><td> <a href="signout">
          <span class="glyphicon glyphicon-off">  Signout</span>
        </a> </td></tr></thead>
</table>

  <font color='red'>
          <c:if test="${errorRentHistory!=null}">
				${errorRentHistory}
			</c:if>
          </font>

<br/>


<table class="table table-striped">
 <caption>Rent History</caption>
 
 <tr><th>Apartment ID#</th>
<th>User Name </th>
<th>Rent</th>
<th>Rent Paid </th>
<th>Month</th>
<th>Year</th>
</tr>


<c:forEach items="${rentDetails}" var="rd">
<tr>
<td>${rd.aptId}</td>
<td>${rd.userName}</td>
<td>${rd.rent}</td>
<td>${rd.rentPaid}</td>
<td>${rd.month}</td>
<td>${rd.year}</td>


</tr>
</c:forEach>
</table>
</br>
<a href="ViewApartment">View Apartment</a>
</body>
</html>