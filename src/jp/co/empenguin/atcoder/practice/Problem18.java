package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Problem18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] S = new int[n];
        for (int i = 0; i < n; i++) {
            S[i] = scan.nextInt();
        }
        int q = scan.nextInt();
        int result = 0;
        for (int i = 0; i < q; i++) {
            int index = Arrays.binarySearch(S, scan.nextInt());
            if (index >= 0) {
                result++;
            }
        }
        System.out.println(result);
        scan.close();
    }
}
