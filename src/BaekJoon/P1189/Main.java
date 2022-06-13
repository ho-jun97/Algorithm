package BaekJoon.P1189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1189
 * [1189번: 컴백홈]-Silver1
 */

public class Main {
    static int R,C,K;
    static char[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer =0;
    static boolean[][] visited;
    static Node end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R+1][C+1];
        visited = new boolean[R+1][C+1];
        for(int i=1; i<=R; i++){
            String str = br.readLine();
            for(int j=1; j<=C; j++){
                map[i][j] = str.charAt(j-1);
            }
        }
        Node start = new Node(R,1);
        end = new Node(1,C);
        visited[R][1] = true;
        dfs(1,start);
        System.out.println(answer);
    }
    static void dfs(int depth, Node node){
        if(depth == K){
            if(node.x == end.x && node.y == end.y){
                answer++;
            }
            return;
        }
        for(int i=0; i<4; i++){
            int px = node.x + dx[i];
            int py = node.y + dy[i];
            if(px>0 && py>0 && px<=R && py<=C){ // 범위 안에 있을 때
                if(!visited[px][py] && map[px][py] != 'T'){ // 방문하지 않고 T(가지 못하는 곳)가 아닐 때
                    visited[px][py] = true;
                    dfs(depth+1, new Node(px,py));
                    visited[px][py] = false;
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
