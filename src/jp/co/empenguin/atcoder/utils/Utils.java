package jp.co.empenguin.atcoder.utils;

import java.util.ArrayList;
import java.util.List;
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
}
