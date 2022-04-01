package jp.co.empenguin.atcoder.work20220326;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        int D = scan.nextInt();

        if (A*60*60+B*60 < C*60*60+D*60+1) {
            System.out.println("Takahashi");
        } else {
            System.out.println("Aoki");
        }

        scan.close();
    }
}
