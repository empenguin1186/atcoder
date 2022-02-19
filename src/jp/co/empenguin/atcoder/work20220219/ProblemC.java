package jp.co.empenguin.atcoder.work20220219;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ProblemC {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();

        int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

        List<Point> p1 = new ArrayList<>();
        List<Point> p2 = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            p1.add(new Point(x1+dx[i], y1+dy[i]));
            p2.add(new Point(x2+dx[i], y2+dy[i]));
        }

        String result = "No";
        for (Point point : p1) {
            if (p2.contains(point)) {
                result = "Yes";
                break;
            }
        }

        System.out.println(result);
        scan.close();
    }
}
