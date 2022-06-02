package BaekJoon.P17780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17780
 * [17780번: 새로운 게임]-Gold2
 */

public class Main {
    static int N,K;
    static int[][] map;
    static Node[] list;
    static LinkedList<Integer>[][] stat;

    static final int WHITE = 0, RED = 1, BLUE = 2;
    static int[] mx = {0,0,-1,1};
    static int[] my = {1,-1,0,0};
    static int[] change = {1,0,3,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        stat = new LinkedList[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                stat[i][j] = new LinkedList<>();
            }
        }
        list = new Node[K+1];
        for(int i=1; i<=K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;
            list[i] = new Node(x,y,d);
            stat[x][y].add(i);
        }
        System.out.println(function());
    }
    static int function(){
        boolean ch = true;
        int time=0;
        while(ch){
            time++;
            if(time>1000){
                break;
            }
            for(int i=1; i<=K; i++){
                Node now = list[i];
                int x = now.x;
                int y = now.y;
                // 제일 아래쪽 말인지 확인
                if(stat[x][y].get(0) != i){
                    continue;
                }
                int px = x + mx[now.dir];
                int py = y + my[now.dir];
                // 파란색일 경우 or 범위를 벗어날 경우
                if(!check(px,py) || map[px][py]==BLUE){
                    now.dir = change[now.dir];
                    px = x + mx[now.dir];
                    py = y + my[now.dir];
                }
                // 방향 바꾸고 이동하려는 칸이 파란색일 경우
                if(!check(px,py) || map[px][py]==BLUE){
                    continue;
                }else if(map[px][py] == RED){ // 빨간색인 경우
                    for(int j=stat[x][y].size()-1; j>=0; j--){
                        int temp = stat[x][y].get(j);
                        stat[px][py].add(temp);
                        list[temp].x = px;
                        list[temp].y = py;
                    }
                    stat[x][y].clear();
                }else{ // 흰색일 경우
                    for(int j=0; j < stat[x][y].size(); j++){
                        int temp = stat[x][y].get(j);
                        stat[px][py].add(temp);
                        list[temp].x = px;
                        list[temp].y = py;
                    }
                    stat[x][y].clear();
                }
                if(stat[px][py].size() >= 4){
                    ch = false;
                    break;
                }
            }
        }
        return ch? -1:time ;
    }
    static boolean check(int x, int y){
        return 0<=x && x<N && 0<=y && y<N;
    }
    static class Node{
        int x,y;
        int dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
