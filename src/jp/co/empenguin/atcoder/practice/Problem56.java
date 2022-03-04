package jp.co.empenguin.atcoder.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * TODO TLE 発生
 */
public class Problem56 {
    public static class Vertex {
        private final int vertexIndex;
        private int distance;
        private boolean seen;

        public void updateDistance(int distance) {
            if (distance < this.distance) {
                this.distance = distance;
            }
        }

        public Vertex(int vertexIndex) {
            this.vertexIndex = vertexIndex;
            this.distance = Integer.MAX_VALUE;
            this.seen = false;
        }

        public int getVertexIndex() {
            return this.vertexIndex;
        }

        public int getDistance() {
            return this.distance;
        }

        public boolean isNotSeen() {
            return !this.seen;
        }

        public void seen() {
            this.seen = true;
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
    }

    public static class VertexMap {
        private final Map<Integer, Vertex> vertexMap;

        public VertexMap() {
            this.vertexMap = new HashMap<>();
        }

        public void addVertex(Vertex vertex) {
            this.vertexMap.put(vertex.vertexIndex, vertex);
        }

        public int findMin() {
            return this.vertexMap.entrySet().stream()
                    .filter(e -> e.getValue().isNotSeen())
                    .min(Comparator.comparingInt(e -> e.getValue().getDistance()))
                    .map(integerVertexEntry -> integerVertexEntry.getValue().getVertexIndex())
                    .orElse(-1);
        }

        public Vertex get(Integer index) {
            return this.vertexMap.get(index);
        }
        
        public int size() {
            return this.vertexMap.size();
        }
    }

    public static class Graph {
        private final Map<Vertex, List<Integer>> graph;

        public Graph() {
            this.graph = new HashMap<>();
        }

        public void addVertex(Vertex vertex, Integer to) {
            if (this.graph.containsKey(vertex)) {
                this.graph.get(vertex).add(to);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(to);
                this.graph.put(vertex, list);
            }
        }

        public List<Integer> findDestination(Vertex vertex) {
            return this.graph.get(vertex);
        }
    }

    public static class Edge {
        private final int from;
        private final int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return from == edge.from && to == edge.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }

    public static class EdgeMap {
        private final Map<Edge, Integer> edgeMap;

        public EdgeMap() {
            this.edgeMap = new HashMap<>();
        }

        public void addEdge(int from, int to, int distance) {
            this.edgeMap.put(new Edge(from, to), distance);
//            Integer currentDistance = this.edgeMap.get(new Edge(from, to));
//            if (currentDistance == null) {
//                this.edgeMap.put(new Edge(from, to), distance);
//                this.edgeMap.put(new Edge(to, from), distance);
//            } else {
//                Integer min = Math.min(currentDistance, distance);
//                this.edgeMap.put(new Edge(from, to), min);
//                this.edgeMap.put(new Edge(to, from), min);
//            }
        }

        public Integer getDistance(int from, int to) {
            return this.edgeMap.get(new Edge(from, to));
        }
    }

    public static class DijkstraSolve {
        final EdgeMap edgeMap;
        final VertexMap vertexMap;
        final Graph graph;

        public DijkstraSolve(EdgeMap edgeMap, VertexMap vertexMap, Graph graph) {
            this.edgeMap = edgeMap;
            this.vertexMap = vertexMap;
            this.graph = graph;
        }

        public int solve(int src, int dst) {
            Vertex current = this.vertexMap.get(src);
            current.updateDistance(0);
            current.seen();

            while (true) {
                int min = findMinimumDistance(current);
                if (min == -1) {
                    break;
                }

                // 経路が存在しない
                current = vertexMap.get(min);
                if (current.getDistance() == Integer.MAX_VALUE) {
                    return -1;
                }

                current.seen();
            }

            return vertexMap.get(dst).getDistance();
        }

        public int[] solveEachVertex(int src) {
            Vertex current = this.vertexMap.get(src);
            current.updateDistance(0);
            current.seen();
            
            int[] distances = new int[this.vertexMap.size()];
            while (true) {
                int min = findMinimumDistance(current);
                if (min == -1) {
                    break;
                }

                // 経路が存在しない
                current = vertexMap.get(min);
                distances[current.getVertexIndex()] = current.getDistance(); 
                current.seen();
            }

            return distances;
        }

        private int findMinimumDistance(Vertex current) {
            List<Integer> destinations = graph.findDestination(current);
            if (destinations != null) {
                for (Integer destination : destinations) {
                    Vertex vertex = vertexMap.get(destination);
                    if (vertex.isNotSeen() && current.getDistance() != Integer.MAX_VALUE) {
                        int distance = edgeMap.getDistance(current.getVertexIndex(), destination);
                        vertex.updateDistance(current.getDistance() + distance);
                    }
                }
            }
            return vertexMap.findMin();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int V = scan.nextInt();
        int E = scan.nextInt();
        int r = scan.nextInt();

        VertexMap vertexMap = new VertexMap();
        for (int i = 0; i < V; i++) {
            Vertex vertex = new Vertex(i);
            vertexMap.addVertex(vertex);
        }

        EdgeMap edgeMap = new EdgeMap();
        Graph graph = new Graph();
        for (int i = 0; i < E; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int distance = scan.nextInt();

            graph.addVertex(vertexMap.get(from), to);
            edgeMap.addEdge(from, to, distance);
        }

        DijkstraSolve solve = new DijkstraSolve(edgeMap, vertexMap, graph);
        int[] distances = solve.solveEachVertex(r);
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
