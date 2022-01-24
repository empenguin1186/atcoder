package jp.co.empenguin.atcoder.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = scan.nextInt();
        final int M = scan.nextInt();
        boolean[][] map = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;
            map[x][y] = true;
        }

        int result = 0;
        for (int i = 0; i < 1 << N; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((1 & i >> j) == 1) {
                    list.add(j);
                }
            }

            boolean isMatch = true;
            for (int j = 0; j < list.size() - 1; j++) {
                for (int k = j+1; k < list.size(); k++) {
                    isMatch &= map[list.get(j)][list.get(k)];
                }
            }

            if (isMatch && result < list.size()) {
                result = list.size();
            }
        }

        System.out.println(result);
        scan.close();
    }
}
