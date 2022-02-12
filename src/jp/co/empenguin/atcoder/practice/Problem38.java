package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem38 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int q = scan.nextInt();
        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            String X = scan.next();
            String Y = scan.next();

            int xl = X.length();
            int yl = Y.length();
            char[] cx = X.toCharArray();
            char[] cy = Y.toCharArray();

            int[][] dp = new int[xl][yl];
            for (int j = 0; j < xl; j++) {
                for (int k = 0; k < yl; k++) {
                    if (j == 0) {
                        if (k == 0) {
                            dp[j][k] = cx[j] == cy[k] ? 1 : 0;
                        } else {
                            dp[j][k] = cx[j] == cy[k] ? 1 : dp[j][k-1];
                        }
                        continue;
                    }

                    if (k == 0) {
                        dp[j][k] = cx[j] == cy[k] ? 1 : dp[j-1][k];
                        continue;
                    }

                    int a = cx[j] == cy[k] ? dp[j-1][k-1] + 1 : dp[j-1][k-1];
                    int temp = Math.max(dp[j-1][k], dp[j][k-1]);
                    dp[j][k] = Math.max(a, temp);
                }
            }
            result[i] = dp[xl-1][yl-1];
        }

        for (int i : result) {
            System.out.println(i);
        }

        scan.close();
    }
}
