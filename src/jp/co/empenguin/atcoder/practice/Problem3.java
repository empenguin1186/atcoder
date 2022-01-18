package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int result = 0;
        int current = 0;
        List<String> acgt = Arrays.asList("A", "C", "G", "T");
        for (int i = 0; i < input.length(); i++) {
            String str = input.substring(i, i+1);
            if (acgt.contains(str)) {
                current++;
            } else {
                if (current > result) {
                    result = current;
                }
                current = 0;
            }
        }
        if (current > result) {
            result = current;
        }
        System.out.println(result);
        scan.close();
    }
}
