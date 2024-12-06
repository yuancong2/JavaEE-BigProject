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
    // 查询所有车辆
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

    // 添加车辆
    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicle (license_plate, model, status, remark) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vehicle.getLicensePlate());
            pstmt.setString(2, vehicle.getModel());
            pstmt.setString(3, vehicle.getStatus());
            pstmt.setString(4, vehicle.getRemark());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 更新车辆信息
public void updateVehicle(Vehicle vehicle) {
    String sql = "UPDATE vehicle SET license_plate=?, model=?, status=?, remark=? WHERE id=?";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, vehicle.getLicensePlate());
        pstmt.setString(2, vehicle.getModel());
        pstmt.setString(3, vehicle.getStatus()); // 更新状态
        pstmt.setString(4, vehicle.getRemark());
        pstmt.setInt(5, vehicle.getId());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    // 删除车辆


    // 根据ID获取车辆信息
    public Vehicle getVehicleById(int id) {
        String sql = "SELECT * FROM vehicle WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setLicensePlate(rs.getString("license_plate"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setStatus(rs.getString("status"));
                vehicle.setRemark(rs.getString("remark"));
                return vehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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

public boolean deleteVehicle(int id) {
    String sql = "DELETE FROM vehicle WHERE id = ?";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        int rowsAffected = pstmt.executeUpdate(); // 获取受影响的行数
        return rowsAffected > 0; // 如果删除了至少一行，返回 true
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // 如果发生异常，返回 false
    }
}

public void addRepairRecord(int vehicleId, double cost, String problem) {
    String sql = "INSERT INTO car_fixhistroy (cost, problem, fix_time, vehicle_id) VALUES (?, ?, NOW(), ?)";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setDouble(1, cost);
        pstmt.setString(2, problem);
        pstmt.setInt(3, vehicleId);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
  
}