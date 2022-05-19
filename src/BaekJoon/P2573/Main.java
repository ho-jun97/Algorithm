package BaekJoon.P2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2573
 * [2573번: 빙산]-Gold4
 */

public class Main {
    static int N,M;
    static int[][] map;
    static int[][] temp;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer =0;
        while(true) {
            int cnt = 0;
            boolean[][] visited = new boolean[N+1][M+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (!visited[i][j] && map[i][j] > 0) {
                        bfs(i, j, visited);
                        cnt++;
                    }
                }
            }
            if (cnt >= 2) {
                break;
            }
            if(cnt==0){
                answer = 0;
                break;
            }
            answer++;
            changeMap();
        }
        System.out.println(answer);
    }
    static void changeMap(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                map[i][j] = temp[i][j];
            }
        }
    }
    static void bfs(int x, int y, boolean[][] visited){
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(x,y));
        visited[x][y] = true;
        temp = new int[N+1][M+1];
        while(!qu.isEmpty()){
            Node now = qu.poll();
            int count = 0;
            for(int i=0; i<4; i++){
                int px = now.x + mx[i];
                int py = now.y + my[i];
                if(px>0 && py>0 && px<=N && py<=M){
                    //1. 빙산일 때
                    if(!visited[px][py] && map[px][py]>0){
                        visited[px][py] = true;
                        qu.add(new Node(px,py));
                    }
                    if(map[px][py]==0){
                        count++;
                    }
                }
            }
            temp[now.x][now.y] = Math.max(0,(map[now.x][now.y]-count)); // 빙하 크기는 음수가 있을 수 없음
        }
    }
    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
