package BaekJoon.P4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4963
 * [4969번: 섬의 개수]-Sliver2
 */

public class Main {
    // 상 하 좌 우 대각선 을 위한 변수
    static int[] mx = {1, -1, 0, 0, 1, -1, -1, 1};
    static int[] my = {0, 0, 1, -1, -1, -1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0){
                break;
            }

            int[][] map = new int[h+1][w+1];
            for(int i=1; i<=h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count=0;
            boolean[][] visited = new boolean[h+1][w+1];
            for(int i=1; i<=h; i++){
                for(int j=1; j<=w; j++){
                    if(!visited[i][j] && map[i][j]==1){
                        count++;
                        bfs(map,w,h,i,j,visited);
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb.toString());
    }
    static void bfs(int[][] map, int w, int h, int x, int y, boolean[][] visited){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0; i<8; i++){
                int px = node.x + mx[i];
                int py = node.y + my[i];

                if(px>0 && py>0 && px<=h && py<=w){
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
