package BaekJoon.P16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/16236
 * [16236번: 아기 상어]-Gold3
 */

public class Main {
    static int N;
    static int[][] map;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int size;
    static PriorityQueue<Node> eat;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        int startX=0, startY=0;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }
        size = 2;
        int answer=0;
        int eatCount=0;
        while(true) {
            eat = new PriorityQueue<>();
            visited = new boolean[N+1][N+1];

            bfs(startX, startY);

            if(eat.size()==0){
                break;
            }
            else{
                Node n = eat.poll(); // 먹을 수 있는게 있으면 한개 먹기
                map[n.x][n.y] = 0; // 먹고 난 뒤 빈 칸 처리
                answer += n.dis; // 거리 더하기
                eatCount++; // 먹은 개수 추가
                startX = n.x;
                startY = n.y;
            }
            if(eatCount==size){
                size++;
                eatCount=0;
            }
        }
        System.out.println(answer);
    }
    static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,0));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){
                int px = now.x + mx[i];
                int py = now.y + my[i];

                if(px>0 && py>0 && px<=N && py<=N){
                    if (!visited[px][py] && 0 <= map[px][py] && map[px][py] <=size) { // 지나갈 수 있는 조건
                        visited[px][py] = true;
                        queue.add(new Node(px, py, now.dis + 1));
                        if(0 < map[px][py] && map[px][py] < size){ // 먹을 수 있는 조건
                            eat.add(new Node(px, py, now.dis + 1));
                        }
                    }
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int x,y;
        int dis;
        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            int com1 = Integer.compare(this.dis, o.dis); // 거리 가까운 수
            if(com1==0){
                int com2 = Integer.compare(this.x, o.x); // 물고기가 위쪽에 가까운 순서
                if(com2==0){
                    return  Integer.compare(this.y,o.y); // 물고기 왼쪽에 가까운 순서
                }
                return com2;
            }
            return com1;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dis=" + dis +
                    '}';
        }
    }
}
