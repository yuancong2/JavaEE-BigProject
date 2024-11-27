/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author SP
 */


import model.Vehicle;
import model.RepairRecord;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    // 获取所有车辆信息1
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicle";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setLicensePlate(rs.getString("license_plate"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setStatus(rs.getString("status"));
                vehicle.setRemark(rs.getString("remark"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    // 更新车辆状态
    public void updateVehicleStatus(int id, String status) {
        String sql = "UPDATE vehicle SET status = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 获取某辆车的维修记录
    public List<RepairRecord> getRepairHistory(int vehicleId) {
        List<RepairRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM car_fixhistroy WHERE vehicle_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vehicleId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    RepairRecord record = new RepairRecord();
                    record.setId(rs.getInt("id"));
                    record.setCost(rs.getDouble("cost"));
                    record.setProblem(rs.getString("problem"));
                    record.setFixTime(rs.getTimestamp("fix_time").toLocalDateTime());
                    record.setVehicleId(rs.getInt("vehicle_id"));
                    records.add(record);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    // 添加维修记录
    public void addRepairRecord(RepairRecord record) {
        String sql = "INSERT INTO car_fixhistroy (cost, problem, fix_time, vehicle_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, record.getCost());
            pstmt.setString(2, record.getProblem());
            pstmt.setTimestamp(3, Timestamp.valueOf(record.getFixTime()));
            pstmt.setInt(4, record.getVehicleId());
            pstmt.executeUpdate();
            System.out.println("114514191981");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}