package BaekJoon.P2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2579
 * [2579번: 계단 오르기]-Silver3
 */

public class Main {
    static int N;
    static int[] list;
    static int[] Dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Dp = new int[N+1];
        list = new int[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Dp[1] = list[1];
        if(N>1){
            Dp[2] = list[1] + list[2];
        }
        for (int i = 3; i <= N; i++) {
            Dp[i] = Math.max(Dp[i-2], Dp[i-3]+list[i-1]) + list[i];
        }
        System.out.println(Dp[N]);

    }
}
