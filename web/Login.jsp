<%-- 
    Document   : Login
    Created on : 25 Mar, 2016, 6:05:48 PM
    Author     : Alroy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
			<link rel="stylesheet" type="text/css" href="css/base.css">
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
				<h1>Login to Basement</h1>
				</div>
			</div>
		
	
	
	
			<div id="content">				
			<div id ="content-inner">
			
			<br><br><br>
			
			<font color='red'><b>${errormsg}</b></font>

			<form name="login" id="log" action="LoginServlet" method="post">
            <table>
                <tr><td>ID:</td><td><input type="text" name="id"/></td></tr>
                <tr><td>Password</td><td><input type="password" name="passwd"/></td></tr>
			</table>
            
			<br><br>
			<input type="Submit" style="border: 1px solid #000000;padding:15px;background:white;width:100px;height:40px;text-align:center;color:black;" name="submit" value="Submit" id="sub"/>
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<input style="border: 1px solid #000000;padding:15px;background:white;width:100px;height:40px;text-align:center;color:black;" type="reset" value="Reset">

			
        
			<br><br><br>
			
			Don't have an account? &nbsp&nbsp&nbsp&nbsp
			<a href="Register.jsp">Register here !</a>
			
			<br><br>
			</form>
			
		
			
			</div>
		</div>
	</body>
</html>
