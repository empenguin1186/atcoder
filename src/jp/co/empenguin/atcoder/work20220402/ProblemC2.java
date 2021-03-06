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
        long sum = 0;
        long applicableCoupons = 0;
        int[] discounted = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
            sum += A[i];
            applicableCoupons += A[i] / X;
            discounted[i] = A[i] % X;
        }

        long m = Math.min(K, applicableCoupons);
        long result = sum - m * X;
        long remains = K - m;
        Arrays.sort(discounted);

        for (int i = N-1; i >= 0; i--) {
            if (remains == 0) {
                break;
            }
            result -= discounted[i];
            remains--;
        }

        System.out.println(result);

        scan.close();
    }
}
