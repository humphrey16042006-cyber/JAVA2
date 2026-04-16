
package Main;

import Bai1.Bai1;
import Bai2.Demo;
import Bai3.Bai3;
import Bai4.Bai4;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== LAB 8 MENU =====");
            System.out.println("1. Bài 1 – Quản lý điểm");
            System.out.println("2. Bài 2 – Quản lý sinh viên");
            System.out.println("3. Bài 3 – Annotation + Reflection");
            System.out.println("4. Bài 4 – Text Block");
            System.out.println("0. Thoát");
            System.out.print("Chọn bài: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> Bai1.main(null);
                case "2" -> Demo.main(null);
                case "3" -> Bai3.main(null);
                case "4" -> Bai4.main(null);
                case "0" -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }

            System.out.println("\nNhấn Enter để tiếp tục...");
            sc.nextLine();
        }
    }
}
