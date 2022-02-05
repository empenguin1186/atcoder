package jp.co.empenguin.atcoder.work20220205;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
        int[] x = new int[N+2];
        x[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = i-1; j >= 0; j--) {
                int r = x[j] + A[i-1];
                x[j+1] = r >= 360 ? r - 360 : r;
            }
            x[0] = 0;
        }
        x[N+1] = 360;
        Arrays.sort(x);
        int result = 0;
        for (int i = 0; i < N+1; i++) {
            int temp = x[i+1] - x[i];
            if (result < temp) {
                result = temp;
            }
        }
        System.out.println(result);
        scan.close();
    }
}
