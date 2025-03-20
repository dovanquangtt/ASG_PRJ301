<%-- 
    Document   : approveMg
    Created on : Mar 18, 2025, 10:07:15 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:forEach var="request" items="${allRequest}">
            <tr>
                <td>${request.getReason()}</td>
                <td>${request.getDateFrom()}</td>
                <td>${request.getDateTo()}</td>
                <td>${request.geteName()}</td>
                <td>${request.getStatus()}</td>
               <td>
            <c:if test="${request.getStatus() eq 'Pending'}">
                <form action="review" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${request.getId()}" />
                    <input type="hidden" name="action" value="approve" />
                    <button type="submit" style="color: white; text-decoration: none; background: green; padding: 5px 10px; border-radius: 5px;">Approve</button>
                </form>
                <form action="review" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${request.getId()}" />
                    <input type="hidden" name="action" value="reject" />
                    <button type="submit" style="color: white; text-decoration: none; background: red; padding: 5px 10px; border-radius: 5px;">Reject</button>
                </form>
            </c:if>
            <c:if test="${request.getStatus() ne 'Pending'}">
                <!-- Có thể hiển thị thông báo hoặc ẩn nút khi đơn không ở trạng thái Pending -->
                <span>No Action</span>
            </c:if>
        </td>
        </c:forEach>

    </table>
</div>
