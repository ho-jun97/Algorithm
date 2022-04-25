package BaekJoon.P2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2583
 * [2583번: 영역 구하기]-Sliver1
 */

public class Main {
    static int M,N,K;
    static int[][] map;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int count;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y = y1; y<y2; y++){
                for(int x = x1; x<x2; x++){
                    map[y][x] = 1;
                }
            }
        }
        answer = new ArrayList<>();

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==0){
                    count=0;
                    dfs(i,j);
                    answer.add(count);
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        answer.forEach(o->System.out.print(o+" "));
    }
    static void dfs(int x, int y){
        map[x][y] = 1;
        count++;
        for(int i=0; i<4; i++){
            int px = x + mx[i];
            int py = y + my[i];

            if(px>=0 && py>=0 && px<M && py<N){
                if(map[px][py]==0){
                    dfs(px,py);
                }
            }
        }
    }
}
