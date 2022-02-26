package jp.co.empenguin.atcoder.work20220226;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int key = scan.nextInt();
            map.merge(key, 1, Integer::sum);
        }
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = scan.nextInt();
        }

        boolean isYes = true;
        for (int i = 0; i < M; i++) {
            int key = B[i];
            Integer value = map.get(key);
            if (value == null) {
                isYes = false;
                break;
            }

            if (value > 0) {
                map.put(key, value - 1);
            } else {
                isYes = false;
                break;
            }
        }

        System.out.println(isYes ? "Yes" : "No");

        scan.close();
    }
}
