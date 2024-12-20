package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 12906
 */
public class StudentDAO {
    // 查询所有学员
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setRegistration_date(rs.getString("registration_date"));
                student.setStatus(rs.getString("status"));
                student.setCoach_id(rs.getInt("coach_id"));
                student.setSession_one(rs.getInt("session_one"));
                student.setSession_two(rs.getInt("session_two"));
                student.setSession_three(rs.getInt("session_three"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

// 添加学员
public void addStudent(Student student) {
    String sql = "INSERT INTO student (name, phone, registration_date, status, coach_id, session_one, session_two, session_three) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, student.getName());
        pstmt.setString(2, student.getPhone());
        pstmt.setString(3, student.getRegistration_date());
        pstmt.setString(4, student.getStatus());
        pstmt.setInt(5, student.getCoach_id()); // 假设 coach_id 是 int 类型
        pstmt.setInt(6, student.getSession_one()); // 假设 session_one 是 int 类型
        pstmt.setInt(7, student.getSession_two()); // 假设 session_two 是 int 类型
        pstmt.setInt(8, student.getSession_three()); // 假设 session_three 是 int 类型
        
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void updateStudent(Student student) {
    String sql = "UPDATE student SET name = ?, phone = ?, registration_date = ?, status = ?, coach_id = ?, session_one = ?, session_two = ?, session_three = ? WHERE id = ?";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, student.getName());
        pstmt.setString(2, student.getPhone());
        pstmt.setString(3, student.getRegistration_date());
        pstmt.setString(4, student.getStatus());
        pstmt.setInt(5, student.getCoach_id()); // 设置教练ID
        pstmt.setInt(6, student.getSession_one()); // 设置第一节课
        pstmt.setInt(7, student.getSession_two()); // 设置第二节课
        pstmt.setInt(8, student.getSession_three()); // 设置第三节课
        pstmt.setInt(9, student.getId()); // ID 作为最后一个参数
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public Student getStudentById(int id) {
    String sql = "SELECT * FROM student WHERE id = ?";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setRegistration_date(rs.getString("registration_date"));
                student.setStatus(rs.getString("status"));
                student.setCoach_id(rs.getInt("coach_id")); // 获取教练ID
                student.setSession_one(rs.getInt("session_one")); // 获取第一节课
                student.setSession_two(rs.getInt("session_two")); // 获取第二节课
                student.setSession_three(rs.getInt("session_three")); // 获取第三节课
                return student;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    public static boolean deleteStudent(int id){
    String sql = "DELETE FROM student WHERE id = ?";
    
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

}
