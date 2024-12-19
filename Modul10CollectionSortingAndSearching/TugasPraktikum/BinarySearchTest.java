package Modul10CollectionSortingAndSearching.TugasPraktikum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BinarySearchTest {
    public static void main(String[] args) {
        // Definisi/inisialisasi data untuk Tim A
        List<Player> TimA = new ArrayList<>(Arrays.asList(
            new Player(168, 50), new Player(170, 60), new Player(165, 56), new Player(168, 55),
            new Player(172, 60), new Player(170, 70), new Player(169, 66), new Player(165, 56),
            new Player(171, 72), new Player(166, 56)
        ));

        // Definisi/inisialisasi data untuk Tim B
        List<Player> TimB = new ArrayList<>(Arrays.asList(
            new Player(170, 66), new Player(167, 60), new Player(165, 59), new Player(166, 58),
            new Player(168, 58), new Player(175, 71), new Player(172, 68), new Player(171, 68),
            new Player(168, 65), new Player(169, 60)
        ));

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=================================================================");
            System.out.println("Pilih opsi:");
            System.out.println("1. Cari tinggi badan yang sama antara Tim A dan Tim B");
            System.out.println("2. Cari berat badan yang sama antara Tim A dan Tim B");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                break;
            }

            switch (choice) {
                case 1:
                    // Mengurutkan Tim A dan Tim B berdasarkan tinggi badan
                    Collections.sort(TimA, (p1, p2) -> Integer.compare(p1.getHeight(), p2.getHeight()));
                    Collections.sort(TimB, (p1, p2) -> Integer.compare(p1.getHeight(), p2.getHeight()));

                    // Mengecek tinggi badan yang sama
                    System.out.println("Mencari tinggi badan yang sama antara Tim A dan Tim B:");
                    for (Player playerB : TimB) {
                        if (binarySearchHeight(TimA, playerB.getHeight())) {
                            System.out.printf("Ditemukan pemain dengan tinggi badan %d cm di kedua tim.\n", playerB.getHeight());
                        }
                    }
                    break;

                case 2:
                    // Mengurutkan Tim A dan Tim B berdasarkan berat badan
                    Collections.sort(TimA, (p1, p2) -> Integer.compare(p1.getWeight(), p2.getWeight()));
                    Collections.sort(TimB, (p1, p2) -> Integer.compare(p1.getWeight(), p2.getWeight()));

                    // Mengecek berat badan yang sama
                    System.out.println("Mencari berat badan yang sama antara Tim A dan Tim B:");
                    for (Player playerB : TimB) {
                        if (binarySearchWeight(TimA, playerB.getWeight())) {
                            System.out.printf("Ditemukan pemain dengan berat badan %d kg di kedua tim.\n", playerB.getWeight());
                        }
                    }
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }

        scanner.close();
    }

    // Binary search untuk tinggi badan
    private static boolean binarySearchHeight(List<Player> list, int height) {
        int result = Collections.binarySearch(list, new Player(height, 0), (p1, p2) -> Integer.compare(p1.getHeight(), p2.getHeight()));
        return result >= 0;
    }

    // Binary search untuk berat badan
    private static boolean binarySearchWeight(List<Player> list, int weight) {
        int result = Collections.binarySearch(list, new Player(0, weight), (p1, p2) -> Integer.compare(p1.getWeight(), p2.getWeight()));
        return result >= 0;
    }
}

class Player {
    private int height;
    private int weight;

    public Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return height == player.height && weight == player.weight;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(height) + Integer.hashCode(weight);
    }
}


// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;
// import java.util.Scanner;

// public class BinarySearchTest {
//     public static void main(String[] args) {
//         // Definisi/inisialisasi data untuk Tim A
//         List<Player> TimA = new ArrayList<>(Arrays.asList(
//             new Player(168, 50), new Player(170, 60), new Player(165, 56), new Player(168, 55),
//             new Player(172, 60), new Player(170, 70), new Player(169, 66), new Player(165, 56),
//             new Player(171, 72), new Player(166, 56)
//         ));

