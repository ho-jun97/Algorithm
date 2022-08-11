package Programmers.합승택시요금;

import java.util.*;
class Solution {
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n+1];

        // 그래프 초기화
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        // 그래프 연결
        for(int i=0; i<fares.length; i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int value = fares[i][2];

            graph[from].add(new Node(to, value));
            graph[to].add(new Node(from, value));
        }
        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] startS = new int[n+1];

        Arrays.fill(startA,INF);
        Arrays.fill(startB,INF);
        Arrays.fill(startS,INF);

        startA = shortPath(a, startA);
        startB = shortPath(b, startB);
        startS = shortPath(s, startS);
        int answer = INF;
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, startA[i] + startB[i] +startS[i]);
        }

        return answer;
    }
    static int[] shortPath(int start, int[] distance){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                return Integer.compare(n1.dis, n2.dis);
            }
        });
        distance[start] = 0;
        pq.add(new Node(start, 0));

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
        return distance;
    }
    static class Node{
        int num;
        int dis;
        public Node(int num, int dis){
            this.num = num;
            this.dis = dis;
        }
        public String toString(){
            return "["+num+", "+dis+"]";
        }
    }
}