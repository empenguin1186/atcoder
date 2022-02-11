package jp.co.empenguin.atcoder.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Problem30 {
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
        int N = scan.nextInt();

        Map<Integer, Coordinate> v = new HashMap<>();
        boolean[][] map = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            String line = scan.next();
            char[] chars = line.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (c == 'S') {
                    map[i][j] = true;
                    v.put(0, new Coordinate(i, j));
                } else if (c == '1' || c == '2' || c == '3' || c == '4'
                        || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                    map[i][j] = true;
                    v.put(Character.getNumericValue(c), new Coordinate(i, j));
                } else if (c == '.') {
                    map[i][j] = true;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            Coordinate start = v.get(i);
            Queue<Coordinate> queue = new ArrayDeque<>();
            queue.add(start);
            int[][] dist = initIntegerArray(H, W, -1);
            dist[start.y][start.x] = 0;

            Coordinate goal = v.get(i+1);

            while (!queue.isEmpty()) {
                Coordinate c = queue.poll();

                if (c.y == goal.y && c.x == goal.x) {
                    break;
                }

                int[] dy = new int[]{0, -1, 0, 1};
                int[] dx = new int[]{-1, 0, 1, 0};

                for (int j = 0; j < 4; j++) {
                    int y = c.y + dy[j];
                    int x = c.x + dx[j];

                    if (y < 0 || y >= H || x < 0 || x >= W || !map[y][x] || dist[y][x] != -1) {
                        continue;
                    }

                    dist[y][x] = dist[c.y][c.x] + 1;
                    queue.add(new Coordinate(y, x));
                }
            }

            result += dist[goal.y][goal.x];
        }

        System.out.println(result);

        scan.close();
    }

    /**
     * 二次元配列を任意の値で初期化する関数
     * @param row 行の長さ
     * @param col 列の長さ
     * @param val 初期値
     * @return 初期化された配列
     */
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
