<%--
    Document   : profile
    Created on : 20-Oct-2015, 20:58:26
    Author     : Aaron
--%>

<%@page import="java.util.*"%>  
<%@page import="uk.ac.dundee.computing.aec.instaaron.stores.*" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
        
    </head>
    <body>
        <header>
            <h1>InstAaron </h1>
            <h2>Your world in Black and White!</h2>
        </header>
        
        <% LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn"); %>
        
        <nav>
            <li><a href="/InstAaron/profile.jsp">Profile</a></li>
            <li><a href="/InstAaron/Upload">Upload</a></li>
            <li><a href="/InstAaron/Images/<%=lg.getUsername()%>">Your Images</a></li>
            <li><a href="/InstAaron/Logout">Log Out</a></li>
        </nav>

        <h1>Profile Information</h1>
        <article>

            <%--get profile information from LoggedIn and display it here--%>
            
            <p>Profile for user <%=lg.getUsername() %>: </p>
            <p>Name :</p><%=lg.getFirstName() %> <br/>
            <p>Last name :</p><%=lg.getLastName() %> <br/>
            <p>Email :</p><%=lg.getEmail() %> <br/>
        </article>

    </body>
</html>
