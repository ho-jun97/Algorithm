package Programmers.미로탈출;

import java.util.*;

class Solution {
    static char[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int xLen, yLen, startX, startY, leverX, leverY;
    public int solution(String[] maps) {
        xLen = maps.length;
        yLen = maps[0].length();
        map = new char[xLen][yLen];
        for(int i=0; i<xLen; i++){
            for(int j=0; j<yLen; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S'){
                    startX = i;
                    startY = j;
                }
                if(map[i][j] == 'L'){
                    leverX = i;
                    leverY = j;
                }
            }
        }
        int a = exit(startX,startY, 'L');
        int b = exit(leverX, leverY, 'E');
        if(a == -1 || b == -1) return -1;
        return a + b;
    }
    static int exit(int x, int y, char target){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[xLen][yLen];
        
        queue.add(new Node(x,y,0));
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            Node pos = queue.poll();
            if(map[pos.x][pos.y]== target){
                return pos.dis;
            }
            
            for(int i=0; i<4; i++){
                int px = pos.x + dx[i];
                int py = pos.y + dy[i];
                
                if(0 <= px && px < xLen && 0 <= py && py < yLen){
                    if(!visited[px][py]){ 
                        visited[px][py] = true;
                        if(map[px][py] != 'X'){
                            queue.add(new Node(px,py,pos.dis+1));
                        }
                    }
                }
            }
        }
        return -1;
    }
    static class Node{
        int x;
        int y;
        int dis;
        
        public Node(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
