package BaekJoon.P9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9205
 * [9205번: 맥주 마시면서 걸어가기]-Silver1
 */

public class Main {
    static int T;
    static int n;
    static int startX,startY,endX,endY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            n = Integer.parseInt(br.readLine());
            Node[] list = new Node[n];

            for(int i=0; i<n+2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(i==0){
                    startX = x;
                    startY = y;
                }else if(i==n+1){
                    endX = x;
                    endY = y;
                }else{
                    list[i-1] = (new Node(x,y));
                }
            }
            if(bfs(list)){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
        }
    }
    static boolean bfs(Node[] list){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX,startY));
        boolean[] visited = new boolean[n];

        while(!queue.isEmpty()){
            Node now = queue.poll();

            int dis = Math.abs(now.x-endX)+Math.abs(now.y-endY);
            if(dis<=1000){
                return true;
            }
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    if(Math.abs(now.x-list[i].x)+Math.abs(now.y-list[i].y) <=1000){
                        visited[i] = true;
                        queue.add(new Node(list[i].x, list[i].y));
                    }
                }
            }
        }
        return false;
    }
    static class Node{
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
