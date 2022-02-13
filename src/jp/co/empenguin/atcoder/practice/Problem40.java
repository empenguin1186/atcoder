package jp.co.empenguin.atcoder.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem40 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int K = scan.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < K; i++) {
            int key = scan.nextInt() - 1;
            int value = scan.nextInt();
            map.put(key, value);
        }

        long[][][] dp = new long[N+1][4][4];
        dp[0][0][0] = 1;

        for (int i = 0; i < N; i++) {
            if (map.containsKey(i)) {
                int pasta = map.get(i);

                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (j == k && pasta == j) {
                            continue;
                        }

                        dp[i+1][pasta][j] += dp[i][j][k];
                        dp[i+1][pasta][j] %= 10000;
                    }
                }
            } else {
                for (int j = 1; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 4; l++) {
                            if (j == k && k == l) {
                                continue;
                            }

                            dp[i+1][j][k] += dp[i][k][l];
                            dp[i+1][j][k] %= 10000;
                        }
                    }
                }
            }
        }

        long result = 0;
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                result += dp[N][i][j];
                result %= 10000;
            }
        }

        System.out.println(result);

        scan.close();
    }
}
