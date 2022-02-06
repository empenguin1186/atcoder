package jp.co.empenguin.atcoder.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem24 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        Map<Integer, List<Integer>> G = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int from = scan.nextInt() - 1;
            int numOfFroms = scan.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < numOfFroms; j++) {
                list.add(scan.nextInt() - 1);
            }
            G.put(from, list);
        }

        boolean[] seen = new boolean[N];

        List<Integer> starts = G.keySet().stream().filter(e -> {
            boolean isContain = true;
            for (List<Integer> value : G.values()) {
                isContain &= !value.contains(e);
            }
            return isContain;
        }).collect(Collectors.toList());
        DfsTimeStamp order = new DfsTimeStamp(N);

        if (starts.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            starts = temp;
        }
        for (Integer start : starts) {
            dfsTimeStamp(G, start, seen, order);
        }

        for (int i = 0; i < N; i++) {
            System.out.printf("%d %d %d%n", i+1, order.getFirstOrder()[i]+1, order.getLastOrder()[i]+1);
        }

        scan.close();
    }

    public static void depthFirstSearch(Map<Integer, List<Integer>> graph, Integer start, boolean[] seen) {
        seen[start] = true;
        List<Integer> vertexes = graph.get(start);

        if (vertexes == null) {
            return;
        }

        for (Integer vertex : vertexes) {
            if (seen[vertex]) continue;
            depthFirstSearch(graph, vertex, seen);
        }
    }

    public static class DfsOrderState {
        int[] order;
        int ptr;

        public DfsOrderState(int n) {
            this.order = new int[n];
            this.ptr = 0;
        }

        public int[] getOrder() {
            return order;
        }

        public void setOrder(int vertex) {
            this.order[vertex] = this.ptr++;
        }
    }

    /**
     * 深さ優先探索において行きがけ、帰りがけ順を求める関数
     * @param graph 探索対象のグラフ
     * @param start 開始地点
     * @param seen 各地点が考慮済みであるかどうかを格納した配列
     * @param firstOrder 行きがけ順を記録しているオブジェクト
     * @param lastOrder 帰りがけ順を記録しているオブジェクト
     */
    public static void dfsFirstLastOrder(
            Map<Integer, List<Integer>> graph,
            Integer start,
            boolean[] seen,
            DfsOrderState firstOrder,
            DfsOrderState lastOrder
    ) {

        // 行きがけ順を記録 & インクリメント
        firstOrder.setOrder(start);

        seen[start] = true;
        List<Integer> vertexes = graph.get(start);
        if (vertexes == null) {
            lastOrder.setOrder(start);
            return;
        }
        for (Integer vertex : vertexes) {
            if (seen[vertex]) continue;
            dfsFirstLastOrder(graph, vertex, seen, firstOrder, lastOrder);
        }

        // 帰りがけ順を記録 & インクリメント
        lastOrder.setOrder(start);
    }

    public static class DfsTimeStamp {
        int[] firstOrder;
        int[] lastOrder;
        int ptr;

        public DfsTimeStamp(int n) {
            this.firstOrder = new int[n];
            this.lastOrder = new int[n];
            this.ptr = 0;
        }

        public int[] getFirstOrder() {
            return this.firstOrder;
        }

        public int[] getLastOrder() {
            return this.lastOrder;
        }

        public void setFirstOrder(int vertex) {
            this.firstOrder[vertex] = this.ptr++;
        }

        public void setLastOrder(int vertex) {
            this.lastOrder[vertex] = this.ptr++;
        }
    }

    /**
     * グラフにおいて各地点のタイムスタンプを記録する関数
     * https://qiita.com/drken/items/4a7869c5e304883f539b
     * @param graph 探索対象のグラフ
     * @param start 開始地点
     * @param seen 各地点が考慮済みであるかどうかを格納した配列
     * @param order タイムスタンプを記録しているオブジェクト
     */
    public static void dfsTimeStamp(
            Map<Integer, List<Integer>> graph,
            Integer start,
            boolean[] seen,
            DfsTimeStamp order
    ) {
        // 行きがけ順を記録 & インクリメント
        order.setFirstOrder(start);

        seen[start] = true;
        List<Integer> vertexes = graph.get(start);
        if (vertexes == null) {
            order.setLastOrder(start);
            return;
        }
        for (Integer vertex : vertexes) {
            if (seen[vertex]) continue;
            dfsTimeStamp(graph, vertex, seen, order);
        }

        // 帰りがけ順を記録 & インクリメント
        order.setLastOrder(start);
    }
}
