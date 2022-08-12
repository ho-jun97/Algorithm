package Programmers.배달;

import java.util.*;
class Solution {
    // 다익스트라
    static int INF = (2000*500000)+1;
    static ArrayList<Node>[] graph;
    static int[] distance;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new ArrayList[N+1];
        distance = new int[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
            distance[i] = INF;
        }

        for(int i=0; i<road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int value = road[i][2];

            graph[from].add(new Node(to, value));
            graph[to].add(new Node(from, value));
        }
        dijkstra(1);
        for(int i=1; i<=N; i++){
            System.out.println(i+" : " + distance[i]);
            if(distance[i] <= K){
                answer++;
            }
        }
        return answer;
    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.dis, o2.dis));
        pq.add(new Node(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.dis > distance[now.num]) continue;

            for(Node next : graph[now.num]){
                if(distance[next.num] > distance[now.num] + next.dis){
                    distance[next.num] = distance[now.num] + next.dis;
                    pq.add(new Node(next.num, distance[next.num]));
                }
            }
        }
    }
    static class Node{
        int num;
        int dis;
        public Node(int num, int dis){
            this.num = num;
            this.dis = dis;
        }
    }
/* 플로이드 와샬
    static int INF = (2000*500000)+1;
    static int[][] graph;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(graph[i],INF);
            graph[i][i] = 0;
        }
        for(int i=0; i<road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int value = road[i][2];

            graph[from][to] = Math.min(graph[from][to],value);
            graph[to][from] = Math.min(graph[to][from],value);
        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        for(int i=1; i<=N; i++){
            System.out.println(i+ "번까지 거리 : " + graph[1][i]);
            if(graph[1][i] <=K){
                answer++;
            }
        }
        return answer;
    }

 */
}