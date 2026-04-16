package Bai2;

public record Student(String id, String name, double gpa) {

    public Student {
        if (gpa < 0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA không hợp lệ: " + gpa);
        }
    }

    public boolean isScholarshipEligible() {
        return gpa >= 3.2;
    }
}

