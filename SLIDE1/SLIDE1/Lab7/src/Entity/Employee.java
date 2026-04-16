package Entity;

public class Employee {
    private int id;
    private String name;
    private double salary;
    public Employee(int id, String name, double salary){
        this.id = id ;
        this.name = name ;
        this.salary = salary ;
    };
    public int getID(){
        return id;
    };
    public void getID(int id){
        this.id = id;
    };
    public String getName(){
        return name;
    };
    public void getName(String name){
        this.name = name;
    };
    public double getSalary(){
        return salary;
    };
    public void getSalary(double salary){
        this.salary = salary;
    };
        @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary =" + salary + "]";
    }
}
