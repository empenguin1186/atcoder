package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

/**
 * TODO
 */
public class Problem39 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[] num = new int[N-1];
        for (int i = 0; i < N - 1; i++) {
            num[i] = scan.nextInt();
        }
        int index = scan.nextInt();
        int sum = 20;

        long[][] dp = new long[N-2][sum+1];
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    long plus = num[0] + num[1];
                    long minus = num[0] - num[1];

                    if (j == plus || j == minus) {
                        dp[i][j] = 1;
                    }
                    continue;
                }

                if (num[i+1] != 0) {
                    long count = 0;
                    int ai = j - num[i+1];
                    if (ai >= 0) {
                        count += dp[i-1][ai];
                    }

                    int bi = j + num[i+1];
                    if (bi <= sum) {
                        count += dp[i-1][bi];
                    }
                    dp[i][j] = count;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N - 3][index]);

        scan.close();
    }
}
