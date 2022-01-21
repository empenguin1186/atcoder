package jp.co.empenguin.atcoder.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 */
public class Problem7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] point = new int[]{scan.nextInt(), scan.nextInt()};
            points.add(point);
        }

        int result = 0;
        for (int i = 0; i < n-3; i++) {
            for (int j = 1; j < n-2; j++) {
                int[] pi = points.get(i);
                int[] pj = points.get(j);
                List<int[]> target = points.subList(j+1, n);

                int[] p1 = new int[]{(pj[0] - pj[1] + pi[1]), (pj[1] + pj[0] - pi[0])};
                int[] p2 = new int[]{(pi[0] - pj[1] + pi[1]), (pi[1] + pj[0] - pi[0])};
                if (target.contains(p1) && target.contains(p2)) {
                    int area = (int) Math.pow(pi[0] - pj[0], 2) + (int) Math.pow(pi[1] - pj[1], 2);
                    if (result < area) {
                        result = area;
                    }
                }
            }
        }
        System.out.println(result);
        scan.close();
    }
}
