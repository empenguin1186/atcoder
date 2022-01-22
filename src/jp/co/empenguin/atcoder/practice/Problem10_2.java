package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

/**
 * TODO TLE発生なし
 */
public class Problem10_2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int q = scan.nextInt();
        int[] ms = new int[q];
        for (int i = 0; i < q; i++) {
            ms[i] = scan.nextInt();
        }
        for (int i = 0; i < q; i++) {
            if (solve(0, ms[i], a)) {
                System.out.println("yes");
                continue;
            }
            System.out.println("no");
        }
        scan.close();
    }

    private static boolean solve(int i, int m, int[] a) {
        if (m == 0) {
            return true;
        }
        if (i > a.length-1) {
            return false;
        }
        return solve(i+1, m, a) || solve(i+1, m - a[i], a);
    }
}
