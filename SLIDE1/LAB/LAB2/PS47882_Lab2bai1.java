package LAB.LAB2;

import java.util.*;

enum Studenttype {
    REGULAR, PART_TIME, INTERNATIONAL
}

class Student {
    private String id;
    private String name;
    private double gpa;
    private Studenttype type;

    public Student(String id, String name, double gpa, Studenttype type) {
        setId(id);
        setName(name);
        setGpa(gpa);
        setType(type);
    }

    public String getId() { return id; }
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID khong duoc rong");
        }
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) {
        if (gpa < 0 || gpa > 4) {
            throw new IllegalArgumentException("GPA phai tu 0 den 4");
        }
        this.gpa = gpa;
    }

    public Studenttype getType() { return type; }
    public void setType(Studenttype type) { this.type = type; }

    @Override
    public String toString() {
        return "Id=" + id + ", name=" + name + ", gpa=" + gpa + ", type=" + type;
    }
}

public class PS47882_Lab2bai1 {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong sinh vien: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.next();
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("GPA: ");
            double gpa = scanner.nextDouble();
            System.out.print("Type (REGULAR, PART_TIME, INTERNATIONAL): ");
            Studenttype type = Studenttype.valueOf(scanner.next().toUpperCase());
            students.add(new Student(id, name, gpa, type));
        }

        // 1. Hien thi danh sach toan bo sinh vien
        System.out.println("\n--- Danh sach sinh vien ---");
        for (Student s : students) {
            System.out.println(s);
        }

        // 2. Hien thi danh sach sinh vien theo tung loai
        System.out.println("\n--- Danh sach theo tung loai ---");
        for (Studenttype t : Studenttype.values()) {
            System.out.println("Loai " + t + ":");
            for (Student s : students) {
                if (s.getType() == t) {
                    System.out.println("   " + s);
                }
            }
        }

        // 3. Dem so luong sinh vien moi loai
        Map<Studenttype, Integer> countMap = new HashMap<>();
        for (Student s : students) {
            countMap.put(s.getType(), countMap.getOrDefault(s.getType(), 0) + 1);
        }

        System.out.println("\n--- Thong ke so luong sinh vien moi loai ---");
        for (Map.Entry<Studenttype, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}