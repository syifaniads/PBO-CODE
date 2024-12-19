package Modul9Collections.TugasPraktikkum;

import java.util.*;
public class PlayerFutsalB {
    public static void main(String[] args) {
        int[][] timA = {{168, 50}, {170, 60}, {165, 56}, {168, 55}, {172, 60}, {170, 70}, {169, 66}, {165, 56}, {171, 72}, {166, 56}};
        int[][] timB = {{170, 66}, {167, 60}, {165, 59}, {166, 58}, {168, 58}, {175, 71}, {172, 68}, {171, 68}, {168, 65}, {169, 60}};

        Map<Integer, List<String>> sameWeight = new HashMap<>();

        for (int i = 0; i < timA.length; i++) {
            for (int j = 0; j < timB.length; j++) {
                if (timA[i][1] == timB[j][1]) {
                    sameWeight.computeIfAbsent(timA[i][1], k -> new ArrayList<>()).add("Tim A: " + (i + 1) + ", Tim B: " + (j + 1));
                }
            }
        }

        for (Map.Entry<Integer, List<String>> entry : sameWeight.entrySet()) {
            System.out.println("Berat badan sama: " + entry.getKey() + " kg");
            for (String player : entry.getValue()) {
                System.out.println(player);
            }
        }
    }
}