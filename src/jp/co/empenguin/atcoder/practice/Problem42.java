package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem42 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            D[i] = scan.nextInt();
        }
        int[] C = new int[M];
        for (int i = 0; i < M; i++) {
            C[i] = scan.nextInt();
        }

        long[][] dp = new long[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int d = D[i];
                int c = C[j];
                long value = (long) c * d;

                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = value;
                        continue;
                    }

                    dp[i][j] = Math.min(dp[i][j-1], value);
                    continue;
                }

                if (j < i) {
                    dp[i][j] = Long.MAX_VALUE;
                    continue;
                }

                dp[i][j] = Math.min(dp[i-1][j-1] + value, dp[i][j-1]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);
        scan.close();
    }
}
