package jp.co.empenguin.atcoder.work20220115;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        final Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            List<Integer> index = map.get(a);
            if (index == null) {
                index = new ArrayList<>();
            }
            index.add(i+1);
            map.put(a, index);
        }

        for (int i = 0; i < q; i++) {
            int x = scan.nextInt();
            int k = scan.nextInt();

            List<Integer> list = map.get(x);
            if (list == null) {
                System.out.println(-1);
                continue;
            }
            if (list.size() < k) {
                System.out.println(-1);
                continue;
            }
            int result = list.get(k - 1);
            System.out.println(result);
        }
        scan.close();
    }
}
