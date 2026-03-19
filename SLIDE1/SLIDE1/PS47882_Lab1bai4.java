package SLIDE1;

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        setId(id);
        setName(name);
        setGpa(gpa);
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

    @Override
    public String toString() {
        return "Student[id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
    }
};
class GraduateStudent extends Student {
    private String thesisTitle;

    public GraduateStudent(String id, String name, double gpa, String thesisTitle) {
        super(id, name, gpa);
        setThesisTitle(thesisTitle);
    }

    public String getThesisTitle() { return thesisTitle; }
    public void setThesisTitle(String thesisTitle) {
        if (thesisTitle == null || thesisTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Thesis title khong duoc rong");
        }
        this.thesisTitle = thesisTitle;
    }

    @Override
    public String toString() {
        return "GraduateStudent[id=" + getId() + ", name=" + getName() + ", gpa=" + getGpa() + ", thesisTitle=" + thesisTitle + "]";
    }
};
public class PS47882_Lab1bai4 {
    public static void main(String[] args) {
        Student s1 = new Student("PS123","Tai",3.5);
        Student s2 = new Student("PS456","An",3.8);
        GraduateStudent gs1 = new GraduateStudent("PS456","An",3.8,"AI in Healthcare");
        System.out.println(s1);
        System.out.println(s2); 
        System.out.println(gs1);
    }
}
