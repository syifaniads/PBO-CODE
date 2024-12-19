package Modul12OperasiFile.TugasPraktikkum;
import java.io.File;
public class SoalNomorEmpat{
    public static void main(String[] args) {
        String directoryPath = "C:/Users/HP PAVILION X360/Documents/example_directory";
        deleteDirectory(directoryPath);
    }

    private static void deleteDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        // Memeriksa apakah directoryPath adalah direktori
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Direktori tidak ditemukan atau bukan direktori yang valid.");
            return;
        }

        // Mendapatkan daftar file di dalam direktori
        File[] filesList = directory.listFiles();

        // Menghapus setiap file di dalam direktori
        if (filesList != null) {
            for (File file : filesList) {
                if (file.isFile()) {
                    file.delete(); // Menghapus file
                    System.out.println("File dihapus: " + file.getName());
                }
            }
        }

        // Menghapus direktori itu sendiri
        if (directory.delete()) {
            System.out.println("Direktori dihapus: " + directoryPath);
        } else {
            System.out.println("Gagal menghapus direktori: " + directoryPath);
        }
    }
}
