package jp.co.empenguin.atcoder.work20220220;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int X = scan.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
            b[i] = scan.nextInt();
        }
        boolean[][] memo = new boolean[N][X+1];
        boolean[][] seen = new boolean[N][X+1];
        String result = dfs(N-1, X, a, b, memo, seen) ? "Yes" : "No";
        System.out.println(result);
        scan.close();
    }

    public static boolean dfs(int i, int X, int[] a, int[] b, boolean[][] memo, boolean[][] seen) {
        if (X < 0) {
            return false;
        }

        if (seen[i][X]) {
            return memo[i][X];
        }

        seen[i][X] = true;
        if (i == 0) {
            if (X == a[i] || X == b[i]) {
                return memo[i][X] = true;
            } else {
                return memo[i][X] = false;
            }
        }

        return memo[i][X] = dfs(i-1, X-a[i], a, b, memo, seen) || dfs(i-1, X-b[i], a, b, memo, seen);
    }
}
