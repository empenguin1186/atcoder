package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem23 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long M = scan.nextLong();
        long[] P = new long[N+1];
        P[0] = 0;
        for (int i = 1; i < N+1; i++) {
            P[i] = scan.nextLong();
        }

        final Set<Long> points = new HashSet<>();
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                points.add(P[i] + P[j]);
            }
        }
        final long[] list = new long[points.size()];
        int i = 0;
        for (Long point : points) {
            list[i++] = point;
        }
        Arrays.sort(list);

        long result = 0;
        for (long el : list) {
            long margin = M - el;
            if (margin < 0) {
                continue;
            }
            int index = lowerBound(list, margin);
            long temp = el + list[index];
            if (result < temp) {
                result = temp;
            }
        }

        System.out.println(result);
        scan.close();
    }

    public static int lowerBound(long[] array, long value) {
        int index = Arrays.binarySearch(array, value);
        if (index < 0) {
            index = - index - 1;
        } else {
            return index;
        }
        if (index < array.length) {
            if (index == 0) {
                return 0;
            }
            return index - 1;
        } else {
            return array.length-1;
        }
    }
}
