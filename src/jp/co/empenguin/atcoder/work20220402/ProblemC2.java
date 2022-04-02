package jp.co.empenguin.atcoder.work20220402;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemC2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int X = scan.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }

        int[] B = new int[N];
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            int coupons = A[i] / X;
            if (flag) {
                if (K - coupons < 0) {
                    B[i] = A[i] - X * K;
                    K = 0;
                    flag = false;
                } else {
                    B[i] = A[i] - X * coupons;
                    K = K - coupons;
                }
            } else {
                B[i] = A[i];
            }
        }

        Arrays.sort(B);
        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += B[i];
        }

        System.out.println(result);

        scan.close();
    }
}
