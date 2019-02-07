<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<div class="col-sm-4">
<h1 >Registration Form</h1>
<h3>${msg}</h3>
<form action="insertUserDetails">
<div class="form-group">
 <label >NAME:</label>
<input type="text" name="name" class="form-control" />
</div>

<div class="form-group">
<label>GENDER :</label> 
<input type="radio" name="gender" value="male"> Male	
<input type="radio" name="gender" value="female"> Female	
<input type="radio" name="gender" value="other"> Other
</div>

<div class="form-group">
<label>DATE OF BIRTH :</label> 
<input type="text" name="dob" class="form-control"/>
</div>

<div class="form-group">
<label>RELIGION :</label> 
 <select name="religion">
                   <option value="hindu">HINDU</option>
  		           <option value="mushlim">MUSHLIM</option>
  		           <option value="shikh">SHIKH</option>
  		           <option value="christian">CHRISTIAN</option> 
                   </select>
</div>
<div class="form-group">
<label>Mother Tongue :</label> 
 <input type="text" name="mother_tongue" class="form-control"/>
</div>

<div class="form-group">
<label>Caste / Division :</label> 
 <input type="text" name="caste" class="form-control"/>
</div>

<div class="form-group">
<label>Country :</label> 
<input type="text" name="country" class="form-control"/>
</div>

<div class="form-group">
<label>MOBILE NO. :</label> 
 <input type="text" name="mobile" class="form-control"/>
</div>

<div class="form-group">
<label>EMAIL-ID :</label> 
 <input type="text" name="email" class="form-control"/>
</div>

<div class="form-group">
<label>PASSWORD :</label> 
<input type="password" name="password" class="form-control"/>
</div>

<input type="submit" value="REGISTER" class="btn btn-primary">
</form>
</div>
</div>
</body>
</html>