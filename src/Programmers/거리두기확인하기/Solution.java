package Programmers.거리두기확인하기;

import javax.swing.text.Position;
import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M;
    static boolean[][] visited;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        N = places[0].length;
        M = places[0][0].length();
        for(int i=0; i<places.length; i++){
            visited = new boolean[N][M];
            boolean check = true;
            aaa: for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(!visited[j][k] && places[i][j].charAt(k) == 'P'){
                        visited[j][k] = true;
                        check = bfs(i,j,k,visited,places[i]);
                        if(!check) break aaa;
                    }
                }
            }
            answer[i] = check?1:0;
        }
        return answer;
    }
    static boolean bfs(int n, int x, int y, boolean[][] visited, String[] map){
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x,y,0));

        while(!queue.isEmpty()){
            Position now = queue.poll();

            for(int i=0; i<4; i++){
                int px = now.x + dx[i];
                int py = now.y + dy[i];
                if(0 <= px && px < N && 0 <= py && py < M){ // 범위 안에 있을 때
                    if(!visited[px][py]){
                        if(map[px].charAt(py) == 'O') {
                            queue.add(new Position(px, py, now.count + 1));
                        }
                        if(map[px].charAt(py) == 'P'){
                            if(now.count+1 <= 2) return false; // P이면서 P와 P의 사이가 2 이하이면 false
                            queue.add(new Position(px,py,0)); // P가 여러개 일수 있으므로 0으로 queue에 넣기
                        }
                        visited[px][py] = true;
                    }
                }
            }
        }
        return true;
    }
    static class Position{
        int x, y, count;
        public Position(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
