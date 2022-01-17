package jp.co.empenguin.atcoder.work20220117;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n < 105) {
            System.out.println(0);
            return;
        }
        if (n == 105) {
            System.out.println(1);
            return;
        }

        int result = 1;
        for (int i = 107; i <= n; i = i + 2) {
            int count = 2;
            for (int j = 3; j < i / 2; j = j + 2) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 8) {
                result++;
            }
        }
        System.out.println(result);
        scan.close();
    }
}
