package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem27_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        int[][] map = new int[n+2][m+2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i+1][j+1] = scan.nextInt();
            }
        }

        int result = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (map[i][j] == 1) {
                    boolean[][] seen = new boolean[n+2][m+2];
                    int temp = dfs(map, i, j, 1, seen);
                    if (result < temp) {
                        result = temp;
                    }
                }
            }
        }

        System.out.println(result);
        scan.close();
    }

    public static int dfs(int[][] map, int y, int x, int val, boolean[][] seen) {
        seen[y][x] = true;

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        int count = val;
        for (int i = 0; i < 4; i++) {
            int row = y + dy[i];
            int col = x + dx[i];

            if (map[row][col] == 1 && !seen[row][col]) {
                int temp = dfs(map, row, col, val+1, seen);
                if (count < temp) {
                    count = temp;
                }
            }
        }

        return count;
    }
}
