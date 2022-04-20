package BaekJoon.P2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2468
 * [2468번: 안전 영역]-Sliver1
 */

public class Main {
    static int N;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        StringTokenizer st;
        int maxHeight = 0; // 제일 높은 높이
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight,map[i][j]);
            }
        }

        int result = 1;
        for(int limit = 1; limit<=maxHeight; limit++){
            boolean[][] visited = new boolean[N+1][N+1];
            int count = 0;

            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(map[i][j]> limit && !visited[i][j]){
                        count++;
                        bfs(limit, visited, i, j);
                    }
                }
            }
            result = Math.max(result,count);
        }
        System.out.println(result);
    }
    static void bfs(int limit, boolean[][] visited, int x, int y){
        visited[x][y] = true; // 방문처리

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0; i<4; i++){
                int px = node.x + mx[i];
                int py = node.y + my[i];
                if(px>0 && py>0 && px<=N && py<=N){
                    if(map[px][py]>limit && !visited[px][py]){
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
