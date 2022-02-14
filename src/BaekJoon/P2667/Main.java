package BaekJoon.P2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2667
 * [2667번: 단지번호붙이기]-Sliver1
 */

public class Main {
    static int N;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] maps;
    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        maps = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        // map 초기화
        for(int i=1; i<=N; i++){
            String[] str = br.readLine().split("");
            for(int j=1; j<=N; j++) {
                maps[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(!visited[i][j] && maps[i][j]==1){
                    answer.add(BFS(i,j));
                }
            }
        }
        Collections.sort(answer); // 오름차순 정렬
        System.out.println(answer.size()); // answer의 크기 = 단지의 수
        for (int i = 0; i <answer.size() ; i++) {
            System.out.println(answer.get(i));
        }
    }
    static int BFS(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y] = true;

        int count=1;
        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){ // 현재의 집의 상하좌우 확인 후 큐에 저장
                int px = now.x + mx[i];
                int py = now.y + my[i];
                if(px >0 && py>0 && px<=N && py <=N){
                    if(maps[px][py]==1 && !visited[px][py]){
                        count++; // 집 증가
                        visited[px][py] = true; // 집 방문 처리
                        queue.add(new Node(px,py));
                    }
                }
            }
        }
        return count;
    }
}
