<%-- 
    Document   : updateCourse
    Created on : Mar 10, 2025, 8:09:37 AM
    Author     : admin
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="update" method="POST">
            <table >
                <tbody>
                    <tr>
                        <td>ID</td>
                        <td><input type="text" readonly="" name="id" value="${course.getId()}" /></td>
                    </tr>
                    <tr>
                        <td>Tên khóa học</td>
                        <td><input type="text" name="name" value="${course.name}" /></td>
                    </tr>
                    <tr>
                        <td>Mô tả</td>
                        <td><input type="text" name="des" value="${course.description}" /></td>
                    </tr>
                    <tr>
                        <td>Thời gian</td>
                        <td><input type="text" name="time" value="${course.duration}" /></td>
                    </tr>
                    <tr>
                        <td>Học phí</td>
                        <td><input type="text" name="fee" value="${course.fee}" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td>${error}</td>
                    </tr>
                </tbody>

            </table>

        </form>
    </body>
</html>
