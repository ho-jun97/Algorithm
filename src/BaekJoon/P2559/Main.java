package BaekJoon.P2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2559
 * [2559번: 수열]-Silver3
 */

public class Main {
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i-1] + arr[i];
        }
        int answer = dp[K];
        for(int i=K; i<=N; i++){
            answer = Math.max(answer, dp[i]-dp[i-K]);
        }
        System.out.println(answer);
    }
}
