package BaekJoon.P13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13023
 * [13023번: ABCDE]-Gold5
 */

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean found;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++){
            dfs(i,1, visited);
            if(found) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }
    static void dfs(int n, int depth, boolean[] visited){
        if(depth == 5){
            found = true;
            return;
        }
        visited[n] = true; // 방문처리
        for(Integer i : graph[n]){
            if(!visited[i]) {
                dfs(i, depth + 1, visited);
            }
        }
        visited[n] = false;
    }
}
