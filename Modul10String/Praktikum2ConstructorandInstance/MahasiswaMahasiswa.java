package Praktikum2ConstructorandInstance;
import java.util.Scanner;
import java.util.*;

public class MahasiswaMahasiswa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree mahasiswaTree = new BinaryTree();

        System.out.println("Enter the number of data:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.println("Enter the data:");
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputData = input.split(" ");
            String No = inputData[0];
            String nama = inputData[1];
            String NIM = inputData[2];
            String Prodi = inputData[3];

            Mahasiswa mahasiswa = new Mahasiswa(No, nama, NIM, Prodi);
            mahasiswaTree.insert(mahasiswa);
        }

        System.out.println("Sum of input using inorder traversal: " + mahasiswaTree.sumInOrder());
    }
}

class BinaryTree {
    private TreeNode root;

    public void insert(Mahasiswa data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, Mahasiswa data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (root.left == null) {
            root.left = insertRec(root.left, data);
        } else if (root.right == null) {
            root.right = insertRec(root.right, data);
        } else {
            root.left = insertRec(root.left, data);
        }

        return root;
    }

    public int sumInOrder() {
        return sumInOrderRec(root);
    }

    private int sumInOrderRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = sumInOrderRec(root.left) + Integer.parseInt(root.data.getNo()) + sumInOrderRec(root.right);
        return sum;
    }
}

class TreeNode {
    Mahasiswa data;
    TreeNode left, right;

    public TreeNode(Mahasiswa data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class Mahasiswa {
    private String No;
    private String nama;
    private String NIM;
    private String Prodi;

    public Mahasiswa(String No, String nama, String NIM, String Prodi) {
        this.No = No;
        this.nama = nama;
        this.NIM = NIM;
        this.Prodi = Prodi;
    }

    public String getNo() {
        return this.No;
    }
}
// public class MahasiswaMahasiswa {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         BinaryTree mahasiswaTree = new BinaryTree();
        
//         System.out.println("Masukkan data mahasiswa dengan format No Nama NIM Prodi:");
//         String input = scanner.nextLine();
//         String[] inputData = input.split(" ");
//         for (int i = 0; i < inputData.length; i += 4) {
//             String No = inputData[i];
//             String nama = inputData[i + 1];
//             String NIM = inputData[i + 2];
//             String Prodi = inputData[i + 3];
            
//             Mahasiswa mahasiswa = new Mahasiswa(No, nama, NIM, Prodi);
//             mahasiswaTree.insert(mahasiswa);
//         }
        
//         Mahasiswa mahasiswa1 = new Mahasiswa("1", "", "", "");
//         Mahasiswa mahasiswa2 = new Mahasiswa("2", "", "", "");
        
//         Mahasiswa foundMahasiswa1 = mahasiswaTree.search(mahasiswa1);
//         if (foundMahasiswa1 != null) {
//             foundMahasiswa1.tampilkanInfo();
//         }
        
//         Mahasiswa foundMahasiswa2 = mahasiswaTree.search(mahasiswa2);
//         if (foundMahasiswa2 != null) {
//             foundMahasiswa2.tampilkanInfo2();
//         }
//     }
// }

// class BinaryTree {
//     private TreeNode root;

//     public void insert(Mahasiswa data) {
//         root = insertRec(root, data);
//     }

//     private TreeNode insertRec(TreeNode root, Mahasiswa data) {
//         if (root == null) {
//             root = new TreeNode(data);
//             return root;
//         }

//         // Insert the current node
//         if (root.data == null) {
//             root.data = data;
//             return root;
//         }

//         // Insert left child if available
//         if (root.left == null) {
//             root.left = insertRec(root.left, data);
//         } 
//         // Insert right child if available
//         else if (root.right == null) {
//             root.right = insertRec(root.right, data);
//         } 
//         // Traverse to the left subtree
//         else {
//             root.left = insertRec(root.left, data);
//         }

//         return root;
//     }

//     public Mahasiswa search(Mahasiswa data) {
//         return searchRec(root, data);
//     }

//     private Mahasiswa searchRec(TreeNode root, Mahasiswa data) {
//         if (root == null || data == null) {
//             return null;
//         }

//         if (data.getNo().equals(root.data.getNo())) {
//             return root.data;
//         }

//         Mahasiswa found = searchRec(root.left, data);
//         if (found != null) {
//             return found;
//         }

//         return searchRec(root.right, data);
//     }
// }

// class TreeNode {
//     Mahasiswa data;
//     TreeNode left, right;

//     public TreeNode(Mahasiswa data) {
//         this.data = data;
//         this.left = this.right = null;
//     }
// }

// class Mahasiswa {
//     private String No;
//     private String nama;
//     private String NIM;
//     private String Prodi;

//     public Mahasiswa(String No, String nama, String NIM, String Prodi) {
//         this.No = No;
//         this.nama = nama;
//         this.NIM = NIM;
//         this.Prodi = Prodi;
//     }

//     public String getNo() {
//         return this.No;
//     }

//     public void tampilkanInfo() {
//         System.out.println("Mahasiswa pertama" + " : " + nama + ", " + NIM + " " + Prodi);
//     }

//     public void tampilkanInfo2(){
//         System.out.println("Mahasiswa kedua" + " : " + nama + ", " + NIM + " " + Prodi);
//     }
// }

// import java.util.*;
// import java.util.Scanner;

// public class MahasiswaMahasiswa {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int j=0;
//         Mahasiswa<String, String, String, String>[] mahasiswaList = new Mahasiswa[2];
//         while(j<2){
//         String masukkan = scanner.nextLine();
//         String[] masukkanData = masukkan.split(" ");
        
//         for (int i = 0; i < masukkanData.length; i += 4) {
//             String No = masukkanData[i];
//             String nama = masukkanData[i + 1];
//             String NIM = masukkanData[i + 2];
//             String Prodi = masukkanData[i + 3];
//             mahasiswaList[j]=new Mahasiswa(No, nama, NIM, Prodi);
//         }j++;
//         }
//         for (Mahasiswa<String, String, String, String> mahasiswa : mahasiswaList) {
//             if(mahasiswa.getNo().equals("1")){
//                 mahasiswa.tampilkanInfo();
//             }
//         }for (Mahasiswa<String, String, String, String> mahasiswa : mahasiswaList) {
//             if(mahasiswa.getNo().equals("2")){
//                 mahasiswa.tampilkanInfo2();
//             }
//         }
//     }
// }
// class Mahasiswa<T, U, V, W> {
//     private T No;
//     private U nama;
//     private V NIM;
//     private W Prodi;

//     public Mahasiswa(T No, U nama, V NIM, W Prodi) {
//         this.No = No;
//         this.nama = nama;
//         this.NIM = NIM;
//         this.Prodi = Prodi;
//     }
//     public T getNo(){
//         return this.No;
//     }
//     public void tampilkanInfo() {
//         System.out.println("Mahasiswa pertama" + " : " + nama + ", " + NIM + " " + Prodi);
        
//     }
//     public void tampilkanInfo2(){
//         System.out.println("Mahasiswa kedua" + " : " + nama + ", " + NIM + " " + Prodi);
//     }
// }

