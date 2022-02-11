package jp.co.empenguin.atcoder.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Problem33 {

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

        int H = scan.nextInt();
        int W = scan.nextInt();

        int numOfBlack = 0;
        boolean[][] map = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            String line = scan.next();
            char[] chars = line.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '#') {
                    numOfBlack++;
                    continue;
                }
                map[i][j] = true;
            }
        }

        boolean[][] seen = new boolean[H][W];
        int[][] dist = initIntegerArray(H, W, -1);

        dist[0][0] = 1;
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(0, 0));
        seen[0][0] = true;

        int[] dy = new int[]{0, -1, 0, 1};
        int[] dx = new int[]{-1, 0, 1, 0};

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            int y = coordinate.y;
            int x = coordinate.x;

            for (int i = 0; i < 4; i++) {
                int yy = y + dy[i];
                int xx = x + dx[i];

                if (yy < 0 || yy >= H || xx < 0 || xx >= W) {
                    continue;
                }

                if (seen[yy][xx]) {
                    continue;
                }

                if (map[yy][xx] && dist[yy][xx] == -1) {
                    queue.add(new Coordinate(yy, xx));
                    seen[yy][xx] = true;
                    dist[yy][xx] = dist[y][x] + 1;
                }
            }
        }

        int result = 0;
        if (dist[H-1][W-1] == -1) {
            result = -1;
        } else {
            result = H * W - dist[H-1][W-1] - numOfBlack;
        }

        System.out.println(result);

        scan.close();
    }

    public static int[][] initIntegerArray(int row, int col, int val) {
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            int[] cols = new int[col];
            Arrays.fill(cols, val);
            array[i] = cols;
        }
        return array;
    }
}
