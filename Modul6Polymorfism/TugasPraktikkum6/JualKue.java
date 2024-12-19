package Modul6Polymorfism.TugasPraktikkum6;
import java.util.Scanner;

public class JualKue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kue[] kueArray = new Kue[40];
        // Input data kue pesanan
        int numKuePesanan = inputJumlahKue(scanner, "pesanan");
        scanner.nextLine();
        for (int i = 0; i < numKuePesanan; i++) {
            System.out.println("Masukkan nama kue pesanan " + (i + 1) + ": ");
            String nama = scanner.nextLine();
            System.out.println("Masukkan harga kue pesanan " + (i + 1) + ": ");
            double harga = scanner.nextDouble();
            System.out.println("Masukkan berat kue pesanan " + (i + 1) + ": ");
            double berat = scanner.nextDouble();
            scanner.nextLine(); // membersihkan newline buffer

            kueArray[i] = new KuePesanan(nama, harga, berat);
        }

        // Input data kue jadi
        for (int i = numKuePesanan; i < 3; i++) {
            System.out.println("Masukkan nama kue jadi " + (i - numKuePesanan + 1) + ": ");
            String nama = scanner.nextLine();
            System.out.println("Masukkan harga kue jadi " + (i - numKuePesanan + 1) + ": ");
            double harga = scanner.nextDouble();
            System.out.println("Masukkan jumlah kue jadi " + (i - numKuePesanan + 1) + ": ");
            double jumlah = scanner.nextDouble();
            scanner.nextLine(); // membersihkan newline buffer

            kueArray[i] = new KueJadi(nama, harga, jumlah);
        }

        scanner.close();

        // Tampilkan semua kue dan jenisnya
        System.out.println("Daftar Semua Kue:");
        for (Kue kue : kueArray) {
            if (kue != null) {
                System.out.println(kue);
            }
        }
        System.out.println();

        // Hitung total harga semua kue
        double totalHarga = 0;
        for (Kue kue : kueArray) {
            if (kue != null) {
                totalHarga += kue.hitungHarga();
            }
        }
        System.out.printf("Total Harga Semua Kue: %.2f\n", totalHarga);

        // Hitung total harga dan total berat dari KuePesanan
        double totalHargaKuePesanan = 0;
        double totalBeratKuePesanan = 0;
        for (Kue kue : kueArray) {
            if (kue instanceof KuePesanan) {
                totalHargaKuePesanan += kue.hitungHarga();
                totalBeratKuePesanan += ((KuePesanan) kue).berat;
            }
        }
        System.out.printf("Total Harga Kue Pesanan: %.2f\n", totalHargaKuePesanan);
        System.out.printf("Total Berat Kue Pesanan: %.2f\n", totalBeratKuePesanan);

        // Hitung total harga dan total jumlah dari KueJadi
        double totalHargaKueJadi = 0;
        double totalJumlahKueJadi = 0;
        for (Kue kue : kueArray) {
            if (kue instanceof KueJadi) {
                totalHargaKueJadi += kue.hitungHarga();
                totalJumlahKueJadi += ((KueJadi) kue).jumlah;
            }
        }
        System.out.printf("Total Harga Kue Jadi: %.2f\n", totalHargaKueJadi);
        System.out.printf("Total Jumlah Kue Jadi: %.2f\n", totalJumlahKueJadi);

        // Cari dan tampilkan informasi kue dengan harga terbesar
        Kue kueTerbesar = kueArray[0];
        for (Kue kue : kueArray) {
            if (kue != null && kue.hitungHarga() > kueTerbesar.hitungHarga()) {
                kueTerbesar = kue;
            }
        }
        System.out.println("Informasi Kue dengan Harga Terbesar:");
        System.out.println(kueTerbesar);
    }

    // Method untuk input jumlah kue pesanan
    private static int inputJumlahKue(Scanner scanner, String jenis) {
        System.out.println("Masukkan jumlah kue " + jenis + " yang ingin dimasukkan: ");
        return scanner.nextInt();
    }
}

abstract class Kue {
    protected String nama;
    protected double harga;

    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public abstract double hitungHarga();

    @Override
    public String toString() {
        return String.format("Kue %s - Harga: %.2f", nama, hitungHarga());
    }
}

class KuePesanan extends Kue {
    double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    @Override
    public double hitungHarga() {
        return harga * berat;
    }
}

class KueJadi extends Kue {
    double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    @Override
    public double hitungHarga() {
        return harga * jumlah * 2;
    }
}
