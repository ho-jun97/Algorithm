package Programmers.전력망을둘로나누기;

import java.util.*;
class Solution {
    static List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new ArrayList[n+1];
        // 배열 초기화
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        // 그래프 구현
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            graph[a].add(b);
            graph[b].add(a);
        }
        // 탐색하면서 1개씩 끊기
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            // 연결 끊기
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));

            answer = Math.min(answer, Math.abs(bfs(n,a) * 2 - n));

            // 다시 연결
            graph[a].add(b);
            graph[b].add(a);
        }
        return answer;
    }
    static int bfs(int n, int a){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(a);
        visited[a] = true;
        int count = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(Integer num : graph[now]){
                if(!visited[num]){
                    visited[num] = true;
                    queue.add(num);
                    count++;
                }
            }
        }
        return count;
    }
}