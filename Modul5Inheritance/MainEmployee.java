package Modul5Inheritance;
import java.util.*;

public class MainEmployee {
    public static void main(String[] args) {
        Manager boss = new Manager("Steven", 80000, 1987, 12, 15, 0);
        boss.setBonus(5000);
        Employee staff = new Employee("Donni", 50000, 1989, 10, 1);
        Employee newStaff = new Employee("John"); // Menggunakan constructor baru
        System.out.println("nama boss : " + boss.getName() + ", salary = " + boss.getSalary());
        System.out.println("nama staff : " + staff.getName() + ", salary = " + staff.getSalary());
        System.out.println("nama new staff : " + newStaff.getName() + ", salary = " + newStaff.getSalary());
    }
}

class Employee {
    private String name;
    private double salary;
    private Date hireday;
    
    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
        this.hireday = calendar.getTime();
    }
    
    // Constructor dengan parameter name
    public Employee(String name) {
        this.name = name;
        this.salary = 0; // Misalkan gaji default adalah 0
        this.hireday = new Date(); // Misalkan tanggal hireday adalah tanggal saat ini
    }
    protected Date getHireDay(){
        return hireday;
    }
    protected String getName(){
        return name;
    }
    protected double getSalary(){
        return salary;
    }
    protected void raiseSalary(double byPercent){
        double raise = salary * byPercent/100;
        salary+=raise;
    }
}

class Manager extends Employee {
    private double bonus;
    
    public Manager(String name, double salary, int year, int month, int day, double bonus) {
        super(name, salary, year, month, day);
        this.bonus = bonus;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    
    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
}
