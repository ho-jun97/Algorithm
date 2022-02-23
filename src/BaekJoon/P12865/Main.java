package BaekJoon.P12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12865
 * [12865번: 평범한 배낭]-Gold5
 */

public class Main {
    static int N,K;
    static int[] W;
    static int[] V;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N+1];
        V = new int[N+1];
        dp = new int[N+1][K+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            W[i] = w;
            V[i] = v;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                dp[i][j] = dp[i-1][j]; // 이전 가치를 저장
                if(j-W[i] >=0){ // 해당 무게에서 자신의 무게를 뺐을 때 무게가 남아있거나 0일 때
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]); // 이전 가치 vs (남은 무게의 가치 + 자신의 가치) 큰거 선택
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
