package jp.co.empenguin.atcoder.work20220226;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        boolean[][] map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = scan.next();
            char[] chars = line.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                map[i][j] = chars[j] == '#';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int v = 0;
                int h = 0;
                int s = 0;
                int t = 0;
                if (i < N-5 && j < N-5) {
                    for (int k = 0; k < 6; k++) {
                        v = map[i+k][j] ? v+1 : v;
                        h = map[i][j+k] ? h+1 : h;
                        s = map[i+k][j+k] ? s+1 : s;
                        t = map[i+k][j+5-k] ? t+1 : t;
                    }
                } else if (i >= N-5 && j < N-5) {
                    for (int k = 0; k < 6; k++) {
                        h = map[i][j+k] ? h+1 : h;
                    }
                } else if (i < N-5 && j >= N-5) {
                    for (int k = 0; k < 6; k++) {
                        v = map[i+k][j] ? v+1 : v;
                    }
                }

                if (v >= 4 || h >= 4 || s >= 4 || t >= 4) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
        scan.close();
    }
}
