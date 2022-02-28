package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO WA, RTE
 */
public class Problem54 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] c = new int[N];
        for (int i = 0; i < N; i++) {
            c[i] = scan.nextInt();
        }

        int[][] dp = initIntegerArray(N, N, Integer.MAX_VALUE);
        int result = 0;
        dp[0][0] = c[0];
        for (int i = 1; i < N; i++) {
            int j = lowerBound(dp[i-1], c[i]);
            if (j == i) {
                dp[i][j] = c[i];
                System.arraycopy(dp[i - 1], 0, dp[i], 0, j);
            } else {
                int index = 0;
                for (int k = 0; k < i + 1; k++) {
                    if (k == j) {
                        dp[i][k] = c[i];
                    } else {
                        dp[i][k] = dp[i-1][index];
                        index++;
                    }
                }
                result++;
            }
        }

        System.out.println(result);
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
