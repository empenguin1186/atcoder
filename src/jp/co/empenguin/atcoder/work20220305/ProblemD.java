package jp.co.empenguin.atcoder.work20220305;

import java.util.Scanner;

public class ProblemD {

    private static char[] CHARS;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String S = scan.next();
        int Q = scan.nextInt();
        CHARS = S.toCharArray();

        long[][] query = new long[Q][2];
        for (int i = 0; i < Q; i++) {
            query[i][0] = scan.nextLong();
            query[i][1] = scan.nextLong() - 1;
        }

        for (int i = 0; i < Q; i++) {
            System.out.println(detect(query[i][0], query[i][1]));
        }

        scan.close();
    }

    public static char detect(long t, long k) {
        if (t == 0) {
            return CHARS[(int) k];
        }

        if (k == 0) {
            return progress(CHARS[0], t);
        }

        return progress(detect(t-1, k/2), k%2+1);
    }

    public static char progress(char c, long t) {
        char result = (char) ('A' + (c - 'A' + t) % 3);
        return result;
    }
}
