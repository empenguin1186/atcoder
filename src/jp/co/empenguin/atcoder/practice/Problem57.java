package jp.co.empenguin.atcoder.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class Problem57 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int[][] query = new int[k][4];
        for (int i = 0; i < k; i++) {
            int operation = scan.nextInt();
            query[i][0] = operation;
            query[i][1] = scan.nextInt() - 1;
            query[i][2] = scan.nextInt() - 1;
            if (operation == 1) {
                query[i][3] = scan.nextInt();
            }
        }

        DijkstraSolve solve = new DijkstraSolve(n);
        for (int i = 0; i < k; i++) {
            if (query[i][0] == 1) {
                solve.addEdge(query[i][1], query[i][2], query[i][3]);
                solve.addEdge(query[i][2], query[i][1], query[i][3]);
            } else {
                solve.initVertexDistance();
                int result = solve.getMinimumDistance(query[i][1], query[i][2]);
                if (result == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(result);
                }
            }
        }

        scan.close();
    }

    public static class Vertex implements Comparable<Object> {
        private final int vertexIndex;
        private int distance;
        private final Vector<Edge> edges;

        public Vertex(int vertexIndex) {
            this.vertexIndex = vertexIndex;
            this.distance = Integer.MAX_VALUE;
            this.edges = new Vector<>();
        }

        public void updateDistance(int distance) {
            if (distance >= 0) {
                this.distance = Math.min(this.distance, distance);
            }
        }

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
        private final Map<Integer, Vertex> vertexMap;

        public DijkstraSolve(int vertexes) {
            this.vertexMap = new HashMap<>();
            for (int i = 0; i < vertexes; i++) {
                vertexMap.put(i, new Vertex(i));
            }
        }

        public void initVertexDistance() {
            for (Vertex vertex : vertexMap.values()) {
                vertex.initDistance();
            }
        }

        public void addEdge(int from, int to, int distance) {
            Vertex fromV = this.vertexMap.get(from);
            Vertex toV = this.vertexMap.get(to);
            Edge edge = new Edge(fromV, toV, distance);
            fromV.addEdge(edge);
        }

        public int getMinimumDistance(int src, int dst) {
            PriorityQueue<Vertex> queue = new PriorityQueue<>();
            queue.addAll(vertexMap.values());

            Vertex current = vertexMap.get(src);
            queue.remove(current);
            current.updateDistance(0);
            queue.offer(current);

            while (!queue.isEmpty()) {
                Vertex vertex = queue.poll();
                if (vertex.getVertexIndex() == dst) {
                    return vertex.getDistance();
                }

                for (Edge edge : vertex.getEdges()) {
                    Vertex to = edge.getTo();
                    if (queue.remove(to)) {
                        to.updateDistance(vertex.getDistance() + edge.getDistance());
                        queue.offer(to);
                    }
                }
            }

            return Integer.MAX_VALUE;
        }
    }
}
