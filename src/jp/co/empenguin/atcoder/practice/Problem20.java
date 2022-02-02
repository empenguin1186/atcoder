package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Problem20 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
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
        Arrays.sort(B);
        Arrays.sort(C);

        int bl = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            int value = A[i];
            bl = findScope(bl, N-1, B, value);
            if (bl < 0) {
                continue;
            }
            int cl = 0;
            for (int j = bl; j < N; j++) {
                cl = findScope(cl, N-1, C, B[j]);
                if (cl < 0) {
                    continue;
                }
                result += N - cl;
            }
        }
        System.out.println(result);
        scan.close();
    }

    public static int findScope(int left, int right, int[] array, int value) {
        if (right - left < 2) {
            if (value < array[left]) {
                return left;
            }
            if (value < array[right]) {
                return right;
            }
            return -1;
        }
        int index = (left + right) / 2;
        if (array[index] < value) {
            return findScope(index, right, array, value);
        } else {
            return findScope(left, index, array, value);
        }
    }

    public static int lowerBound(Integer[] array, int value) {
        return ~Arrays.binarySearch(array, value, (x, y) -> x.compareTo(y) >= 0 ? 1 : -1);
    }

    public static int upperBound(Integer[] array, int value) {
        return ~Arrays.binarySearch(array, value, (x, y) -> x.compareTo(y) > 0 ? 1 : -1);
    }
}
