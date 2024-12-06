<%-- 
    Document   : editStudent
    Created on : 2024-11-27, 16:23:11
    Author     : 12906
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学员信息</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .edit-student-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
        .edit-student-container h2 {
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }
        .edit-student-container label {
            display: block;
            margin-bottom: 5px;
        }
        .edit-student-container input[type="text"],
        .edit-student-container input[type="date"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .edit-student-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #0056b3;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .edit-student-container input[type="submit"]:hover {
            background-color: #004494;
        }
        .edit-student-container p {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
    <c:if test="${not empty student}">
    <div class="edit-student-container">
        <h2>修改学员信息</h2>
        <form action="EditStudentServlet" method="post">
            <input type="hidden" name="id" value="${student.id}">
            姓名: <input type="text" name="name" value="${student.name}" required><br>
            电话: <input type="text" name="phone" value="${student.phone}" required><br>
            报名日期: <input type="date" name="registration_date" value="${student.registration_date}" required><br>
            状态: <input type="text" name="status" value="${student.status}" required><br>
            教练ID: <input type="text" name="coachId" value="${student.coach_id}" required><br>
            
            <!-- 下拉菜单选择科目是否通过 -->
            第一节课:
            <select name="sessionOne" required>
                <option value="0" ${student.session_one == 0 ? 'selected' : ''}>未通过</option>
                <option value="1" ${student.session_one == 1 ? 'selected' : ''}>已通过</option>
            </select><br>
            
            第二节课:
            <select name="sessionTwo" required>
                <option value="0" ${student.session_two == 0 ? 'selected' : ''}>未通过</option>
                <option value="1" ${student.session_two == 1 ? 'selected' : ''}>已通过</option>
            </select><br>
            
            第三节课:
            <select name="sessionThree" required>
                <option value="0" ${student.session_three == 0 ? 'selected' : ''}>未通过</option>
                <option value="1" ${student.session_three == 1 ? 'selected' : ''}>已通过</option>
            </select><br>
            
            <input type="submit" value="提交修改">
        </form>
    </div>
    </c:if>
    <c:if test="${empty student}">
    <div class="edit-student-container">
        <p>学员信息不存在。</p>
    </div>
    </c:if>
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

