package jp.co.empenguin.atcoder.work20220130;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String S = scan.next();
        char[] chars = S.toCharArray();
        int n = chars.length;

        int x = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != 'a') {
                break;
            }
            x++;
        }

        int y = 0;
        for (int i = n-1; i >=0; i--) {
            if (chars[i] != 'a') {
                break;
            }
            y++;
        }

        if (x > y) {
            System.out.println("No");
        } else {
            if (x + y >= n) {
                System.out.println("Yes");
            } else {
                boolean isYes = true;
                for (int i = 0; i < n - y - x; i++) {
                    isYes &= chars[x+i] == chars[n-y-1-i];
                }
                System.out.println(isYes ? "Yes" : "No");
            }
        }
        scan.close();
    }
}
