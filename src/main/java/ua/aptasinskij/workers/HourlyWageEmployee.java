package ua.aptasinskij.workers;

public class HourlyWageEmployee extends Employee {

    public HourlyWageEmployee(double salary, int ID, String name) {
        super(salary, ID, name);
    }

    @Override
    public double getMonthlySalary() {
        return getSalary() * 20.8 * 8;
    }

}
