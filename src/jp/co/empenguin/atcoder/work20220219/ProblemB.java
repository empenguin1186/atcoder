package jp.co.empenguin.atcoder.work20220219;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long x = scan.nextLong();
        long result;
        if (x < 0) {
            result = x % 10 == 0 ? x / 10 : x / 10 - 1;
        } else {
            result = x / 10;
        }
        System.out.println(result);
        scan.close();
    }
}
