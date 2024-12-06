<%-- 
    Document   : studentList
    Created on : 2024-11-20, 15:14:27
    Author     : 12906
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学员列表</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #0056b3;
            color: white;
        }
        tr:hover {background-color: #f5f5f5;}
        .status-passed {
            color: green;
        }
        .status-failed {
            color: red;
        }
        .add-student-link {
            display: block;
            width: 200px;
            padding: 10px;
            margin: 20px auto;
            background-color: #0056b3;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }
        .add-student-link:hover {
            background-color: #004494;
        }
    </style>
</head>
<body>
<h2>学员列表</h2>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>电话</th>
        <th>报名日期</th>
        <th>状态</th>
        <th>教练ID</th>
        <th>科目一</th>
        <th>科目二</th>
        <th>科目三</th>
        <th>操作</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.phone}</td>
            <td>${student.registration_date}</td>
            <td>${student.status}</td>
            <td>${student.coach_id}</td>
            <td class="${student.session_one == 1 ? 'status-passed' : 'status-failed'}"><c:out value="${student.session_one == 1 ? '已通过' : '未通过'}"/></td>
            <td class="${student.session_two == 1 ? 'status-passed' : 'status-failed'}"><c:out value="${student.session_two == 1 ? '已通过' : '未通过'}"/></td>
            <td class="${student.session_three == 1 ? 'status-passed' : 'status-failed'}"><c:out value="${student.session_three == 1 ? '已通过' : '未通过'}"/></td>
            <td><a href="EditStudentServlet?id=${student.id}">修改</a>
            <a href="DeleteStudentServlet?id=${student.id}" onclick="return confirm('确定要删除这个学员吗?');">删除</a>
            </td>
            <td>
                <c:choose>
                    <c:when test="${student.session_two == 1}">
                        已通过
                    </c:when>
                    <c:otherwise>
                        未通过
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${student.session_three == 1}">
                        已通过
                    </c:when>
                    <c:otherwise>
                        未通过
                    </c:otherwise>
                </c:choose>
            </td>
            <td><a href="editStudent.jsp?id=${student.id}">修改</a></td>
        </tr>
    </c:forEach>
    <c:if test="${empty students}">
        <tr>
            <td colspan="10">没有学员信息</td>
        </tr>
    </c:if>
</table>
<a href="addStudent.jsp" class="add-student-link">添加新学员</a>
<a href="homepage.jsp" class="add-student-link">主页</a>
</body>
</html>
