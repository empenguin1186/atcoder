package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Problem48 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            int N = scan.nextInt();
            if (N == 0) {
                break;
            }
            int[] w = new int[N];
            for (int i = 0; i < N; i++) {
                w[i] = scan.nextInt();
            }

            int[][] dp = initIntegerArray(N, N, -1);
            rec(0, N-1, w, dp);
            System.out.println(dp[0][N - 1]);
        }
        scan.close();
    }

    public static int rec(int left, int right, int[] w, int[][] dp) {
        if (right - left + 1 <= 1) {
            return 0;
        }

        if (right - left + 1 == 2) {
            return Math.abs(w[left] - w[left+1]) <= 1 ? 2 : 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        if (Math.abs(w[right] - w[left]) <= 1 && rec(left+1, right-1, w, dp) == right - left - 1) {
             return dp[left][right] = Math.max(right - left + 1, dp[left][right]);
        }

        int result = 0;
        for (int i = left+1; i < right; i++) {
            result = Math.max(rec(left, i, w, dp) + rec(i+1, right, w, dp), result);
        }

        return dp[left][right] = result;
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
