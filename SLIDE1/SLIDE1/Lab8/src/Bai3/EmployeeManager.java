package Bai3;
class Employee {
    @Deprecated
    public double getSalary() {
        return 500;
    }

    public double getBaseSalary() {
        return 500;
    }
}

class Manager extends Employee {
    @Override
    public double getSalary() {
        return getBaseSalary() + 1000;
    }
}
