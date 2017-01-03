package ua.aptasinskij.workers;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Даний клас містить методи для вирішення проблем наведених у тестовому завданні.
 */

public class EmployeeProblems {

    /*
     * Метод що вирішує проблему сортування колекції обʼєктів у порядку спадання та виводу необхідної
     * інформації про кожен елемент колекції на екран.
     * Параметри:
     * employeeList - колекція обʼєктів типу Employee яку необхідно відсорутвати;
     * employeeComparator - реалізація інтерфейсу Comparator<T> яка задає необхідний нам алгоритм сортування.
     * */
    public void descendingSortAndPrint(List<Employee> employeeList, Comparator<Employee> employeeComparator) {
        /*
        * Сортуємо колекцію із використанням стандартного Collections API.
        * */
        Collections.sort(employeeList, employeeComparator);

        /*
        * Виводимо інформацію про кожного обʼєкта колекції.
        * */
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    /*
    * Метод що вирішує проблему виводу на екран інформації про перші пʼять обʼєктів типу Employee із колекції.
    * Параметер employeeList - колекція об'єктів типу Employee.
    * */
    public void printFirstFive(List<Employee> employeeList) {
        /*
        * Спочатку необхідно переконатись чи колекція дісно містить хоча б 5 елементів.
        * */
        if (employeeList.size() >= 5) {
            /*
            * Якщо колекція містить білеше 5-ти обʼєктів, то доступ до перших 5 отримуємо
            * за допомогою циклу for із обмеженням управляючої змінної i < 5.
            * */
            for (int i = 0; i < 5; i++) {
                System.out.println(employeeList.get(i));
            }
        } else {
            /*
            * Якщо колекція містить меньше 5-ти обʼєктів, то точне їх число нам не важливе
            * і ми можемо вивести інформацію про всі обʼєкти колекції.
            * */
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }

    /*
    * Метод що вирішує проблему виводу на екран інформації про перші три обʼєкти типу Employee із колекції.
    * Параметер employeeList - колекція об'єктів типу Employee.
    * */
    public void printLastThree(List<Employee> employeeList) {
        /*
        * Спочатку необхідно переконатись чи колекція дісно містить хоча б 3 елементи.
        * */
        if (employeeList.size() >= 3) {
            /*
            * Якщо колекція містить білеше 3-х обʼєктів, то доступ до останніх 3 отримуємо
            * за допомогою циклу for, шляхом обходження колекції з кінця.
            * */
            for (int i = employeeList.size() - 1; i > employeeList.size() - 4; i--) {
                /*
                * Виводимо ID обʼєкта за допомогою відповідного методу get.
                * */
                System.out.println(employeeList.get(i).getID());
            }
        } else {
            /*
            * Якщо колекція містить меньше 3-х обʼєктів, то точне їх число нам не важливе
            * і ми можемо вивести інформацію про всі обʼєкти колекції.
            * */
            for (Employee employee : employeeList) {
                System.out.println(employee.getID());
            }
        }
    }

    /*
    * Метод що вирішує проблему запису колекції обʼєктів типу Employee у файл.
    * Параметр employeeList - колекція обʼєктів типу Employee яку потрібно записати у файл.
    * Параметр fileName - назва файлу в який буде відбуватись запис.
    * */
    public void writeEmployeeListToFile(List<Employee> employeeList, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * Метод що вирішує проблему зчитування колекції обʼєктів типу Employee з файлу.
    * Параметр fileName - назва файлу з якого буде зчитуватись колекція обʼєктів типу Employee.
    * Метод повертає колекцію зчитаних обʼєктів.
    * */
    public List<Employee> readEmployeeListFromFile(String fileName) {
        List<Employee> result = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            result = (List<Employee>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}