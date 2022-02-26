package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Memory exceeded.
 */
public class Problem53 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }

        int[][] dp = initIntegerArray(N, N, Integer.MAX_VALUE);
        dp[0][0] = a[0];
        for (int i = 1; i < N; i++) {
            int ai = a[i];
            int n = lowerBound(dp[i-1], ai);
            for (int j = 0; j < N; j++) {
                if (j == n) {
                    dp[i][j] = ai;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for (int j = N-1; j >= 0; j--) {
            for (int i = 0; i < N; i++) {
                if (dp[i][j] != Integer.MAX_VALUE) {
                    System.out.println(j+1);
                    return;
                }
            }
        }

        scan.close();
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

    public static int lowerBound(int[] array, int value) {
        int raw = Arrays.binarySearch(array, value);
        return raw < 0 ? -1 * raw - 1 : raw;
    }
}
