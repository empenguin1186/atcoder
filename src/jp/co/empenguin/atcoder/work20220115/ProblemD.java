package jp.co.empenguin.atcoder.work20220115;

import java.util.Scanner;

/**
 * 不正解
 */
public class ProblemD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int n = scan.nextInt();
        System.out.println(calculateMin(n, a, false));
        scan.close();
    }

    private static int calculateMin(int n, int a, boolean shifted) {

        // 1. n が 10 未満である場合 -> 入れ替えはできない
        // 2. n の1の位が0の場合 -> 入れ替えはできない
        // 3. n が 2 の場合 -> 1
        // 4. 入れ替えもできないし a でも割り切れない場合 -> -1
        // 5. a で割り切れない場合かつ 1, 2 の条件を満たさない -> 入れ替え
        //

        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if (n < 10 || n % 10 == 0) {
            if (n % a == 0) {
                return 1 + calculateMin(n/a, a, false);
            }
            return -1;
        }

        if (shifted) {
            return 1 + calculateMin(n/a, a, false);
        }

        String str = String.valueOf(n);
        char prefix = str.charAt(0);
        String middle = str.substring(1, str.length());
        int replaced = Integer.parseInt(middle + prefix);
        if (n % a != 0) {
            return 1 + calculateMin(replaced, a, true);
        }
        return 1 + Math.min(calculateMin(replaced, a, true), calculateMin(n/a, a, false));
    }
}
