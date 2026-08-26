/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab7;

/**
 *
 * @author intel
 */
class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getAddressInfo() {
        return street + ", " + city;
    }
}

class Employee {
    protected int id;
    protected String name;
    protected double salary;
    protected Address address;

    public Employee() {}

    public Employee(int id, String name, double salary, Address address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary + 
               ", Address: " + (address != null ? address.getAddressInfo() : "N/A");
    }

    public void setAddress(Address address) { this.address = address; }
    public void setSalary(double salary) { this.salary = salary; }
}

class Manager extends Employee {
    private String parkingNo;

    public Manager(int id, String name, double salary, Address address, String parkingNo) {
        super(id, name, salary, address);
        this.parkingNo = parkingNo;
    }

    public void setParkingNo(String parkingNo) { this.parkingNo = parkingNo; }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Parking No: " + parkingNo;
    }
}

public class EmpDiagram {
    public static void main(String[] args) {
        // Polymorphism: Employee reference points to Manager instance
        Employee emp = new Manager(101, "Somchai", 55000.0, new Address("123 Sukhumvit", "Bangkok"), "P-405");
        
        System.out.println(emp.getDetails());
    }
}