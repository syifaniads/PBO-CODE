package Modul8Interface.TugasPraktikkum;
import java.util.*;

public class TugasPraktikkumBab8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================================");
        System.out.println("=========KOPERASI KARYAWAN NV. Meneer========");
        System.out.println("=============================================");

//karyawan
        System.out.print("Masukkan Nomor Regitrasi Karyawan: ");
        int registrationNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Masukkan Nama Karyawan: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan gaji Karyawan per Bulan: ");
        int salaryPerMonth = scanner.nextInt();

//Tagihan
        System.out.print("Masukkan Jumlah Tagihan: ");
        int numInvoices = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Invoice[] invoices = new Invoice[numInvoices];
        for (int i = 0; i < numInvoices; i++) {
            System.out.println("=============================================");
            System.out.print("Masukkan Detail Info Tagihan " + (i + 1) + ":");
            System.out.print("\nMasukkan Nama Produk: ");
            String productName = scanner.nextLine();
            System.out.print("Masukkan Kuantitas: ");
            int quantity = scanner.nextInt();
            System.out.print("Masukkan Harga Per Item: ");
            int pricePerItem = scanner.nextInt();
            invoices[i] = new Invoice(productName, quantity, pricePerItem);
            scanner.nextLine(); // Consume newline
        }

//objek Karyawan
        Employee employee = new Employee(registrationNumber, name, salaryPerMonth, invoices);
//tampilan1
        employee.displayEmployeeInfo();
//tampilan2
        employee.displayInvoices();
        scanner.close();
    }
}
