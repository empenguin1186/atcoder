package jp.co.empenguin.atcoder.work20220226;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = 10;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }

        int result = a[0];
        result = a[result];
        result = a[result];

        System.out.println(result);

        scan.close();
    }
}
