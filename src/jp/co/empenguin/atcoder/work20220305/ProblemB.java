package jp.co.empenguin.atcoder.work20220305;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String S = scan.next();
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        for (char c : chars) {
            System.out.print(c);
        }
        System.out.println("");
        scan.close();
    }
}
