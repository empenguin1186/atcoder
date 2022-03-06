package jp.co.empenguin.atcoder.work20220305;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        int X = scan.nextInt();

        if (X > A && X <= B) {
            double result = (double) C / (B - A);
            System.out.println(result);
        } else if (X > B) {
            System.out.println("0.000000000000");
        } else {
            System.out.println("1.000000000000");
        }

        scan.close();
    }
}
