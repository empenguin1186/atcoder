package jp.co.empenguin.atcoder.work20220122;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] p = new int[n];
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            q[i] = scan.nextInt();
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[j] % p[i] == 0) {
                    result++;
                    j++;
                    i++;
                }
            }
        }
        System.out.println(result);
        scan.close();
    }
}
