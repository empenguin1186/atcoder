package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Problem49Alpha {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = scan.nextInt();
        final int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = scan.nextInt();
            }
        }
        int[][] dp = initIntegerArray(1 << N, N, -1);

        int result = Integer.MAX_VALUE;
        for (int v = 0; v < N; v++) {
            if (rec((1 << N)-1, v, dist, dp) < result) {
                result = rec((1 << N)-1, v, dist, dp);
            }
        }
        System.out.println(result);
        scan.close();
    }

    public static int rec(int bit, int v, int[][] dist, int[][] dp) {
        if (dp[bit][v] != -1) {
            return dp[bit][v];
        }

        if (bit == 1 << v) {
            return 0;
        }

        int prev = bit & ~(1 << v);
        int N = dp[0].length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if ((1 & (prev >> i)) != 1) {
                continue;
            }
            if (result > rec(prev, i, dist, dp) + dist[i][v]) {
                result = rec(prev, i, dist, dp) + dist[i][v];
            }
        }

        return dp[bit][v] = result;
    }

    public static int[][] initIntegerArray(int row, int col, int val) {
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            int[] cols = new int[col];
            Arrays.fill(cols, val);
            array[i] = cols;
        }
        return array;
    }
}
