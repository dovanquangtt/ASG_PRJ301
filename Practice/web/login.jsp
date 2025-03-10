<%-- 
    Document   : login
    Created on : Mar 9, 2025, 3:12:44 PM
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
        <div class="login-container">
            <h1>Login</h1>
            <form action="login" method="POST">
                <table>
                    <tbody>
                        <tr>
                            <td>userID:</td>
                            <td><input type="text" name="name" value="" /></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password" value="" /></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="LOGIN" />
            </form>   
        </div>
    </body>
</html>
