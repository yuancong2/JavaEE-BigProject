<%-- 
    Document   : addVehicle
    Created on : 2024-11-20, 16:21:21
    Author     : SP
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加车辆</title>
</head>
<body>
<h2>添加车辆</h2>
<form action="VehicleServlet" method="post">
    车牌号: <input type="text" name="licensePlate" required><br>
    型号: <input type="text" name="model" required><br>
    备注: <input type="text" name="remark"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
