<%-- 
    Document   : editStudent
    Created on : 2024-11-27, 16:23:11
    Author     : 12906
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改学员信息</title>
</head>
<body>
<h2>修改学员信息</h2>
<c:if test="${not empty student}">
    <form action="EditStudentServlet" method="post">
        <input type="hidden" name="id" value="${student.id}"> <!-- 隐藏字段，用于保存学员ID -->
        姓名: <input type="text" name="name" value="${student.name}" required><br>
        电话: <input type="text" name="phone" value="${student.phone}" required><br>
        报名日期: <input type="date" name="registration_date" value="${student.registration_date}" required><br>
        状态: <input type="text" name="status" value="${student.status}" required><br>
        教练ID: <input type="text" name="coachId" value="${student.coach_id}" required><br>
        第一节课: <input type="text" name="sessionOne" value="${student.session_one}" required><br>
        第二节课: <input type="text" name="sessionTwo" value="${student.session_two}" required><br>
        第三节课: <input type="text" name="sessionThree" value="${student.session_three}" required><br>
        <input type="submit" value="提交修改">
    </form>
</c:if>
<c:if test="${empty student}">
    <p>学员信息不存在。</p>
</c:if>
</body>
</html>

