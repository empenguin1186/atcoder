package jp.co.empenguin.atcoder.work20220123;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = scan.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 4 * N - 1; i++) {
            int input = scan.nextInt();
            Integer count = map.get(input);
            if (count == null) {
                map.put(input, 1);
                continue;
            }
            map.put(input, count+1);
        }
        Integer result = map.entrySet().stream().filter(e -> e.getValue() == 3).findFirst().get().getKey();
        System.out.println(result);
        scan.close();
    }
}
