package jp.co.empenguin.atcoder.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Problem28 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        Map<Integer, List<Integer>> G = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int from = scan.nextInt() - 1;
            int numOfTo = scan.nextInt();
            if (numOfTo == 0) {
                continue;
            }

            List<Integer> tos = new ArrayList<>();
            for (int j = 0; j < numOfTo; j++) {
                int to = scan.nextInt() - 1;
                tos.add(to);
            }
            G.put(from, tos);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new ArrayDeque<>();

        dist[0] = 0;
        queue.add(0);

        while (!queue.isEmpty()) {
            int v = queue.poll();

            List<Integer> toList = G.get(v);
            if (toList == null) {
                continue;
            }
            for (Integer to : toList) {
                if (dist[to] != -1) {
                    continue;
                }
                dist[to] = dist[v] + 1;
                queue.add(to);
            }
        }

        for (int i = 0; i < N; i++) {
            String str = (i + 1) + " " + dist[i];
            System.out.println(str);
        }

        scan.close();
    }
}
