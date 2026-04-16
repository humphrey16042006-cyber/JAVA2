package Bai3;

import Bai2.Student;
import Bai4.Util;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> list = new ArrayList<>();
    private final String file = "students.dat";

    public StudentService() {
        list = Util.readFile(file);
    }

    public void add(Student s) {
        list.add(s);
        System.out.println("Them thanh cong!");
    }

    public void remove(String id) {
        boolean found = list.removeIf(s -> s.getId().equals(id));
        if (found) {
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Khong tim thay!");
        }
    }

    public void show() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        list.forEach(System.out::println);
    }

    public void save() {
        Util.writeFile(file, list);
        System.out.println("Da luu file!");
    }
}