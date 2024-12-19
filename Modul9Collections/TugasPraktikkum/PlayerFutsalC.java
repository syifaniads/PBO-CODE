package Modul9Collections.TugasPraktikkum;
import java.util.*;

public class PlayerFutsalC {
        public static void main(String[] args) {
            int[][] timA = {{168, 50}, {170, 60}, {165, 56}, {168, 55}, {172, 60}, {170, 70}, {169, 66}, {165, 56}, {171, 72}, {166, 56}};
            int[][] timB = {{170, 66}, {167, 60}, {165, 59}, {166, 58}, {168, 58}, {175, 71}, {172, 68}, {171, 68}, {168, 65}, {169, 60}};
    
            int minTimA = Integer.MAX_VALUE;
            int maxTimA = Integer.MIN_VALUE;
            int minTimB = Integer.MAX_VALUE;
            int maxTimB = Integer.MIN_VALUE;
    
            for (int i = 0; i < timA.length; i++) {
                if (timA[i][0] < minTimA) {
                    minTimA = timA[i][0];
                }
                if (timA[i][0] > maxTimA) {
                    maxTimA = timA[i][0];
                }
            }
    
            for (int i = 0; i < timB.length; i++) {
                if (timB[i][0] < minTimB) {
                    minTimB = timB[i][0];
                }
                if (timB[i][0] > maxTimB) {
                    maxTimB = timB[i][0];
                }
            }
    
            System.out.println("Rentang nilai tinggi badan Tim A: " + minTimA + " - " + maxTimA + " cm");
            System.out.println("Rentang nilai tinggi badan Tim B: " + minTimB + " - " + maxTimB + " cm");
        }
    }

