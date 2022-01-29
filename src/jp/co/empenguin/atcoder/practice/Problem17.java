package jp.co.empenguin.atcoder.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem17 {
    public static class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int K = scan.nextInt();
        final int[][] queens = new int[K][2];
        for (int i = 0; i < K; i++) {
            queens[i][0] = scan.nextInt();
            queens[i][1] = scan.nextInt();
        }

        int[] rows = new int[8-K];
        int[] cols = new int[8-K];
        int current = 0;
        for (int i = 0; i < 8; i++) {
            boolean isContain = false;
            for (int j = 0; j < K; j++) {
                isContain |= i == queens[j][0];
            }
            if (!isContain) {
                rows[current] = i;
                current++;
            }
        }
        current = 0;
        for (int i = 0; i < 8; i++) {
            boolean isContain = false;
            for (int j = 0; j < K; j++) {
                isContain |= i == queens[j][1];
            }
            if (!isContain) {
                cols[current] = i;
                current++;
            }
        }

        boolean[][] map = new boolean[8][8];
        boolean isEnd = false;
        do {
            if (isEnd) {
                break;
            }
            do {
                // 候補となる座標のリストを作成する
                List<Point> points = new ArrayList<>();
                for (int i = 0; i < K; i++) {
                    points.add(new Point(queens[i][0], queens[i][1]));
                }
                for (int i = 0; i < 8 - K; i++) {
                    points.add(new Point(rows[i], cols[i]));
                }

                // 各座標は同じ列、または同じ行に位置しないように選んでいるので、任意に選んだ2つの座標が斜めに位置するかの判定だけ行えば良い
                List<List<Point>> pair = make(points, 2);
                boolean is8Queen = true;
                for (List<Point> pointList : pair) {
                    Point a = pointList.get(0);
                    Point b = pointList.get(1);
                    if (Math.abs((double)(a.y - b.y)/(a.x - b.x)) == 1) {
                        is8Queen = false;
                        break;
                    }
                }

                // 候補が見つかった場合、各座標を記録
                if (is8Queen) {
                    for (Point point : points) {
                        map[point.x][point.y] = true;
                    }
                    isEnd = true;
                }
            } while (nextPermutation(cols));
        } while (nextPermutation(rows));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String str = map[i][j] ? "Q" : ".";
                System.out.print(str);
            }
            System.out.println("");
        }
        scan.close();
    }

    /**
     * 順列全探索の組み合わせを列挙する関数
     * @param array 対象の配列(一番最初に呼ばれる際には昇順にソート済であること)
     * @return 次の組み合わせが存在するかどうか
     */
    public static boolean nextPermutation(int[] array) {

        int start = 0;
        int end = array.length;

        for(int i = end-2; i >= start; i--) {
            // array[i] < array[i+1] となる最大の i を特定. i+1 以降は降順に並んでいることになる.
            if(array[i] < array[i+1]) {

                // 末尾から array[i] < array[j] となる j を特定し、array[i] と array[j] を入れ替える
                // i+1 以降は降順で並んでいることから array[j-1] <= array[i] < array[j] < array[j-1], array[j-2], ...となり、
                // array[j] は array[i] より大きいかつ array[i] との差分が最小となる.
                // これにより辞書順的に現在の配列の並びの次にくるパターンを導出することができる.
                int j = end - 1;
                while(array[i] >= array[j]) {
                    j--;
                }
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;

                // なるべく辞書順的に上位に来るように、i+1 以降は昇順にソートする
                Arrays.sort(array, i+1, end);

                return true;
            }
        }

        return false;
    }

    /**
     * 組み合わせを列挙する関数
     * @param candidate 候補の配列
     * @param r nCr の r の部分
     * @param <T> 扱う要素の型
     * @return 全組み合わせが格納された配列
     */
    public static <T> List<List<T>> make(List<T> candidate, int r) {
        if (candidate.size() < r || candidate.size() <= 0 || r <= 0) {
            List<List<T>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());
            return empty;
        }

        List<List<T>> combination = new ArrayList<>();
        for (int i = 0; i <= candidate.size() - r; i++) {
            T picked = candidate.get(i);
            List<T> rest = new ArrayList<>(candidate);
            rest.subList(0, i + 1).clear();
            combination.addAll(make(rest, r - 1).stream().peek(list -> list.add(0, picked)).collect(Collectors.toList()));
        }
        return combination;
    }
}
