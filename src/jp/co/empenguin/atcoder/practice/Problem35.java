package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem35 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int W = scan.nextInt();
        int[][] w = new int[N][2];
        for (int i = 0; i < N; i++) {
            w[i][0] = scan.nextInt();
            w[i][1] = scan.nextInt();
        }

        int[][] dp = new int[W+1][N];
        for (int i = 0; i < W+1; i++) {
            for (int j = 0; j < N; j++) {
                int vi = w[j][0];
                int wi = w[j][1];

                // 重さの上限が0の場合
                if (i == 0) {
                    dp[i][j] = 0;
                    break;
                }

                // 初めの要素のみを考慮する場合
                if (j == 0) {
                    if (wi <= i) {
                        dp[i][j] = vi;
                    } else {
                        dp[i][j] = 0;
                    }
                    continue;
                }

                // それ以外の場合
                int margin = i - wi;
                int b = dp[i-1][j];
                int c = dp[i][j-1];
                if (margin >= 0) {
                    int a = dp[margin][j-1] + vi;
                    int d = Math.max(a, b);
                    dp[i][j] = Math.max(c, d);
                } else {
                    dp[i][j] = Math.max(b, c);
                }
            }
        }

        System.out.println(dp[W][N - 1]);
        scan.close();
    }
}
