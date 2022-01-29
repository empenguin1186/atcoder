package jp.co.empenguin.atcoder.work20220129;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

    public static class Area {
        public Area(long start, long end) {
            this.start = start;
            this.end = end;
        }

        private long start;
        private long end;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = scan.nextInt();
        final long L = scan.nextLong();
        final long W = scan.nextLong();
        long[] a = new long[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextLong();
        }

        List<Area> areas = new ArrayList<>();
        areas.add(new Area(0, 0));
        long start = a[0];
        long end = a[0] + W;
        if (N != 1) {
            for (int i = 1; i < N; i++) {
                if (end < a[i]) {
                    areas.add(new Area(start, end));
                    start = a[i];
                }
                end = a[i] + W;
                if (i == N-1) {
                    areas.add(new Area(start, end));
                }
            }
        } else {
            areas.add(new Area(start, end));
        }
        areas.add(new Area(L, L));

        long result = 0;
        for (int i = 0; i < areas.size()-1; i++) {
            long x1 = areas.get(i).end;
            long x2 = areas.get(i+1).start;
            result += ((x2 - x1) / W);
            if ((x2 - x1) % W != 0) {
                result += 1;
            }
        }
        System.out.println(result);
        scan.close();
    }
}
