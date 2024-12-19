package Modul9Collections.TugasPraktikkum;
import java.util.*;
public class PlayerFutsalF {
        public static void main(String[] args) {
            int[][] timA = {{168, 50}, {170, 60}, {165, 56}, {168, 55}, {172, 60}, {170, 70}, {169, 66}, {165, 56}, {171, 72}, {166, 56}};
            int[][] timB = {{170, 66}, {167, 60}, {165, 59}, {166, 58}, {168, 58}, {175, 71}, {172, 68}, {171, 68}, {168, 65}, {169, 60}};
    
            Set<Integer> timAWeights = new HashSet<>();
            for (int i = 0; i < timA.length; i++) {
                timAWeights.add(timA[i][1]);
            }
    
            System.out.print("Berat badan pada tim B yang tidak ada pada tim A: ");
            for (int i = 0; i < timB.length; i++) {
                if (!timAWeights.contains(timB[i][1])) {
                    System.out.print(timB[i][1] + " ");
                }
            }
            System.out.println();
        }
    }  

