package jp.co.empenguin.atcoder.work20220312;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
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
            C[i] = B[i];
        }

        int result1 = 0;
        int result2 = 0;
        Arrays.sort(C);
        for (int i = 0; i < N; i++) {
            if (A[i] == B[i]) {
                result1++;
            } else {
                int index = Arrays.binarySearch(C, A[i]);
                if (index >= 0) {
                    result2++;
                }
            }
        }
        System.out.println(result1);
        System.out.println(result2);
        scan.close();
    }
}
