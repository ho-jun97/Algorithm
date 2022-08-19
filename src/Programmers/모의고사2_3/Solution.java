package Programmers.모의고사2_3;

import java.util.*;
class Solution {
    static ArrayList<Integer>[] graph;
    static int N;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        N = n;
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];

            graph[a].add(b);
            graph[b].add(a);
        }
        answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            answer[i] = bfs(sources[i], destination);
        }
        return answer;
    }
    static int bfs(int start, int destination){
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        queue.add(new Node(start, 0));
        visited[start] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.num == destination){
                return now.count;
            }
            for(Integer next : graph[now.num]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(new Node(next, now.count+1));
                }
            }
        }
        return -1;
    }
    static class Node{
        int num;
        int count;
        public Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
}


