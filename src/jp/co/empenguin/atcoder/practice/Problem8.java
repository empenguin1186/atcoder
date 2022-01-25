package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = scan.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
            B[i] = scan.nextInt();
        }

        Arrays.sort(A);
        int a = A[N/2];
        Arrays.sort(B);
        int b = B[N/2];
        long result = 0;
        for (int i = 0; i < N; i++) {
            result += Math.abs(a-A[i]) + Math.abs(B[i]-A[i]) + Math.abs(B[i]-b);
        }
        System.out.println(result);

//        long result = Long.MAX_VALUE;
//        final int length = 100;
//        for (int i = 0; i < length-1; i++) {
//            for (int j = i+1; j < length; j++) {
//                long cost = 0;
//                for (int k = 0; k < N; k++) {
//                    cost += Math.abs(i+1-A[k]) + Math.abs(B[k]-A[k]) + Math.abs(B[k]-j-1);
//                }
//                if (cost < result) {
//                    result = cost;
//                }
//            }
//        }
//        System.out.println(result);
        scan.close();
    }
}
