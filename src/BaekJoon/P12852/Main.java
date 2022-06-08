package BaekJoon.P12852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/12852
 * [12852번: 1로 만들기 2]-Silver1
 */

public class Main {
    static int N;
    static Node[] dp;
    static class Node{
        int num;
        String proc;

        public Node(int num, String proc) {
            this.num = num;
            this.proc = proc;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Node[N+1];
        dp[1] = new Node(0, "1");
        for(int i=2; i<=N; i++) {
            int count = Integer.MAX_VALUE;
            int before = 0;
            if(i%3==0){
                count = dp[i/3].num;
                before = i/3;
            }
            if(i%2==0){
                if(count> dp[i/2].num) {
                    count = dp[i / 2].num;
                    before = i / 2;
                }
            }
            if(count>dp[i-1].num){
                count = dp[i-1].num;
                before = i-1;
            }

            dp[i] = new Node(dp[before].num+1, i + " " + dp[before].proc);
        }
        System.out.println(dp[N].num);
        System.out.println(dp[N].proc);
    }
}