//         // Mengurutkan Tim A berdasarkan tinggi badan
//         Collections.sort(TimA, (p1, p2) -> Integer.compare(p1.getHeight(), p2.getHeight()));

//         // Cetak Tim A sebelum pencarian
//         System.out.println("=================================================================");
//         System.out.println("Anggota Tim A:");
//         printPlayers(TimA);

//         // Input user untuk mencari berat badan di Tim A
//         Scanner scanner = new Scanner(System.in);
//         while (true) {
//             System.out.println("=================================================================");
//             System.out.print("Masukkan berat badan yang ingin dicari di Tim A (atau ketik -1 untuk keluar): ");
//             int weightToSearch = scanner.nextInt();
            
//             // Exit condition
//             if (weightToSearch == -1) {
//                 break;
//             }

//             // Mencari jumlah pemain dengan berat badan yang dimasukkan user di Tim A
//             int countWeight = countPlayersWithWeight(TimA, weightToSearch);
//             System.out.printf("Jumlah pemain dengan berat badan %d kg di Tim A: %d\n", weightToSearch, countWeight);
//         }
        
//         scanner.close();
//     }

//     private static void printPlayers(List<Player> players) {
//         for (Player player : players) {
//             System.out.println("Height: " + player.getHeight() + " cm, Weight: " + player.getWeight() + " kg");
//         }
//     }

//     private static int countPlayersWithWeight(List<Player> list, int weight) {
//         int count = 0;
//         for (Player player : list) {
//             if (player.getWeight() == weight) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

// class Player {
//     private int height;
//     private int weight;

//     public Player(int height, int weight) {
//         this.height = height;
//         this.weight = weight;
//     }

//     public int getHeight() {
//         return height;
//     }

//     public int getWeight() {
//         return weight;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj) return true;
//         if (obj == null || getClass() != obj.getClass()) return false;
//         Player player = (Player) obj;
//         return height == player.height;
//     }

//     @Override
//     public int hashCode() {
//         return Integer.hashCode(height);
//     }
// }




// package Modul10CollectionSortingAndSearching.TugasPraktikum;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;
// import java.util.Scanner;

// public class BinarySearchTest {
//     public static void main(String[] args) {
//         // Definisi/inisialisasi data untuk Tim A
//         List<Player> TimA = new ArrayList<>(Arrays.asList(
//             new Player(168, 50), new Player(170, 60), new Player(165, 56), new Player(168, 55),
//             new Player(172, 60), new Player(170, 70), new Player(169, 66), new Player(165, 56),
//             new Player(171, 72), new Player(166, 56)
//         ));

//         // Definisi/inisialisasi data untuk Tim B
//         List<Player> TimB = new ArrayList<>(Arrays.asList(
//             new Player(170, 66), new Player(167, 60), new Player(165, 59), new Player(166, 58),
//             new Player(168, 58), new Player(175, 71), new Player(172, 68), new Player(171, 68),
//             new Player(168, 65), new Player(169, 60)
//         ));

//         // Mengurutkan Tim A berdasarkan tinggi badan
//         Collections.sort(TimA, (p1, p2) -> Integer.compare(p1.getHeight(), p2.getHeight()));

//         // Mengurutkan Tim B berdasarkan tinggi badan
//         Collections.sort(TimB, (p1, p2) -> Integer.compare(p1.getHeight(), p2.getHeight()));

//         // Cetak Tim A sebelum pencarian
//         System.out.println("=================================================================");
//         System.out.println("Anggota Tim A:");
//         printPlayers(TimA);

//         // Cetak Tim B sebelum pencarian
//         System.out.print("=================================================================");
//         System.out.print("\nAnggota Tim B:");
//         printPlayers(TimB);

//         // Input user untuk mencari tinggi badan
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("=================================================================");
//         System.out.print("Masukkan tinggi badan yang ingin dicari: ");
//         int heightToSearch = scanner.nextInt();
//         scanner.close();

//         // Mencari tinggi badan di Tim A
//         printSearchResults(TimA, heightToSearch, "Tim A");

