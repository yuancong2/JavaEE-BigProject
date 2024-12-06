<%-- 
    Document   : editVehicle
    Created on : 2024-12-4, 18:12:46
    Author     : SP
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑车辆</title>
</head>
<body>
<h2>编辑车辆</h2>
<form action="VehicleServlet" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="${vehicle.id}"/>
    车牌号: <input type="text" name="licensePlate" value="${vehicle.licensePlate}"/><br/>
    型号: <input type="text" name="model" value="${vehicle.model}"/><br/>
    状态:
    <select name="status">
        <option value="可用" ${vehicle.status == '可用' ? 'selected' : ''}>可用</option>
        <option value="维修中" ${vehicle.status == '维修中' ? 'selected' : ''}>维修中</option>
        <option value="弃置" ${vehicle.status == '弃置' ? 'selected' : ''}>弃置</option>
    </select><br/>
    备注: <input type="text" name="remark" value="${vehicle.remark}"/><br/>
    <input type="submit" value="保存修改"/>
<form action="VehicleServlet" method="post" style="display:inline;">
    <input type="hidden" name="action" value="delete"/>
    <input type="hidden" name="id" value="${vehicle.id}"/>
    <input type="submit" value="删除" onclick="return confirm('确定要删除吗？');"/>
</form>
</form>
<a href="VehicleServlet">返回车辆列表</a>

</body>
</html>