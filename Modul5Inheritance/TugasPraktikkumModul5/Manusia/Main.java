package Modul5Inheritance.TugasPraktikkumModul5.Manusia;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah manusia yang ingin dimasukkan: ");
        int jumlahManusia = scanner.nextInt();
        scanner.nextLine();

        Manusia[] manusiaArray = new Manusia[jumlahManusia];

        for (int i = 0; i < jumlahManusia; i++) {
            System.out.println("\nMasukkan informasi Manusia " + (i + 1) + ":");
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Jenis Kelamin (true=laki-laki, false=perempuan): ");
            boolean jenisKelamin = scanner.nextBoolean();
            scanner.nextLine();
            System.out.print("NIK: ");
            String nik = scanner.nextLine();
            System.out.print("Status Menikah (true=menikah, false=belum menikah): ");
            boolean menikah = scanner.nextBoolean();
            scanner.nextLine();

            System.out.print("Apakah sekarang seorang Pekerja? (true/false): ");
            boolean isPekerja = scanner.nextBoolean();
            scanner.nextLine();

            if (isPekerja) {
                System.out.print("\nTahun Masuk (YYYY-MM-DD): ");
                String tanggalMasukStr = scanner.nextLine();
                LocalDate tahunMasuk = LocalDate.parse(tanggalMasukStr);
                System.out.print("Gaji: ");
                double gaji = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Jumlah Anak: ");
                int jumlahAnak = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Apakah sekarang seorang Manager? (true/false): ");
                boolean isManager = scanner.nextBoolean();
                scanner.nextLine();

                if (isManager) {
                    System.out.print("Departemen: ");
                    String departemen = scanner.nextLine();
                    manusiaArray[i] = new Manager(nama, jenisKelamin, nik, menikah, gaji, tahunMasuk, jumlahAnak, departemen);
                } else {
                    manusiaArray[i] = new Pekerja(nama, jenisKelamin, nik, menikah, gaji, tahunMasuk, jumlahAnak);
                }
            } else {
                System.out.print("NIM: ");
                String nim = scanner.nextLine();
                System.out.print("IPK: ");
                double ipk = scanner.nextDouble();
                scanner.nextLine();

                manusiaArray[i] = new MahasiswaFILKOM(nama, jenisKelamin, nik, menikah, nim, ipk);
            }
        }

        scanner.close();

        for (int i = 0; i < jumlahManusia; i++) {
            System.out.println("\nInformasi Manusia " + (i + 1) + ":");
            System.out.println(manusiaArray[i].toString());
        }
    }
}
interface Pendapatan {
    double getTunjangan();
    double getPendapatan();
}

class Manusia implements Pendapatan {
    private String nama;
    private boolean jenisKelamin;
    private String nik;
    private boolean menikah;

    public Manusia(String nama, boolean jenisKelamin, String nik, boolean menikah) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.nik = nik;
        this.menikah = menikah;
    }

    @Override
    public double getTunjangan() {
        if (menikah) {
            if (jenisKelamin) { 
                return 25.0;
            } else {
                return 20.0;
            }
        } else {
            return 15.0;
        }
    }

    @Override
    public double getPendapatan() {
        return getTunjangan();
    }

    @Override
    public String toString() {
        String jenis = (jenisKelamin) ? "Laki-laki" : "Perempuan";
        String status = (menikah) ? "Menikah" : "Belum Menikah";
        return "Nama: " + nama + "\nNIK: " + nik + "\nJenis Kelamin: " + jenis + "\nStatus: " + status + "\nPendapatan: $" + getPendapatan();
    }
}

class MahasiswaFILKOM extends Manusia {
    private String nim;
    private double ipk;

    public MahasiswaFILKOM(String nama, boolean jenisKelamin, String nik, boolean menikah, String nim, double ipk) {
        super(nama, jenisKelamin, nik, menikah);
        this.nim = nim;
        this.ipk = ipk;
    }

    public String getStatus() {
        String angkatan = nim.substring(0, 2);
        String prodi = "";

        switch (nim.charAt(6)) {
            case '2':
                prodi = "Teknik Informatika";
                break;
            case '3':
                prodi = "Teknik Komputer";
                break;
            case '4':
                prodi = "Sistem Informasi";
                break;
            case '6':
                prodi = "Pendidikan Teknologi Informasi";
                break;
            case '7':
                prodi = "Teknologi Informasi";
                break;
        }

        return prodi + ", 20" + angkatan;
    }

    public double getBeasiswa() {
        if (ipk >= 3.0 && ipk <= 3.5) {
            return 50.0;
        } else if (ipk > 3.5 && ipk <= 4.0) {
            return 75.0;
        } else {
            return 0.0;
        }
    }

    @Override
    public double getPendapatan() {
        double tunjangan = super.getTunjangan();
        double beasiswa = getBeasiswa();
        return tunjangan + beasiswa;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNIM: " + nim + "\nIPK: " + ipk + "\nStatus: " + getStatus();
    }
}
class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(String nama, boolean jenisKelamin, String nik, boolean menikah, double gaji, LocalDate tahunMasuk, int jumlahAnak) {
        super(nama, jenisKelamin, nik, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public int getJumlahAnak() {
        return jumlahAnak;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public double getBonus() {
        LocalDate now = LocalDate.now();
        int yearsOfWork = now.minusYears(tahunMasuk.getYear()).getYear();

        if (yearsOfWork >= 0 && yearsOfWork <= 5) {
            return 0.05 * gaji;
        } else if (yearsOfWork > 5 && yearsOfWork <= 10) {
            return 0.10 * gaji;
        } else {
            return 0.15 * gaji;
        }
    }

    public double getTunjanganAnak() {
        return jumlahAnak * 20.0;
    }

    @Override
    public double getPendapatan() {
        return gaji + getBonus() + getTunjanganAnak();
    }

    @Override
    public String toString() {
        return super.toString() + "\nTahun Masuk: " + tahunMasuk + "\nJumlah Anak: " + jumlahAnak + "\nGaji: $" + gaji;
    }
}
class Manager extends Pekerja {
    private String departemen;

    public Manager(String nama, boolean jenisKelamin, String nik, boolean menikah, double gaji, LocalDate tahunMasuk, int jumlahAnak, String departemen) {
        super(nama, jenisKelamin, nik, menikah, gaji, tahunMasuk, jumlahAnak);
        this.departemen = departemen;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    @Override
    public double getPendapatan() {
        // Tunjangan ditambah sebesar 10% dari gaji
        double tunjangan = super.getGaji() * 0.1;
        return super.getGaji() + super.getBonus() + super.getTunjanganAnak() + tunjangan;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartemen: " + departemen;
    }
}

