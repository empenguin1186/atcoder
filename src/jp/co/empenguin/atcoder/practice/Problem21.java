package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO 不正解
 */
public class Problem21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long[] H = new long[N];
        long[] S = new long[N];

        long max = 0;
        for (int i=0; i<N;i++) {
            H[i] = scan.nextLong();
            S[i] = scan.nextLong();
            long finalHeight = H[i] + S[i] * (N-1);

            max = Math.max(finalHeight, max);
        }

        long left = 0;
        long right = max;

        while(right - left > 1) {
            boolean isOver = false;

            long mid = (right + left) / 2;
            long[] t = new long[N];
            for (int i=0; i<N; i++) {
                // 設定した高さを超えるまでの秒数を算出
                long value = (mid - H[i]) / S[i];
                t[i] = (mid - H[i]) % S[i] == 0 ? value : value + 1;
            }

            Arrays.sort(t);

            for (int i=0; i<N; i++) {
                // 設定した高さを超えるまでにかかる秒数よりも風船を割るのにかかる秒数の方が大きくなった場合、条件は満たせず
                if (t[i] <= i) isOver = true;
            }

            if (isOver) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(right);

        scan.close();
    }
}