//         // Mencari tinggi badan di Tim B
//         printSearchResults(TimB, heightToSearch, "Tim B");

//         // Mencari jumlah pemain dengan tinggi badan 168 cm di Tim B
//         int heightToCount = 168;
//         int count168 = countPlayersWithHeight(TimB, heightToCount);
//         System.out.printf("\nJumlah pemain dengan tinggi badan %d cm di Tim B: %d\n", heightToCount, count168);

//         // Mencari jumlah pemain dengan tinggi badan 160 cm di Tim B
//         heightToCount = 160;
//         int count160 = countPlayersWithHeight(TimB, heightToCount);
//         System.out.printf("Jumlah pemain dengan tinggi badan %d cm di Tim B: %d\n", heightToCount, count160);
//     }

//     private static void printPlayers(List<Player> players) {
//         for (Player player : players) {
//             System.out.println("Height: " + player.getHeight() + " cm, Weight: " + player.getWeight() + " kg");
//         }
//     }

//     private static void printSearchResults(List<Player> list, int height, String teamName) {
//         int result = Collections.binarySearch(list, new Player(height, 0), (p1, p2) -> Integer.compare(p1.getHeight(), p2.getHeight()));
//         System.out.printf("\nSearching for height %d in %s\n", height, teamName);
//         if (result >= 0) {
//             System.out.printf("Found at index %d: Height: %d cm, Weight: %d kg\n", result, list.get(result).getHeight(), list.get(result).getWeight());
//         } else {
//             System.out.printf("Not Found (%d)\n", result);
//         }
//     }

//     private static int countPlayersWithHeight(List<Player> list, int height) {
//         int count = 0;
//         for (Player player : list) {
//             if (player.getHeight() == height) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

// class Player {
//     private int height;
//     private int weight;

//     public Player(int height, int weight) {
//         this.height = height;
//         this.weight = weight;
//     }

//     public int getHeight() {
//         return height;
//     }

//     public int getWeight() {
//         return weight;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj) return true;
//         if (obj == null || getClass() != obj.getClass()) return false;
//         Player player = (Player) obj;
//         return height == player.height;
//     }

//     @Override
//     public int hashCode() {
//         return Integer.hashCode(height);
//     }
// }

// package Modul10CollectionSortingAndSearching.TugasPraktikum;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;
// import java.util.Scanner;

// public class BinarySearchTest {
//     public static void main(String[] args) {
//         // Definisi/inisialisasi data untuk Tim A
//         List<Player> TimA = new ArrayList<>(Arrays.asList(
//             new Player(168, 50), new Player(170, 60), new Player(165, 56), new Player(168, 55),
//             new Player(172, 60), new Player(170, 70), new Player(169, 66), new Player(165, 56),
//             new Player(171, 72), new Player(166, 56)
//         ));

//         // Definisi/inisialisasi data untuk Tim B
//         List<Player> TimB = new ArrayList<>(Arrays.asList(
//             new Player(170, 66), new Player(167, 60), new Player(165, 59), new Player(166, 58),
//             new Player(168, 58), new Player(175, 71), new Player(172, 68), new Player(171, 68),
//             new Player(168, 65), new Player(169, 60)
//         ));

//         // Mengurutkan Tim A berdasarkan tinggi badan
//         Collections.sort(TimA, (p1, p2) -> Integer.compare(p1.getHeight(), p2.getHeight()));

//         // Mengurutkan Tim B berdasarkan tinggi badan
//         Collections.sort(TimB, (p1, p2) -> Integer.compare(p1.getHeight(), p2.getHeight()));

//         // Cetak Tim A sebelum pencarian
//         System.out.println("=================================================================");
//         System.out.println("Anggota Tim A:");
//         printPlayers(TimA);

//         // Cetak Tim B sebelum pencarian
//         System.out.print("=================================================================");
//         System.out.print("\nAnggota Tim B:");
//         printPlayers(TimB);
// // 
//         // Input user untuk mencari tinggi badan
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("=================================================================");
//         System.out.print("Masukkan tinggi badan yang ingin dicari: ");
//         int heightToSearch = scanner.nextInt();
//         scanner.close();

