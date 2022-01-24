package jp.co.empenguin.atcoder.work20220123;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String S = scan.next();
        int a = scan.nextInt();
        int b = scan.nextInt();

        char[] result = S.toCharArray();
        char sa = result[a-1];
        char sb = result[b-1];
        result[a-1] = sb;
        result[b-1] = sa;

        System.out.println(result);
        scan.close();
    }
}
