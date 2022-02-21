package jp.co.empenguin.atcoder.work20220220;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemD {

    public static class State {
        int current;
        int num;

        public State(int current, int num) {
            this.current = current;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }

        Map<Integer, State> record = new HashMap<>();
        int[] result = new int[N];

        int prev = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                record.put(i, new State(a[i], 1));
                result[i] = i+1;
                continue;
            }

            State prevState = record.get(prev);
            if (prevState.current != a[i]) {
                record.put(prev+1, new State(a[i], 1));
                prev = i;
                result[i] = i+1;
            } else {
                if (prevState.num == a[i] - 1) {
                    prev = prev + 1 - a[i];
                    result[i] = prev + 1;
                } else {
                    record.put(prev+1, new State(a[i], prevState.num+1));
                    prev = i;
                    result[i] = i+1;
                }
            }
        }
        for (int i : result) {
            System.out.println(i);
        }
        scan.close();
    }
}
