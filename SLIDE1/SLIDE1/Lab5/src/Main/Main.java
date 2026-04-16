package Main;

import Bai2.Student;
import Bai3.StudentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        menu();
    }

    static void menu(){
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("======= MENU =======");
            System.out.println("1. Them hoc sinh vao danh sach");
            System.out.println("2. Xoa hoc sinh khoi danh sach");
            System.out.println("3. Hien thi danh sach");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("GPA: ");
                    double gpa = Double.parseDouble(sc.nextLine());

                    service.add(new Student(id, name, gpa));
                    break;

                case 2:
                    System.out.print("Nhap ID can xoa: ");
                    service.remove(sc.nextLine());
                    break;

                case 3:
                    service.show();
                    break;

                case 0:
                    service.save();
                    System.out.println("Thoat!");
                    return;

                default:
                    System.out.println("Sai lua chon!");
            }
        }
    }
}