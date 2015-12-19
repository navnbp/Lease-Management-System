<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script type='text/javascript'  src='http://code.jquery.com/jquery-1.8.3.js'></script>
<script type='text/javascript'  src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.1.0/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"  href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css"/>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Manager Home</title>

<style type='text/css'>
.container {
  margin-top: 10px;
}

.hero-unit {
  padding: 50px 50px 50px 50px;
}

.form-horizontal .control-label {
  width: 61px;
}

.form-horizontal .controls {
  margin-left: 20px;
}
/* Landscape phone to portrait tablet */
@media ( max-width : 767px) {
}
/* Landscape phones and down */
@media ( max-width : 480px) {
  .hero-unit {
    margin-left: -20px;
    margin-right: -20px;
  }
  .form-horizontal .controls {
    margin-left: 0;
  }
}

</style>
</head>
<body>
<h1 align="center">Lease Management System</h1><br/></br>
<div class="row">
	<div class="col-md-8">
		<p align='right'>Welcome  ${username}</p> 
	</div>
 	<div class="col-md-4">
 		<a href="signout">
          <span class="glyphicon glyphicon-off">  Signout</span>
        </a>
 		
 		 
 	</div>
</div>

<div class="container">
    <div class="hero-unit">
      <div class="row-fluid">
        <div class="offset4 span4">
   <div class="control-group">
             	
              	<div class="controls">
              	<a href='AddApartment'>Add Apartment</a>
              </div>
            </div>
            
               <div class="control-group">
             	
              	<div class="controls">
              	<a href='ViewApartment'>View Apartment</a>
              </div>
            </div>
</div></div>
</div></div>

<!-- <table>
<tr></tr>
<tr></tr>
<tr><td></td><td><a href='AddApartment'>Add Apartment</a></td><td></td></tr><tr></tr>
<tr></tr>
<tr><td></td><td><a href='ViewApartment'>View Apartment</a></td><td></td></tr>
<tr></tr>


</table> -->

</body>
</html>