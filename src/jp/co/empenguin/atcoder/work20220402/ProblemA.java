package jp.co.empenguin.atcoder.work20220402;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x1 = scan.nextInt();
        int y1 = scan.nextInt();

        int x2 = scan.nextInt();
        int y2 = scan.nextInt();

        int x3 = scan.nextInt();
        int y3 = scan.nextInt();

        int x4;
        int y4;

        if (x1 == x2) {
            x4 = x3;
        } else if (x2 == x3) {
            x4 = x1;
        } else {
            x4 = x2;
        }

        if (y1 == y2) {
            y4 = y3;
        } else if (y2 == y3) {
            y4 = y1;
        } else {
            y4 = y2;
        }

        System.out.println(x4 + " " + y4);

        scan.close();
    }
}
