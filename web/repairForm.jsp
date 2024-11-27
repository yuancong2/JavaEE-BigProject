<%-- 
    Document   : repairForm
    Created on : 2024-11-27, 15:39:23
    Author     : SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>维修记录</title>
</head>
<body>
<h2>填写维修记录</h2>
<form action="VehicleServlet" method="post">
    <input type="hidden" name="action" value="finishRepair">
    <input type="hidden" name="id" value="${param.id}">
    <label for="problem">问题描述：</label><br>
    <textarea id="problem" name="problem" rows="4" cols="50" required></textarea><br><br>
    <label for="cost">维修费用：</label><br>
    <input type="number" id="cost" name="cost" step="0.01" required><br><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
