package jp.co.empenguin.atcoder.work20220226;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Q = scan.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            int operation = scan.nextInt();
            if (operation == 1) {
                list.add(scan.nextLong());
                Collections.sort(list);
                continue;
            }

            long x = scan.nextLong();
            int k = scan.nextInt();
            if (operation == 2) {
                int index = upperBound(list, x);
                int nextIndex = index - k + 1;
                if (nextIndex >= 0) {
                    System.out.println(list.get(nextIndex));
                } else {
                    System.out.println(-1);
                }
            } else {
                int index = lowerBound(list, x);
                int nextIndex = index + k - 1;
                if (nextIndex < list.size()) {
                    System.out.println(list.get(nextIndex));
                } else {
                    System.out.println(-1);
                }
            }
        }
        scan.close();
    }

    public static int upperBound(List<Long> list, long value) {
        int temp = Collections.binarySearch(list, value);
        return temp < 0 ? Math.min(-1 * temp - 1, list.size() - 1) : temp;
    }

    public static int lowerBound(List<Long> list, long value) {
        int temp = Collections.binarySearch(list, value);
        return temp < 0 ? -1 * temp - 1 : temp;
    }
}
