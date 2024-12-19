package Modul12OperasiFile.TugasPraktikkum;
import java.io.File;
public class SoalNomorDua {
    public static void main(String[] args) {
        System.out.println("[ INI ADALAH PROGRAM MENGHITUNG BESAR UKURAN FILE ]");
        String filePath = "C:/Users/HP PAVILION X360/Desktop/PBO CODE/src/Modul12OperasiFile/AMenulisTeksKeFile/TulisFile1.java";
        mengeprintBesarUkuranFile(filePath);
    }
    private static void mengeprintBesarUkuranFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("File tidak ditemukan atau bukan file yang valid.");
            return;
        }
        long fileSizeInBytes = file.length();
        if (fileSizeInBytes >= 1024 * 1024) {
            System.out.printf("Ukuran file: %.2f MB%n", fileSizeInBytes / 1_048_576.0);
        } else {
            System.out.printf("Ukuran file: %.2f KB%n", fileSizeInBytes / 1024.0);
        }
    }
}

// import java.io.File;
// public class FileSizeConverter {

//     public static void main(String[] args) {
//         // Ganti dengan path file yang ingin Anda cek
//         String filePath = "TulisFile1/to/your/file.ext";

//         File file = new File(filePath);
        
//         if (file.exists() && file.isFile()) {
//             mengeprintBesarUkuranFile(file);
//         } else {
//             System.out.println("File tidak ditemukan atau bukan file yang valid.");
//         }
//     }

//     private static void mengeprintBesarUkuranFile(File file) {
//         long fileSizeInBytes = file.length();
//         double fileSizeInKB = fileSizeInBytes / 1024.0;
//         double fileSizeInMB = fileSizeInKB / 1024.0;

//         if (fileSizeInMB >= 1) {
//             System.out.printf("Ukuran file: %.2f MB%n", fileSizeInMB);
//         } else {
//             System.out.printf("Ukuran file: %.2f KB%n", fileSizeInKB);
//         }
//     }
// }
