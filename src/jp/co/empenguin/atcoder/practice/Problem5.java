package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();

        long result = 0;
        if (a + b > 2 * c) {
            if (x > y) {
                result += 2L * c * y;
                if (a > 2 * c) {
                    result += 2L * c * (x - y);
                } else {
                    result += (long) a * (x - y);
                }
            } else if (x == y) {
                result += 2L * c * y;
            } else {
                result += 2L * c * x;
                if (b > 2 * c) {
                    result += 2L * c * (y - x);
                } else {
                    result += (long) b * (y - x);
                }
            }
        } else {
            if (x > y) {
                result += (long) (a + b) * y + (long) a * (x - y);
            } else if (x == y) {
                result += (long) (a + b) * x;
            } else {
                result += (long) (a + b) * x + (long) b * (y - x);
            }
        }
        System.out.println(result);
        scan.close();
    }
}
