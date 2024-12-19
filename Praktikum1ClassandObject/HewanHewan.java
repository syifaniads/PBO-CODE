package Praktikum1ClassandObject;
import java.util.*;

class Hewan{
    String namaHewan;
    String jenisHewan;
    String namaIlmiahHewan;
    String umurHewan;
    String asal;

    Hewan(String namaHewan, String jenisHewan, String namaIlmiahHewan, String umurHewan, String asal){
        this.namaHewan = namaHewan;
        this.jenisHewan = jenisHewan;
        this.namaIlmiahHewan = namaIlmiahHewan;
        this.umurHewan = umurHewan;
        this.asal = asal;
    }
}
public class HewanHewan {
    public static void main(String[] args) throws Exception {
        Set<Integer> kategoriKategori = new LinkedHashSet<>();
        Map<Integer, ArrayList<Hewan>> mp = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int jumlahhewan = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < jumlahhewan; i++) { 
            String namaHewan= scanner.nextLine();
            String jenisHewan = scanner.nextLine();
            String namaIlmiahHewan = scanner.nextLine();
            String umurHewan = scanner.nextLine();
            String asal = scanner.nextLine();
            int nomorKategori = i + 1;
            kategoriKategori.add(nomorKategori);
            Hewan hewan = new Hewan(namaHewan, jenisHewan, namaIlmiahHewan, umurHewan, asal);
            if (!mp.containsKey(i+1)) {
                mp.put(i+1, new ArrayList<>());
            }
            mp.get(i+1).add(hewan);
        }
        System.out.println("Halo, Selamat datang di Batu Secret Zoo, berikut adalah list hewan kami!");
        for (int hasil : kategoriKategori) {
            System.out.println("============================================================");
            System.out.print(hasil + ". ");
            for (Hewan hewan : mp.get(hasil)) {
                System.out.println("\"" + hewan.namaHewan + "\"");
                System.out.println("hewan ini berjenis \"" + hewan.jenisHewan + "\"");
                System.out.println("dan bernama ilmiah \"" + hewan.namaIlmiahHewan + "\"");
                System.out.println("\"" + hewan.namaHewan + "\" sudah berusia " + hewan.umurHewan + " tahun");
                System.out.println("dan berasal dari negara \"" + hewan.asal + "\"");
                System.out.println("============================================================");
            }
        }
        System.out.println("Terimakasih!");
    }
}