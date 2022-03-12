package jp.co.empenguin.atcoder.work20220312;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        scan.close();

        int amount = V;
        while (true) {
            amount -= A;
            if (amount < 0) {
                System.out.println("F");
                return;
            }
            amount -= B;
            if (amount < 0) {
                System.out.println("M");
                return;
            }
            amount -= C;
            if (amount < 0) {
                System.out.println("T");
                return;
            }
        }
    }
}
