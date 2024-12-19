package Modul7FinalStatic.TugasPraktikkum;
import java.util.Scanner;

public class Labkomdas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================================");
        System.out.println("=================TOKO BELI BAJU=================");
        System.out.println("================================================");
        System.out.print("Masukkan jumlah pembelian jaket A: ");
        int jumlahA = scanner.nextInt();
        System.out.print("Masukkan jumlah pembelian jaket B: ");
        int jumlahB = scanner.nextInt();
        System.out.print("Masukkan jumlah pembelian jaket C: ");
        int jumlahC = scanner.nextInt();
        System.out.println("================================================");
        JenisJaket jaketA = new JaketA();
        JenisJaket jaketB = new JaketB();
        JenisJaket jaketC = new JaketC();
        int totalHarga = jaketA.hitungTotalHarga(jumlahA) +
                         jaketB.hitungTotalHarga(jumlahB) +
                         jaketC.hitungTotalHarga(jumlahC);

        System.out.println("Total harga: Rp " + totalHarga);
        System.out.println("================================================");

        scanner.close();
    }
}
interface JenisJaket {
    final int HARGA_A = 100000;
    final int HARGA_B = 125000;
    final int HARGA_C = 175000;
    int hitungTotalHarga(int jumlah);
}
class JaketA implements JenisJaket {
    static final int DISKON_A = 95000;

    public int hitungTotalHarga(int jumlah) {
        if (jumlah > 100) {
            return jumlah * DISKON_A;
        } else {
            return jumlah * HARGA_A;
        }
    }
}
class JaketB implements JenisJaket {
    static final int DISKON_B = 120000;

    public int hitungTotalHarga(int jumlah) {
        if (jumlah > 100) {
            return jumlah * DISKON_B;
        } else {
            return jumlah * HARGA_B;
        }
    }
}
class JaketC implements JenisJaket {
    static final int DISKON_C = 160000;

    public int hitungTotalHarga(int jumlah) {
        if (jumlah > 100) {
            return jumlah * DISKON_C;
        } else {
            return jumlah * HARGA_C;
        }
    }
}
