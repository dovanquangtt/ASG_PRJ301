
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>H? th?ng ngh? phép</title>
        <<link rel="stylesheet" href="style.css"/>
        <script>
            function toggleForm() {
                document.getElementById("leaveForm").style.display = "block";
                document.getElementById("leaveList").style.display = "none";
                document.getElementById("approveRequests").style.display = "none";
                document.getElementById("laborStatus").style.display = "none";
            }

            function toggleList() {
                document.getElementById("leaveList").style.display = "block";
                document.getElementById("leaveForm").style.display = "none";
                document.getElementById("approveRequests").style.display = "none";
                document.getElementById("laborStatus").style.display = "none";
            }

            function toggleApprove() {
                document.getElementById("approveRequests").style.display = "block";
                document.getElementById("leaveForm").style.display = "none";
                document.getElementById("leaveList").style.display = "none";
                document.getElementById("laborStatus").style.display = "none";
            }

            function toggleLaborStatus() {
                document.getElementById("laborStatus").style.display = "block";
                document.getElementById("leaveForm").style.display = "none";
                document.getElementById("leaveList").style.display = "none";
                document.getElementById("approveRequests").style.display = "none";
            }
        </script>


    </head>
    <body>
        <div class="header-bar">Leave System</div>
        <div class="navbar">
            <a href="createForm.jsp" onclick="toggleForm()">Create Leave Request</a>
            <a href="createForm.jsp" onclick="toggleList()">View Requests</a>
        </div>
        <div class="content">
            <p>Welcome to the Leave Management System Select a function from the menu above.</p>
        </div>

        <div id="leaveList" class="list-container">
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
