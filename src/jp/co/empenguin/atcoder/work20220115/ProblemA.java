package jp.co.empenguin.atcoder.work20220115;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        int a = input / 100;
        int b = input / 10 - a * 10;
        int c = input - 100 * a - 10 * b;

        int result = input + b * 100 + c * 10 + a + c * 100 + a * 10 + b;

        System.out.println(result);
        scan.close();
    }
}
