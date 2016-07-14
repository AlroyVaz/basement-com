<%-- 
    Document   : test
    Created on : 10 Apr, 2016, 1:21:15 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
    </head>
    <body>
        <h1>Test Page</h1>
        <form method="post" action="TestServlet">
            USER ID : <input type="text" name="field1"/><br>
            Password : <input type="text" name="field2"/><br>
            <input type="Submit" name="submit" value="Submit"/>
        </form>
    </body>
</html>
