package Bai1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "data.txt";
        List<String> listName = Arrays.asList("HH", "TT", "KK", "AA");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String name : listName) {
                bw.write(name);
                bw.newLine();
            }
            System.out.println("Da ghi file: " + filePath);
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Noi dung trong file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}