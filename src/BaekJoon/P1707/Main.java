package BaekJoon.P1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1707
 * [1707번: 이분 그래프]-Gold4
 */

public class Main {
    static int T;
    static int RED = 1;
    static int BLUE = -1;
    static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점의 개수
            int E = Integer.parseInt(st.nextToken()); // 간선의 개수
            ArrayList<Integer>[] graph = new ArrayList[V+1];
            for(int j=1; j<=V; j++){
                graph[j] = new ArrayList<>();
            }
            for(int j=0; j<E; j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            int[] visited = new int[V+1];
            ans = "YES";
            for(int j=1; j<=V; j++) {
                if(visited[j]==0) {
                    if(check(j,graph, visited)) break;
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb.toString());
    }
    static boolean check(int n, ArrayList<Integer>[] graph, int[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = RED;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Integer node : graph[now]){
                if(visited[node]==visited[now]){
                    ans = "NO";
                    return true;
                }
                if(visited[node]==0){
                    visited[node]=(visited[now]==RED)?BLUE:RED;
                    queue.add(node);
                }
            }
        }
        return false;
    }
}
