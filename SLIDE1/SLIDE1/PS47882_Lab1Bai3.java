package SLIDE1;
public class PS47882_Lab1Bai3 {
    public static void main(String[] args) {
        Employee e1 = null, e2 = null, e3 = null, e4 = null, e5 = null;

        try {
            e1 = new Employee("E01", "An", -5000); // ❌ basicSalary âm
        } catch (Exception ex) {
            System.out.println("Loi tao e1: " + ex.getMessage());
            e1 = new Employee("E01", "An", 5000); // ✅ fix
        }

        try {
            e2 = new FullTimeEmployee("E02", "Binh", 6000, -50, 100); // ❌ bonus âm
        } catch (Exception ex) {
            System.out.println("Loi tao e2: " + ex.getMessage());
            e2 = new FullTimeEmployee("E02", "Binh", 6000, 500, 100); // ✅ fix
        }

        try {
            e3 = new FullTimeEmployee("E03", "Cuong", 5000, 500, -100); // ❌ penalty âm
        } catch (Exception ex) {
            System.out.println("Loi tao e3: " + ex.getMessage());
            e3 = new FullTimeEmployee("E03", "Cuong", 5000, 500, 100); // ✅ fix
        }

        try {
            e4 = new PartTimeEmployee("E04", "Dung", -10, 50); // ❌ workingHours âm
        } catch (Exception ex) {
            System.out.println("Loi tao e4: " + ex.getMessage());
            e4 = new PartTimeEmployee("E04", "Dung", 100, 50); // ✅ fix
        }

        e5 = new PartTimeEmployee("E05", "Ha", 80, 60); // ✅ hợp lệ

        Employee[] employees = {e1, e2, e3, e4, e5};
        for (Employee e : employees) {
            System.out.println(e.getName() + " - Thu nhap: " + e.income());
        }
    }
}