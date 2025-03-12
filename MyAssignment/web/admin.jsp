<%-- 
    Document   : admin
    Created on : Mar 12, 2025, 10:11:45 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hệ thống nghỉ phép</title>
    <link rel="stylesheet" href="style.css"/>
    <script>
        function showSection(sectionId) {
            let sections = ["leaveList", "approveRequests", "laborStatus"];
            sections.forEach(id => {
                document.getElementById(id).style.display = "none";
            });
            document.getElementById(sectionId).style.display = "block";
        }
    </script>
</head>
<body>
    <div class="header-bar">Leave System</div>
    <div class="navbar">
        <a href="#" onclick="showSection('leaveList')">View Requests</a>
        <a href="#" onclick="showSection('approveRequests')">Approve Requests</a>
        <a href="#" onclick="showSection('laborStatus')">Labor Status</a>
    </div>
    <div class="content">
        <div class="header">Welcome to the Leave Management System</div>
        <p>Select a function from the menu above.</p>
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
        </table>
    </div>
    
    <div id="approveRequests" class="list-container" style="display: none;">
        <h3>Chấp thuận yêu cầu nghỉ phép</h3>
        <table>
            <tr>
                <th>Title</th>
                <th>From</th>
                <th>To</th>
                <th>Created By</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <tr>
                <td>Vacation Leave</td>
                <td>1/1/2025</td>
                <td>5/1/2025</td>
                <td>Mr E</td>
                <td>Pending</td>
                <td>
                    <button class="action-btn approve-btn">Approve</button>
                    <button class="action-btn reject-btn">Reject</button>
                </td>
            </tr>
        </table>
    </div>
    
    <div id="laborStatus" class="list-container" style="display: none;">
        <h3>Tình trạng lao động của nhân viên</h3>
        <table border="1">
            <tr style="background: green; color: white;">
                <th>Nhân viên</th>
                <th>1/1</th>
                <th>2/1</th>
                <th>3/1</th>
            </tr>
            <tr>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
            </tr>
        </table>
    </div>
</body>
</html>
