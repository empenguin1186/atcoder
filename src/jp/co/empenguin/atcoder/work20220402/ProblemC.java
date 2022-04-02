package jp.co.empenguin.atcoder.work20220402;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int K = scan.nextInt();
        int X = scan.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
            if (i > 0) {
                B[i] = B[i-1] + A[i];
            } else {
                B[i] = A[i];
            }
        }

        int[][] dp = new int[K][N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dp[i][0] = Math.max(0, A[i] - X);
                continue;
            }

            if (A[i] - X >= 0) {
                dp[0][i] = B[i-1] + (A[i] - X);
            } else {
                dp[0][i] = dp[0][i-1] + A[i];
            }
        }

        for (int i = 0; i < K; i++) {
            dp[i][0] = Math.max(0, A[0] - (i+1) * X);
        }

        for (int i = 1; i < K; i++) {
            for (int j = 1; j < N; j++) {
                int count = 0;
                int k = i;
                int result = Integer.MAX_VALUE;
                while (k >= 0 && A[j] - count * X > -X) {
                    result = Math.min(result, dp[k][j-1] + Math.max(0, A[j] - count * X));
                    k--;
                    count++;
                }
                dp[i][j] = result;
            }
        }

        System.out.println(dp[K - 1][N - 1]);

        scan.close();
    }
}
