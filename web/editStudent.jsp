<%-- 
    Document   : editStudent
    Created on : 2024-11-27, 16:23:11
    Author     : 12906
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学员信息</title>
</head>
<body>
<h2>修改学员信息</h2>
<form action="editStudent" method="post">
    <input type="hidden" name="id" value="${student.id}">
    <label for="name">姓名:</label>
    <input type="text" id="name" name="name" value="${student.name}" required><br><br>
    <label for="phone">电话:</label>
    <input type="text" id="phone" name="phone" value="${student.phone}" required><br><br>
    <label for="registrationDate">报名日期:</label>
    <input type="date" id="registrationDate" name="registrationDate" value="${student.registration_date}" required><br><br>
    <label for="status">状态:</label>
    <input type="text" id="status" name="status" value="${student.status}" required><br><br>
    <input type="submit" value="提交">
</form>
<a href="StudentServlet">返回学员列表</a>
</body>
</html>

