package Main;

import Connect.DBConnect;
import Entity.Employee;
import Repository.EmployeeRepository;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();    
    }
    
    static void JDBC(){
        Connection conn = DBConnect.getConnection();
        if (conn != null) {
                System.out.println("Chuong trinh da ket noi voi MySQL database lab06_jdbc.");
            } else {
                System.out.println("Khong the ket noi voi MySQL database.");
            }
    }
    
    static void menu() {
        Scanner sc = new Scanner(System.in);
        EmployeeRepository RepoEmployee = new EmployeeRepository();
        while (true) {
            System.out.println("===== Quan ly Nhan vien =====");
            System.out.println("1. Xem danh sach nhan vien");
            System.out.println("2. Them nhan vien moi");
            System.out.println("3. Tim kiem nhan vien theo ma");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    JDBC();
                    List<Employee> employees = RepoEmployee.getAllEmployee();
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    JDBC();
                    System.out.print("Nhap ten: ");
                    String name = sc.nextLine();
                    System.out.print("Nhap luong: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    Employee newEmployee = new Employee(0, name, salary);
                    RepoEmployee.addEmployee(newEmployee);
                    break;
                case 3:
                    JDBC();
                    System.out.print("Nhap ma nhan vien can tim: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    Employee found = RepoEmployee.findById(id);
                    if (found != null) {
                        System.out.println("Tim kiem thanh cong!");
                        System.out.println(found);
                    } else {
                        System.out.println("Tim kiem that bai! Khong tim thay nhan vien co ma " + id);
                    }
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    sc.close();
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}