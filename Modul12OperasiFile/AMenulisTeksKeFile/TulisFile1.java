package Modul12OperasiFile.AMenulisTeksKeFile;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class TulisFile1 {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk membaca input dari keyboard
        try (Scanner keyboard = new Scanner(System.in)) {
            // Meminta pengguna memasukkan teks
            System.out.print("Masukkan teks yang akan disimpan: ");
            String text = keyboard.nextLine();

            // Menulis teks ke dalam file "test.txt"
            try (FileWriter writer = new FileWriter("test.txt", true)) {
                writer.write(text);
                System.out.println("Teks berhasil disimpan ke file 'test.txt'.");
            } catch (IOException e) {
                System.err.println("Gagal menulis ke file: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}

