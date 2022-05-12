package BaekJoon.P1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1520
 * [1520번: 내리막 길]-Gold4
 */

public class Main {
    static int N,M;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M+1][N+1];
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M+1][N+1];
        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                dp[i][j] = -1;
            }
        }

        int answer = dfs(1,1);
        System.out.println(answer);
    }
    static int dfs(int x, int y) {
        if (x == M && y == N) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = 0; // 0으로 초기화
        for (int i = 0; i < 4; i++) {
            int px = x + mx[i];
            int py = y + my[i];
            if (px > 0 && py > 0 && px <= M && py <= N) {
                if (map[x][y] > map[px][py]) { // 내리막길일 때
                    dp[x][y] += dfs(px, py);
                }
            }
        }
        return dp[x][y];
    }
}
