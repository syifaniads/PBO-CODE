package Modul12OperasiFile.TugasPraktikkum;

import java.io.File;

public class SoalNomorTiga {
    public static void main(String[] args) {
        System.out.println("[] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] []");
        System.out.println("[ INI ADALAH PROGRAM MENAMPILKAN FILE DIREKTORI ]");
        System.out.println("[] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] []");
        String directoryPath = "C:/Users/HP PAVILION X360/Documents";
        listFiles(directoryPath);
    }

    private static void listFiles(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Direktori tidak ditemukan atau bukan direktori yang valid.");
            return;
        }

        File[] filesList = directory.listFiles();

        if (filesList != null && filesList.length > 0) {
            System.out.println("Daftar file di dalam direktori " + directoryPath + ":");
            for (File file : filesList) {
                if (file.isFile()) {
                    System.out.println("[ File: " + file.getName() + " ]");
                } else if (file.isDirectory()) {
                    System.out.println();
                    System.out.println("[ Direktori: " + file.getName() + " ]");
                }
            }
        } else {
            System.out.println("Direktori kosong.");
        }
    }
}

