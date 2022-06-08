package BaekJoon.P1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1012
 * [1012번: 유기농 배추]-Silver2
 */

public class Main {
    static int T;
    static int M,N,K;
    static int[][] map;
    static boolean[][] visited;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수
            map = new int[M + 1][N + 1];
            visited = new boolean[M + 1][N + 1];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a+1][b+1] = 1;

            }
            int count=0;
            for(int i=1; i<=M; i++){
                for(int j=1; j<=N; j++){
                    if(!visited[i][j] && map[i][j]==1){
                        count++;
                        BFS(i,j);
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void BFS(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){
                int px = now.x + mx[i];
                int py = now.y + my[i];
                if(px>0 && py>0 && px<=M && py<=N){
                    if(!visited[px][py] && map[px][py]==1){
                        visited[px][py] = true;
                        queue.add(new Node(px,py));
                    }
                }
            }
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
