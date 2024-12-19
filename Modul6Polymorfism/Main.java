package Modul6Polymorfism;

import java.time.LocalDate;

abstract class Employee {
    private String name;
    private String noKTP;
    private LocalDate dateOfBirth;

    public Employee(String name, String noKTP, LocalDate dateOfBirth) {
        this.name = name;
        this.noKTP = noKTP;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public LocalDate getDateOfBirth() { 
        return dateOfBirth;
    }

    public abstract double earnings();
    
    public String toString() {
        return String.format("Nama: %s\nNo.KTP: %s\nTanggal Lahir: %s", getName(), getNoKTP(), getDateOfBirth());
    }
}

class HourlyEmployee extends Employee {
    private double wage; //upah per jam
    private double hours; //jumlah jam tiap minggu

    public HourlyEmployee(String name, String noKTP, LocalDate dateOfBirth, double wage, double hours) {
        super(name, noKTP, dateOfBirth);
        this.wage = wage;
        this.hours = hours;
    }

    public double earnings() {
        if (hours <= 40)
            return wage * hours;
        else
            return 40 * wage + (hours - 40) * wage * 1.5;
    }

    public String toString() {
        return super.toString() + String.format("\nPendapatan: $%.2f", earnings());
    }
}

class CommissionEmployee extends Employee {
    private double grossSales;//penjualan per minggu
    private double commissionRate;//komisi

    public CommissionEmployee(String name, String noKTP, LocalDate dateOfBirth, double grossSales, double commissionRate) {
        super(name, noKTP, dateOfBirth);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public double earnings() {
        return grossSales * commissionRate;
    }

    public String toString() {
        return super.toString() + String.format("\nPendapatan: $%.2f", earnings());        
    }
}
class ProductionEmployee extends Employee {
    private double productionPerWeek; // Jumlah barang yang diproduksi per minggu
    private double wagePerItem; // Upah per barang

    public ProductionEmployee(String name, String noKTP, LocalDate dateOfBirth, double productionPerWeek, double wagePerItem) {
        super(name, noKTP, dateOfBirth);
        this.productionPerWeek = productionPerWeek;
        this.wagePerItem = wagePerItem;
    }

    public double earnings() {
        return productionPerWeek * wagePerItem;
    }

    public String toString() {
        return super.toString() + String.format("\nPendapatan dari produksi: $%.2f", earnings());
    }
}
class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;//gaji pokok tiap minggu

    public BasePlusCommissionEmployee(String name, String noKTP, LocalDate dateOfBirth, double grossSales, double commissionRate, double baseSalary) {
        super(name, noKTP, dateOfBirth, grossSales, commissionRate); 
        this.baseSalary = baseSalary;
    }

    public double earnings() {
        return super.earnings() + baseSalary;
    }

    public String toString() {
        return super.toString() + String.format("\nPendapatan: $%.2f", earnings());
    }
}

public class Main {
    public static void main(String[] args) {
        LocalDate SarahBirthDate = LocalDate.of(1990, 5, 15);
        LocalDate AgungBirthDate = LocalDate.of(1985, 8, 20);
        LocalDate keanuBirthDate = LocalDate.of(1975, 9, 2);
        LocalDate AlfiBirthDate = LocalDate.of(1995, 4, 5);

        SalariedEmployee salariedEmployee = new SalariedEmployee("Sarah", "135", SarahBirthDate, 800.00);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Agung", "234", AgungBirthDate, 16.75, 40);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Keanu", "145", keanuBirthDate, 10000, 0.06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Alfi", "234", AlfiBirthDate, 5000, 0.04, 300);
        ProductionEmployee productionEmployee = new ProductionEmployee("Tifa", "567", LocalDate.of(1987, 11, 10), 500, 2.50);

        Employee[] employees = { salariedEmployee, hourlyEmployee, commissionEmployee, basePlusCommissionEmployee, productionEmployee };

        int currentMonth = LocalDate.now().getMonthValue();

        for (Employee employee : employees) {
            if (employee.getDateOfBirth().getMonthValue() == currentMonth) {
                System.out.println("=========================================\n");
                System.out.println(employee.getName() + " mendapatkan bonus sebesar $100000 karena ulang tahun!");
                // employee.setBaseSalary(employee.earnings() + 100000);
            }
        }
        System.out.println("=========================================");
        System.out.println("Employees diproses secara polimorfisme:\n");
        
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee);
            System.out.printf("Pendapatan: $%,.2f\n\n", currentEmployee.earnings());
            System.out.println("=========================================");
        }
    }
}
