package jp.co.empenguin.atcoder.work20220123;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = scan.nextInt();
        final int M = scan.nextInt();
        Map<String, Integer> map = new HashMap<>();
        String[] result = new String[N];
        for (int i = 0; i < N; i++) {
            String si = scan.next();
            map.put(si, i);
            result[i] = "No";
        }
        for (int i = 0; i < M; i++) {
            String express = scan.next();
            int index = map.get(express);
            result[index] = "Yes";
        }
        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
        scan.close();
    }
}
