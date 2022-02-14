package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem41 {
    public static int CANNOT_CALCULATED = -1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int D = scan.nextInt();
        int N = scan.nextInt();
        int[] T = new int[D];
        for (int i = 0; i < D; i++) {
            T[i] = scan.nextInt();
        }

        int[][] ABC = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                ABC[i][j] = scan.nextInt();
            }
        }

        int[][] dp = new int[D][N];
        for (int i = 0; i < D; i++) {
            for (int j = 0; j < N; j++) {
                int t = T[i];
                int a = ABC[j][0];
                int b = ABC[j][1];
                int c = ABC[j][2];

                if (i == 0) {
                    dp[i][j] = t >= a && t <= b ? 0 : CANNOT_CALCULATED;
                    continue;
                }

                if (t >= a && t <= b) {
                    int temp = 0;
                    for (int k = 0; k < N; k++) {
                        if (dp[i-1][k] != CANNOT_CALCULATED) {
                            temp = Math.max(temp, dp[i-1][k] + Math.abs(ABC[k][2] - c));
                        }
                    }
                    dp[i][j] = temp;
                } else {
                    dp[i][j] = CANNOT_CALCULATED;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[D-1][i]);
        }

        System.out.println(result);
        scan.close();
    }
}
