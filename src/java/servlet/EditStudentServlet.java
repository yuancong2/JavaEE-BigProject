/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditStudentServlet", urlPatterns = {"/EditStudentServlet"})
public class EditStudentServlet extends HttpServlet {
    private StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求和响应的编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 根据 ID 获取学生信息
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.getStudentById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("/editStudent.jsp").forward(request, response);
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 设置请求和响应的编码
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    
    // 更新学生信息
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String phone = request.getParameter("phone");
    String registration_date = request.getParameter("registration_date");
    String status = request.getParameter("status");
    String coachId = request.getParameter("coachId"); // 获取教练ID
    String sessionOne = request.getParameter("sessionOne"); // 获取第一节课
    String sessionTwo = request.getParameter("sessionTwo"); // 获取第二节课
    String sessionThree = request.getParameter("sessionThree"); // 获取第三节课

    Student student = new Student();
    student.setId(id);
    student.setName(name);
    student.setPhone(phone);
    student.setRegistration_date(registration_date);
    student.setStatus(status);
    student.setCoach_id(Integer.parseInt(coachId)); // 设置教练ID
    student.setSession_one(Integer.parseInt(sessionOne)); // 设置第一节课
    student.setSession_two(Integer.parseInt(sessionTwo)); // 设置第二节课
    student.setSession_three(Integer.parseInt(sessionThree)); // 设置第三节课

    studentDAO.updateStudent(student); // 更新学员信息

    // 重定向回学员列表
    response.sendRedirect("StudentServlet"); // 确保这个路径是正确的，并且指向学员列表的显示页面
}
}
