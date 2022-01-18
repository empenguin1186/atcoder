package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        long result = 0;
        for (int i = 0; i < m-1; i++) {
            for (int j = 1; j < m; j++) {
                long score = 0;
                for (int k = 0; k < n; k++) {
                    score += Math.max(a[k][i], a[k][j]);
                }
                if (result < score) {
                    result = score;
                }
            }
        }
        System.out.println(result);
        scan.close();
    }
}
