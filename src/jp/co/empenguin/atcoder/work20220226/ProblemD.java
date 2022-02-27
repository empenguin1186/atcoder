package jp.co.empenguin.atcoder.work20220226;

import java.util.Scanner;
import java.util.TreeMap;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Q = scan.nextInt();
        TreeMap<Long, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < Q; i++) {
            int operation = scan.nextInt();
            long x = scan.nextLong();
            if (operation == 1) {
                if (treeMap.containsKey(x)) {
                    treeMap.put(x, treeMap.get(x) + 1);
                } else {
                    treeMap.put(x, 1);
                }
                continue;
            }

            int k = scan.nextInt();
            Long ans = x;
            int count = treeMap.getOrDefault(x, 0);
            if (operation == 2) {
                while (count < k) {
                    ans = treeMap.lowerKey(ans);
                    if (ans == null) {
                        break;
                    } else {
                        count += treeMap.get(ans);
                    }
                }
            } else {
                while (count < k) {
                    ans = treeMap.higherKey(ans);
                    if (ans == null) {
                        break;
                    } else {
                        count += treeMap.get(ans);
                    }
                }
            }
            if (ans != null) {
                System.out.println(ans);
            } else {
                System.out.println(-1);
            }
        }
        scan.close();
    }
}
