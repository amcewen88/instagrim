<%-- 
    Document   : test
    Created on : Sep 29, 2014, 9:16:48 AM
    Author     : Administrator
--%>
import 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instaaron.stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <h1>Hello World!</h1>
            <% LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn"); %>
            <h1>Profile for user <%=lg.getUsername() %>: </h1>
            <%=lg.getFirstName() %> <br/>
            <%=lg.getLastName() %> <br/>
            <%=lg.getEmail() %> <br/>
    </body>
    <footer>
            <ul>
                <li class='nav'><a href="/InstAaron/Logout">Log Out</a></li>
                <li class="footer"><a href="/InstAaron">Home</a></li>
            </ul>
        </footer>
</html>
