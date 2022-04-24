package BaekJoon.P11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11052
 * [11052번: 카드 구매하기]-Sliver1
 */

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(str[i-1]);
        }
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = arr[1];
        for(int i=2; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i],dp[i-j]+arr[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
