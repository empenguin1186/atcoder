package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO TLE
 */
public class Problem55 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }

        Integer[][] dp = initIntegerArray(N, N, Integer.MAX_VALUE);
        dp[0][0] = a[0];

        int colorCount = 1;
        int[][] colors = new int[N][N];
        colors[0][0] = colorCount;

        for (int i = 1; i < N; i++) {
            int j = upperBound(dp[i-1], a[i]);
            if (j == i) {
                dp[i][j] = a[i];
                System.arraycopy(dp[i - 1], 0, dp[i], 0, j);

                System.arraycopy(colors[i - 1], 0, colors[i], 0, i);
                colors[i][i] = colors[i][i-1];
            } else {
                int index = 0;
                Set<Integer> colorSet = new HashSet<>();
                for (int k = 0; k < i + 1; k++) {
                    if (k == j) {
                        dp[i][k] = a[i];
                        continue;
                    }

                    dp[i][k] = dp[i-1][index];
                    colors[i][k] = colors[i-1][index];
                    if (k > j) {
                        colorSet.add(colors[i-1][index]);
                    }
                    index++;
                }

                if (colorSet.size() == colorCount) {
                    colorCount++;
                    colors[i][j] = colorCount;
                } else {
                    colors[i][j] = colors[i][j-1];
                }
            }
        }

        System.out.println(colorCount);
        scan.close();
    }

    public static int upperBound(Integer[] array, Integer value) {
        return ~Arrays.binarySearch(array, value-1, (x,y)->x.compareTo(y)>0?1:-1);
    }

    public static Integer[][] initIntegerArray(int row, int col, int val) {
        Integer[][] array = new Integer[row][col];
        for (int i = 0; i < row; i++) {
            Integer[] cols = new Integer[col];
            Arrays.fill(cols, val);
            array[i] = cols;
        }
        return array;
    }
}
