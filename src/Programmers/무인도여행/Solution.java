package Programmers.무인도여행;

import java.util.*;
class Solution {
    static char[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int N,M;
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        visited = new boolean[N][M];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                map[i][j] = maps[i].charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // X가 아니고 방문하지 않으면 bfs 돌기
                if(!visited[i][j] && map[i][j] != 'X'){
                    // 값 저장
                    list.add(bfs(i,j));
                }
            }
        }
        // size 0이면 섬이 없음
        if(list.size()==0) return new int[]{-1};
        return list.stream().sorted().mapToInt(i->i).toArray();
    }
    static int bfs(int x, int y){
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{x,y});
        visited[x][y] = true;
        int ans = 0;
        while(!qu.isEmpty()){
            int[] now = qu.poll();
            ans += map[now[0]][now[1]]-'0';
            for(int i=0; i<4; i++){
                int px = now[0] + dx[i];
                int py = now[1] + dy[i];

                if(0 <= px && px < N && 0 <= py && py < M){
                    if(!visited[px][py] && map[px][py] != 'X'){
                        visited[px][py] = true;
                        qu.add(new int[]{px,py});
                    }
                }
            }
        }
        return ans;
    }
}