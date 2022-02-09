package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem27 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] seen = new boolean[n][m];
                if (map[i][j] == 1) {
                    int temp = dfs(map, i, j, n, m, seen, 1);
                    if (result < temp) {
                        result = temp;
                    }
                }
            }
        }

        System.out.println(result);
        scan.close();
    }

    public static int dfs(int[][] map, int y, int x, int n, int m, boolean[][] seen, int val) {
        seen[y][x] = true;

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        int count = val;
        for (int i = 0; i < 4; i++) {
            int row = y + dy[i];
            int col = x + dx[i];

            if (row < 0 || row >= n || col < 0 || col >= m || seen[row][col]) {
                continue;
            }

            if (map[row][col] == 1) {
                int temp = dfs(map, row, col, n, m, seen, val+1);
                if (count < temp) {
                    count = temp;
                }
            }
        }

        return count;
    }
}
