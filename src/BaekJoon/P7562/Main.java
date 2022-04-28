package BaekJoon.P7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7562
 * [7562번: 나이트의 이동]-Sliver1
 */

public class Main {
    static int T;
    static int[] mx = {-1,-2,-2,-1, 1, 2, 2, 1};
    static int[] my = {-2,-1, 1, 2, 2, 1,-1,-2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            int c = bfs(N,startX, startY, endX, endY, map, visited);
            sb.append(c).append('\n');
        }
        System.out.println(sb.toString());
    }
    static int bfs(int size,int startX, int startY, int endX, int endY, int[][] map, boolean[][] visited){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX,startY,0));
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.x==endX && now.y==endY){
                return now.count;
            }
            for(int i=0; i<8; i++){
                int px = now.x+mx[i];
                int py = now.y+my[i];
                if(px>=0 && py>=0 && px<size && py<size){
                    if(!visited[px][py]){
                        queue.add(new Node(px,py,now.count+1));
                        visited[px][py] = true;
                    }
                }
            }
        }
        return -1;
    }
    static class Node{
        int x,y;
        int count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