//         // Mencari tinggi badan di Tim A
//         printSearchResults(TimA, heightToSearch, "Tim A");

//         // Mencari tinggi badan di Tim B
//         printSearchResults(TimB, heightToSearch, "Tim B");
//     }

//     private static void printPlayers(List<Player> players) {
//         for (Player player : players) {
//             System.out.println("Height: " + player.getHeight() + " cm, Weight: " + player.getWeight() + " kg");
//         }
//     }

//     private static void printSearchResults(List<Player> list, int height, String teamName) {
//         int result = Collections.binarySearch(list, new Player(height, 0), (p1, p2) -> Integer.compare(p1.getHeight(), p2.getHeight()));
//         System.out.printf("\nSearching for height %d in %s\n", height, teamName);
//         if (result >= 0) {
//             System.out.printf("Found at index %d: Height: %d cm, Weight: %d kg\n", result, list.get(result).getHeight(), list.get(result).getWeight());
//         } else {
//             System.out.printf("Not Found (%d)\n", result);
//         }
//     }
// }

// class Player {
//     private int height;
//     private int weight;

//     public Player(int height, int weight) {
//         this.height = height;
//         this.weight = weight;
//     }

//     public int getHeight() {
//         return height;
//     }

//     public int getWeight() {
//         return weight;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj) return true;
//         if (obj == null || getClass() != obj.getClass()) return false;
//         Player player = (Player) obj;
//         return height == player.height;
//     }

//     @Override
//     public int hashCode() {
//         return Integer.hashCode(height);
//     }
// }

//=================================SOAL A=============================================
// public class PengurutanDataPemainFutsal{

//     public static void main(String[] args) {
//         //definisi/inisialisasi data
//         int[][] PemainFutsal = {
//                 {168, 50, 170, 66},
//                 {170, 60, 167, 60},
//                 {165, 56, 165, 59},
//                 {168, 55, 166, 58},
//                 {172, 60, 168, 58},
//                 {170, 70, 175, 71},
//                 {169, 66, 172, 68},
//                 {165, 56, 171, 68},
//                 {171, 72, 168, 65},
//                 {166, 56, 169, 60}
//         };
//         // mengeprint data sebelum di urutkan
//         System.out.println("=================================================================");
//         System.out.println("DATA PEMAIN SEBELUM DIURUTKAN:");
//         System.out.println("=================================================================");
//         printPemainFutsal(PemainFutsal);

//         // menge-sort pemain berdasarkan tinggi dengan ascending order
//         Arrays.sort(PemainFutsal, (a, b) -> a[0] - b[0]);
//         System.out.println("=================================================================");
//         System.out.println("DATA URUTAN PEMAIN BERDASARKAN KETINGGIAN DENGAN ASCENDING ORDER");
//         System.out.println("=================================================================");
//         printPemainFutsal(PemainFutsal);

//         // menges-sort pemain berdasarkan tinggi dengan descending order
//         Arrays.sort(PemainFutsal, (a, b) -> b[0] - a[0]);
//         System.out.println("=================================================================");
//         System.out.println("DATA URUTAN PEMAIN BERDASARKAN KETINGGIAN DENGAN DESCENDING ORDER");
//         System.out.println("=================================================================");
//         printPemainFutsal(PemainFutsal);
//     }

//     private static void printPemainFutsal(int[][] PemainFutsal) {
//         for (int[] player : PemainFutsal) {
//             System.out.println("ketinggian: " + player[0] + " cm, berat: " + player[1] + " kg");
//         }
//     }
// }
//=================================SOAL B=============================================
// public class PengurutanDataPemainFutsal{
//     public static void main(String[] args) {
//         // Define the player data
//         int[][] pemainFutsal = {
//                 {168, 50, 170, 66},
//                 {170, 60, 167, 60},
//                 {165, 56, 165, 59},
//                 {168, 55, 166, 58},
//                 {172, 60, 168, 58},
//                 {170, 70, 175, 71},
//                 {169, 66, 172, 68},
//                 {165, 56, 171, 68},
//                 {171, 72, 168, 65},
//                 {166, 56, 169, 60}
//         };
//         // mengeprint data sebelum diurutkan
//         System.out.println("=================================================================");
//         System.out.println("DATA PEMAIN SEBELUM DIURUTKAN:");
//         System.out.println("=================================================================");
//         printpemainFutsal(pemainFutsal);

