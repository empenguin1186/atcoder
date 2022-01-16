package jp.co.empenguin.atcoder.work20220115;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int h = scan.nextInt();
            if (result < h) {
                result = h;
                continue;
            }
            break;
        }
        System.out.println(result);
        scan.close();
    }
}
