package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

/**
 * TODO 間違い
 */
public class Problem51 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] p = new int[N];
        String str = scan.next();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'J') {
                p[i] = 0;
            } else if (c == 'O') {
                p[i] = 1;
            } else {
                p[i] = 2;
            }
        }
        int[][] dp = new int[8][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0) {
                    if ((1 & (j)) == 1 || (1 & (j >> p[i])) == 1) {
                        dp[j][i] = 1;
                    } else {
                        dp[j][i] = 0;
                    }
                    continue;
                }

                int result = 0;
                for (int k = 0; k < 8; k++) {
                    if ((k&j) != 0 && (1 & (j >> p[i])) == 1) {
                        result += dp[k][i-1];
                    }
                }
                dp[j][i] = result;
            }
        }

        int result = 0;
        for (int i = 0; i < 8; i++) {
            result += dp[i][N-1];
        }
        System.out.println(result);
        scan.close();
    }
}
