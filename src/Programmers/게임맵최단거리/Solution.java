package Programmers.게임맵최단거리;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/1844
 * 게임 맵 최단거리(Lv.2)
 */

class Solution {
    static int[] mx = {0,1,0,-1};
    static int[] my = {1,0,-1,0};
    static boolean[][] visit; // 방문 체크
    static int n,m;
    public static class Node{ // 해당 칸 노드 클래스로 표현
        int x;
        int y;
        int dis;
        public Node(int x, int y , int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public static int BFS(int x, int y, int[][] maps){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y,1)); // 시작 큐에 저장
        visit[x][y] = true; // 방문처리

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.x == n-1 && node.y == m - 1){ // 제일 마지막 도착했을 경우
                return node.dis;
            }
            for(int i=0; i<4; i++){
                int px = node.x + mx[i];
                int py = node.y + my[i];
                if(px >= 0 && py >=0 && px<n && py<m){ // map 경계 안에 있을 경우
                    if(maps[px][py]==1 && !visit[px][py]){ // 1(흰색부분) 이면서 방문하지 않은 칸
                        visit[px][py] = true; //방문 처리리
                        queue.offer(new Node(px,py,node.dis+1));
                    }
                }
            }
        }
        return -1;
    }
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        visit = new boolean[n][m];
        return BFS(0,0,maps);
    }
}
