/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.VehicleDAO;
import model.RepairRecord;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SP
 */
@WebServlet(name = "RepairHistoryServlet", urlPatterns = {"/RepairHistoryServlet"})
public class RepairHistoryServlet extends HttpServlet {
    private VehicleDAO vehicleDAO = new VehicleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vehicleId = request.getParameter("id");
        List<RepairRecord> repairHistory = vehicleDAO.getRepairHistory(Integer.parseInt(vehicleId));
        request.setAttribute("repairHistory", repairHistory);
        request.getRequestDispatcher("/repairHistory.jsp").forward(request, response);
    }
}