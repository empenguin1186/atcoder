package jp.co.empenguin.atcoder.work20220416;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long A = scan.nextLong();
        int B = scan.nextInt();
        int K = scan.nextInt();

        int count = 0;

        while (A < B) {
            A *= K;
            count++;
        }

        System.out.println(count);
        scan.close();
    }
}
