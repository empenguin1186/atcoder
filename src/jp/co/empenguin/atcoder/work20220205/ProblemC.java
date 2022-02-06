package jp.co.empenguin.atcoder.work20220205;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextLong();
        double log = Math.log10(N);
        int n = (int) Math.floor(log);
        BigDecimal result = new BigDecimal(0);
        for (int i = 0; i < n; i++) {
            long start = (long) Math.pow(10, i);
            long end = (long) Math.pow(10, i+1) - 1;
            BigDecimal x = new BigDecimal(end - start + 1);
            BigDecimal y = new BigDecimal(end - start + 2);
            BigDecimal temp = x.multiply(y).divide(new BigDecimal(2));
            result = result.add(temp);
        }
        long start = (long) Math.pow(10, n);
        BigDecimal x = new BigDecimal(N - start + 1);
        BigDecimal y = new BigDecimal(N - start + 2);
        BigDecimal z = x.multiply(y).divide(new BigDecimal(2));
        System.out.println(result.add(z).remainder(new BigDecimal(998244353)).toString());
        scan.close();
    }
}
