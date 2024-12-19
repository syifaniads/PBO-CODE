package Modul8Interface.LatihanPraktikkum2;
import java.util.*;

public class Rectangle implements Colorable, Comparable {
    private String warna;
    private int kategori;

    public static void main(String[] args) {
        Rectangle kotak1 = new Rectangle("hijau");
        Rectangle kotak2 = new Rectangle(0);
        Rectangle kotak3 = new Rectangle("ungu", 1);
        kotak1.howToColor();
        kotak2.howToColor();
        kotak3.compareTo(1);
    }
    public Rectangle() {
        this.warna = null;
    }
    public Rectangle(String warna) {
        this.warna = warna;
    }
    public Rectangle(int kategori) {
        this.kategori = kategori;
    }
    public Rectangle(String warna, int kategori) {
        this.warna = warna;
        this.kategori = kategori;
    }
    public void howToColor() {
        if (this.warna == null) {
            System.out.println("Tidak ada warna, bangun kotak masih polos");
        } else {
        System.out.println("Bangun kotak sudah diwarnai dengan warna " + this.warna);
        }
    }
    public int compareTo(Object obj) {
        if (obj instanceof Integer) {
            this.kategori = (int) obj;
            if (this.kategori == 0) {
                System.out.println("Ukuran cat yang cocok untuk bangun kotak dengan ukuran kategori " + this.kategori + " yaitu 2.5L");
            } else {
                System.out.println("Ukuran cat yang cocok untuk bangun kotak dengan ukuran kategori " + this.kategori + " yaitu 6.5L");
            }
        } else {
            System.out.println("Objek yang diberikan bukan Integer.");
        }
        return 0;
    }
}


// package Modul8Interface.LatihanPraktikkum2;
// import java.util.*;

// public class Rectangle implements Colorable, Comparable {
//     private String warna;
//     private int kategori;
//     public static void main(String[] args) {
//         Rectangle kotak1 = new Rectangle("merah");
//         Rectangle kotak2 = new Rectangle();
//         Rectangle kotak3 = new Rectangle();
//         kotak1.howToColor();
//         kotak2.howToColor();
//         kotak3.compareTo(4);
//     }
//     public Rectangle() {
//         this.warna = null;
//     }

//     public Rectangle(String warna) {
//         this.warna = warna;
//     }

//     public void howToColor() {
//         if (this.warna == null) {
//             System.out.println("Tidak ada warna, warna bangun kotak masih polos");
//         } else {
//             System.out.println("Bangun kotak sudah diwarnai dengan warna " + this.warna);
//         }
//     }

//     public void compareTo(Object obj) {
//         if (obj instanceof Integer) {
//             this.kategori = (int) obj;
//             System.out.println("Ukuran cat yang cocok untuk bangun kotak dengan ukuran kategori " + this.kategori + " yaitu 2.5L");
//         } else {
//             System.out.println("Objek yang diberikan bukan Integer.");
//         }
//     }
// }
