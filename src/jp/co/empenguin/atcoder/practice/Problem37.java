package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem37 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] dp = new int[n+1][m];
        int[] coin = new int[m];

        for (int i = 0; i < m; i++) {
            coin[i] = scan.nextInt();
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = i / coin[j];
                    continue;
                }

                int value = coin[j];
                int margin = i - value;
                if (margin >= 0) {
                    dp[i][j] = Math.min(dp[i][j-1], dp[margin][j] + 1);
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        System.out.println(dp[n][m - 1]);

        scan.close();
    }
}
