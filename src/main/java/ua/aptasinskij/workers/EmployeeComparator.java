package ua.aptasinskij.workers;

import java.util.Comparator;

/*
* Реалізація інтерфейсу Comparator<T> для сортування елементів колекції типу Employee
* у спадаючому порядку заробітньої плати, у випадку рівності - по імені.
* */
public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee firstEmployee, Employee secondEmployee) {
        int salaryCompare = Double.compare(secondEmployee.getSalary(), firstEmployee.getSalary());
        if (salaryCompare != 0){
            return salaryCompare;
        }
        return secondEmployee.getName().compareTo(firstEmployee.getName());
    }

}
