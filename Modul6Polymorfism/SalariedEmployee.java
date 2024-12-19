package Modul6Polymorfism;
import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private double weeklySalary; //gaji/minggu
    public SalariedEmployee(String name, String noKTP, LocalDate dateOfBirth, double weeklySalary) {
    super(name, noKTP, dateOfBirth);
    this.weeklySalary=weeklySalary;
    }
    public double earnings() {
    return weeklySalary;
    }
    public String toString() {
    return String.format("Salaried employee: " + super.toString() +"\nweekly salary:" + weeklySalary);
    }
}