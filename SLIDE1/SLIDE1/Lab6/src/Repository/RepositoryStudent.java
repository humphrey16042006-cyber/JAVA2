package repository;

import Connect.DBConnect;
import Entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryStudent {

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT student_id, student_name, gender, gpa FROM student";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getString("gender"),
                        rs.getDouble("gpa")
                );
                students.add(s);
            }

        } catch (Exception e) {
            System.out.println("Loi khi lay danh sach sinh vien: " + e.getMessage());
        }

        return students;
    }


    public void addStudent(Student student) {
        String sql = "INSERT INTO student(student_name, gender, gpa) VALUES (?, ?, ?)";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getStudentName());
            stmt.setString(2, student.getGender());
            stmt.setDouble(3, student.getGpa());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Them sinh vien thanh cong!");
            }

        } catch (Exception e) {
            System.out.println("Loi khi them sinh vien: " + e.getMessage());
        }
    }
}