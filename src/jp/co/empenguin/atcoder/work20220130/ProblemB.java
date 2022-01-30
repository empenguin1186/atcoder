package jp.co.empenguin.atcoder.work20220130;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int H = scan.nextInt();
        int W = scan.nextInt();
        int[][] B = new int[W][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                B[j][i] = scan.nextInt();
            }
        }
        for (int i = 0; i < W; i++) {
            StringBuilder b = new StringBuilder();
            for (int j = 0; j < H; j++) {
                b.append(String.valueOf(B[i][j]));
                b.append(" ");
            }
            System.out.println(b.toString());
        }
        scan.close();
    }
}
