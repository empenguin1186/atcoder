package jp.co.empenguin.atcoder.work20220130;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String S = scan.next();
        char[] chars = S.toCharArray();
        boolean isYes = true;
        int length = chars.length;
        boolean isHead = true;
//        int tail = length;
//
//        while (tail > 0 && chars[tail-1] == 'a') {
//            tail--;
//        }
//        int numOfTailA = length - tail;
//        int head = 0;
//        while (head < length && chars[head] == 'a') {
//            head++;
//        }
//        int numOfHeadA = head;
//        int start = 0;
//        int end = length;
//        if (numOfHeadA < numOfTailA) {
//
//        }

//        while (index < length && !(index == tail - index - 1)) {
//            char c1 = chars[index];
//            char c2 = chars[tail - index - 1];
//            if (c1 == c2) {
//                isHead = false;
//                index++;
//            } else {
//                if (c2 == 'a' && isHead) {
//                    tail--;
//                } else {
//                    isYes = false;
//                    break;
//                }
//            }
//        }

        String result = isYes ? "Yes" : "No";
        System.out.println(result);
        scan.close();
    }
}
