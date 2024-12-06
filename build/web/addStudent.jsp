<%-- 
    Document   : addStudent
    Created on : 2024-11-20, 15:14:58
    Author     : 12906
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学员</title>
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
        .add-student-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        .add-student-container h2 {
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }
        .add-student-container label {
            display: block;
            margin-bottom: 5px;
        }
        .add-student-container input[type="text"],
        .add-student-container input[type="date"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .add-student-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #0056b3;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .add-student-container input[type="submit"]:hover {
            background-color: #004494;
        }
    </style>
</head>
<body>
    <div class="add-student-container">
        <h2>添加学员</h2>
        <form action="StudentServlet" method="post">
            姓名: <input type="text" name="name" required><br>
            电话: <input type="text" name="phone" required><br>
            报名日期: <input type="date" name="registration_date" required><br>
            教练ID: <input type="text" name="coachId" required><br>
            <input type="submit" value="添加">
        </form>
    </div>
</body>
</html>

