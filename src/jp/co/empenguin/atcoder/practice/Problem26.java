package jp.co.empenguin.atcoder.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem26 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int Q = scan.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            List<Integer> aList = graph.get(a);
            if (aList == null) {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                graph.put(a, list);
            } else {
                aList.add(b);
            }

//            List<Integer> bList = graph.get(b);
//            if (bList == null) {
//                List<Integer> list = new ArrayList<>();
//                list.add(a);
//                graph.put(b, list);
//            } else {
//                bList.add(a);
//            }
        }

        int[] result = new int[N];
        for (int i = 0; i < Q; i++) {
            int p = scan.nextInt() - 1;
            int x = scan.nextInt();
            result[p] += x;
        }
        dfs(graph, 0, result);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N-1; i++) {
            sb.append(result[i]);
            sb.append(" ");
        }
        sb.append(result[N-1]);
        System.out.println(sb.toString());

        scan.close();
    }

    public static void dfs(Map<Integer, List<Integer>> graph, int start, int[] result) {
        List<Integer> children = graph.get(start);
        if (children != null) {
            for (Integer child : children) {
                if (start == child) {
                    continue;
                }
                result[child] += result[start];
                dfs(graph, child, result);
            }
        }
    }
}
