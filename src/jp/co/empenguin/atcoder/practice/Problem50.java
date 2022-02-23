package jp.co.empenguin.atcoder.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Problem50 {
    public static long[][] dist;
    public static long[][] time;
    public static State[][] dp;
    public static int N;

    public static class State {
        private long dist;
        private int count;

        public State(long dist, int count) {
            this.dist = dist;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        int M = scan.nextInt();

        dist = initIntegerArray(N, N, -1);
        time = new long[N][N];
        for (int i = 0; i < M; i++) {
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            dist[a][b] = dist[b][a] = scan.nextLong();
            time[a][b] = time[b][a] = scan.nextLong();
        }

        for (int i = 0; i < N; i++) {
            dist[i][i] = 0;
        }

        /** dp[S][i]: 現在どの建物に訪問済(集合Sで表現)で現在地点がiの時の最短距離と最短ルートの総数 */
        dp = new State[1 << N][N];
        for (int i = 0; i < 1 << N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = new State(-1, 0);
            }
        }
        dp[0][0] = new State(0, 1);

        for (int s = 0; s < 1 << N; s++) {
            for (int i = 0; i < N; i++) {
                // 仮定より i は 集合 S に属している必要がある
                if (s != 0 && (s & 1 << i) == 0) {
                    continue;
                }

                for (int j = 0; j < N; j++) {
                    // 仮定より j は集合 S に属していない必要がある
                    if ((s & 1 << j) != 0) {
                        continue;
                    }

                    // dp[s][i] が計算できない状況(時間ぎれ、もしくは道路が存在しない)はスキップ
                    if (dp[s][i].dist == -1 || dist[i][j] == -1) {
                        continue;
                    }

                    // 次に訪問する建物についてのdpを計算する
                    long nextDist = dp[s][i].dist + dist[i][j];

                    // 時間ぎれの場合はスキップ
                    if (nextDist > time[i][j]) {
                        continue;
                    }

                    int ns = s|1<<j;
                    if (dp[ns][j].dist == -1 || dp[ns][j].dist > nextDist) {
                        dp[ns][j] = new State(nextDist, dp[s][i].count);
                    } else if (dp[ns][j].dist == nextDist) {
                        // 現状の最小値と一致していたらその分加算する.
                        // これは s の値がループごとにユニークであることから、考慮するルートはそれぞれ異なり重複が起きないため単純に加算することでdpの値を算出できるためである。
                        // ここの分岐は i (sに含まれている) の総数だけ入る可能性がある.
                        dp[ns][j] = new State(nextDist, dp[s][i].count + dp[ns][j].count);
                    }
                }
            }
        }

        if (dp[(1 << N)-1][0].dist == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(dp[(1 << N) - 1][0].dist + " " + dp[(1 << N) - 1][0].count);
        }

        scan.close();
    }

    public static long[][] initIntegerArray(int row, int col, long val) {
        long[][] array = new long[row][col];
        for (int i = 0; i < row; i++) {
            long[] cols = new long[col];
            Arrays.fill(cols, val);
            array[i] = cols;
        }
        return array;
    }
}
