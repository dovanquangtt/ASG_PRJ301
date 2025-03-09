<%-- 
    Document   : login
    Created on : Mar 6, 2025, 1:02:20 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="login-container"> <!-- Wrap the form in this div for styling -->
            <h1>Login</h1>
            <form action="login" method="POST">
                <table>
                    <tbody>
                        <tr>
                            <td>Username:</td>
                            <td><input type="text" name="username" value="" /></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password" value="" /></td> <!-- Change type to "password" for security -->
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="LOGIN" />
            </form>   
        </div>
    </body>
</html>
