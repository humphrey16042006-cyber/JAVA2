package Main;

import Connect.DBConnect;
import java.sql.Connection;
import repository.RepositoryStudent;
import Entity.Student;
import Entity.Tree;
import java.util.List;
import java.util.Scanner;
import repository.RepositoryTree;

public class Main {         
    
    public static void main(String[] args) {
        menu();
    }
    static void JDBC(){
        Connection conn = DBConnect.getConnection();
        if (conn != null) {
            System.out.println("Chuong trinh da ket noi voi MySQL database lab06_jdbc1.");
        } else {
            System.out.println("Khong the ket noi voi MySQL database.");
        }
    }
    static void menu(){
        Scanner sc = new Scanner(System.in);
        RepositoryStudent StudentRepo = new RepositoryStudent();
        RepositoryTree TreeRepo = new RepositoryTree();
        while (true) {
            System.out.println("===== Quan ly Sinh Vien =====");
            System.out.println("1. Xem danh sach sinh vien");
            System.out.println("2. Them sinh vien moi");
            System.out.println("3. Xem danh sach node");
            System.out.println("4. Them node moi");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    JDBC();
                    List<Student> students = StudentRepo.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 2:
                    JDBC();
                    System.out.print("Nhap ten sinh vien: ");
                    String name = sc.nextLine();
                    System.out.print("Nhap gioi tinh: ");
                    String gender = sc.nextLine();
                    System.out.print("Nhap GPA: ");
                    double gpa = sc.nextDouble();
                    sc.nextLine();

                    Student newStudent = new Student(0, name, gender, gpa);
                    StudentRepo.addStudent(newStudent);
                    break;

                case 3:
                    JDBC();
                    List<Tree> nodes = TreeRepo.getAllNodes();
                    for (Tree t : nodes) {
                        System.out.println(t);
                    }
                    break;

                case 4:
                    JDBC();
                    System.out.print("Nhap ten node: ");
                    String nodeName = sc.nextLine();
                    System.out.print("Nhap parent id (neu khong co thi nhap -1): ");
                    int parentId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhap level: ");
                    int level = sc.nextInt();
                    sc.nextLine();

                    Tree newNode = new Tree(0, nodeName, parentId == -1 ? null : parentId, level);
                    TreeRepo.addNode(newNode);
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
