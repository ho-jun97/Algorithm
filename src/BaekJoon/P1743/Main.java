package BaekJoon.P1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1743
 * [1743번: 음식물 피하기]-Silver1
 */

public class Main {
    static char[][] map;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int N,M,K;
    static int ans = Integer.MIN_VALUE;
    static int count;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = '#';
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(!visited[i][j] && map[i][j]=='#'){
                    visited[i][j] = true;
                    count = 1;
                    dfs(i,j);
                    ans = Math.max(ans,count);
                }
            }
        }
        System.out.println(ans);
    }
    static void dfs(int x, int y){
        for(int i=0; i<4; i++) {
            int px = x + mx[i];
            int py = y + my[i];
            if (px > 0 && py > 0 && px <= N && py <= M) {
                if(!visited[px][py] && map[px][py]=='#'){
                    visited[px][py] = true;
                    count++;
                    dfs(px,py);


                }
            }
        }
    }
}
