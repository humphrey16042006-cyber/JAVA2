package Repository;

import Connect.DBConnect;
import Entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    public List<Employee> getAllEmployee() {
        List<Employee> emp = new ArrayList<>();
        String sql = "SELECT id, name, salary FROM employee";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Employee t = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary")
                );
                emp.add(t);
            }
        } catch (SQLException e) {
            System.err.println("Loi khi lay danh sach Employee: " + e.getMessage());
            e.printStackTrace();
        }
        return emp;
    }

    public void addEmployee(Employee emps) {
        String sql = "INSERT INTO employee (name, salary) VALUES (?, ?)";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emps.getName());
            stmt.setDouble(2, emps.getSalary());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Them Employee thanh cong!");
            }
        } catch (SQLException e) {
            System.err.println("Loi khi them Employee: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Employee findById(int id) {
        String sql = "SELECT id, name, salary FROM employee WHERE id = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Loi khi tim kiem Employee: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}