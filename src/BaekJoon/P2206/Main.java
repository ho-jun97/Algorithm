package BaekJoon.P2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2206
 * [2206번: 벽 부수고 이동하기]-Gold4
 */

public class Main {
    static int N,M;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int[][] map;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = (str.charAt(j-1)-'0');
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.println(bfs(1,1));

    }
    static int bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,1, 0));
        visited[x][y] = 0;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.x ==N && now.y ==M){
                return now.count;
            }
            for(int i=0; i<4; i++){
                int px = now.x + mx[i];
                int py = now.y + my[i];
                if(px>0 && py>0 && px<=N && py<=M){
                    if(visited[px][py] > now.crack) {
                        if (map[px][py] == 0) {
                            visited[px][py] = now.crack;
                            queue.add(new Node(px, py, now.count + 1, now.crack));
                        } else {
                            if (now.crack==0) {
                                visited[px][py] = now.crack+1;
                                queue.add(new Node(px, py, now.count + 1, now.crack+1));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    static class Node{
        int x,y;
        int count;
        int crack;
        public Node(int x, int y, int count, int crack ) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.crack = crack;
        }
    }
}
