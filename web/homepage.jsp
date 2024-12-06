<%-- 
    Document   : homepage
    Created on : 2024-12-4, 15:57:13
    Author     : 12906
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
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
        .homepage-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .homepage-container h1 {
            color: #333;
            margin-bottom: 20px;
        }
        .homepage-container a {
            display: block;
            margin: 10px 0;
            padding: 10px 20px;
            background-color: #0056b3;
            color: white;
            text-decoration: none;
            border-radius: 3px;
            transition: background-color 0.3s;
        }
        .homepage-container a:hover {
            background-color: #004494;
        }
        .homepage-container p {
            color: red;
            margin-bottom: 20px;
        }
    </style>
    <script>
        function redirectToLogin() {
            setTimeout(function () {
                window.location.href = "login.html";
            }, 3000); // 3秒后跳转
        }
    </script>
</head>
<body>
    <%
        if (session == null || session.getAttribute("user") == null) {
    %>
    <div class="homepage-container">
        <p>您未登录或会话已失效，系统将在 3 秒后跳转到登录页面。</p>
        <script>redirectToLogin();</script>
    </div>
    <%
        return;
        }

        // 从会话中获取用户名
        String username = (String) session.getAttribute("user");
    %>
    <div class="homepage-container">
        <h1>欢迎！ 当前用户：<%= username %></h1>
        <a href="StudentServlet">学员列表</a>
        <a href="LogoutServlet">注销</a>
    </div>
</body>
</html>




