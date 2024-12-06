/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;


/**
 *
 * @author 12906
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求和响应的编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<Student> students = studentDAO.getAllStudents(); // 查询数据库
        request.setAttribute("students", students);          // 设置到 request 中
        request.getRequestDispatcher("/studentList.jsp").forward(request, response); // 转发到 JSP
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 设置请求和响应的编码
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    // 添加新学员
    String name = request.getParameter("name");
    String phone = request.getParameter("phone");
    String registrationDate = request.getParameter("registrationDate");
    String status = "报名中";
    String coachIdStr = request.getParameter("coachId"); // 假设从表单中获取教练ID
    int sessionOneStr = 0; // 假设从表单中获取第一节课
    int sessionTwoStr = 0; // 假设从表单中获取第二节课
    int sessionThreeStr = 0; // 假设从表单中获取第三节课

    Student student = new Student();
    student.setName(name);
    student.setPhone(phone);
    student.setRegistration_date(registrationDate);
    student.setStatus(status);
    student.setCoach_id(Integer.parseInt(coachIdStr)); // 设置教练ID
    student.setSession_one(sessionOneStr); // 设置第一节课
    student.setSession_two(sessionTwoStr); // 设置第二节课
    student.setSession_three(sessionThreeStr); // 设置第三节课

    studentDAO.addStudent(student); // 将学员信息添加到数据库
    response.sendRedirect("StudentServlet"); // 重定向到学员列表页面
}
}
