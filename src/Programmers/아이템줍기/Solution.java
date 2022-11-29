package Programmers.아이템줍기;

import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static int len = 102;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        // 1. 사각형 1로 채우기
        map = new int[len][len];
        visited = new boolean[len][len];
        for(int[] rec : rectangle){

            for(int x=rec[0]*2; x<=rec[2]*2; x++){
                for(int y=rec[1]*2; y<=rec[3]*2; y++){
                    map[y][x] = 1;
                }
            }
        }
        // 2. 사각형 내부  0으로 채우기
        for(int[] rec : rectangle){
            for(int x=rec[0]*2+1; x<=rec[2]*2-1; x++){
                for(int y=rec[1]*2+1; y<=rec[3]*2-1; y++){
                    map[y][x] = 0;
                }
            }
        }
        // 3. bfs 최단거리 구하기
        answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);

        return answer/2;
    }
    static int bfs(int startX, int startY, int endX, int endY){
        Queue<Node> queue = new LinkedList<>();
        visited[startY][startX] = true;
        queue.add(new Node(startX,startY,0));

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.x == endX && now.y == endY){
                return now.dis;
            }

            for(int i=0; i<4; i++){
                int px = now.x + dx[i];
                int py = now.y + dy[i];
                if(0<= px && px < len && 0 <= py && py < len){
                    if(!visited[py][px] && map[py][px] == 1){
                        visited[py][px] = true;
                        queue.add(new Node(px,py,now.dis+1));
                    }
                }
            }
        }
        return -1;
    }
    static class Node{
        int x,y,dis;
        public Node(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
