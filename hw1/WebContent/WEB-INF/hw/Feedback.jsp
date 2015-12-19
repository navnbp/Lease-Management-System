<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="cs320.hw.entity.Apartment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="java.math.BigDecimal" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<head>

<script type='text/javascript'  src='http://code.jquery.com/jquery-1.8.3.js'></script>
<script type='text/javascript'  src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.1.0/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"  href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css"/>

<title>Lease Management System</title>


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
  margin-left: 80px;
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

.error{
    font:10px Tahoma,sans-serif;
    color:#ED7476;
    margin-left:5px;
    display:inline;
}

</style>


</head>
<body>
<h1 align="center">Lease Management System</h1><br/>

<table  class="table" align='center'  >
<thead><tr><td></td><td></td><td></td><td></td><td></td><td><p align='right'>Welcome ${username} </p></td><td> <a href="signout">
          <span class="glyphicon glyphicon-off">  Signout</span>
        </a> </td></tr></thead>
</table>
<div class="container">
    <div class="hero-unit">
      <div class="row-fluid">
        <div class="offset4 span4">
          <legend>Feedback </legend>
          <div class=".error">
          <font color='red'>
          <c:if test="${errorFeedback!=null}">
				${errorFeedback}
			</c:if>
          </font>
          </div>
         <div></br></div>
          <form class="form-horizontal" action='Feedback' method='post'>
           
        <c:forEach  items="${apLst}" var="apartment">
				<c:if test="${aptId==apartment.id}" >
 					<c:choose>
  						<c:when test="${apartment.apartmentType eq ApartmentType.OneBHK}">
    						<c:set scope="page" var="aptType" value="1 BD, 1 Bath" />
  						</c:when>
  						<c:when test="${apartment.apartmentType eq ApartmentType.TwoBHKOneBath}">
 							<c:set scope="page" var="aptType" value="2 BD, 1 Bath" />
   						</c:when>
			  			<c:otherwise>
  							<c:set scope="page" var="aptType" value="2 BD, 2 Bath" />
  						</c:otherwise>
					</c:choose>
		
		<div class="control-group">
             	 <label class="control-label" for="ApartmentID">Apartment ID#</label>
              	<div class="controls">
        			${apartment.apartmentId}
              </div>
              </div>
		
		    <div class="control-group">
             	 <label class="control-label" for="ApartmentType">Apartment Type</label>
              	<div class="controls">
        			${aptType}
              </div>
            </div>

		    <div class="control-group">
             	 <label class="control-label" for="facility">Facility</label>
              	<div class="controls">
        			<textarea rows='4' cols='30'  readonly="readonly" >${ apartment.getFacility() } </textarea>
              	</div>
            </div>
        
		    <div class="control-group">
             	 <label class="control-label" for="rent">Rent</label>
              	<div class="controls">
        		<input type='text' value='${ apartment.rent}' name='rent'  />
              </div>
            </div>
            
             <div class="control-group">
             	 <label class="control-label" for="deposit">Deposit</label>
              	<div class="controls">
        		<input type='text' value='${ apartment.deposit }'  name='deposit' />
              </div>
            </div>
	</c:if>

</c:forEach>
           
           
            <div class="control-group">
             	 <label class="control-label" for="name">Lease Holder Name</label>
              	<div class="controls">
        <input type='text' name='name' maxlength='25'  required placeholder='Name'></input>
              </div>
            </div>
           
               <div class="control-group">
             	 <label class="control-label" for="docs">List of Documents</label>
              	<div class="controls">
     			   <textarea rows='4' cols='30' name='docs' maxlength='60' ></textarea>
              </div>
            </div>
           
               <div class="control-group">
             	 <label class="control-label" for="comments">Comments</label>
              	<div class="controls">
        		<textarea rows='4' cols='30' name='comments'  ></textarea>
              </div>
            </div>
           
               <div class="control-group">
             	 <label class="control-label" for="date">Lease Termination Date</label>
              	<div class="controls">
        			<input type='text' name='date' maxlength='20' required placeholder='mm/dd/yyyy hh:mm:ss'></input>
              </div>
            </div>
              
             <div class="control-group">
              <div class="controls">
               
             <input type='submit' class="btn" name='password' value='submit'/> &nbsp; &nbsp;
             <input type='reset' class="btn" name='clear' value='clear' />
              </div>
             
            </div>
           
         </form>
        </div>
      </div>
    </div>
  </div>



<%-- <h1>Feedback</h1>

<br/>


<font color='red'>
<c:if test="${errorFeedback!=null}">
${errorFeedback}
</c:if>
</font><br/><br/>
<table>
<form action='Feedback' method="post">

<c:forEach  items="${aptList}" var="apartment">
	<c:if test="${aptId==apartment.apartmentId}" >
 		<c:choose>
  			<c:when test="${apartment.apartmentType eq ApartmentType.OneBHK}">
    			<c:set scope="page" var="aptType" value="1 BD, 1 Bath" />
  			</c:when>
  			<c:when test="${apartment.apartmentType eq ApartmentType.TwoBHKOneBath}">
 				<c:set scope="page" var="aptType" value="2 BD, 1 Bath" />
   			</c:when>
  			<c:otherwise>
  				<c:set scope="page" var="aptType" value="2 BD, 2 Bath" />
  			</c:otherwise>
		</c:choose>
		
<tr><td>Apartment Type</td><td>${aptType}</td></tr>
<tr><td>Facility</td><td><textarea rows='4' cols='30'  readonly="readonly" >${ apartment.getFacility() } </textarea></td></tr>
<tr><td>Rent</td><td><input type='text' value='${ apartment.rent}' name='rent'  /></td></tr>
<tr><td>Deposit</td><td><input type='text' value='${ apartment.deposit }'  name='deposit' /></td></tr>
	</c:if>

</c:forEach>

<tr><td></td><td></td></tr>
<tr><td></td><td></td></tr>

<tr><td>Lease Holder Name</td><td><input type='text' name='name' maxlength='25'  required placeholder='Name'></input></td></tr>
<tr><td>List of Documents</td><td><textarea rows='4' cols='30' name='docs' maxlength='60' ></textarea></td></tr>
<tr><td>Comments</td><td><textarea rows='4' cols='30' name='comments'  ></textarea></td></tr>
<tr><td>Lease Termination Date</td><td><input type='text' name='date' maxlength='20' required placeholder='mm/dd/yyyy hh:mm:ss'></input>

<tr></tr>
<tr><td></td><td><input type='submit' name='submit'  value='submit' />&nbsp &nbsp<input type='reset' value='clear'/></td></tr>

</form>
</table> --%>
</body>
</html>