package BaekJoon.P3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3109
 * [3109번: 빵집]-Gold2
 */

public class Main {
    static int R,C;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R+1][C+1];
        visited = new boolean[R+1][C+1];

        for(int i = 1; i <= R; i++){
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = str.charAt(j-1);
            }
        }
        int count=0;
        for(int i=1; i<=R; i++){
            if(dfs(i,1)){
                count++;
            }
        }
        System.out.println(count);
    }
    static boolean dfs(int x, int y){
        if(y==C) return true;
        for(int i=0; i<3; i++){
            int px = x+dx[i];
            int py = y+dy[i];

            if(px>0 && py>0 && px<=R && py<=C){ // 영역 안에 있을 때
                if(!visited[px][py] && map[px][py]=='.'){
                    visited[px][py] = true;
                    if(dfs(px,py)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
