package jp.co.empenguin.atcoder.work20220416;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final String number = scan.next();
        int result = 45;
        for (int i = 0; i < number.length(); i++) {
            final int n = Integer.parseInt(number.substring(i, i+1));
            result -= n;
        }
        System.out.println(result);
        scan.close();
    }
}
