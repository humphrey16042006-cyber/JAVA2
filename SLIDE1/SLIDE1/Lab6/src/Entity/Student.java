package Entity;

public class Student {
    private int studentId;
    private String studentName;
    private String gender;
    private double gpa;

    public Student() {}

    public Student(int studentId, String studentName, String gender, double gpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        setGpa(gpa);
    }

    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa > 0 && gpa <= 4) {
            this.gpa = gpa;
        } else {
            System.out.println("GPA khong hop le (0 < GPA <= 4)");
        }
    }

    @Override
    public String toString() {
        return "Student [id=" + studentId + ", name=" + studentName + ", gender=" + gender + ", gpa=" + gpa + "]";
    }
}