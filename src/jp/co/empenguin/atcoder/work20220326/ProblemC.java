package jp.co.empenguin.atcoder.work20220326;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scan.nextInt();
        }

        boolean result = true;
        for (int i = 1; i < N-1; i++) {
            boolean a = Math.abs(A[i] - A[i-1]) <= K;
            boolean b = Math.abs(A[i] - B[i-1]) <= K;
            boolean c = Math.abs(A[i] - A[i+1]) <= K;
            boolean d = Math.abs(A[i] - B[i+1]) <= K;

            boolean temp1 = (a && c) || (a && d) || (b && c) || (b && d);

            boolean e = Math.abs(B[i] - A[i-1]) <= K;
            boolean f = Math.abs(B[i] - B[i-1]) <= K;
            boolean g = Math.abs(B[i] - A[i+1]) <= K;
            boolean h = Math.abs(B[i] - B[i+1]) <= K;

            boolean temp2 = (e && g) || (e && h) || (f && g) || (f && h);

            if (!temp1 && !temp2) {
                result = false;
                break;
            }
        }

        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
