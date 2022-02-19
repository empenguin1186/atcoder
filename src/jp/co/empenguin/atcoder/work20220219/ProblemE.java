package jp.co.empenguin.atcoder.work20220219;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO 不正解
 */
public class ProblemE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int Q = scan.nextInt();
        int[] X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = scan.nextInt();
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            int key = Math.min(a, b);
            int value = Math.max(a, b);

            List<Integer> list = graph.get(key);
            if (list == null) {
                List<Integer> temp = new ArrayList<>();
                temp.add(value);
                graph.put(key, temp);
            } else {
                list.add(value);
            }
        }

        int [] V = new int[Q];
        int [] K = new int[Q];
        for (int i = 0; i < Q; i++) {
            V[i] = scan.nextInt();
            K[i] = scan.nextInt();
        }

        Map<Integer, List<Integer>> vertex = new HashMap<>();
        dfs(0, graph, vertex, X);

        for (int i = 0; i < Q; i++) {
            List<Integer> list = vertex.get(V[i]-1);
            System.out.println(list.get(K[i]-1));
        }

        scan.close();
    }

    public static List<Integer> dfs(int start, Map<Integer, List<Integer>> graph, Map<Integer, List<Integer>> vertex, int[] X) {
        List<Integer> result = new ArrayList<>();
        result.add(X[start]);

        List<Integer> list = graph.get(start);
        if (list == null) {
            vertex.put(start, result);
            return result;
        }

        for (Integer v : list) {
            List<Integer> temp = dfs(v, graph, vertex, X);
            result.addAll(temp);
        }
        Collections.sort(result);
        Collections.reverse(result);
        vertex.put(start, result);
        return result;
    }
}
