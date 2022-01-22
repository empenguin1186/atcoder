package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int result = 0;
        int[][] s = new int[m][];
        int[] num = new int[m];
        int[] p = new int[m];

        for (int i = 0; i < m; i++) {
            int k = scan.nextInt();
            int[] temp = new int[k];
            for (int j = 0; j < k; j++) {
                temp[j] = scan.nextInt();
            }
            s[i] = temp;
            num[i] = k;
        }
        for (int i = 0; i < m; i++) {
            p[i] = scan.nextInt();
        }

        for (int i = 0; i < 1 << n; i++) {
            boolean isMatch = true;
            for (int j = 0; j < m; j++) {
                int count = 0;
                for (int k = 0; k < num[j]; k++) {
                    int index = s[j][k] - 1;
                    if ((1 & i >> index) == 1) {
                        count++;
                    }
                }
                isMatch &= (count % 2 == p[j]);
            }
            if (isMatch) {
                result++;
            }
        }

        System.out.println(result);
        scan.close();
    }
}
