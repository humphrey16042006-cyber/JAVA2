package SLIDE1;
// Lớp Employee
class Employee {
    private String id;
    private String name;
    private double basicSalary;

    public Employee(String id, String name, double basicSalary) {
        setId(id);
        setName(name);
        setBasicSalary(basicSalary);
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

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) {
        if (basicSalary < 0) {
            throw new IllegalArgumentException("Luong co ban phai >= 0");
        }
        this.basicSalary = basicSalary;
    }

    public double income() {
        return basicSalary;
    }

    @Override
    public String toString() {
        return "Employee[id=" + id + ", name=" + name + ", income=" + income() + "]";
    }
}

// FullTimeEmployee
class FullTimeEmployee extends Employee {
    private double bonus;
    private double penalty;

    public FullTimeEmployee(String id, String name, double basicSalary, double bonus, double penalty) {
        super(id, name, basicSalary);
        setBonus(bonus);
        setPenalty(penalty);
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) {
        if (bonus < 0) throw new IllegalArgumentException("Bonus >= 0");
        this.bonus = bonus;
    }

    public double getPenalty() { return penalty; }
    public void setPenalty(double penalty) {
        if (penalty < 0) throw new IllegalArgumentException("Penalty >= 0");
        this.penalty = penalty;
    }

    @Override
    public double income() {
        return getBasicSalary() + bonus - penalty;
    }
}

// PartTimeEmployee
class PartTimeEmployee extends Employee {
    private double workingHours;
    private double hourlyRate;

    public PartTimeEmployee(String id, String name, double workingHours, double hourlyRate) {
        super(id, name, 0); // basicSalary không dùng
        setWorkingHours(workingHours);
        setHourlyRate(hourlyRate);
    }

    public double getWorkingHours() { return workingHours; }
    public void setWorkingHours(double workingHours) {
        if (workingHours < 0) throw new IllegalArgumentException("Gio lam >= 0");
        this.workingHours = workingHours;
    }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) throw new IllegalArgumentException("Rate >= 0");
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double income() {
        return workingHours * hourlyRate;
    }
}

// Main
public class PS47882_Lab1Bai2 {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("E01", "An", 5000, 1000, 200);
        Employee e2 = new FullTimeEmployee("E02", "Binh", 6000, 500, 100);
        Employee e3 = new PartTimeEmployee("E03", "Cuong", 100, 50);
        Employee e4 = new PartTimeEmployee("E04", "Dung", 80, 60);
        Employee e5 = new Employee("E05", "Ha", 4000);

        Employee[] employees = {e1, e2, e3, e4, e5};

        // In danh sách
        for (Employee e : employees) {
            System.out.println(e + " | Income = " + e.income());
        }

        // Tìm nhân viên có thu nhập cao nhất
        Employee maxEmp = employees[0];
        for (Employee e : employees) {
            if (e.income() > maxEmp.income()) {
                maxEmp = e;
            }
        }
        System.out.println("Nhan vien co thu nhap cao nhat: " + maxEmp);
    }
}