<%-- 
    Document   : vehicleList
    Created on : 2024-11-20, 16:12:23
    Author     : SP
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>车辆列表</title>
</head>
<body>
<h2>车辆列表</h2>
<table border="1">
    <tr>
        <th>编号</th>
        <th>车牌号</th>
        <th>型号</th>
        <th>状态</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <c:forEach var="vehicle" items="${vehicles}">
        <tr>
            <td>${vehicle.id}</td>
            <td><a href="RepairHistoryServlet?id=${vehicle.id}">${vehicle.licensePlate}</a></td>
            <td>${vehicle.model}</td>
            <td>${vehicle.status}</td>
            <td>${vehicle.remark}</td>
            <td>
                <c:choose>
                    <c:when test="${vehicle.status == '维修中'}">
                        <a href="VehicleServlet?action=restore&id=${vehicle.id}">恢复可用</a>
                    </c:when>
                    <c:otherwise>
                        <form action="RepairServlet" method="post">
                            <input type="hidden" name="id" value="${vehicle.id}">
                            <input type="text" name="cost" placeholder="维修费用" required>
                            <input type="text" name="problem" placeholder="问题描述" required>
                            <button type="submit">维修</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty vehicles}">
        <tr>
            <td colspan="6">没有车辆信息</td>
        </tr>
    </c:if>
</table>
<a href="addVehicle.jsp">添加新车辆</a>
</body>
</html>


