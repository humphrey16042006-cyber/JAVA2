package Bai4;

import Bai2.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Student> readFile(String filename) {
        List<Student> list = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("File chua ton tai!");
            return list;
        }

        if (file.length() == 0) {
            System.out.println("File rong!");
            return list;
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            list = (List<Student>) ois.readObject();

        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay class!");
        } catch (IOException e) {
            System.out.println("File loi hoac sai dinh dang!");
        }

        return list;
    }

    public static void writeFile(String filename, List<Student> list) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(filename))) {

            oos.writeObject(list);

        } catch (IOException e) {
            System.out.println("Loi ghi file!");
        }
    }
}