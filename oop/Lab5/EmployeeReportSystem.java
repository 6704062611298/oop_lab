/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

/**
 *
 * @author intel
 */
import java.util.ArrayList;

class Employee {
    private String firstname;
    private String lastname;
    private String id;
    private double salary;

    public Employee(String firstname, String lastname, String id, double sal) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.salary = sal;
    }

    // Calculate earnings after 5% tax deduction
    public double earning() {
        return this.salary * 0.95;
    }

    // Calculate bonus based on working years (>5 years = 12x salary, else 6x salary)
    public double bonus(int year) {
        if (year > 5) {
            return this.salary * 12;
        } else {
            return this.salary * 6;
        }
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getId() { return id; }
}

public class EmployeeReportSystem {
    // Print employee report summary
    public static void printEmp(ArrayList<Employee> arrayEarn, int[] workYears) {
        System.out.printf("%-12s %-12s %-10s %-12s %-12s\n", "First name", "Last name", "ID", "Earning", "Bonus");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < arrayEarn.size(); i++) {
            Employee emp = arrayEarn.get(i);
            int year = workYears[i];
            System.out.printf("%-12s %-12s %-10s %-12.2f %-12.2f\n", 
                emp.getFirstname(), 
                emp.getLastname(), 
                emp.getId(), 
                emp.earning(), 
                emp.bonus(year));
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> arrayEarn = new ArrayList<>();
        
        arrayEarn.add(new Employee("Somchai", "Jaidee", "E001", 30000));
        arrayEarn.add(new Employee("Somsri", "Rukdee", "E002", 50000));

        int[] workYears = {3, 7}; // Example working years

        printEmp(arrayEarn, workYears);
    }
}