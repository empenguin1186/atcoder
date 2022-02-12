package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem34 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] fib = new int[n+1];

        fib[0] = 1;
        fib[1] = 1;

        for (int i = 2; i < n+1; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        System.out.println(fib[n]);

        scan.close();
    }
}
