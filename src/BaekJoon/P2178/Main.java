package BaekJoon.P2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2178
 * [2178번:미로 탐색]-Sliver1
 */

public class Main {
    static int N,M;
    static int[][] map;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static boolean[][] visited;
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = (str.charAt(j-1) - '0');
            }
        }
        BFS(1,1);
        System.out.println(map[N][M]);

    }
    static void BFS(int startX, int startY){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX,startY));

        while(!queue.isEmpty()){
            Node now = queue.poll();
            visited[now.x][now.y] = true; // 방문처리

            for(int i=0; i<4; i++){ // 상하좌우 확인
                int px = now.x + mx[i];
                int py = now.y + my[i];
                if(px > 0 && py >0 && px <=N && py <=M){ // map 범위 안에 있을 때
                    if(map[px][py]==1 && !visited[px][py]){ // 방문하지 않고 값이 1일 때
                        queue.add(new Node(px,py)); //  큐에 저장
                        map[px][py] = map[now.x][now.y] + 1; // 개수 카운트
                    }
                }
            }
        }
    }
}
