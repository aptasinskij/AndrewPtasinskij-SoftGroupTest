package ua.aptasinskij.workers;

/*
* Абстрактний клас для виділення спільної функціональності дочірніх класів та поліморфізму.
* */
public abstract class Employee {

    private double salary;
    private int ID;
    private String name;

    public Employee(double salary, int ID, String name) {
        this.salary = salary;
        this.ID = ID;
        this.name = name;
    }

    public abstract double getMonthlySalary();

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
