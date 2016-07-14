<%-- 
    Document   : Profile
    Created on : 8 Apr, 2016, 3:41:50 PM
    Author     : Alroy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Files"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Profile</title>
			<link rel="stylesheet" type="text/css" href="css/profile.css">

	</head>
	<body>
		<div id="page">
			<header id="header">
				<div id="header-inner">	
					<div id="logo">
						<h1><a href="#">Basement<span>.com</span></a></h1>
					</div>
					<div id="top-nav">
						<ul>
						<li><a href="#">Home</a></li>
						<li><a href="LogoutServlet">Sign out</a></li>
						</ul>
					</div>
					<div class="clr"></div>
				</div>
			</header>
			<div class="feature">
				<div class="feature-inner">
				<h1>Welcome ${fname} ${lname} </h1>
                                <h3>${id}</h3>
				</div>
			</div>
		
	
			<div id="content">
				<div id="content-inner">
				
					<main id="contentbar">
						<div class="article">
							
							
						<form method="post" action="UploadServlet" enctype="multipart/form-data">
						Select file to upload:
						<input type="file" name="uploadFile" />
						<br>    
							
						<div>
						<input type="submit" value="Upload" id="upload" style = "border: 1px solid #000000;padding:10px;width:100px;background:white;">
						</div>
							
						</form>	
							
							
						<p>${message} <b>${filename}</b></p>
						<br>
						<p><h3>My Files</h3></p>
                                                <table id="t1">
                                                    <thead align="left">
                                                        <tr>
                                                            <th>Files</th>
                                                            <th>Size(in bytes)</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
						<c:forEach items="${addlist}" var="a">
                                                    <tr id="r1"><td><c:out value="${a.filename}"/></td>
                                                        <td><c:out value="${a.size}"/></td></tr>
							
						</c:forEach>
                                                    </tbody>
                                                </table>
                                                <br>
                                                <h3><a>Shared with me</a></h3>
                                                <table id="t1">
                                                    <thead align="left">
                                                        <tr>
                                                            <th>Files</th>
                                                            <th>Size(in bytes)</th>
                                                            <th>Owner</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
							<c:forEach items="${addlist1}" var="a">
								<tr id="r1"><td><c:out value="${a.filename}"/></td>
								<td><c:out value="${a.size}"/></td>
								<td><c:out value="${a.owner}"/></td></tr>
							</c:forEach>
                                                    </tbody>
                                                </table>	
						</div>
					</main>
					
					<nav id="sidebar">
						<div class="widget">
							<h3><a href="#">My Basement</a></h3>
							<p id="fileCount"><b>No of files : ${count}</p>
                                                        <p>Total space used: <br>${size} kbytes</b></p>
                                                        <p><b>${warn}</b></p><br>
							
                                                        <form method="get" action="DownloadServlet" id="new_id" name="downform">
                                                        <table>
                                                            <thead><tr><h3>Download Files</h3></tr></thead>
                                                            <tr>
								<td>File Name:</td></tr>
								<tr><td><input type="text" name="dfname"/></td></tr>
								<tr><td><input type="Submit" name="download" value="download" id="download" style = "border: 1px solid #000000;padding:10px;width:100px;background:white;"/></td>
                                                            </tr>
                                                        </table>
                                                        </form>
                                                        <br><br>
                                                        <form method="get" action="ShareServlet" id="share" name="shareform" >
                                                        <table>
                                                            <thead><tr><h3>Share Files</h3></tr></thead>
                                                            <tr>
								<td>File Name:</td></tr>
								<tr><td><input type="text" name="sfname"/></td></tr>
								<tr><td>Share user:</td></tr>
								<tr><td><input type="text" name="suser"/></td></tr>
								<tr><td><input type="Submit" name="share" value="Share" id="shreid" style = "border: 1px solid #000000;padding:10px;width:100px;background:white;"/></td>
                                                            </tr>
                                                        </table>
                                                        </form>
							
							<br><br><br><br><br><br><br><br><br><br>
							<br><br><br><br><br><br><br><br><br><br>
							
							
							
							
							<ul>
							<li><a href="#">Home</a></li>
							<li><a href="LogoutServlet">Sign out</a></li>

							</ul>
						</div>
					</nav>
					
					<div class="clr"></div>
				</div>
			</div>
		
			<div id="footerblurb">
				<div id="footerblurb-inner">
				
					<div class="column">
						<h2><span>Upload</span></h2>
						<p>ANYWHERE ANYTIME</p>
					</div>	
					<div class="column">
						<h2><span>Download</span></h2>
						<p>AT ONE CLICK</p>
					</div>
					<div class="column">
						<h2><span>Share</span></h2>
						<p>WITH YOUR FRIENDS</p>
					</div>	
					
					<div class="clr"></div>

				</div>
			</div>
			<footer id="footer">
				<div id="footer-inner">
					<p>&copy; Copyright &#124; <a href="#">Basement.com</a>  </p>
					<div class="clr"></div>
				</div>
			</footer>
		</div>
	</body>
</html>
