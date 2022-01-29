package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem16 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = scan.nextInt();
        final int[] P = new int[N];
        final int[] Q = new int[N];
        final int[] indexArray = IntStream.range(1, N+1).toArray();

        for (int i = 0; i < N; i++) {
            P[i] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            Q[i] = scan.nextInt();
        }

        int count = 0;
        int a = 0;
        int b = 0;
        do {
            if (a != 0 && b != 0) {
                break;
            }
            count++;
            a = Arrays.equals(P, indexArray) ? count : a;
            b = Arrays.equals(Q, indexArray) ? count : b;
        } while (nextPermutation(indexArray));

        System.out.println(Math.abs(a - b));

        scan.close();
    }

    /**
     * 順列全探索の組み合わせを列挙する関数
     * @param array 対象の配列(一番最初に呼ばれる際には昇順にソート済であること)
     * @return 次の組み合わせが存在するかどうか
     */
    public static boolean nextPermutation(int[] array) {

        int end = array.length;

        for(int i = end-2; i >= 0; i--) {
            // array[i] < array[i+1] となる最大の i を特定. i+1 以降は降順に並んでいることになる.
            if(array[i] < array[i+1]) {

                // 末尾から array[i] < array[j] となる j を特定し、array[i] と array[j] を入れ替える
                // i+1 以降は降順で並んでいることから array[j-1] <= array[i] < array[j] < array[j-1], array[j-2], ...となり、
                // array[j] は array[i] より大きいかつ array[i] との差分が最小となる.
                // これにより辞書順的に現在の配列の並びの次にくるパターンを導出することができる.
                int j = end - 1;
                while(array[i] >= array[j]) {
                    j--;
                }
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;

                // なるべく辞書順的に上位に来るように、i+1 以降は昇順にソートする
                Arrays.sort(array, i+1, end);

                return true;
            }
        }

        return false;
    }
}
