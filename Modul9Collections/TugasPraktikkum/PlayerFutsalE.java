package Modul9Collections.TugasPraktikkum;
import java.util.*;
public class PlayerFutsalE {
        public static void main(String[] args) {
            int[][] timA = {{168, 50}, {170, 60}, {165, 56}, {168, 55}, {172, 60}, {170, 70}, {169, 66}, {165, 56}, {171, 72}, {166, 56}};
            int[][] timB = {{170, 66}, {167, 60}, {165, 59}, {166, 58}, {168, 58}, {175, 71}, {172, 68}, {171, 68}, {168, 65}, {169, 60}};
    
            Set<Integer> timBHeights = new HashSet<>();
            for (int i = 0; i < timB.length; i++) {
                timBHeights.add(timB[i][0]);
            }
    
            System.out.print("Tinggi badan pada tim A yang tidak ada pada tim B: ");
            for (int i = 0; i < timA.length; i++) {
                if (!timBHeights.contains(timA[i][0])) {
                    System.out.print(timA[i][0] + " ");
                }
            }
            System.out.println();
        }
    }   
