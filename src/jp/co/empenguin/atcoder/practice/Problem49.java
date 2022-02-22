package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO 不正解
 */
public class Problem49 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int E = scan.nextInt();
        
        int[][] dist = initIntegerArray(N, N, -1);
        for (int i = 0; i < E; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            dist[a][b] = dist[b][a] = scan.nextInt();
        }

        for (int i = 0; i < N; i++) {
            dist[i][i] = 0;
        }

        int[][] dp = initIntegerArray(1 << N, N, -1);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.min(result, rec((1 << N) - 1, i, dp, dist));
        }

        System.out.println(result);
        scan.close();
    }

    public static int rec(int bit, int v, int[][] dp, int[][] dist) {
        if (dp[bit][v] != -1) {
            return dp[bit][v];
        }

        if (bit == 1 << v) {
            return dp[bit][v] = 0;
        }

        int prev = bit & ~(1 << v);
        int N = dist[0].length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if ((1 & (prev >> i)) != 1) {
                continue;
            }
            if (dist[v][i] != -1 && rec(prev, i, dp, dist) != Integer.MAX_VALUE) {
                result = Math.min(result, rec(prev, i, dp, dist) + dist[v][i]);
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
