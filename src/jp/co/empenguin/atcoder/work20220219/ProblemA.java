package jp.co.empenguin.atcoder.work20220219;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long H = scan.nextInt();
        double result = Math.sqrt(H*(12800000+H));
        System.out.println(result);
        scan.close();
    }
}
