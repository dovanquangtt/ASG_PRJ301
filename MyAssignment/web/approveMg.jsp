<%-- 
    Document   : approveMg
    Created on : Mar 18, 2025, 10:07:15 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="table-container">
    <h3>Approve Requests</h3>
    <table style="width: 100%; border-collapse: collapse; background: #2c2c2c; color: white;">
        <tr style="background: #ff5722;">
            <th>Title</th>
            <th>From</th>
            <th>To</th>
            <th>Created By</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <tr style="background: #333;">
            <td>Wedding Leave</td>
            <td>1/1/2025</td>
            <td>3/1/2025</td>
            <td>Mr. F</td>
            <td>Pending</td>
            <td>
                <button class="action-btn approve-btn">Approve</button>
                <button class="action-btn reject-btn">Reject</button>
            </td>
        </tr>
        <tr style="background: #333;">
            <td>Vacation Leave</td>
            <td>1/1/2025</td>
            <td>5/1/2025</td>
            <td>Mr. E</td>
            <td>Pending</td>
            <td>
                <button class="action-btn approve-btn">Approve</button>
                <button class="action-btn reject-btn">Reject</button>
            </td>
        </tr>
    </table>
</div>
