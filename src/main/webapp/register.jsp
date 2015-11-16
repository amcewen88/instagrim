<%-- 
    Document   : register.jsp
    Created on : Sep 28, 2014, 6:29:51 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>InstAaron</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <header>
        <h1>InstAaron </h1>
        <h2>Your world in Black and White!</h2>
        </header>
        <nav>
            <ul>
                <li><a href="login.jsp">Login</a></li>
                
            </ul>
        </nav>
       
        <article>
            <h3>Register as user</h3>
            <form method="POST"  action="Register">
                <ul>
                    <li>User Name <input type="text" name="username"></li>
                    <li>Password <input type="password" name="password"></li>
                    <li>First Name <input type="text" name="firstname"></li>
                    <li>Last Name <input type="text" name="lastname"></li>
                    <li>Email <input type="text" name="email"></li>
                    <li>House No. <input type="text" name="address"></li>
                    <li>Street <input type="text" name="address"></li>
                    <li>City <input type="text" name="address"></li>
                    <li>Zip <input type="integer" name="address"></li>
                </ul>
                <br/>
                <input type="submit" value="Register"> 
            </form>

        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/InstAaron">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
