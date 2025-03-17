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
            <a href="viewep.jsp">View Requests</a>
        </div>
        <div class="content">
            <h3>List of Leave Requests</h3>
            <table>
                <tr>
                    <th>Title</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Created By</th>
                    <th>Status</th>
                    <th>Processed By</th>
                    <th>Action</th>
                </tr>
                <tr>
                    <td>Wedding Leave</td>
                    <td>1/1/2025</td>
                    <td>3/1/2025</td>
                    <td>Mr F</td>
                    <td>In Progress</td>
                    <td>-</td>
                    <td>
                        <button class="action-btn update-btn">Update</button>
                        <button class="action-btn delete-btn">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td>Vacation Leave</td>
                    <td>1/1/2025</td>
                    <td>5/1/2025</td>
                    <td>Mr E</td>
                    <td>Rejected</td>
                    <td>Mr B</td>
                    <td>
                        <button class="action-btn update-btn">Update</button>
                        <button class="action-btn delete-btn">Delete</button>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
