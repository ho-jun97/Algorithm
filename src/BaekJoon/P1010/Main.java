package BaekJoon.P1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1010
 * [1010번: 다리 놓기]-Sliver5
 */

public class Main {
    static int T;
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // M개중에 N개 뽑는다 -> nCr( n=M, r=N)
            int answer = combination(M,N);
            System.out.println(answer);
        }
    }
    static int combination(int n, int r){
        if(dp[n][r]>0){ // 이미 탐색한 경우
            return dp[n][r];
        }
        if(n==r || r==0){ // 조합 성질(nC0 = nCn = 1)
            return dp[n][r]=1;
        }
        // 조합 성질 = (n+1Cr+1 = nCr + nCr+1) -> (nCr = n-1Cr-1 + n-1Cr)
        return dp[n][r] = combination(n-1,r-1) + combination(n-1,r);
    }
}
