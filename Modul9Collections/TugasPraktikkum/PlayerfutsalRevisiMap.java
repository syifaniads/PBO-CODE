package Modul9Collections.TugasPraktikkum;
import java.util.HashMap;
import java.util.Map;

public class PlayerfutsalRevisiMap {
 public static void main(String[] args) {
 // a) Implementasi Map untuk menyimpan data tim A dan tim B
 Map<Integer, Player> timA = new HashMap<>();
 Map<Integer, Player> timB = new HashMap<>();
 initializeData(timA, timB);
 // b) Update data Map untuk tim B sesuai dengan kesalahan pencatatan
 updateTimB(timB, 168, 66);
 // c) Implementasi Map untuk menyimpan data tinggi badan dan berat badan yang sama
 Map<Integer, Player> tinggiSama = new HashMap<>();
 populateTinggiSama(timA, timB, tinggiSama);
 // d) Update data Map untuk tim A berdasarkan kondisi terakhir
 updateTimA(timA, tinggiSama);
 System.out.println("================================================================================");
 System.out.println("a) Implementasi Map untuk menyimpan data tim A dan tim B:\n");
 System.out.println("No | Tim A - Tinggi | Tim A -Berat | Tim B - Tinggi | Tim B - Berat");
 System.out.println("------------------------------------------------------------------------");
 printMap(timA, timB);
 System.out.println("\nb) Update data Map untuk tim B sesuai dengan kesalahan pencatatan:\n");
 printMapTimB(timB);
 System.out.println("\nc) Implementasi Map untuk menyimpan data tinggi badan dan berat badan yang sama:\n");
 System.out.println("No | Tim A - Tinggi | Tim A - Berat | Tim B - Tinggi | Tim B - Berat");
 System.out.println("------------------------------------------------------------------------");
 printMap(tinggiSama);
 System.out.println("\nJawaban d) Update data Map untuk tim A berdasarkan kondisi terakhir:\n");
 System.out.println("No | Tim A - Tinggi | Tim A - Berat | Tim B - Tinggi | Tim B - Berat");
 System.out.println("------------------------------------------------------------------------");
 printMap(timA, timB);
 System.out.println("================================================================================");
}
 public static void initializeData(Map<Integer, Player> timA, Map<Integer, Player> timB) {
 // Isi data tim A
 timA.put(1, new Player(168, 50));
 timA.put(2, new Player(170, 60));
 timA.put(3, new Player(165, 56));
 timA.put(4, new Player(168, 55));
 timA.put(5, new Player(172, 60));
 timA.put(6, new Player(170, 70));
 timA.put(7, new Player(169, 66));
 timA.put(8, new Player(165, 56));
 timA.put(9, new Player(171, 72));
 timA.put(10, new Player(166, 56));
 
 timB.put(1, new Player(170, 66));
 timB.put(2, new Player(167, 60));
 timB.put(3, new Player(165, 59));
 timB.put(4, new Player(166, 58));
 timB.put(5, new Player(168, 58));
 timB.put(6, new Player(175, 71));
 timB.put(7, new Player(172, 68));
 timB.put(8, new Player(171, 68));
 timB.put(9, new Player(168, 65));
 timB.put(10, new Player(169, 60));
 }
 public static void updateTimB(Map<Integer, Player> timB, int tinggiBadan, int beratBadan) {
    Player player = timB.get(tinggiBadan);
    if (player != null) {
        player.setBeratBadan(beratBadan);
    }
 }
 public static void populateTinggiSama(Map<Integer, Player> timA, Map<Integer, Player> timB, Map<Integer, Player> tinggiSama) {
    for (Map.Entry<Integer, Player> entryA : timA.entrySet()) {
        Player playerA = entryA.getValue();
        Player playerB = timB.get(entryA.getKey());
        if (playerB != null && playerA.getTinggiBadan() == playerB.getTinggiBadan()) {
            tinggiSama.put(entryA.getKey(), playerA);
        }
    }
  }
  public static void updateTimA(Map<Integer, Player> timA, Map<Integer, Player> tinggiSama) {
  timA.entrySet().removeIf(entry -> entry.getValue().getTinggiBadan() < 168);
  }
  public static void printMap(Map<Integer, Player> timA, Map<Integer, Player> timB) {
    for (int i = 1; i <= 10; i++) {
        Player playerA = timA.get(i);
        Player playerB = timB.get(i);
        if (playerA != null && playerB != null) {
            System.out.printf("%-3d | %-15d | %-14d | %-14d | %-13d%n",i, playerA.getTinggiBadan(), playerA.getBeratBadan(),playerB.getTinggiBadan(), playerB.getBeratBadan());
        }
    }
  }
  public static void printMapTimB(Map<Integer, Player> timB){
    System.out.println("No | Tim B - Tinggi | Tim B - Berat"); 
    System.out.println("-------------------------------------");
    for (int i = 1; i <= 10; i++) {
        Player playerB = timB.get(i);
        if (playerB != null) {
            System.out.printf("%-3d | %-15d | %-13d%n", i, playerB.getTinggiBadan(), playerB.getBeratBadan());
        }
    }
}
public static void printMap(Map<Integer, Player> tinggiSama) {
    for (Map.Entry<Integer, Player> entry : tinggiSama.entrySet()) {
        Player player = entry.getValue();
        System.out.printf("%-3d | %-15d | %-14d | %-14d | %-13d%n", entry.getKey(), player.getTinggiBadan(), player.getBeratBadan(), player.getTinggiBadan(), player.getBeratBadan());
    }
}
static class Player {
    private int tinggiBadan;
    private int beratBadan;
    public Player(int tinggiBadan, int beratBadan) {
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
 }
  public int getTinggiBadan() {
    return tinggiBadan;
 }
 public int getBeratBadan() {
    return beratBadan;
 }
 public void setBeratBadan(int beratBadan) {
    this.beratBadan = beratBadan;
 }
}
}