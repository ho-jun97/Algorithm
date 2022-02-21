package BaekJoon.P7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7576
 * [7576번: 토마토]-Gold5
 */

public class Main {
    static int M,N;
    static int[][] Map;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new int[M+1][N+1];
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = BFS();
        if(check()){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }
    }
    static boolean check(){ // 토마토 전체가 익었는지 확인하는 함수
        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                if(Map[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
    static int BFS(){
        // 1. 처음 익은 토마토의 위치들을 queue에 저장한다.
        Queue<Node> queue = new LinkedList<>();
        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                if(Map[i][j]==1){
                    queue.add(new Node(i,j,0));
                }
            }
        }
        int count=0; // 날짜 카운트
        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){ // 현재 토마토의 (좌 우 앞 뒤)를 확인한다.
                int px = now.x + mx[i];
                int py = now.y + my[i];

                if(px>0 && py>0 && px<=M && py<=N){ // 범위 안에 있을 때
                    if(Map[px][py]==0){ // 익지않은 토마토일 때
                        Map[px][py] = 1; // 익은 토마토로 변경
                        queue.add(new Node(px,py,now.day+1)); // 현재 토마토로 인해서 익은 토마토 큐에 저장
                        count = Math.max(now.day+1,count); // 최대 날짜
                    }
                }
            }
        }
        return count;
    }
    static class Node{
        int x;
        int y;
        int day; // 해당 토마토가 시작일로부터 언제 익었는지 확인하는 변수
        public Node(int x,int y,int day) {
            this.x = x;
            this.y = y;
            this.day=day;
        }
    }
}
