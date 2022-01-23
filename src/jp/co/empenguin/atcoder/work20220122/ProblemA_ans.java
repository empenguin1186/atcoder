package jp.co.empenguin.atcoder.work20220122;

import java.util.Scanner;

public class ProblemA_ans {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var n = scan.nextInt();
        var a = new int[n+1];

        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        a[n] = Integer.MIN_VALUE;

        int deleteNumber = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > a[i+1]) {
                deleteNumber = a[i];
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] != deleteNumber) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println("");
        scan.close();
    }
}
