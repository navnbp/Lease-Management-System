<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">



<head>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lease Details</title>
</head>
<body>
<h1 align="center">Lease Management System</h1><br/>
<table  class="table" align='center'  >
<thead><tr><td></td><td></td><td></td><td></td><td></td><td><p align='right'>Welcome ${username} </p></td><td> <a href="signout">
          <span class="glyphicon glyphicon-off">  Signout</span>
        </a> </td></tr></thead>
</table>

  <font color='red'>
          <c:if test="${errorDisplayFeedback!=null}">
				${errorDisplayFeedback}
			</c:if>
          </font>

<br/>
<table class="table table-striped">
 <caption>Lease Details</caption>
<tr><th>Apartment#</th>
<th>Leaseholder Name </th>
<th>Lease Termination Date</th>
<th>Documents</th>
<th>Rent</th>
<th>Deposit</th>
<th>Comments</th>
</tr>
<c:forEach items="${leaseDetails}" var="ld">


<tr>
 <td>${ld.aptId}</td> 
<td>${ld.leaseHoldername}</td>
<td><fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${ld.leaseTerminationDate}" /></td>
<td>${ld.docs}</td>
<td>${ld.rent}</td>
<td>${ld.deposit}</td>
<td>${ld.comments}</td>
 </tr>
</c:forEach>


</table>
<br/>
<br/>
<a href='ViewApartment'>View Apartment</a>
</body>
</html>

