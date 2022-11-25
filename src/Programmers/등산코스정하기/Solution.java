package Programmers.등산코스정하기;

import java.util.*;
class Solution {

    static ArrayList<Node>[] graph;
    static int INF = Integer.MAX_VALUE;
    static int[] intensity;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList[n+1];
        intensity = new int[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
            intensity[i] = INF;
        }

        for(int i=0; i<paths.length; i++){
            int from = paths[i][0];
            int to = paths[i][1];
            int value = paths[i][2];

            if(isGate(from, gates) || isSummit(to,summits)){
                graph[from].add(new Node(to,value));
            }else if(isGate(to, gates) || isSummit(from,summits)){
                graph[to].add(new Node(from,value));
            }else{
                graph[from].add(new Node(to,value));
                graph[to].add(new Node(from,value));
            }
        }

        dijkstra(gates, summits);


        int min= Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for(int summit : summits){
            if(intensity[summit] < minValue){
                min = summit;
                minValue = intensity[summit];
            }
        }
        return new int[]{min,minValue};
    }
    // 다익스트라
    public void dijkstra(int[] gates, int[] summits){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.intensity,o2.intensity));

        for(int i=0; i<gates.length; i++){
            pq.add(new Node(gates[i],0));
            intensity[gates[i]] = 0;
        }

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.intensity > intensity[now.num]) continue;

            for(Node next: graph[now.num]){
                int dis = Math.max(intensity[now.num], next.intensity);
                if(intensity[next.num] > dis){
                    intensity[next.num] = dis;
                    pq.add(new Node(next.num, dis));
                }
            }
        }
    }
    //  입구인지 확인
    static boolean isGate(int num, int[] arr){
        for(int i : arr){
            if(num ==  i) return true;
        }
        return false;
    }
    // 정상인지 확인
    static boolean isSummit(int num, int[] arr){
        for(int i : arr){
            if(num ==  i) return true;
        }
        return false;
    }
    static class Node{
        int num;
        int intensity;
        public Node(int num, int intensity){
            this.num = num;
            this.intensity = intensity;
        }
    }
}
