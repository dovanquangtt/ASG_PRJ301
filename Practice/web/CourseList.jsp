<%-- 
    Document   : CourseList
    Created on : Mar 9, 2025, 3:36:11 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <h1>Welcome, 
            <c:choose>
                <c:when test="${not empty user}">
                    ${user.getDisplay()} 
                </c:when>
                <c:otherwise>
                    Guest
                </c:otherwise>
            </c:choose> <a href="http://localhost:9999/logout"><input type="button" value="Logout" /></a>  
        </h1>
        <form action="search" method="get">
            <input type="text" name="search" value="${keyword}" />
            <input type="submit" value="Filter" />
        </form>
        <c:if test="${not empty courseList}">
            <h2>Danh sách khóa học</h2>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Tên khóa học</th>
                    <th>Mô tả</th>
                    <th>Thời gian</th>
                    <th>Học phí</th>
                    <th> </th>
                    <th></th>
                </tr>
                <c:forEach var="course" items="${courseList}">
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.name}</td>
                        <td>${course.description}</td>
                        <td>${course.duration}</td>
                        <td>${course.fee} $</td>
                        <td><a href="http://localhost:9999/update?id=${course.id}">Edit</a>
                        <td><a href="http://localhost:9999/delete?id=${course.id}">Delete</a>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
