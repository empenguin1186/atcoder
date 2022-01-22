package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

/**
 * TODO TLE発生 Bit全探索
 */
public class Problem10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int q = scan.nextInt();
        int[] expecteds = new int[q];
        for (int i = 0; i < q; i++) {
            expecteds[i] = scan.nextInt();
        }
        for (int i = 0; i < q; i++) {
            boolean isEqual = false;
            for (int j = 0; j < 1 << n; j++) {
                int output = 0;
                for (int k = 0; k < n; k++) {
                    if ((1 & j >> k) == 1) {
                        output += a[k];
                    }
                }
                isEqual |= expecteds[i] == output;
            }
            if (isEqual) {
                System.out.println("yes");
                continue;
            }
            System.out.println("no");
        }
        scan.close();
    }
}