//         // mengurut data berat dengan ascending order
//         Arrays.sort(pemainFutsal, (a, b) -> a[2] - b[2]);
//         System.out.println("=================================================================");
//         System.out.println("DATA URUTAN PEMAIN BERDASARKAN BERAT DENGAN ASCENDING ORDER");
//         System.out.println("=================================================================");
//         printpemainFutsal(pemainFutsal);

//         // mengurut data berat dengan desecending order
//         Arrays.sort(pemainFutsal, (a, b) -> b[2] - a[2]);
//         System.out.println("=================================================================");
//         System.out.println("DATA URUTAN PEMAIN BERDASARKAN BERAT DENGAN DESCENDING ORDER");
//         System.out.println("=================================================================");
//         printpemainFutsal(pemainFutsal);
//     }

//     private static void printpemainFutsal(int[][] pemainFutsal) {
//         for (int[] player : pemainFutsal) {
//             System.out.println("ketinggian: " + player[0] + " cm, berat: " + player[2] + " kg");
//         }
//     }
// }
//=================================SOAL C=============================================
// package Modul10CollectionSortingAndSearching.TugasPraktikkum;

// public class PengurutanDataPemainFutsal {
//     public static void main(String[] args) {
//         // Definisi/inisialisasi data
//         int[][] PemainFutsal = {
//                 {168, 50, 170, 66},
//                 {170, 60, 167, 60},
//                 {165, 56, 165, 59},
//                 {168, 55, 166, 58},
//                 {172, 60, 168, 58},
//                 {170, 70, 175, 71},
//                 {169, 66, 172, 68},
//                 {165, 56, 171, 68},
//                 {171, 72, 168, 65},
//                 {166, 56, 169, 60}
//         };
// ////////////////////D
// package Modul10CollectionSortingAndSearching.TugasPraktikkum;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// public class PengurutanDataPemainFutsal {
//     public static void main(String[] args) {
//         // Definisi/inisialisasi data
//         int[][] PemainFutsal = {
//                 {170, 66},
//                 {167, 60},
//                 {165, 59},
//                 {166, 58},
//                 {168, 58},
//                 {175, 71},
//                 {172, 68},
//                 {171, 68},
//                 {168, 65},
//                 {169, 60}
//         };

//         // Convert the array to a list of lists
//         List<List<Integer>> TimB = new ArrayList<>();
//         for (int[] player : PemainFutsal) {
//             List<Integer> playerData = new ArrayList<>();
//             for (int data : player) {
//                 playerData.add(data);
//             }
//             TimB.add(playerData);
//         }

//         // Print members of Tim B before copying
//         System.out.println("=================================================================");
//         System.out.println("Anggota Tim B:");
//         printpemainFutsal(TimB);

//         // Create a new list for Tim C with the same size as Tim B
//         List<List<Integer>> TimC = new ArrayList<>(TimB.size());
//         for (int i = 0; i < TimB.size(); i++) {
//             TimC.add(new ArrayList<>(TimB.get(i).size()));
//         }

//         // Use Collections.copy to copy data from Tim B to Tim C
//         Collections.copy(TimC, TimB);

//         // Print members of Tim C after copying
//         System.out.println("=================================================================");
//         System.out.println("Anggota Tim C:");
//         printpemainFutsal(TimC);
//     }

//     private static void printpemainFutsal(List<List<Integer>> pemainFutsal) {
//         for (List<Integer> player : pemainFutsal) {
//             System.out.println("Height: " + player.get(0) + " cm, Weight: " + player.get(1) + " kg");
//         }
//     }
// }
