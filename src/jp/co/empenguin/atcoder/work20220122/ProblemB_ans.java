package jp.co.empenguin.atcoder.work20220122;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProblemB_ans {
    public static void main(String[] args) {

//        number(1000);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] P = new int[n];
        int[] Q = new int[n];

        for(int i = 0; i < n; i++) P[i] = sc.nextInt();
        for(int i = 0; i < n; i++) Q[i] = sc.nextInt();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = Q[0] % P[i] == 0 ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = Q[i] % P[0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Q[i] % P[j] == 0 ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[n - 1][n - 1]);

//        int[] index = new int[n + 1];
//
//        for(int i = 0; i < n; i++) index[Q[i]] = i;
//
//        // pi が割り切れる q の値を洗い出す
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i < n; i++){
//            int x = P[i];
//            List<Integer> list2 = new ArrayList<>();
//            while (x <= n){
//                list2.add(index[x]);
//                x += P[i];
//            }
//            list2.sort(Comparator.reverseOrder());
//            list.addAll(list2);
//        }
//
//        int size = list.size();
//        int[] a = new int[size];
//
//        int index2 = 0;
//        for(int val: list){
//            a[index2++] = val;
//        }
//
//        var l = new int[size];
//        l[0] = a[0];
//        int length = 1;
//
//        for(int i = 1; i < size; i++){
//            if(l[length - 1] < a[i]){
//                l[length++] = a[i];
//            }else{
//                l[lowerBound(l, length, a[i])] = a[i];
//            }
//        }
//        System.out.println(length);

    }

    private static void number(int n) {
        int[] p = new int[n];
        int[] q = new int[n];
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            p[i] = (int) (Math.random()*n) % n + 1;
            q[i] = (int) (Math.random()*n) % n + 1;
        }
        for (int i = 0; i < n-1; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println(p[n-1]);
        for (int i = 0; i < n-1; i++) {
            System.out.print(q[i] + " ");
        }
        System.out.println(q[n-1]);
    }

    static int lowerBound(int[] a, int right, int key){
        int left = -1;
        while(right - left > 1){
            int mid = left + (right - left) / 2;
            if(a[mid] >= key){
                right = mid;
            }else{
                left = mid;
            }
        }
        return right;
    }
}
