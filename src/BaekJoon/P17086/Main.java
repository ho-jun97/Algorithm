package BaekJoon.P17086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17086
 * [17086번: 아기 상어2]-Silver2
 */

public class Main {
    static int N,M;
    static int[][] map;
    static int[] dx = {-1,1,0,0,-1,1,-1,1};
    static int[] dy = {0,0,-1,1,-1,-1,1,1};
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                bfs(i,j);
            }
        }
        System.out.println(answer);
    }
    static void bfs(int x, int y){
        visited = new boolean[N+1][M+1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,0));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(map[now.x][now.y]==1){
                answer = Math.max(answer, now.count);
                break;
            }
            for(int i=0; i<8; i++){
                int px = now.x + dx[i];
                int py = now.y + dy[i];

                if(px>0 && py>0 & px<=N && py<=M){
                    if(!visited[px][py]){
                        visited[px][py] = true;
                        queue.add(new Node(px,py,now.count+1));
                    }
                }
            }
        }

    }
    static class Node{
        int x,y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
