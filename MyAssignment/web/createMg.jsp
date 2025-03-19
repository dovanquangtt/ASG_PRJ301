<%-- 
    Document   : createMg
    Created on : Mar 18, 2025, 9:52:03 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="leaveForm" class="form-container">
    <h3>Leave Request Form</h3>
    <form action="req" method="POST">
        <label>From:</label>
        <input type="date" name="startDate" style="width: 100%;">
        <br><br>
        <label>To:</label>
        <input type="date" name="endDate" style="width: 100%;">
        <br><br>
        <label>Reason:</label>
        <br>
        <textarea name="reason" value="${reason}" rows="3" style="width: 100%;"></textarea>
        <br><br>
        <button class="submit-btn">Submit</button>
    </form>
    <c:if test="${not empty error}">
        <div style="color: red; margin-bottom: 10px;">
            <ul>
                <c:forEach var="error" items="${error}">
                    <li>${error}</li>
                    </c:forEach>
            </ul>
        </div>
    </c:if>
    ${message}
</div>
</div>
