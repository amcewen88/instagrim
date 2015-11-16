<%-- 
    Document   : UsersPics
    Created on : Sep 24, 2014, 2:52:48 PM
    Author     : Administrator
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instaaron.stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>InstAaron</title>
        <link rel="stylesheet" type="text/css" href="/InstAaron/Styles.css" />
    </head>
    <body>
        <header>
        
        <h1>InstaAaron </h1>
        <h2>Your world in Black and White!</h2>
        </header>
        
        <nav>
            <ul>
                <% LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn"); %>
                
                <li class="nav"><a href="/InstAaron/upload.jsp">Upload</a></li>
                <li><a href="/InstAaron/Images/<%=lg.getUsername()%>">Your Images</a></li>
                <li><a href="/InstAaron/profile.jsp">Your Profile</a></li>
                <li class='nav'><a href="/InstAaron/Logout">Log Out</a></li>
            </ul>
        </nav>
 
        <article>
            <h1>Your Pics</h1>
        <%
            java.util.LinkedList<Pic> lsPics = (java.util.LinkedList<Pic>) request.getAttribute("Pics");
            if (lsPics == null) {
        %>
        <p>No Pictures found</p>
        <%
        } else {
            Iterator<Pic> iterator;
            iterator = lsPics.iterator();
            while (iterator.hasNext()) {
                Pic p = (Pic) iterator.next();

        %>
        <a href="/InstAaron/Image/<%=p.getSUUID()%>" ><img src="/InstAaron/Thumb/<%=p.getSUUID()%>"></a><br/><%

            }
            }
        %>
        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/InstAaron">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
