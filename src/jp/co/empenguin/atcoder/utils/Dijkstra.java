package jp.co.empenguin.atcoder.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Dijkstra {
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
            return this.vertexMap.entrySet().stream().filter(e -> e.getValue().isNotSeen()).min(Comparator.comparingInt(e -> e.getValue().distance)).get().getValue().getDistance();
        }

        public Vertex get(Integer index) {
            return this.vertexMap.get(index);
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

        public List<Integer> findByVertex(Vertex vertex) {
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
            this.edgeMap.put(new Edge(to, from), distance);
        }

        public Integer getDistance(int from, int to) {
            return this.edgeMap.get(new Edge(from, to));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        int E = scan.nextInt();
        int[][] map = initIntegerArray(V, V, -1);

        final EdgeMap edgeMap = new EdgeMap();
        final Graph graph = new Graph();
        final VertexMap vertexMap = new VertexMap();
        for (int i = 0; i < E; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int distance = scan.nextInt();

            Vertex vertex = new Vertex(from);
            edgeMap.addEdge(from, to, distance);
            graph.addVertex(vertex, to);
            vertexMap.addVertex(vertex);
        }

        int src = scan.nextInt();
        int dst = scan.nextInt();
        int[] distances = new int[V];

        Vertex current = vertexMap.get(src);
        current.updateDistance(0);
        current.seen();
        while(true) {
            List<Integer> connected = graph.findByVertex(current);
            for (Integer to : connected) {
                Vertex vertex = vertexMap.get(to);
                Integer distance = edgeMap.getDistance(current.getVertexIndex(), to);
                vertex.updateDistance(current.getDistance() + distance);
            }
            Integer min = vertexMap.findMin();
            current = vertexMap.get(min);
            current.seen();
        }

        scan.close();
    }

    public static void dijkstra(int[][] map, int src, int[] distances) {

    }

    public static int[][] initIntegerArray(int row, int col, int val) {
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            int[] cols = new int[col];
            Arrays.fill(cols, val);
            array[i] = cols;
        }
        return array;
    }
}