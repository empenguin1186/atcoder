package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Problem19 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int d = scan.nextInt();
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] ds = new int[n+1];
        
        ds[0] = 0;
        for (int i = 1; i < n; i++) {
            ds[i] = scan.nextInt();
        }
        ds[n] = d;
        Arrays.sort(ds);
        
        int[] k = new int[m];
        for (int i = 0; i < m; i++) {
            k[i] = scan.nextInt();
        }
        
        int result = 0;
        for (int i = 0; i < m; i++) {
            int num = k[i];
            int distance = binarySearch(0, n, ds, num);
            result += distance;
        }

        System.out.println(result);
        scan.close();
    }

    private static int binarySearch(int left, int right, int[] array, int point) {
        if (right - left < 2) {
            return Math.min(Math.abs(point-array[right]), Math.abs(point-array[left]));
        }
        int index = (left + right) / 2;
        if (array[index] < point) {
            return binarySearch(index, right, array, point);
        } else {
            return binarySearch(left, index, array, point);
        }
    }
}
