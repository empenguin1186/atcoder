package jp.co.empenguin.atcoder.practice;

import java.util.Scanner;

public class Problem6_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();

        String[][] result = getSplitValue(101);

        int count = 0;
        for (int i = 0; i < 1000; i++) {
            String[] number;
            if (i < 10) {
                number = new String[]{"0", "0", String.valueOf(i)};
            } else if (i < 100) {
                String[] temp = String.valueOf(i).split("");
                number = new String[]{"0", temp[0], temp[1]};
            } else {
                number = String.valueOf(i).split("");
            }

            int first = s.indexOf(number[0]);
            if (first == -1) {
                continue;
            }
            int second = s.indexOf(number[1], first+1);
            if (second == -1){
                continue;
            }
            int third = s.indexOf(number[2], second+1);
            if (third == -1) {
                continue;
            }
            count++;
        }
        System.out.println(count);
        scan.close();
    }

    /**
     * 0 ~ input までの数字を一文字ずつ文字列の配列として返す関数
     * @param input 最大値
     * @return 分割された文字配列の配列。桁が足りない場合は先頭から0で補う
     */
    private static String[][] getSplitValue(int input) {
        int keta = (int) Math.log10(input);
        String[][] result = new String[input][keta + 1];

        for (int i = 0; i < input; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            if (keta + 1 > len) {
                int diff = keta + 1 - len;
                for (int j = 0; j < diff; j++) {
                    result[i][j] = "0";
                }
                for (int j = diff; j < keta + 1; j++) {
                    result[i][j] = str.split("")[j-diff];
                }
            }
        }
        return result;
    }
}
