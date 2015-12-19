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


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register Resident</title>


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

 <div class="container">
    <div class="hero-unit">
      <div class="row-fluid">
        <div class="offset4 span4">
          <legend>Register </legend>
          <div class=".error">
          <font color='red'>
          <c:if test="${errorReg!=null}">
				${errorReg}
			</c:if>
          </font>
          </div>
         <div></br></div>
          <form class="form-horizontal" action='RegisterResident' method='post'>
            
            <div class="control-group">
             	 <label class="control-label" for="username">Username</label>
              	<div class="controls">
              	<input type='text' name='username' maxlength='25' placeholder='User Name' required/>
              </div>
            </div>
            
            <div class="control-group">
              <label class="control-label" for="emailid">Email ID</label>
              <div class="controls">
				<input type='text' name='emailid' maxlength='30' placeholder='Email ID' required />
               </div>
            </div>
          
            <div class="control-group">
              <label class="control-label" for="password">Password  </label>
              <div class="controls">
					<input type='password' placeholder='Password' name='password' maxlength='20' required />
               </div>
            </div>
            
            <div class="control-group">
              <label class="control-label" for="confirmPassword">Confirm Password  </label>
              <div class="controls">
		<input type='password' placeholder='Password' name='confirmPassword' maxlength='20' required />
               </div>
            </div>
        
            <div class="control-group">
              <label class="control-label" for="contact">Contact#  </label>
              <div class="controls">
		<input type='text' name='contact' placeholder='Mobile no' maxlength='12' />
               </div>
            </div>
        
            <div class="control-group">
              <label class="control-label" for="people"> #People </label>
              <div class="controls">
				<input type='text' name='people' maxlength='2' />
               </div>
            </div>
            
          
           <div class="control-group">
              <label class="control-label" for="occupation">Occupation </label>
              <div class="controls">
			<input type='radio' name='occupation' value='Student'>Student</input><br>
			<input type='radio' name='occupation' value='Family' checked='checked'>Family</input><br>
			<input type='radio' name='occupation' value='Businees' >Business</input><br>
               </div>
            </div>
            
            <div class="control-group">
              <label class="control-label" for="apartmentType">Apartment Type </label>
              <div class="controls">
			<input type='radio' name='apartmentType' value='OneBHK' checked='checked'>1BHK</input><br>
			<input type='radio' name='apartmentType' value='TwoBHKOneBath' >2BHK - 1Bath</input><br>
			<input type='radio' name='apartmentType' value='TwoBHKTwoBath' >2BHK - 2 Bath</input><br>
               </div>
            </div>
            
            <div class="control-group">
              <label class="control-label" for="preference">Facilites </label>
              <div class="controls">
			<textarea rows='4' cols='50' name='preference' maxlength='200' > </textarea>
               </div>
            </div>
            
            <div class="control-group">
              <label class="control-label" for="emailid">Need From Date </label>
              <div class="controls">
			<input type='text' placeholder='mm/dd/yyyy hh:mm:ss' name='date' required/>
			
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
             <a href='Login'>Login</a>
              </div>
            </div>
         </form>
        </div>
      </div>
    </div>
  </div>













<!--
<form class="form-horizontal" action='RegisterResident' method='post'><h1>Lease Management System</h1><br/>

     
 <tr><td>Username</td><td><input type='text' name='username' maxlength='25' placeholder='User Name' required/></td></tr>
<tr><td>Email ID</td><td><input type='text' name='emailid' maxlength='30' placeholder='Email ID' required></input></td></tr>
<tr><td>Password</td><td><input type='password' placeholder='Password' name='password' maxlength='20' required></input></td></tr>
<tr><td>Confirm Password</td><td><input type='password' placeholder='Password' name='confirmPassword' maxlength='20' required></input></td></tr>
<tr><td>Contact#</td><td><input type='text' name='contact' placeholder='Mobile no' maxlength='12' ></input></td></tr>
<tr><td>#People</td><td><input type='text' name='people' maxlength='2' /></td></tr>
<tr><td></td><td><input type='radio' name='occupation' value='Student'>Student</input><br>
<input type='radio' name='occupation' value='Family' checked='checked'>Family</input><br>
<input type='radio' name='occupation' value='Businees' >Business</input></td></tr><br>
<tr><td>Type</td><td><input type='radio' name='apartmentType' value='OneBHK' checked='checked'>1BHK</input><br>
<input type='radio' name='apartmentType' value='TwoBHKOneBath' >2BHK - 1Bath</input><br>
<input type='radio' name='apartmentType' value='TwoBHKTwoBath' >2BHK - 2 Bath</input><br></td></tr>
<tr><td>Facilites</td><td><textarea rows='4' cols='50' name='preference' maxlength='200' > </textarea></td></tr>
<tr><td>Need From Date</td><td><input type='text' placeholder='mm/dd/yyyy hh:mm:ss' name='date' required/>

</td></tr>
<tr><td><input type='submit' value='submit' name='submit'/></td><td><input type='reset' value='clear' name='clear'/></td></tr>
 
 </form>
</table>
<br/><br/><a href='Login'>Login</a></html>-->
</body>
</html>