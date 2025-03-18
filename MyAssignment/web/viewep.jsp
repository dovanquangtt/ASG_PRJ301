<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>View Leave Requests</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div class="header-bar">Leave System</div>
        <div class="navbar">
            <a href="createForm.jsp">Create Leave Request</a>
            <a href="http://localhost:9999/MyAssignment/viewep">View Requests</a>
        </div>
        <div class="content">
            <table>
                <tr>
                    <th>Reason</th>
                    <th>From</th>
                    <th>To</th>
                    <th>DateCreate</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${list}" var="request">
                    <tr>
                        <td>${request.getReason()}</td>
                        <td>${request.getDateFrom()}</td>
                        <td>${request.getDateTo()}</td>
                        <td>${request.getDateCreate()}</td>
                        <td>${request.getStatus()}</td>
                        
                        <td>
                            <button class="action-btn update-btn" onclick="location.href = 'updateRequest?id=${request.getId()}'">Update</button>
                            <button class="action-btn delete-btn" onclick="location.href = 'deleteRequest?id=${request.getId()}'">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty list}">
                    <tr><td colspan="6">Không tìm thấy đơn xin nghỉ phép nào.</td></tr>
                </c:if>
            </table>
        </div>
    </body>
</html>
