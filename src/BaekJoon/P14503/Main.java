package BaekJoon.P14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14503
 * [14503번: 로봇 청소기]-Gold5
 */

public class Main {
    static int N,M;
    static int[][] map;
    // 북, 동, 남, 서
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] clean;
    static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int robotX = Integer.parseInt(st.nextToken());
        int robotY = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        clean = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(robotX,robotY,dir);
        System.out.println(answer);
    }
    static void dfs(int x, int y, int dir){
        clean[x][y] = true;

        for(int i=0; i<4; i++){
            // 2. 방향 바꾸기
            dir = dir==0?3:dir-1;
            int px = x + dx[dir];
            int py = y + dy[dir];
            if(px>=0 && py>=0 && px<N && py<M) {
                if (!clean[px][py] && map[px][py] == 0) { // 청소하지 않고 별이 아닐 때
                    answer++;
                    dfs(px,py,dir);
                    return;
                }
            }
        }
        // 방향의 뒤쪽 확인
        int robotX = x + dx[dir]*-1;
        int robotY = y + dy[dir]*-1;
        if (robotX >= 0 && robotY >= 0  && robotX < N  && robotY < M){
            if(map[robotX][robotY] != 1) { // 뒤에 벽이면
                dfs(robotX, robotY, dir);
            }
        }
    }
}
