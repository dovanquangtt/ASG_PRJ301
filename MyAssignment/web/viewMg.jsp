<%-- 
    Document   : viewMg
    Created on : Mar 18, 2025, 10:03:41 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="table-container">
    <h3>View Requests</h3>
    <table style="width: 100%; border-collapse: collapse; background: #2c2c2c; color: white;">
        <tr style="background: #ff5722;">
            <th>Reason</th>
            <th>From</th>
            <th>To</th>
            <th>DateCreate</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <c:forEach var="request" items="${list}">
            <tr>
                <td>${request.getReason()}</td>
                <td>${request.getDateFrom()}</td>
                <td>${request.getDateTo()}</td>
                <td>${request.getDateCreate()}</td>
                <td>${request.getStatus()}</td>
                <td>
                    <c:if test="${request.getStatus() == 'Pending'}">
                        <button class="action-btn update-btn" onclick="location.href = 'update?id=${request.getId()}'">Update</button>
                        <button class="action-btn delete-btn" onclick="location.href = 'delete?id=${request.getId()}'">Delete</button>
                    </c:if>
                    <c:if test="${request.getStatus() != 'Pending'}">
                        <span style="color: gray;">Processed</span>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>