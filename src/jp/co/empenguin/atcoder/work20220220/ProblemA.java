package jp.co.empenguin.atcoder.work20220220;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        String result = "No";
        if (Math.abs(a - b) == 1) {
            result = "Yes";
        } else if (Math.max(a, b) == 10 && Math.min(a, b) == 1) {
            result = "Yes";
        }
        System.out.println(result);
        scan.close();
    }
}
