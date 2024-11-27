<%-- 
    Document   : addStudent
    Created on : 2024-11-20, 15:14:58
    Author     : 12906
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学员</title>
</head>
<body>
<h2>添加学员</h2>
<form action="StudentServlet" method="post">
    姓名: <input type="text" name="name" required><br>
    电话: <input type="text" name="phone" required><br>
    报名日期: <input type="date" name="registration_date" required><br>
    教练ID: <input type="text" name="coachId" required><br>
    <input type="submit" value="添加">
</form>
</body>
</html>

