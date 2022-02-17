package jp.co.empenguin.atcoder.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem44 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        while(true) {
            int value = scan.nextInt();
            if (value == 0) {
                break;
            }
            list.add(value);
        }
        int max = Collections.max(list);

        int length = 10000;
        int[][] dp = new int[max][length];
        for (int el : list) {
            int n = 1;
            int temp = Integer.MAX_VALUE;
            while(n*(n+1)*(n+2)/6 < el) {
                int val = function(el, n, dp);
                if (temp > val) {
                    temp = val;
                }
                n++;
            }

            int m = 1;
            int temp2 = Integer.MAX_VALUE;
            while(m*(m+1)*(m+2)/6 < el) {
                int val = oddFunction(el, m, dp);
                if (temp2 > val) {
                    temp2 = val;
                }
                m += 2;
            }

            System.out.println(temp + " " + temp2);
        }

        scan.close();
    }

    public static int function(int a, int i, int[][] dp) {
        if (dp[a][i] != 0) {
            return dp[a][i];
        }
        if (a == 0) {
            dp[a][i] = 0;
            return 0;
        }

        if (i == 1) {
            dp[a][i] = a;
            return a;
        }

        int result = Integer.MAX_VALUE;
        for (int j = i; j > 0; j--) {
            int sub = j * (j+1) * (j+2) / 6;
            int temp = function(a-sub, j, dp) + 1;
            if (result > temp) {
                result = temp;
            }
        }

        dp[a][i] = result;
        return result;
    }

    public static int oddFunction(int a, int i, int[][] dp) {
        if (dp[a][i] != 0) {
            return dp[a][i];
        }
        if (a == 0) {
            dp[a][i] = 0;
            return 0;
        }

        if (i == 1) {
            dp[a][i] = a;
            return a;
        }

        int result = Integer.MAX_VALUE;
        for (int j = i; j > 0; j -= 2) {
            int sub = j * (j+1) * (j+2) / 6;
            int temp = function(a-sub, j, dp) + 1;
            if (result > temp) {
                result = temp;
            }
        }

        dp[a][i] = result;
        return result;
    }
}
