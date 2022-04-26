package BaekJoon.P10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10026
 * [10026번: 적록색약]-Gold5
 */

public class Main {
    static char[][] map;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int N;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N+1][N+1];

        StringTokenizer st;
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=N; j++){
                map[i][j] = str.charAt(j-1);
            }
        }
        StringBuilder sb = new StringBuilder();
        check = false; // 적록색맹이 아님
        int count=0;
        boolean[][] visited = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(!visited[i][j]){
                    count++;
                    bfs(i,j,visited);
                }
            }
        }
        sb.append(count).append(" ");
        count=0;
        check = true; // 적록색맹임
        visited = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(!visited[i][j]){
                    count++;
                    bfs(i,j,visited);
                }
            }
        }
        sb.append(count);
        System.out.println(sb.toString());
    }
    static void bfs(int x, int y, boolean[][] visited){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,map[x][y]));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){
                int px = now.x + mx[i];
                int py = now.y + my[i];

                if(px>0 && py>0 && px<=N && py<=N){
                    if(check && !visited[px][py]){ // 적록색약이면서 방문하지 않았을 때
                        if(now.color == 'R' || now.color == 'G') { // R 이거나 G 일 때
                            if (map[px][py] == 'R' || map[px][py] == 'G') { // R G 구분 없이 방문처리
                                visited[px][py] = true;
                                queue.add(new Node(px, py, map[px][py]));
                            }
                        }else{
                            if(now.color == map[px][py]){
                                visited[px][py] = true;
                                queue.add(new Node(px, py, map[px][py]));
                            }
                        }
                    } else{ // 적록색이 아니고 방문하지 않았을 때
                        if(!visited[px][py] && now.color == map[px][py]){
                            visited[px][py] = true;
                            queue.add(new Node(px,py,map[px][py]));
                        }
                    }
                }
            }
        }
    }
    static class Node{
        int x,y;
        char color;

        public Node(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
