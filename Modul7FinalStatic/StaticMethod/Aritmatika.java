package Modul7FinalStatic.StaticMethod;

public class Aritmatika {
    public void hitungPenjumlahan(int a, int b) {
        int nilai = a + b;
        // hitungPenjumlahan(a, b);
        System.out.println("nilai penjumlahan adalah : " + nilai);
    }

    public static void hitungPerkalian(int a, int b) {
        // hitungPenjumlahan(a, b);
        int nilai = a * b;
        System.out.println("nilai perkalian adalah : " + nilai);
    }

    public static void hitungPengurangan(int a, int b) {
        int nilai = a - b;
        System.out.println("nilai pengurangan adalah :" + nilai);
    }

    public double hitungPembagian(String nil, String nil2) {
        double a = Double.parseDouble(nil);
        double b = Double.parseDouble(nil2);
        return a / b;
    }
}