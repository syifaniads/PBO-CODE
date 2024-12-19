package Modul10String.TugasPraktikum;
import java.util.TreeMap;
import java.util.Scanner;
public class ProgramPenghitungTokenJava {
    public static void main(String[] args) {
        // Membuat scanner untuk menerima input dari pengguna
        Scanner scanner = new Scanner(System.in);
        // Meminta pengguna untuk memasukkan paragraf
        System.out.print("Masukkan narasi paragraf: ");
        String paragraph = scanner.nextLine();
        // Menghitung frekuensi token
        TreeMap<String, Integer> tokenFrequency = countTokenFrequency(paragraph);
        // Menampilkan hasil
        System.out.println("|Token                          |  Frekuensi |");
        for (String token : tokenFrequency.keySet()) {
            System.out.printf("|%-30s | %-10d |%n", token, tokenFrequency.get(token));
        }
        // Menutup scanner
        scanner.close();
    }
    public static TreeMap<String, Integer> countTokenFrequency(String text) {
        TreeMap<String, Integer> tokenFrequency = new TreeMap<>(); // Automatically sorts by keys
        // Memecah string menjadi token menggunakan regex
        String[] tokens = text.toLowerCase().split("[\\s\\p{Punct}]+");
        for (String token : tokens) {
            if (!token.isEmpty()) {
                tokenFrequency.put(token, tokenFrequency.getOrDefault(token, 0) + 1);
            }
        }
        return tokenFrequency;
    }
}
