package jp.co.empenguin.atcoder.work20220326;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean[] flag = new boolean[2001];
        int N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int index = scan.nextInt();
            flag[index] = true;
        }

        for (int i = 0; i < 2001; i++) {
            if (!flag[i]) {
                System.out.println(i);
                break;
            }
        }

        scan.close();
    }
}
