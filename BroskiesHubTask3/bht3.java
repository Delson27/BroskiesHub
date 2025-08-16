package BroskiesHubTask3;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Employee{
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [Name: " + name + ", Age: " + age + ", Salary: " + salary + "]";
    }
}

public class bht3 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 60000));
        employees.add(new Employee("Bob", 25, 75000));
        employees.add(new Employee("Charlie", 35, 50000));
        employees.add(new Employee("David", 28, 90000));
         

        //Sort by salary(Descending)
        Collections.sort(employees, new Comparator<Employee>(){
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e2.salary, e1.salary);
            }

        });
        System.out.println("Employees sorted by Salary (Descending):");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println();

        //Sort by name(ascending)
        Collections.sort(employees, new Comparator<Employee>(){
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.name.compareTo(e2.name);
            }

        });
        System.out.println("Employees sorted by Name (Ascending):");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println();
    }
}
