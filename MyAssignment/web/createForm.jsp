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
            <a href="createForm.jsp">Create Leave Request</a>
            <a href="view.jsp">View Requests</a>
        </div>
        <div class="content">
            <h3>Leave Request Form</h3>
            <form action="req" method="POST">
                <p><strong>User:</strong> Mr. Tèo, <strong>Role:</strong> Employee, <strong>Department:</strong> IT</p>
                <label>From:</label>
                <input type="date" name="startDate" style="width: 100%;" value="${requestScope.startDate}">
                <br><br>
                <label>To:</label>
                <input type="date" name="endDate" style="width: 100%;" value="${requestScope.endDate}">
                <br><br>
                <label>Reason:</label>
                <br>
                <textarea id="reason" name="reason" rows="3" style="width: 100%;">${requestScope.reason}</textarea>
                <br><br>
                <button class="submit-btn">Submit</button>
            </form>

            <c:if test="${not empty requestScope.error}">
                <ul style="color: red;">
                    <c:forEach var="err" items="${requestScope.error}">
                        <li>${err}</li>
                    </c:forEach>
                </ul>
            </c:if>

            <c:if test="${not empty requestScope.message}">
                <p style="color: green;">${requestScope.message}</p>
            </c:if>
        </div>
    </body>
</html>
