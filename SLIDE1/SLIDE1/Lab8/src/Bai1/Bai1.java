package Bai1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> scores = new ArrayList<>();

        System.out.println("Nhập 5 điểm kiểm tra (có thể để trống = null):");

        for (int i = 0; i < 5; i++) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                scores.add(null); // giá trị null
            } else {
                scores.add(Integer.parseInt(input)); // Autoboxing
            }
        }

        System.out.println("Danh sách điểm: " + scores);

        double sum = 0;
        int count = 0;

        for (Integer score : scores) {
            if (score != null) { // tránh NullPointerException
                sum += score;   // Unboxing
                count++;
            }
        }

        double avg = (count == 0) ? 0 : sum / count;
        System.out.println("Điểm trung bình: " + avg);

        String rank;
        if (avg >= 8) rank = "Giỏi";
        else if (avg >= 6.5) rank = "Khá";
        else rank = "Trung bình";

        System.out.println("Xếp loại: " + rank);
    }
}
