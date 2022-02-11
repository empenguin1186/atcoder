package jp.co.empenguin.atcoder.practice;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Problem31 {
    public static class Coordinate {
        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }

        private int y;
        private int x;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int W = scan.nextInt();
        int H = scan.nextInt();
        boolean[][] map = new boolean[H+2][W+2];

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                map[i][j] = scan.nextInt() == 1;
            }
        }

        boolean[][] queued = new boolean[H+2][W+2];
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(0, 0));
        queued[0][0] = true;

        int[] oddDy = new int[]{-1, -1, 0, 1, 1, 0};
        int[] oddDx = new int[]{0, 1, 1, 1, 0, -1};
        int[] evenDy = new int[]{-1, -1, 0, 1, 1, 0};
        int[] evenDx = new int[]{-1, 0, 1, 0, -1, -1};

        int count = 0;
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            int[] dx = coordinate.y % 2 == 0 ? evenDx : oddDx;
            int[] dy = coordinate.y % 2 == 0 ? evenDy : oddDy;

            for (int i = 0; i < 6; i++) {
                int yy = coordinate.y + dy[i];
                int xx = coordinate.x + dx[i];

                if (yy < 0 || yy >= H+2 || xx < 0 || xx >= W+2) {
                    continue;
                }
                if (map[yy][xx]) {
                    count++;
                    continue;
                }
                if (!queued[yy][xx]) {
                    queue.add(new Coordinate(yy, xx));
                    queued[yy][xx] = true;
                }
            }
        }

        System.out.println(count);
        scan.close();
    }
}
