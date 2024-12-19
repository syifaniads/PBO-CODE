package Praktikum3EncapsulationandInheritance;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagemenAnggotaPerpustakaan<S extends AnggotaPerpustakaan> {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<AnggotaPerpustakaan> userList = new ArrayList<>();
        ManagemenAnggotaPerpustakaan<AnggotaPerpustakaan> management = new ManagemenAnggotaPerpustakaan<>();
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Anggota Biasa");
            System.out.println("2. Tambah Anggota Premium");
            System.out.println("3. Tampilkan Semua Anggota");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            System.out.println();
            
            switch (menu) {
                case 1:
                    management.addUser(scanner, userList, true);
                    break;
                    
                case 2:
                    management.addUser(scanner, userList, false);
                    break;
                    
                case 3:
                    management.displayAllUsers(userList);
                    break;
                    
                case 4:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Pilihan tidak valid!\n");
                    break;
            }
        }
    }
    
    private void addUser(Scanner scanner, ArrayList<AnggotaPerpustakaan> userList, boolean isBiasa) {
        System.out.println("Masukkan nama anggota:");
        scanner.nextLine();
        String nama = scanner.nextLine();
        System.out.println("Masukkan alamat anggota:");
        String alamat = scanner.nextLine();
        System.out.println("Masukkan nomor anggota:");
        int nomor = scanner.nextInt();
        if (isBiasa) {
            System.out.println("Masukkan batas peminjaman:");
            int batasPeminjaman = scanner.nextInt();
            System.out.println("Masukkan batas waktu:");
            int batasWaktu = scanner.nextInt();
            userList.add(new AnggotaBiasa(nama, alamat, nomor, batasPeminjaman, batasWaktu));
            System.out.println("Anggota Biasa berhasil ditambahkan.");
        } else {
            userList.add(new AnggotaPremium(nama, alamat, nomor));
            System.out.println("Anggota Premium berhasil ditambahkan.");
        }
        System.out.println();
    }
    
    private void displayAllUsers(ArrayList<AnggotaPerpustakaan> userList) {
        System.out.println("Daftar Semua Anggota:");
        for (AnggotaPerpustakaan user : userList) {
            System.out.println("Nama: " + user.getNama());
            System.out.println("Alamat: " + user.getAlamat());
            System.out.println("Nomor Anggota: " + user.getNomorAnggota());
            if (user instanceof AnggotaBiasa) {
                AnggotaBiasa anggotaBiasa = (AnggotaBiasa) user;
                System.out.println("Batas Peminjaman: " + anggotaBiasa.getBatasPeminjaman());
                System.out.println("Batas Waktu: " + anggotaBiasa.getBatasWaktu());
            }
            System.out.println();
        }
    }
}

abstract class AnggotaPerpustakaan {
    private String nama;
    private String alamat;
    private int nomorAnggota;

    public AnggotaPerpustakaan(String nama, String alamat, int nomorAnggota) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomorAnggota = nomorAnggota;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getNomorAnggota() {
        return nomorAnggota;
    }
}

class AnggotaPremium extends AnggotaPerpustakaan {
    public AnggotaPremium(String nama, String alamat, int nomorAnggota) {
        super(nama, alamat, nomorAnggota);
    }
}

class AnggotaBiasa extends AnggotaPerpustakaan {
    private int batasPeminjaman;
    private int batasWaktu;
    
    public AnggotaBiasa(String nama, String alamat, int nomorAnggota, int batasPeminjaman, int batasWaktu) {
        super(nama, alamat, nomorAnggota);
        this.batasPeminjaman = batasPeminjaman;
        this.batasWaktu = batasWaktu;
    }

    public int getBatasPeminjaman() {
        return batasPeminjaman;
    }

    public int getBatasWaktu() {
        return batasWaktu;
    }
}
