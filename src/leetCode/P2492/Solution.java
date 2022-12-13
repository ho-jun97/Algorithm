package leetCode.P2492;

import java.util.*;
class Solution {
    static List<Node>[] graph;
    static int min;
    static boolean[] visited;
    public int minScore(int n, int[][] roads) {
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] road : roads){
            int a = road[0];
            int b = road[1];
            int v = road[2];

            graph[a].add(new Node(b,v));
            graph[b].add(new Node(a,v));
        }
        dfs(1);
        return min;
    }
    static void dfs(int num){

        visited[num] = true;

        for(Node next : graph[num]){
            min = Math.min(min, next.value);

            if(!visited[next.num]){
                dfs(next.num);
            }
        }
    }
    static class Node{
        int num,value;
        public Node(int num, int value){
            this.num = num;
            this.value = value;
        }
    }
}
