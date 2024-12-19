package Modul9Collections.TugasPraktikkum;
import java.util.*;

public class PlayerFutsalD{
        public static void main(String[] args) {
            int[][] timA = {{168, 50}, {170, 60}, {165, 56}, {168, 55}, {172, 60}, {170, 70}, {169, 66}, {165, 56}, {171, 72}, {166, 56}};
            int[][] timB = {{170, 66}, {167, 60}, {165, 59}, {166, 58}, {168, 58}, {175, 71}, {172, 68}, {171, 68}, {168, 65}, {169, 60}};
    
            int minTimA = Integer.MAX_VALUE;
            int maxTimA = Integer.MIN_VALUE;
            int minTimB = Integer.MAX_VALUE;
            int maxTimB = Integer.MIN_VALUE;
    
            for (int i = 0; i < timA.length; i++) {
                if (timA[i][1] < minTimA) {
                    minTimA = timA[i][1];
                }
                if (timA[i][1] > maxTimA) {
                    maxTimA = timA[i][1];
                }
            }
    
            for (int i = 0; i < timB.length; i++) {
                if (timB[i][1] < minTimB) {
                    minTimB = timB[i][1];
                }
                if (timB[i][1] > maxTimB) {
                    maxTimB = timB[i][1];
                }
            }
    
            System.out.println("Rentang nilai berat badan Tim A: " + minTimA + " - " + maxTimA + " kg");
            System.out.println("Rentang nilai berat badan Tim B: " + minTimB + " - " + maxTimB + " kg");
        }
    }
