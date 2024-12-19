package Modul7FinalStatic.TugasPraktikkum;
import java.util.Scanner;

public class OperasiKalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false; 
        while (!exit) { // loop utama
            System.out.println("================================================");
            System.out.println("=============APLIKASI KALKULATOR================");
            System.out.println("================================================");
            System.out.print("Masukkan angka pertama: ");
            int angka1 = scanner.nextInt(); 
            System.out.print("Masukkan angka kedua: ");
            int angka2 = scanner.nextInt();
            System.out.println("Penjumlahan: " + Calculator.tambah(angka1, angka2));
            System.out.println("Pengurangan: " + Calculator.kurang(angka1, angka2));
            System.out.println("================================================");
            System.out.print("Masukkan angka ketiga untuk perkalian: ");
            int angka3 = scanner.nextInt();
            System.out.print("Masukkan angka keempat untuk pembagian: ");
            int angka4 = scanner.nextInt();
            System.out.println("Perkalian: " + Calculator.kali(angka3, angka4));
            System.out.println("Pembagian: " + Calculator.bagi(angka3, angka4));
            System.out.println("================================================");
            System.out.print("Masukkan pembilang pecahan: ");
            int pembilang = scanner.nextInt();
            System.out.print("Masukkan penyebut pecahan: ");
            int penyebut = scanner.nextInt();
            System.out.println("Pecahan setelah disederhanakan: " + Calculator.sederhana(pembilang, penyebut));
            System.out.println("================================================");
            System.out.println("Apakah Anda ingin keluar? (Y/N)");
            String pilihan = scanner.next();
            if (pilihan.equalsIgnoreCase("Y")) {
                exit = true; // jika pengguna memilih untuk keluar, atur exit ke true untuk keluar dari loop
            }
        }
        scanner.close();
    }
}

class Calculator {
    public static int tambah(int a, int b) {
        return a + b;
    }
    public static int kurang(int a, int b) {
        return a - b;
    }
    public static int kali(int a, int b) {
        return a * b;
    }
    public static double bagi(double a, double b) {
        if (b == 0) {
            System.out.println("Tidak bisa melakukan pembagian dengan nol.");
            return Double.NaN; // NaN = Not a Number
        }
        return a / b;
    }
    public static String sederhana(int pembilang, int penyebut) {
        int gcd = gcd(pembilang, penyebut); // Mencari FPB
        pembilang /= gcd;
        penyebut /= gcd;
        return pembilang + "/" + penyebut;
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
