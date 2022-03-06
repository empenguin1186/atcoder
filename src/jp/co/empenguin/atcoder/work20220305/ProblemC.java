package jp.co.empenguin.atcoder.work20220305;

import java.util.Scanner;

public class ProblemC {

    private static long CONST = 998244353;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long[][] dp = new long[11][N];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == 0) {
                    dp[j][i] = 1;
                    continue;
                }

                dp[j][i] = (dp[j-1][i-1] + dp[j][i-1] + dp[j+1][i-1]) % CONST;
            }
        }

        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += dp[i][N-1] % CONST;
        }
        System.out.println(result % CONST);
        scan.close();
    }
}
