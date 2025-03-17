<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Create Leave Request</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div class="header-bar">Leave System</div>
        <div class="navbar">
            <a href="createForm.jsp" class="active">Create Leave Request</a>
            <a href="viewep.jsp">View Requests</a>
        </div>
        <div class="content">
            <div class="form-container">
                <h3>Leave Request Form</h3>
                <form action="req" method="POST" class="leave-form">
                    <p class="user-info">
                        <strong>User:</strong> Mr. Tèo, 
                        <strong>Role:</strong> Employee, 
                        <strong>Department:</strong> IT
                    </p>
                    <div class="form-group">
                        <label for="startDate">From:</label>
                        <input type="date" id="startDate" name="startDate" value="${requestScope.startDate}">
                    </div>
                    <div class="form-group">
                        <label for="endDate">To:</label>
                        <input type="date" id="endDate" name="endDate" value="${requestScope.endDate}">
                    </div>
                    <div class="form-group">
                        <label for="reason">Reason:</label>
                        <textarea id="reason" name="reason" rows="3">${requestScope.reason}</textarea>
                    </div>
                    <button type="submit" class="submit-btn">Submit</button>
                </form>

                <c:if test="${not empty requestScope.error}">
                    <ul class="error-message">
                        <c:forEach var="err" items="${requestScope.error}">
                            <li>${err}</li>
                            </c:forEach>
                    </ul>
                </c:if>

                <c:if test="${not empty requestScope.message}">
                    <p class="success-message">${requestScope.message}</p>
                </c:if>
            </div>
        </div>
    </body>
</html>