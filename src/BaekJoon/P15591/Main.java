package BaekJoon.P15591;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15591
 * [15591번: MoonTube(Sliver)]-Gold5
 */

public class Main {
    static int N,Q;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            graph[p].add(new Node(q,r));
            graph[q].add(new Node(p,r));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            answer = 0;
            bfs(k,v);
            sb.append(answer).append('\n');
        }
        System.out.println(sb.toString());
    }
    static void bfs(int k, int v){
        visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();

            for(Node next : graph[now]){
                if(!visited[next.num] && next.value >= k){
                    visited[next.num] = true;
                    queue.add(next.num);
                    answer++;
                }
            }
        }

    }
    static class Node{
        int num;
        int value;

        public Node(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
}
