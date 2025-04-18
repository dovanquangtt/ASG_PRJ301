<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Create/Update Leave Request</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div class="header-bar">Leave System</div>
        <div class="navbar">
            <a href="createForm.jsp" class="active">Create Leave Request</a>
            <a href="http://localhost:9999/MyAssignment/viewep">View Requests</a>
        </div>
        <div class="content">
            <div class="form-container">
                <h3>Leave Request Form</h3>
                <!-- Nếu là cập nhật thì thêm hidden field chứa id -->
                <c:if test="${not empty requestData}">
                    <form action="req" method="POST" class="leave-form">
                        <input type="hidden" name="id" value="${requestData.id}" />
                        <div class="form-group">
                            <label for="startDate">From:</label>
                            <input type="date" id="startDate" name="startDate" value="${requestData.dateFrom}" required>
                        </div>
                        <div class="form-group">
                            <label for="endDate">To:</label>
                            <input type="date" id="endDate" name="endDate" value="${requestData.dateTo}" required>
                        </div>
                        <div class="form-group">
                            <label for="reason">Reason:</label>
                            <textarea id="reason" name="reason" required>${requestData.reason}</textarea>
                        </div>
                        <button type="submit" class="submit-btn">Submit</button>
                    </form>
                </c:if>
                <!-- Nếu là tạo mới -->
                <c:if test="${empty requestData}">
                    <form action="req" method="POST" class="leave-form">
                        <div class="form-group">
                            <label for="startDate">From:</label>
                            <input type="date" id="startDate" name="startDate" required>
                        </div>
                        <div class="form-group">
                            <label for="endDate">To:</label>
                            <input type="date" id="endDate" name="endDate" required>
                        </div>
                        <div class="form-group">
                            <label for="reason">Reason:</label>
                            <textarea id="reason" name="reason" required></textarea>
                        </div>
                        <button type="submit" class="submit-btn">Submit</button>
                    </form>
                </c:if>

                <c:if test="${not empty error}">
                    <div class="error-list">
                        <ul>
                            <c:forEach var="err" items="${error}">
                                <li>${err}</li>
                                </c:forEach>
                        </ul>
                    </div>
                </c:if>
                <c:if test="${not empty message}">
                    <div class="error-list">
                        <p>${message}</p>
                    </div>
                </c:if>
            </div>
        </div>
    </body>
</html>