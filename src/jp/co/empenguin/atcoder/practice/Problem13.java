package jp.co.empenguin.atcoder.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO 回答間違いだが考え方は正しい
 */
public class Problem13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int R = scan.nextInt();
        final int C = scan.nextInt();
        final int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i < 1 << R; i++) {
            final List<Integer> list = new ArrayList<>();
            for (int j = 0; j < R; j++) {
                if ((1 & i >> j) == 1) {
                    list.add(i);
                }
            }
            int count = 0;
            for (int k = 0; k < C; k++) {
                int row = 0;
                for (int j = 0; j < R; j++) {
                    if (list.contains(j)) {
                        row += 1 - map[j][k];
                    } else {
                        row += map[j][k];
                    }
                }
                count += Math.max(R-row, row);
            }
            if (result < count) {
                result = count;
            }
        }
        System.out.println(result);
        scan.close();
    }
}
