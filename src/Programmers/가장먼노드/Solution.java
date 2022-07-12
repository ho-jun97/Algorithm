package Programmers.가장먼노드;

import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] distance;
    static int max = Integer.MIN_VALUE;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n+1];
        distance = new int[n+1];
        visited = new boolean[n+1];
        // graph 초기화
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        // graph 연결
        for(int i=0; i<edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];

            graph[a].add(b);
            graph[b].add(a);
        }
        bfs(1);
        for(int i=1; i<=n; i++){ // 노드들의 길이를 반복문 돌면서 최대 길이가 같으면 answer+1
            if(max == distance[i]) answer++;
        }
        return answer;
    }
    // 각 노드들이 1로부터 떨어진 길이 구하기
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(Integer next : graph[now]){
                if(!visited[next]){
                    visited[next] = true;
                    distance[next] = distance[now]+1;
                    max = Math.max(max, distance[now]+1);
                    queue.add(next);
                }
            }
        }
    }
}
