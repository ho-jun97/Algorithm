package BaekJoon.P18428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18428
 * [18428번: 감시 피하기]-Silver1
 */

public class Main {
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static char[][] block;
    static ArrayList<Node> students;
    static String answer="NO";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new char[N+1][N+1];
        block = new char[N+1][N+1];
        students = new ArrayList<>();
        for(int i=1; i<=N; i++){
            char[] temp = br.readLine().replaceAll(" ","").toCharArray();
            for(int j=1; j<=N; j++){
                map[i][j] = temp[j-1];
                if(map[i][j] == 'S'){
                    students.add(new Node(i,j));
                }
            }
        }
        block = copy(map);
        dfs(0);
        System.out.println(answer);
    }
    static char[][] copy(char[][] arr){
        char[][] temp = new char[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }
    // 모든 장애물 경의 수를 찾는다.
    static void dfs(int depth){
        if(depth==3){
            if(bfs()){
                answer = "YES";
            }
            return;
        }else{
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(block[i][j]=='X'){
                        block[i][j] = 'O';
                        dfs(depth+1);
                        block[i][j] = 'X';
                    }
                }
            }
        }
    }
    // 장애물 경의 수에서 판단하기
    static boolean bfs(){
        char[][] copyBlock = copy(block);
        Queue<Node> queue = new LinkedList<>();
        for(Node n : students){
            queue.add(n);
        }
        boolean check = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){
                int px = now.x + dx[i];
                int py = now.y + dy[i];
                while(true) {
                    if (px > 0 && py > 0 && px <= N && py <= N) {
                        if (copyBlock[px][py] == 'T'){ // 선생님과 마주칠 때
                            return false;
                        }else if(copyBlock[px][py] == 'O') {// 벽일 때
                            break;
                        }
                    }else{
                        break;
                    }
                    px += dx[i];
                    py += dy[i];
                }
            }
        }
        return true;
    }
    static class Node{
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
