package Bai4;
import Bai2.Student;

public class Bai4 {
    public static void main(String[] args) {

        String welcome = """
                Xin chào các bạn sinh viên!
                Chào mừng đến với khóa học Lập Trình Java 2.
                Chúc các bạn học tốt!
                """;

        System.out.println(welcome);

        String email = """
                Xin chào %s,

                Đây là email thông báo về lịch học tuần này.
                Vui lòng kiểm tra thông tin chi tiết trong hệ thống.

                Trân trọng,
                Bộ môn CNTT
                """.formatted("Bình");

        System.out.println(email);

        Student st = new Student("S01", "An", 3.5);

        String html = """
                <html>
                    <body>
                        <h1>Thông tin sinh viên</h1>
                        <p>ID: %s</p>
                        <p>Name: %s</p>
                        <p>GPA: %.2f</p>
                    </body>
                </html>
                """.formatted(st.id(), st.name(), st.gpa());

        System.out.println(html);

        String sql = """
                SELECT *
                FROM Students
                WHERE gpa > 3.0;
                """;

        System.out.println(sql);
    }
}