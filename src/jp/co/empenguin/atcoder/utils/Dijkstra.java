package jp.co.empenguin.atcoder.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

/**
 * TODO TLE 発生
 */
public class Dijkstra {
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

        public void addEdge(int from, int to, int distance) {
            Vertex fromV = this.vertexMap.get(from);
            Vertex toV = this.vertexMap.get(to);
            Edge edge = new Edge(fromV, toV, distance);
            fromV.addEdge(edge);
        }

        public int[] getDistanceWithEachVertex(int src) {
            PriorityQueue<Vertex> queue = new PriorityQueue<>();
            queue.addAll(vertexMap.values());

            Vertex current = vertexMap.get(src);
            queue.remove(current);
            current.updateDistance(0);
            queue.offer(current);
            int[] distances = new int[this.vertexMap.values().size()];

            while (!queue.isEmpty()) {
                Vertex vertex = queue.poll();
                distances[vertex.getVertexIndex()] = vertex.getDistance();

                for (Edge edge : vertex.getEdges()) {
                    Vertex to = edge.getTo();
                    if (queue.remove(to)) {
                        to.updateDistance(vertex.getDistance() + edge.getDistance());
                        queue.offer(to);
                    }
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int V = scan.nextInt();
        int E = scan.nextInt();
        int r = scan.nextInt();

        DijkstraSolve solve = new DijkstraSolve(V);
        for (int i = 0; i < E; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int distance = scan.nextInt();

            solve.addEdge(from, to, distance);
        }

        int[] distances = solve.getDistanceWithEachVertex(r);

        for (int distance : distances) {
            if (distance == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance);
            }
        }

        scan.close();
    }
}
