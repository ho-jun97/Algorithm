package Programmers.모두0으로만들기;

import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static boolean[] visited;
    static long[] values;
    public long solution(int[] a, int[][] edges) {
        values = new long[a.length];
        indegree = new int[a.length]; // 차수 (리프 노드를 알기 위한 배열)
        visited = new boolean[a.length]; // 방문 체크
        for(int i=0; i<a.length; i++){ // 가중치 long 변환
            values[i] = a[i];
        }
        // 그래프 초기화
        graph = new ArrayList[a.length];
        for(int i=0; i<a.length; i++){
            graph[i] = new ArrayList<>();
        }
        // 그래프 연결
        for(int i=0; i<edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];

            graph[x].add(y);
            graph[y].add(x);

            indegree[x]++;
            indegree[y]++;
        }
        long answer = bfs();
        return answer;
    }
    public long bfs(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){ // 차수가 1이면 queue에 저장
            if(indegree[i]==1){
                queue.add(i);
            }
        }
        long count=0;
        while(!queue.isEmpty()){
            int now = queue.poll();
            visited[now] = true;

            for(Integer num : graph[now]){
                if(!visited[num]){
                    values[num] += values[now];
                    count += Math.abs(values[now]);
                    values[now] = 0;
                    indegree[num]--; // 차수 낮추기

                    if(indegree[num]==1){ // 차수 첫 번째이면 큐에 저장
                        queue.add(num);
                    }
                }
            }
        }
        for(int i=0; i<values.length; i++){
            if(values[i] !=0){ // 0이 하나라도 있으면 -1리턴
                return -1;
            }
        }
        return count;
    }
}
