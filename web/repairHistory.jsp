<%-- 
    Document   : repairHistory
    Created on : 2024-11-27, 16:14:42
    Author     : SP
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>维修历史记录</title>
</head>
<body>
<h2>车牌号: ${vehicle.licensePlate} 的维修历史记录</h2>
<table border="1">
    <tr>
        <th>维修编号</th>
        <th>费用</th>
        <th>问题描述</th>
        <th>修理时间</th>
    </tr>
    <c:forEach var="record" items="${repairHistory}">
        <tr>
            <td>${record.id}</td>
            <td>${record.cost}</td>
            <td>${record.problem}</td>
            <td>${record.fixTime}</td>
        </tr>
    </c:forEach>
    <c:if test="${empty repairHistory}">
        <tr>
            <td colspan="4">暂无维修记录</td>
        </tr>
    </c:if>
</table>
<a href="VehicleServlet">返回车辆列表</a>
</body>
</html>
