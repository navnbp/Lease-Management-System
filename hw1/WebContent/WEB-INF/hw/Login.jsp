<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type='text/javascript'  src='http://code.jquery.com/jquery-1.8.3.js'></script>
<script type='text/javascript'  src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.1.0/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"  href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

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


<title>Lease Management System</title>
</head>
<body>


 <div class="container">
    <div class="hero-unit">
      <div class="row-fluid">
        <div class="offset4 span4">
          <legend>Sign in </legend>
          <div class=".error">
          <font color='red'>
          <c:if test="${errorLogin!=null}">
				${errorLogin}
			</c:if>
          </font>
          </div>
         <div></br></div>
          <form class="form-horizontal" action='Login' method='post'>
            
            <div class="control-group">
             	 <label class="control-label" for="emailidS">Email</label>
              	<div class="controls">
              		<input type='text' name='emailid' maxlength='30' placeholder='Email' required />
              </div>
            </div>
            
            <div class="control-group">
              <label class="control-label" for="inputPassword">Password</label>
              <div class="controls">
				<input type='password' name='password' maxlength='20' placeholder='Password' required/>
               </div>
            </div>
            <div class="control-group">
              <div class="controls">
               
             <input type='submit' class="btn" name='password' value='submit'/> &nbsp; &nbsp;
             <input type='reset' class="btn" name='clear' value='clear' />
              </div>
             
            </div>
            <div class="control-group">
           
              <div class="controls">
                <a  href='RegisterResident'>Register</a>
              </div>
            </div>
         </form>
        </div>
      </div>
    </div>
  </div>




<%--  <form action='Login' method='post'>
<h1>Lease Management System</h1><br/>
<br/>

<h5><font color='red'>
<c:if test="${errorLogin!=null}">
${errorLogin}"
</c:if>
</font></h5>

<table>
<tr><td></td><td><h4>Login</h4></td></tr>
<tr><td>EmailID</td><td><input type='text' name='emailid' maxlength='30' placeholder='EmailID' required /></td></tr>
<tr><td>Password</td><td><input type='password' name='password' maxlength='20' placeholder='Password' required/></td> </tr><tr></tr>
<tr><td><input type='submit' name='password' value='submit'/></td><td><input type='reset' name='clear' value='clear' /></td> </tr><tr></tr>
<tr><td></td><td><a href='RegisterResident'>Register</a></td></tr>
</table>
</form> --%>
 
</body>
</html>