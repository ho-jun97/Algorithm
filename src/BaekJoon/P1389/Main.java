package BaekJoon.P1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1389
 * [1389번: 케빈 베이컨의 6단계 법칙]-Sliver1
 */

public class Main {
    static int N,M;
    static int[][] dis;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dis = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i!=j){
                    dis[i][j] = INF;
                }
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dis[a][b] = dis[b][a] = 1;
        }
        //플로이드 와샬 알고리즘
        for(int k=1; k<=N; k++){ // 중간 다리
            for(int i=1; i<=N; i++){ // 처음
                for(int j=1; j<=N; j++){ // 끝
                    dis[i][j] = Math.min(dis[i][k]+dis[k][j], dis[i][j]);
                }
            }
        }
        int min = INF;
        int ans=0;
        for(int i=1; i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++){
                sum += dis[i][j];
            }
            if(sum < min){
                min = sum;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}