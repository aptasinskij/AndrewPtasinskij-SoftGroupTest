package ua.aptasinskij.workers;

public class FixedPaymentEmployee extends Employee {

    public FixedPaymentEmployee(double salary, int ID, String name) {
        super(salary, ID, name);
    }

    @Override
    public double getMonthlySalary() {
        return getSalary();
    }

}
