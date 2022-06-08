package BaekJoon.P13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13305
 * [13305번: 주유소]-Silver4
 */

public class Main {
    static int N;
    static long[] cost;
    static long[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new long[N];
        distance = new long[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        long answer = 0;
        long minCost = cost[0];
        for(int i=0; i<N-1; i++){
            minCost = Math.min(minCost,cost[i]);

            answer += (minCost*distance[i]);
        }
        System.out.println(answer);
    }
}
