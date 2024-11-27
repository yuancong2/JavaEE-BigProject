/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
/**
 *
 * @author SP
 */
public class RepairRecord {
    private int id;                   // 修理记录编号
    private double cost;              // 修理费用
    private String problem;           // 问题描述
    private LocalDateTime fixTime;    // 修理时间
    private int vehicleId;            // 关联车辆编号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public LocalDateTime getFixTime() {
        return fixTime;
    }

    public void setFixTime(LocalDateTime fixTime) {
        this.fixTime = fixTime;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}