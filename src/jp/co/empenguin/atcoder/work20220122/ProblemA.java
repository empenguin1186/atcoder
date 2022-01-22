package jp.co.empenguin.atcoder.work20220122;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
//        Set<Integer> elements = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < n; i++) {

            int element = scan.nextInt();
            Integer count = map.get(element);
            if (count == null) {
                map.put(element, 1);
            } else {
                count += 1;
                map.put(element, count);
                if (maxCount < count) {
                    maxCount = count;
                }
            }

//            elements.add(element);
            builder.append(element);
        }
        final int hoge = maxCount;
        var list = map.entrySet().stream().filter(e -> e.getValue() == hoge).collect(Collectors.toList());
        String str = builder.toString();
        List<String> candidate = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            candidate.add(str.replace(String.valueOf(entry.getKey()), ""));
        }
//        for (Integer element : elements) {
//            candidate.add(str.replace(String.valueOf(element), ""));
//        }
        candidate.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        String result = candidate.get(0);
        for (int i = 0; i < result.length(); i++) {
            System.out.print(result.charAt(i));
            System.out.print(" ");
        }
        System.out.println("");
        scan.close();
    }
}
