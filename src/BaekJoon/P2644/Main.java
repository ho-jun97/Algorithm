package BaekJoon.P2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2644
 * [2644번: 촌수계산]-Silver2
 */

public class Main {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        answer = -1;
        dfs(from,to, 0);
        System.out.println(answer);
    }

    static void dfs(int from, int to, int count){
        if(from==to){
            answer = count;
            return;
        }
        visited[from] = true;
        for(Integer i : graph[from]){
            if(!visited[i]){
                dfs(i,to,count+1);
            }
        }
    }
}

