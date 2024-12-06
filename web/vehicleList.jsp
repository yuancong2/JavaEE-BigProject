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
<a href="addVehicle.jsp">添加新车辆</a>
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
                <a href="VehicleServlet?action=edit&id=${vehicle.id}">修改/删除</a>
                <c:if test="${vehicle.status == '维修中'}">
                    <a href="repairForm.jsp?id=${vehicle.id}">维修</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>