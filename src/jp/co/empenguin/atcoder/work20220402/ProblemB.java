package jp.co.empenguin.atcoder.work20220402;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double A = scan.nextDouble();
        double B = scan.nextDouble();

        double D = Math.pow(A, 2) + Math.pow(B, 2);

        double x = A / Math.sqrt(D);
        double y = B / Math.sqrt(D);

        System.out.println(x + " " + y);

        scan.close();
    }
}
