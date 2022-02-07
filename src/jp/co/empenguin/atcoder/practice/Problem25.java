package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem25 {
    private static int H;
    private static int W;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int w = scan.nextInt();
            int h = scan.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            W = w;
            H = h;
            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = scan.nextInt();
                }
            }

            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 0) continue;
                    dfs(i, j, map);
                    result++;
                }
            }
            System.out.println(result);
        }
        scan.close();
    }

    public static void dfs(int h, int w, int[][] map) {
        map[h][w] = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int dh = h + i;
                int dw = w + j;
                if (dh < 0 || dh >= H || dw < 0 || dw >= W || map[dh][dw] == 0) {
                    continue;
                }
                dfs(dh, dw, map);
            }
        }
    }
}
