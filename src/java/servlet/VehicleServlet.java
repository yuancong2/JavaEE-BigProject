/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.VehicleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vehicle;
import model.RepairRecord;
import java.time.*;

/**
 *
 * @author SP
 */


@WebServlet(name = "VehicleServlet", urlPatterns = {"/VehicleServlet"})
public class VehicleServlet extends HttpServlet {
    private VehicleDAO vehicleDAO = new VehicleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Vehicle vehicle = vehicleDAO.getVehicleById(id);
            request.setAttribute("vehicle", vehicle);
            request.getRequestDispatcher("/editVehicle.jsp").forward(request, response);
        } else {
            List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
            request.setAttribute("vehicles", vehicles);
            request.getRequestDispatcher("/vehicleList.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String licensePlate = request.getParameter("licensePlate");
            String model = request.getParameter("model");
            String remark = request.getParameter("remark");
            String status = "可用"; // 默认状态

            Vehicle vehicle = new Vehicle();
            vehicle.setLicensePlate(licensePlate);
            vehicle.setModel(model);
            vehicle.setStatus(status);
            vehicle.setRemark(remark);

            vehicleDAO.addVehicle(vehicle);

        } else if ("update".equals(action)) {
           int id = Integer.parseInt(request.getParameter("id"));
            String licensePlate = request.getParameter("licensePlate");
            String model = request.getParameter("model");
            String status = request.getParameter("status");
            String remark = request.getParameter("remark");

            Vehicle vehicle = new Vehicle();
            vehicle.setId(id);
            vehicle.setLicensePlate(licensePlate);
            vehicle.setModel(model);
            vehicle.setStatus(status);
            vehicle.setRemark(remark);

            vehicleDAO.updateVehicle(vehicle);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            vehicleDAO.deleteVehicle(id);
        }else if ("repair".equals(action)) {
int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
            double cost = Double.parseDouble(request.getParameter("cost"));
            String problem = request.getParameter("problem");
            vehicleDAO.addRepairRecord(vehicleId, cost, problem);
            vehicleDAO.updateVehicleStatus(vehicleId, "可用");


    }

        response.sendRedirect("VehicleServlet"); // 重定向到车辆列表
    }
}