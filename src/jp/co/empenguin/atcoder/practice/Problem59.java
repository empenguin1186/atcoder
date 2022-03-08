package jp.co.empenguin.atcoder.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

/**
 * TODO 未実装
 */
public class Problem59 {
    public static class Vertex implements Comparable<Object> {
        private final int vertexIndex;
        private int distance;
        private final Vector<Edge> edges;

        public Vertex(int vertexIndex) {
            this.vertexIndex = vertexIndex;
            this.distance = Integer.MAX_VALUE;
            this.edges = new Vector<>();
        }

        /**
         * 距離を更新する.
         * @param distance 更新しようとする距離の値
         */
        public void updateDistance(int distance) {
            if (distance >= 0) {
                this.distance = Math.min(this.distance, distance);
            }
        }

        /**
         * 距離を初期化する.
         */
        public void initDistance() {
            this.distance = Integer.MAX_VALUE;
        }

        public int getVertexIndex() {
            return this.vertexIndex;
        }

        public int getDistance() {
            return this.distance;
        }

        public Vector<Edge> getEdges() {
            return edges;
        }

        /**
         * 連結している Edge を追加する
         * @param edge 連結している Edge
         */
        public void addEdge(Edge edge) {
            this.edges.add(edge);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return vertexIndex == vertex.vertexIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertexIndex);
        }

        @Override
        public int compareTo(Object o) {
            if (! (o instanceof Vertex)) throw new IllegalArgumentException("Vertex needed");
            Vertex x = (Vertex) o;
            return Integer.compare(this.distance, x.distance);
        }
    }

    public static class Edge {
        private final Vertex from;
        private final Vertex to;
        private final int distance;

        public Edge(Vertex from, Vertex to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        public Vertex getFrom() {
            return from;
        }

        public Vertex getTo() {
            return to;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return distance == edge.distance && Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to, distance);
        }
    }

    public static class DijkstraSolve {
        /** 各頂点を格納したMap */
        private final Map<Integer, Vertex> vertexMap;

        /** 最短距離をもつ頂点を探すために使用する優先度キュー */
        private final PriorityQueue<Vertex> queue;

        public DijkstraSolve(int vertexes, int[] C, int[] R) {
            this.vertexMap = new HashMap<>();
            for (int i = 0; i < vertexes; i++) {
                vertexMap.put(i, new Vertex(i));
            }
            this.queue = new PriorityQueue<>();
        }

        public void addEdge(int from, int to, int distance) {
            Vertex fromV = this.vertexMap.get(from);
            Vertex toV = this.vertexMap.get(to);
            Edge edge = new Edge(fromV, toV, distance);
            fromV.addEdge(edge);
        }

        /**
         * 各頂点の最短距離の初期化.
         */
        public void initVertexDistance() {
            for (Vertex vertex : vertexMap.values()) {
                vertex.initDistance();
            }
        }

        /**
         * 各頂点における始点srcからの最短距離を算出するメソッド.
         * @param src 始点
         * @return 各頂点への最短距離を格納した配列
         */
        public int[] getDistanceWithEachVertex(int src) {
            this.queue.clear();
            this.queue.addAll(vertexMap.values());

            Vertex current = vertexMap.get(src);
            this.queue.remove(current);
            current.updateDistance(0);
            this.queue.offer(current);
            int[] distances = new int[this.vertexMap.values().size()];

            while (!this.queue.isEmpty()) {
                Vertex vertex = this.queue.poll();
                distances[vertex.getVertexIndex()] = vertex.getDistance();

                for (Edge edge : vertex.getEdges()) {
                    Vertex to = edge.getTo();
                    if (this.queue.remove(to)) {
                        to.updateDistance(vertex.getDistance() + edge.getDistance());
                        this.queue.offer(to);
                    }
                }
            }

            return distances;
        }

        /**
         * src - dst間の最短距離を求めるメソッド. 到達できない場合は Integer.MAX_VALUE が返却される
         * @param src 始点
         * @param dst 終点
         * @return 最短距離
         */
        public int getMinimumDistance(int src, int dst) {
            this.queue.clear();
            this.queue.addAll(vertexMap.values());

            Vertex current = vertexMap.get(src);
            this.queue.remove(current);
            current.updateDistance(0);
            this.queue.offer(current);

            while (!this.queue.isEmpty()) {
                Vertex vertex = this.queue.poll();
                if (vertex.getVertexIndex() == dst) {
                    return vertex.getDistance();
                }

                for (Edge edge : vertex.getEdges()) {
                    Vertex to = edge.getTo();
                    if (this.queue.remove(to)) {
                        to.updateDistance(vertex.getDistance() + edge.getDistance());
                        this.queue.offer(to);
                    }
                }
            }

            return Integer.MAX_VALUE;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        int[] C = new int[N];
        int[] R = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = scan.nextInt();
            R[i] = scan.nextInt();
        }

        DijkstraSolve solve = new DijkstraSolve(N, C, R);
        for (int i = 0; i < K; i++) {
            int from = scan.nextInt() - 1;
            int to = scan.nextInt() - 1;
            solve.addEdge(from, to, 0);
            solve.addEdge(to, from, 0);
        }

        scan.close();
    }
}
