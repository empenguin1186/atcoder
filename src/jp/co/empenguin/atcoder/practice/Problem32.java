package jp.co.empenguin.atcoder.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

/**
 * TODO 間違い
 */
public class Problem32 {

    public static class Coordinate {
        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }

        private int y;
        private int x;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return y == that.y && x == that.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    public static enum Direction {
        LEFT(0, -1),
        RIGHT(0, 1),
        UP(-1, 0),
        DOWN(1, 0);

        Direction(int dy, int dx) {
            this.dy = dy;
            this.dx = dx;
        }

        private int dy;
        private int dx;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int w = scan.nextInt();
            int h = scan.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = initIntegerArray(h, w, -1);
            Map<Coordinate, List<Direction>> wallMap = new HashMap<>();
            for (int i = 0; i < 2 * h - 1; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < w-1; j++) {
                        int value = scan.nextInt();
                        if (value == 1) {
                            int y = i / 2;
                            int x = j;
                            Coordinate left = new Coordinate(y, x);
                            List<Direction> leftList = wallMap.get(left);
                            if (leftList == null) {
                                List<Direction> list = new ArrayList<>();
                                list.add(Direction.RIGHT);
                                wallMap.put(left, list);
                            } else {
                                leftList.add(Direction.RIGHT);
                            }

                            Coordinate right = new Coordinate(y, x+1);
                            List<Direction> rightList = wallMap.get(right);
                            if (rightList == null) {
                                List<Direction> list = new ArrayList<>();
                                list.add(Direction.LEFT);
                                wallMap.put(right, list);
                            } else {
                                rightList.add(Direction.LEFT);
                            }
                        }
                    }
                } else {
                    for (int j = 0; j < w; j++) {
                        int value = scan.nextInt();
                        if (value == 1) {
                            int y = i / 2;
                            int x = j;
                            Coordinate down = new Coordinate(y, x);
                            List<Direction> downList = wallMap.get(down);
                            if (downList == null) {
                                List<Direction> list = new ArrayList<>();
                                list.add(Direction.DOWN);
                                wallMap.put(down, list);
                            } else {
                                downList.add(Direction.DOWN);
                            }

                            Coordinate up = new Coordinate(y+1, x);
                            List<Direction> upList = wallMap.get(up);
                            if (upList == null) {
                                List<Direction> list = new ArrayList<>();
                                list.add(Direction.UP);
                                wallMap.put(up, list);
                            } else {
                                upList.add(Direction.UP);
                            }
                        }
                    }
                }
            }

            boolean[][] seen = new boolean[h][w];
            map[0][0] = 1;
            Queue<Coordinate> queue = new ArrayDeque<>();
            queue.add(new Coordinate(0, 0));
            seen[0][0] = true;

            while (!queue.isEmpty()) {
                Coordinate coordinate = queue.poll();
                List<Direction> wallList = wallMap.get(coordinate);

                for (Direction d : Direction.values()) {
                    int yy = coordinate.y + d.dy;
                    int xx = coordinate.x + d.dx;

                    if (yy < 0 || yy >= h || xx < 0 || xx >= w || seen[yy][xx]) {
                        continue;
                    }

                    if (wallList == null) {
                        queue.add(new Coordinate(yy, xx));
                        seen[yy][xx] = true;
                        map[yy][xx] = map[coordinate.y][coordinate.x] + 1;
                    } else {
                        if (!wallList.contains(d)) {
                            queue.add(new Coordinate(yy, xx));
                            map[yy][xx] = map[coordinate.y][coordinate.x] + 1;
                        }
                        seen[yy][xx] = true;
                    }
                }
            }

            if (map[h-1][w-1] == -1) {
                System.out.println(0);
            } else {
                System.out.println(map[h-1][w-1]);
            }
        }

        scan.close();
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
