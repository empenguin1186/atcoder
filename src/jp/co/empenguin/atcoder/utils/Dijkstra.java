package jp.co.empenguin.atcoder.utils;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        int E = scan.nextInt();
        int[][] map = initIntegerArray(V, V, -1);

        for (int i = 0; i < E; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int distance = scan.nextInt();
            map[from][to] = map[to][from] = distance;
        }

        int src = scan.nextInt();
        int dst = scan.nextInt();
        int[] distances = new int[V];

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
