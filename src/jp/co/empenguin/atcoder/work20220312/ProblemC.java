package jp.co.empenguin.atcoder.work20220312;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {
    public static class Point {
        private Integer left;
        private Integer right;

        public Point() {
            this.left = Integer.MAX_VALUE;
            this.right = -1;
        }

        public void setPoint(char c, Integer value) {
            if (c == 'L') {
                this.right = Math.max(this.right, value);
            } else {
                this.left = Math.min(this.left, value);
            }
        }

        public boolean isCollisionOccurred() {
            return this.left <= this.right;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] X = new int[N];
        int[] Y = new int[N];

        for (int i = 0; i < N; i++) {
            X[i] = scan.nextInt();
            Y[i] = scan.nextInt();
        }

        String S = scan.next();
        char[] chars = S.toCharArray();

        Map<Integer, Point> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char c = chars[i];
            if (map.containsKey(Y[i])) {
                Point point = map.get(Y[i]);
                point.setPoint(c, X[i]);
            } else {
                Point point = new Point();
                point.setPoint(c, X[i]);
                map.put(Y[i], point);
            }
        }

        String result = "No";
        for (Point value : map.values()) {
            if (value.isCollisionOccurred()) {
                result = "Yes";
                break;
            }
        }

        System.out.println(result);
        scan.close();
    }
}
