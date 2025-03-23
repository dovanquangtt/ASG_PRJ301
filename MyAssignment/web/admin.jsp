<%-- 
    Document   : admin
    Created on : Mar 12, 2025, 10:11:45 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hệ thống nghỉ phép</title>
        <link rel="stylesheet" href="style.css"/>
        <style>
            /* Additional CSS to center the content */
            .content {
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: calc(100vh - 100px); /* Adjust to account for header and navbar */
            }
            .form-container {
                margin: 0 auto;
                width: 400px; /* Ensure consistent width */
            }
        </style>
    </head>
    <body>
        <div class="header-bar">Leave System</div>
        <div class="navbar">
            <a href="http://localhost:9999/MyAssignment/review">Approve Requests</a>
            <a href="#">Labor Status</a>
        </div>
        <div class="content">
            <%
                String action = request.getParameter("action");
                if (action == null || action.isEmpty()) {
            %>
            <div class="header">Welcome to the Leave Management System</div>
            <p>Select a function from the menu above.</p>
            <%    
                } else if (action.equals("approve")) {
            %>
            <jsp:include page="approveAd.jsp" />
            <%    
                }
            %>
        </div>
    </body>
</html>