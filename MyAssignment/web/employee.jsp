<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>H? th?ng ngh? ph�p</title>
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
            <a href="#" onclick="toggleForm()">Create Leave Request</a>
            <a href="#" onclick="toggleList()">View Requests</a>
        </div>
        <div class="content">
            <div class="header">Welcome to the Leave Management System</div>
            <p>Select a function from the menu above.</p>
        </div>
        <div id="leaveForm" class="form-container">
            <h3>Leave Request Form</h3>
            <p><strong>User:</strong> Mr. T�o, <strong>Role:</strong> Employee, <strong>Department:</strong> IT</p>
            <label for="startDate">From:</label>
            <input type="date" id="startDate" style="width: 100%;">
            <br><br>
            <label for="endDate">To:</label>
            <input type="date" id="endDate" style="width: 100%;">
            <br><br>
            <label for="reason">Reason:</label>
            <br>
            <textarea id="reason" rows="3" style="width: 100%;"></textarea>
            <br><br>
            <button class="submit-btn">Submit</button>
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
