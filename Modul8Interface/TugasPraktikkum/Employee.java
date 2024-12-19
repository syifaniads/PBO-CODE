package Modul8Interface.TugasPraktikkum;

class Employee implements Payable {
    private Integer registrationNumber;
    private String name;
    private Integer salaryPerMonth;
    private Invoice[] invoices;
    public Employee(Integer registrationNumber, String name, Integer salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }
    public double getPayableAmount() {
        double totalInvoicesAmount = 0;
        for (Invoice invoice : invoices) {
            totalInvoicesAmount += invoice.getPayableAmount();
        }
        return salaryPerMonth - totalInvoicesAmount;
    }
    public void displayEmployeeInfo() {
        System.out.println("=============================================");
        System.out.println("===================NOTA======================");
        System.out.println("=============================================");
        System.out.println("Nama Karyawan: " + name);
        System.out.println("Nomor Registrasi: " + registrationNumber);
        System.out.println("Gaji Per Bulan: Rp." + salaryPerMonth);
        System.out.println("Total Gaji Setelah Potongan Tagihan: Rp." + getPayableAmount());
        System.out.println("=============================================");
    }
    public void displayInvoices() {
        System.out.println("================LIST TAGIHAN==================");
        System.out.println("Tagihan untuk Karyawan: " + name);
        for (Invoice invoice : invoices) {
            System.out.println("Produk: " + invoice.getProductName());
            System.out.println("Jumlah: " + 
            invoice.getQuantity());
            System.out.println("Harga Per Item: Rp." + 
            invoice.getPricePerItem());
            System.out.println("Total Tagihan: Rp." + invoice.getPayableAmount());
            System.out.println("=============================================");
        }
    }
}
   