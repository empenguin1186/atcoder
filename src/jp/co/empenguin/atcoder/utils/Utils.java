package jp.co.empenguin.atcoder.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;

public class Utils {

    /**
     * 二進数表記で 1 となっている桁のリストを返す関数(010010 の場合 [1, 4])
     * @param number 入力
     * @param bitLength 二進数における桁数(100010 の場合 6)
     * @return 二進数表記で 1 となっている桁のリスト
     */
    public static List<Integer> detectFlag(int number, int bitLength) {
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < bitLength; i++) {
            if ((1 & number >> i) == 1) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 組み合わせを列挙する関数
     * @param candidate 候補の配列
     * @param r nCr の r の部分
     * @param <T> 扱う要素の型
     * @return 全組み合わせが格納された配列
     */
    public static <T> List<List<T>> make(List<T> candidate, int r) {
        // 5C6みたいなのは空
        // 0C5も空
        // 5C0も空
        if (candidate.size() < r || candidate.size() <= 0 || r <= 0) {
            List<List<T>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());
            return empty;
        }

        List<List<T>> combination = new ArrayList<>();
        // 5C3だったら、添字0, 1, 2だけ考えたらいい
        for (int i = 0; i <= candidate.size() - r; i++) {
            // 一つ取り出して
            T picked = candidate.get(i);
            List<T> rest = new ArrayList<>(candidate);
            // 以降の文字を削って
            rest.subList(0, i + 1).clear();
            // 再帰呼び出しし、得られたリストの全ての先頭に取り出したものを結合する
            combination.addAll(make(rest, r - 1).stream().peek(list -> list.add(0, picked)).collect(Collectors.toList()));
        }
        return combination;
    }

    /**
     * 0 ~ input までの数字を一文字ずつ文字列の配列として返す関数
     * @param input 最大値
     * @return 分割された文字配列の配列。桁が足りない場合は先頭から0で補う
     */
    public static String[][] getSplitValue(int input) {
        int keta = (int) Math.log10(input);
        String[][] result = new String[input][keta + 1];

        for (int i = 0; i < input; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            if (keta + 1 > len) {
                int diff = keta + 1 - len;
                for (int j = 0; j < diff; j++) {
                    result[i][j] = "0";
                }
                for (int j = diff; j < keta + 1; j++) {
                    result[i][j] = str.split("")[j-diff];
                }
            }
        }
        return result;
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
     * 階乗を出力する関数
     * @param n n! の n の部分
     * @return 階乗
     */
    public static long factorial(int n) {
        return n == 1 ? 1 : n * factorial(n-1);
    }


    /**
     * 一次元の座標群 array と点 point が与えられた場合の最短距離を求める関数
     * 例) array = [1, 3, 5, 8], point = 6 が与えられた場合、戻り値は1となる(|6-5|=1).
     *
     * @param left 探索対象の配列の左端のインデックス
     * @param right 探索対象の配列の右端のインデックス
     * @param array 探索対象の座標を格納した配列. あらかじめ昇順にソートされてある必要がある
     * @param point 最短距離を特定したい座標(1次元)
     * @return 最短距離
     */
    public static int findMinimumDistance(int left, int right, int[] array, int point) {
        if (right - left < 2) {
            return Math.min(Math.abs(point-array[right]), Math.abs(point-array[left]));
        }
        int index = (left + right) / 2;
        if (array[index] < point) {
            return findMinimumDistance(index, right, array, point);
        } else {
            return findMinimumDistance(left, index, array, point);
        }
    }

    /**
     * lower_bound 関数. 昇順ソートされた配列 array に対して、value の値よりも小さい値が最後に出現した位置を返す関数
     * @param array 昇順ソートされた配列
     * @param value 判定する値
     * @return value の値よりも大きい値が最初に出現した位置
     */
    public static int lowerBound(Integer[] array, int value) {
        return ~Arrays.binarySearch(array, value, (x, y) -> x.compareTo(y) >= 0 ? 1 : -1);
    }

    /**
     * upper_bound 関数. 昇順ソートされた配列 array に対して、value の値よりも大きい値が最初に出現した位置を返す関数
     * @param array 昇順ソートされた配列
     * @param value 判定する値
     * @return value の値よりも大きい値が最初に出現した位置
     */
    public static int upperBound(Integer[] array, int value) {
        return ~Arrays.binarySearch(array, value, (x, y) -> x.compareTo(y) > 0 ? 1 : -1);
    }

    /**
     * 三分探索を行う関数
     * @param low 探索を行う範囲を [low, high] とした場合の low の値. 左端の座標.
     * @param high 探索を行う範囲を [low, high] とした場合の high の値. 右端の座標.
     * @param operator 最小値を求める関数 f(x). 最小値を一つだけもつ. 下に凸である必要あり.
     * @return 最小値をとる際の x 座標
     */
    public static double ternarySearch(double low, double high, DoubleUnaryOperator operator) {
        // 500 は適当
        for (int i = 0; i < 500; i++) {
            double left = (2 * low + 1 * high) / 3;
            double right = (1 * low + 2 * high) / 3;
            double leftVal = operator.applyAsDouble(left);
            double rightVal = operator.applyAsDouble(right);
            if (leftVal < rightVal) {
                high = right;
            } else {
                low = left;
            }
        }
        return low;
    }

    /**
     * 深さ優先探索を行う関数
     * @param graph 探索を行うグラフ
     * @param start 探索の開始地点
     * @param seen 開始地点から各地点へ到達できるかどうかを格納する配列
     */
    public static void depthFirstSearch(Map<Integer, List<Integer>> graph, Integer start, boolean[] seen) {
        seen[start] = true;
        List<Integer> vertexes = graph.get(start);

        if (vertexes == null) {
            return;
        }

        for (Integer vertex : vertexes) {
            if (seen[vertex]) continue;
            depthFirstSearch(graph, vertex, seen);
        }
    }
}
