<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  
  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add Apartment</title>



 <script type='text/javascript'  src='http://code.jquery.com/jquery-1.8.3.js'></script>
<script type='text/javascript'  src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.1.0/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"  href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css"/>
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" /> -->
 
  
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

<%-- <div class="row">
<div class=".col-md-6">
<p align='right'>Welcome  ${username}</p> 
</div>
 <div class="col-md-6"><a href='signout'>Signout</a></div>
</div> --%>

<%-- <div class="row">
<div align="right">
<p >Welcome  ${username}</p> <a href="signout">
          <span class="glyphicon glyphicon-off">  Signout</span>
        </a>
</div>

</div>  --%>
<table  class="table" align='center'  >
<thead><tr><td></td><td></td><td></td><td></td><td></td><td><p align='right'>Welcome ${username} </p></td><td> <a href="signout">
          <span class="glyphicon glyphicon-off">  Signout</span>
        </a> </td></tr></thead>
</table>


<div class="container">
    <div class="hero-unit">
      <div class="row-fluid">
        <div class="offset4 span4">
          <legend>Add Apartment </legend>
          <div class=".error">
          <font color='red'>
          <c:if test="${errorAddApar!=null}">
				${errorAddApar}
			</c:if>
          </font>
          </div>
         <div></br></div>
          <form class="form-horizontal" action='AddApartment' method='post'>
            
            <div class="control-group">
             	 <label class="control-label" for="apartmentId">Apartment#</label>
              	<div class="controls">
              	<input type='text' name='apartmentId' maxlength='10' placeholder='Apartment ID' required />
              </div>
            </div>
            
            <div class="control-group">
              <label class="control-label" for="apartmentType">Type</label>
              <div class="controls">
				<input type='radio' name='apartmentType' value='OneBHK' checked='checked'>1BHK</input><br/>
				<input type='radio' name='apartmentType' value='<c:out value='TwoBHKOneBath'></c:out>' >2BHK - 1 Bath</input><br/>
				<input type='radio' name='apartmentType' value='<c:out value='TwoBHKTwoBath'></c:out>' >2BHK - 2 Bath</input><br/>
               </div>
            </div>
           
           
            <div class="control-group">
              <label class="control-label" for="apartmentType">Facilities</label>
              <div class="controls">
				<textarea rows='4' cols='30' name='facility'> </textarea>
				</div>
            </div>
           
           
           <div class="control-group">
              <label class="control-label" for="maximumPeople">Maximum People </label>
              <div class="controls">
				<input type='text' name='maximumPeople' maxlength='2' placeholder='Max People' />
					</div>
            </div>
            
            <div class="control-group">
              <label class="control-label" for="rent">Rent</label>
              <div class="controls">
				<input type='text' name='rent' maxlength='10' placeholder='Rent' required />
				
				</div>
            </div>
            
            <div class="control-group">
              <label class="control-label" for="deposit">Deposits</label>
              <div class="controls">
				<input type='text' name='deposit' maxlength='10' placeholder='Deposit' required/>
				</div>
            </div>
           
            <div class="control-group">
              <div class="controls">
               
             <input type='submit' class="btn" name='password' value='submit'/> &nbsp; &nbsp;
             <input type='reset' class="btn" name='clear' value='clear' />
              </div>
             
            </div>
            <div><br/></div>
            <div class="control-group">
           
              <div class="controls">
              <a href="ManagerHome"> Home</a>
              </div>
            </div>
         </form>
        </div>
      </div>
    </div>
  </div>


















<%-- 
<form action='AddApartment' method='post'>
<table>
<tr><td></td><td><h4>Welcome <c:out value="${username}"/></h4></td><td><a href='signout'>Signout</a></td></tr>
<tr><td>Apartment#</td><td><input type='text' name='apartmentId' maxlength='10' placeholder='Apartment ID' required /></td></tr>
<tr><td>Type</td><td><input type='radio' name='apartmentType' value='OneBHK' checked='checked'>1BHK</input><br/>
<input type='radio' name='apartmentType' value='<c:out value='TwoBHKOneBath'></c:out>' >2BHK - 1 Bath</input><br/>
<input type='radio' name='apartmentType' value='<c:out value='TwoBHKTwoBath'></c:out>' >2BHK - 2 Bath</input><br/></td></tr>
<tr><td>Facilities</td><td><textarea rows='4' cols='30' name='facility'   > </textarea></td></tr>
<tr><td>Maximum People</td><td><input type='text' name='maximumPeople' maxlength='2' placeholder='Max People' /></td></tr>
<tr><td>Rent</td><td><input type='text' name='rent' maxlength='8' placeholder='Rent' required /></td></tr>
<tr><td>Deposits</td><td><input type='text' name='deposit' maxlength='8' placeholder='Deposit' required/></td></tr>
<tr></tr><tr></tr><tr><td><input type='submit' name='submit' value='submit'/></td><td><input type='reset' name='clear' value='clear'/></td></tr>
</table>
<br/><br/><a href="ManagerHome"> Home</a> --%>
</body>
</html>