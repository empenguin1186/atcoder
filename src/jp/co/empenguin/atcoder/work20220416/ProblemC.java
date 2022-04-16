package jp.co.empenguin.atcoder.work20220416;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO 間違い
 *
 */
public class ProblemC {
    private static final long NUM = 998244353;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int K = scan.nextInt();

        long[] dp = new long[K+M];
        Arrays.fill(dp, 1);
        for (int i = N; i < K; i++) {
            for (int j = 0; j < M; j++) {
                dp[i+j] += 1;
                dp[i+j] %= NUM;
            }
        }

        long result = 0;
        for (int i = N-1; i < K; i++) {
            result += dp[i];
            result %= NUM;
        }

        System.out.println(result);
        scan.close();
    }
}
