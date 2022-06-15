package BaekJoon.P17199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17199
 * [17199번: Milk Factory]-Silver1
 */

public class Main {
    static int N;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];

        StringTokenizer st;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(graph[i][k]==1 && graph[k][j]==1){
                        graph[i][j] = 1;
                    }
                }
            }
        }
        int answer = -1;
        for(int i=1; i<=N; i++){
            int count = 0;
            for(int j=1; j<=N; j++){
                if(graph[j][i]==1){
                    count++;
                }
            }
            if(count == N-1){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
