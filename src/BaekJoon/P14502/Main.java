package BaekJoon.P14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14502
 * [14502번: 연구소]-Gold5
 */

public class Main {
    static int N,M;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int[][] map;
    static int[][] wall;
    static int max = 0;
    static ArrayList<Node> virus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        virus = new ArrayList<>();
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    virus.add(new Node(i,j));
                }
            }
        }

        wall = copy(map);

        DFS(0);

        System.out.println(max);

    }
    static int[][] copy(int[][] arr){
        int[][] copy = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }
    static void DFS(int depth){
        if(depth==3){
            BFS();
            return;
        }else{
            for(int i=1; i<=N; i++){
                for(int j=1; j<=M; j++){
                    if(wall[i][j]==0){
                        wall[i][j]=1;
                        DFS(depth+1);
                        wall[i][j]=0;
                    }
                }
            }
        }
    }
    static void BFS(){

        int[][] copyWall = copy(wall);
        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<virus.size(); i++){
            queue.add(new Node(virus.get(i).x, virus.get(i).y));
        }
        while(!queue.isEmpty()){
            Node now = queue.poll();
            for (int i=0; i<4; i++){
                int px = now.x + mx[i];
                int py = now.y + my[i];

                if(px>0 && py>0 && px<=N && py<=M){
                    if(copyWall[px][py]==0){
                        copyWall[px][py]=2;
                        queue.add(new Node(px,py));
                    }
                }
            }
        }
        int count = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(copyWall[i][j]==0){
                    count++;
                }
            }
        }
        max = Math.max(max,count);
    }
    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
