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

/**
 *
 * @author 12906
 */
@WebServlet(name = "DeleteStudentServlet", urlPatterns = {"/DeleteStudentServlet"})
public class DeleteStudentServlet extends HttpServlet {
private StudentDAO studentDAO = new StudentDAO();

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String idParam = request.getParameter("id");
    if (idParam == null || idParam.isEmpty()) {
        response.sendRedirect("StudentServlet?error=missing_id");
        return;
    }

    try {
        int id = Integer.parseInt(idParam);

        // 删除操作
        boolean success = studentDAO.deleteStudent(id);

        // 根据删除结果跳转
        if (success) {
            response.sendRedirect("StudentServlet?message=delete_success");
        } else {
            response.sendRedirect("StudentServlet?error=delete_failed");
        }
    } catch (NumberFormatException e) {
        response.sendRedirect("StudentServlet?error=invalid_id");
    }
}


}
