<%-- 
    Document   : Register
    Created on : 9 Apr, 2016, 11:11:47 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
			<link rel="stylesheet" type="text/css" href="css/base.css">
			
		
			
			<script type="text/javascript">

		  function checkForm(form)
		  {
		  
			
			re = /[0-9]/;
			if(!re.test(form.id.value)) {
			  alert("Error: Login ID must contains only numbers");
			  form.id.focus();
			  return false;
			}
			
			re = /^[0-9]{6}$/;
			if(!re.test(form.id.value)) {
			  alert("Error: Login ID should be 6 letters long");
			  form.id.focus();
			  return false;
			}
			
			
			re = /[a-zA-Z0-9_.-@#$%]{6,15}/;
			if(!re.test(form.pass.value)) {
				alert("Error: Password must contain at least six characters!");
				form.pass.focus();
				return false;
			  } 
			 
			if(form.cpass.value == "" || form.pass.value != form.cpass.value) {
				alert("Error: Please check that you've confirmed your password!");
				form.cpass.focus();
				return false;
			}
			
			
			if(form.fname.value === "") {
			  alert("Error: First name cannot be blank!");
			  form.fname.focus();
			  return false;
			}		 

			if(form.lname.value === "") {
			  alert("Error: lastname cannot be blank!");
			  form.lname.focus();
			  return false;
			}
			
			 
			
			 re = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
			  if(!re.test(form.email.value)) {
			  alert("Error: Email should be in correct format");
			  form.email.focus();
			  return false;
			}
			 
			  
		}
		</script>
			
			
			
	</head>

	<body>
		<div id="page">
			<header>
				<div id="header">	
					<div id="logo">
						<h1><a href="#">Basement<span>.com</span></a></h1>
					</div>
					
					<div class="clr"></div>
				</div>
			</header>
			
			<div class="feature">
				<div class="feature-inner">
				<h1>Create your Basement account</h1>
				</div>
			</div>
	
			<div id="content">				
			<div id ="content-inner">
			
			<form name="registerForm" onsubmit="return checkForm(this);" action="RegisterServlet" method="post">
		 
			<table> 
					
					<tr>
						<td>ID &nbsp;&nbsp; :</td> 
				<td> <input type="text" name="id"><font color="Red"><a id="idwarn"></a></font> </td>
					</tr>   
						
					<tr> <br>
				<td>Password &nbsp;&nbsp; :</td> 
				<td> <input type="password" name="pass"> <font color="Red"><a id="passwarn"></a></font></td>
					</tr>
					
					<tr> 
				<td>Confirm Password &nbsp;&nbsp; :</td> 
				<td> <input type="password" name="cpass"> <font color="Red"><a id="conwarn"></a></font></td>
					</tr>
					
					<tr> 
				<td>First Name  &nbsp;&nbsp; :</td> 
						<td> <input type="text" name="fname"><font color="Red"><a id="fnamewarn"></a></font> </td>  
					</tr>
					
					<tr> 
				<td>Last Name &nbsp;&nbsp; :</td> 
				<td> <input type="text" name="lname"> <font color="Red"><a id="lnamewarn"></a></font></td>
					</tr>
					<tr> 
				<td>Email ID &nbsp;&nbsp; :</td> 
				<td> <input type="text" name="email"> <font color="Red"><a id="emailwarn"></a></font></td>
					</tr>
					<tr>  
				<td colspan=2> </td>
					</tr>
			</table>
		<br><br>
		
		<center>
		<input type="submit" value="Register" id="button" style="border: 1px solid #000000;padding:15px;background:white;width:100px;height:40px;text-align:center;color:black;"/>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<input style="border: 1px solid #000000;padding:15px;background:white;width:100px;height:40px;text-align:center;color:black;" type="reset" value="Reset">
		</center>
		<br><br>
			
			Already have an account? &nbsp&nbsp
			<a href="Login.jsp" >Login here !</a>
			<br><br>
			</form>
			
		
			
			</div>
		</div>
	</body>
</html>
