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
        // 根据 ID 获取学生信息
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.getStudentById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("/editStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 更新学生信息
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String registrationDate = request.getParameter("registrationDate");
        String status = request.getParameter("status");

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setPhone(phone);
        student.setRegistration_date(registrationDate);
        student.setStatus(status);

        studentDAO.updateStudent(student);

        // 重定向回学员列表
        response.sendRedirect("studentList");
    }
}
