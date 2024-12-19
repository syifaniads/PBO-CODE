package Modul9Collections.TugasPraktikkum;
import java.util.*;

public class PlayerFutsalA {
    public static void main(String[] args) {
        int[][] timA = {{168, 50}, {170, 60}, {165, 56}, {168, 55}, {172, 60}, {170, 70}, {169, 66}, {165, 56}, {171, 72}, {166, 56}};
        int[][] timB = {{170, 66}, {167, 60}, {165, 59}, {166, 58}, {168, 58}, {175, 71}, {172, 68}, {171, 68}, {168, 65}, {169, 60}};

        Map<Integer, List<String>> sameHeight = new HashMap<>();

        for (int i = 0; i < timA.length; i++) {
            for (int j = 0; j < timB.length; j++) {
                if (timA[i][0] == timB[j][0]) {
                    sameHeight.computeIfAbsent(timA[i][0], k -> new ArrayList<>()).add("Tim A: " + (i + 1) + ", Tim B: " + (j + 1));
                }
            }
        }

        for (Map.Entry<Integer, List<String>> entry : sameHeight.entrySet()) {
            System.out.println("Tinggi badan sama: " + entry.getKey() + " cm");
            for (String player : entry.getValue()) {
                System.out.println(player);
            }
        }
    }
}
