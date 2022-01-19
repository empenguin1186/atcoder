package jp.co.empenguin.atcoder.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();
        List<String> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars.add(String.valueOf(c));
        }
        final List<List<String>> result = make(chars, 3);
        final Set<List<String>> output = new HashSet<>();
        for (List<String> strings : result) {
            output.add(strings);
        }
        System.out.println(output.size());
        scan.close();
    }

    // 候補となるリストと、何個ピックアップするかを渡す
    private static <T> List<List<T>> make (List<T> candidate, int r) {
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
}
