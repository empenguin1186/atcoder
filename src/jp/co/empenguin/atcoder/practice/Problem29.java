package jp.co.empenguin.atcoder.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Problem29 {
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

        int R = scan.nextInt();
        int C = scan.nextInt();
        int sy = scan.nextInt() - 1;
        int sx = scan.nextInt() - 1;
        int gy = scan.nextInt() - 1;
        int gx = scan.nextInt() - 1;

        boolean[][] map = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = scan.next();
            char[] chars = line.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '.') {
                    map[i][j] = true;
                }
            }
        }

        int[][] dist = new int[R][C];
        for (int i = 0; i < R; i++) {
            int[] cols = new int[C];
            Arrays.fill(cols, -1);
            dist[i] = cols;
        }

        Queue<Coordinate> queue = new ArrayDeque<>();
        dist[sy][sx] = 0;
        queue.add(new Coordinate(sy, sx));

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            map[coordinate.y][coordinate.x] = false;

            int[] dy = new int[]{0, -1, 0, 1};
            int[] dx = new int[]{-1, 0, 1, 0};

            for (int i = 0; i < 4; i++) {
                int y = coordinate.y + dy[i];
                int x = coordinate.x + dx[i];

                if (y < 0 || y >= R || x < 0 || x >= C || !map[y][x] || dist[y][x] != -1) {
                    continue;
                }

                dist[y][x] = dist[coordinate.y][coordinate.x] + 1;
                queue.add(new Coordinate(y, x));
            }
        }

        System.out.println(dist[gy][gx]);

        scan.close();
    }
}
