package BaekJoon.P11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11724
 * [11724번: 연결 요소의 개수]-Sliver2
 */

public class Main {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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
        int count = 0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(Integer i : graph[now]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    static void dfs(int i){
        if(visited[i]){
            return;
        }else{
            visited[i] = true;
            for(Integer num : graph[i]){
                dfs(num);
            }
        }
    }
}
