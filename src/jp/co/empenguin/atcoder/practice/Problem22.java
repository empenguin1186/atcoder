package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class Problem22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final double P = scan.nextDouble();
        double low = 0;
        double high = P;
        double x = ternarySearch(low, high, e -> mua(e, P));
        System.out.println(mua(x, P));
        scan.close();
    }

    public static double mua(double x, double p) {
        return x + (p / Math.pow(2, x / 1.5));
    }

    public static double ternarySearch(double low, double high, DoubleUnaryOperator operator) {
        for (int i = 0; i < 500; i++) {
            double left = (2 * low + 1 * high) / 3;
            double right = (1 * low + 2 * high) / 3;
            double leftVal = operator.applyAsDouble(left);
            double rightVal = operator.applyAsDouble(right);
            if (leftVal < rightVal) {
                high = right;
            } else {
                low = left;
            }
        }
        return low;
    }
}
