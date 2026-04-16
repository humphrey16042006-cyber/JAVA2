package Bai2;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("S01", "An", 3.5),
                new Student("S02", "Bình", 2.8),
                new Student("S03", "Chi", 3.9)
        );

        System.out.println("Sinh viên đủ điều kiện học bổng:");
        students.stream()
                .filter(Student::isScholarshipEligible)
                .forEach(System.out::println);
    }
}
