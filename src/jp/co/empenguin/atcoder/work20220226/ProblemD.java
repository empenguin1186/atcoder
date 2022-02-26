package jp.co.empenguin.atcoder.work20220226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Q = scan.nextInt();
        int N = 200000;
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
            int temp = Collections.binarySearch(list, x);
            int index = temp < 0 ? -1 * temp - 1 : temp;
            if (operation == 2) {
                if (index - k + 1 >= 0) {
                    System.out.println(list.get(index - k + 1));
                } else {
                    System.out.println(-1);
                }
            } else {
                if (index + k - 1  < list.size()) {
                    System.out.println(list.get(index + k - 1));
                } else {
                    System.out.println(-1);
                }
            }
        }
        scan.close();
    }

    public static int lowerBound(int[] array, int value) {
        int raw = Arrays.binarySearch(array, value);
        return raw < 0 ? -1 * raw - 1 : raw;
    }
}
