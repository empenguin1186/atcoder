package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

/**
 * TODO 間違い
 */
public class Problem45 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int N = scan.nextInt();
            int M = scan.nextInt();

            if (N == 0 && M == 0) {
                break;
            }

            int[] C = new int[N];
            for (int i = 0; i < N; i++) {
                C[i] = scan.nextInt();
            }

            int[] x = new int[M];
            for (int i = 0; i < M; i++) {
                x[i] = scan.nextInt();
            }

            long[][] y = new long[N][M];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == 0) {
                        y[j][i] = 128 + C[j];
                        continue;
                    }
                    y[j][i] = y[j][i-1] + C[j];
                }
            }

            long[] dp = new long[M];
            for (int i = 0; i < M; i++) {
                long temp = Long.MAX_VALUE;

                for (int j = 0; j < N; j++) {
                    long pow = (long) Math.pow(x[i] - y[j][i], 2);
                    long yy = i == 0 ? pow : dp[i-1] + pow;
                    if (yy < temp) {
                        temp = yy;
                    }
                }

                dp[i] = temp;
            }

            System.out.println(dp[M - 1]);
        }

        scan.close();
    }
}
