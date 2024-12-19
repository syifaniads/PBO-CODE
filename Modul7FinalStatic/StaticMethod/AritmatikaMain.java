package Modul7FinalStatic.StaticMethod;
import java.util.*;

public class AritmatikaMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("masukkan nilai 1 : ");
        int nil1 = in.nextInt();
        System.out.print("masukkan nilai 2 : ");
        int nil2 = in.nextInt();
        // memanggil method static
        Aritmatika.hitungPengurangan(nil1, nil2);
        System.out.print("masukkan nilai 1 : ");
        nil1 = in.nextInt();
        System.out.print("masukkan nilai 2 : ");
        nil2 = in.nextInt();
        // memanggil method static
        Aritmatika.hitungPerkalian(nil1, nil2);
        System.out.print("masukkan nilai 1 : ");
        int value1 = in.nextInt();
        System.out.print("masukkan nilai 2 : ");
        int value2 = in.nextInt();
        // memanggil method NONstatic harus melalui objek
        Aritmatika a = new Aritmatika();
        a.hitungPenjumlahan(value1, value2);
        // memanggil method nonstatic
        in.nextLine();
        System.out.print("masukkan nilai 1 : ");
        String val1 = in.nextLine();
        System.out.print("masukkan nilai 2 : ");
        String val2 = in.nextLine();
        System.out.println("nilai pembagian adalah : " + a.hitungPembagian(val1, val2));
    }
}
