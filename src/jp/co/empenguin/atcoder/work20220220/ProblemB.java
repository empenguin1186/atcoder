package jp.co.empenguin.atcoder.work20220220;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < N; i++) {
            a.add(scan.nextInt());
        }
        System.out.println(a.size());
        scan.close();
    }
}
