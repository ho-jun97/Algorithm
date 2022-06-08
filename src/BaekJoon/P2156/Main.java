package BaekJoon.P2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2156
 * [2156번: 포도주 시식]-Silver1
 */

public class Main {
    static int N;
    static int[] wine;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        wine = new int[N+1];
        dp = new int[N+1];

        for(int i=1; i<=N; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = wine[1];
        if(N>1){
            dp[2] = dp[1]+wine[2];
        }

        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+wine[i], dp[i-3]+wine[i-1]+ wine[i]));
        }
        System.out.println(dp[N]);
    }
}
