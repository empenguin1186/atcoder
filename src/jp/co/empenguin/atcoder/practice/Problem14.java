package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = scan.nextInt();
        final int K = scan.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
        
        int result = 0;
        int currentHeight = a[0];
        for (int i = 1; i < K; i++) {
            if (currentHeight >= a[i]) {
                result += currentHeight - a[i] + 1;
                currentHeight = currentHeight + 1;
                continue;
            }
            currentHeight = a[i];
        }
        System.out.println(result);
        scan.close();
    }
}
