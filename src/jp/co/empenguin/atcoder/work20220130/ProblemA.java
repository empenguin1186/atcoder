package jp.co.empenguin.atcoder.work20220130;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextLong();
        if (N >= Integer.MIN_VALUE && N <= Integer.MAX_VALUE) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println(Math.pow(2, 32));
        scan.close();
    }
}
