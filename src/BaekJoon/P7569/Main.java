package BaekJoon.P7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7569
 * [7569번: 토마토]-Gold5
 */

public class Main {
    static int M,N,H;
    static int[][][] map;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int[] mh = {1,-1};
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H + 1][N + 1][M + 1];

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k]==1){
                        list.add(new Node(i,j,k,0));
                    }
                }
            }
        }
        int answer = bfs();
        if(check()){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }
    }
    static boolean check(){
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if(map[i][j][k]==0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        for(Node node : list) {
            queue.add(node);
        }
        int count=0;
        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){ // 앞 뒤 왼쪽 오른쪽
                int px = now.x + mx[i];
                int py = now.y + my[i];
                if(px>0 && py>0 && px<=N && py<=M){
                    if(map[now.h][px][py]==0){
                        map[now.h][px][py] = 1;
                        queue.add(new Node(now.h,px,py,now.day+1));
                        count = Math.max(count,now.day+1);
                    }
                }
            }
            for(int i=0; i<2; i++){
                int ph = now.h + mh[i];
                if(ph >0 && ph<=H){
                    if(map[ph][now.x][now.y]==0){
                        map[ph][now.x][now.y]=1;
                        queue.add(new Node(ph,now.x, now.y, now.day+1));
                        count = Math.max(count,now.day+1);
                    }
                }
            }
        }
        return count;
    }
    static class Node{
        int h,x,y;
        int day;
        public Node(int h, int x, int y,int day) {
            this.h = h;
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
