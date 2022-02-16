package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem43 {
    public static final int RED = 0;
    public static final int BLUE = 1;
    public static final int WHITE = 2;
    public static final int BLACK = 3;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] map = new int[5][N];

        for (int i = 0; i < 5; i++) {
            String line = scan.next();
            char[] chars = line.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (c == 'R') {
                    map[i][j] = RED;
                } else if (c == 'B') {
                    map[i][j] = BLUE;
                } else if (c == 'W') {
                    map[i][j] = WHITE;
                } else {
                    map[i][j] = BLACK;
                }
            }
        }

        int[][] dp = new int[3][N+1];
        for (int j = 1; j < N+1; j++) {
            int red = 0;
            int blue = 0;
            int white = 0;
            for (int k = 0; k < 5; k++) {
                int color = map[k][j-1];
                if (color == RED) {
                    red++;
                } else if (color == BLUE) {
                    blue++;
                } else if (color == WHITE) {
                    white++;
                }
            }

            dp[RED][j] = Math.min(dp[BLUE][j-1], dp[WHITE][j-1]) + 5 - red;
            dp[BLUE][j] = Math.min(dp[RED][j-1], dp[WHITE][j-1]) + 5 - blue;
            dp[WHITE][j] = Math.min(dp[BLUE][j-1], dp[RED][j-1]) + 5 - white;
        }

        int result = Math.min(Math.min(dp[RED][N], dp[BLUE][N]), dp[WHITE][N]);

        System.out.println(result);
        scan.close();
    }
}
