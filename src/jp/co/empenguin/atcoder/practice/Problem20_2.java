package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Problem20_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        Integer[] C = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            C[i] = scan.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(C);

        long result = 0;
        for (int i : B) {
            long a = lowerBound(A, i);
            long c = N - upperBound(C, i);
            result += a * c;
        }
        
        System.out.println(result);
        scan.close();
    }

    public static int lowerBound(Integer[] array, int value) {
        return ~Arrays.binarySearch(array, value, (x, y) -> x.compareTo(y) >= 0 ? 1 : -1);
    }

    public static int upperBound(Integer[] array, int value) {
        return ~Arrays.binarySearch(array, value, (x, y) -> x.compareTo(y) > 0 ? 1 : -1);
    }
}
