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
        int sum = 0;
        int applicableCoupons = 0;
        int[] discounted = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
            sum += A[i];
            applicableCoupons += A[i] / X;
            discounted[i] = A[i] % X;
        }

        int result = 0;
        if (applicableCoupons >= K) {
            result = sum - K * X;
        } else {
            int to = K - applicableCoupons;
            Arrays.sort(discounted);
            int[] array = Arrays.copyOfRange(discounted, 0, Math.max(0, N - to));
            result = Arrays.stream(array).sum();
        }

        System.out.println(result);

        scan.close();
    }
}
