package BaekJoon.P13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13549
 * [13549번: 숨바꼭질 3]-Gold5
 */

public class Main {
    static int N,K;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int M = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[M*2];
        if(N==K){
            System.out.println(0);
        }else {
            bfs(N);
            System.out.println(min);
        }
    }
    static void bfs(int start){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start,0));
        visited[start] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.num==K){
                min = Math.min(min,now.time);
            }
            if(now.num*2 <= M && !visited[now.num*2]){
                visited[now.num*2] =true;
                queue.add(new Node(now.num*2, now.time));
            }
            if(now.num-1 >= 0 && !visited[now.num-1]){
                visited[now.num-1] =true;
                queue.add(new Node(now.num-1, now.time+1));
            }
            if(now.num+1 <= M && !visited[now.num+1]){
                visited[now.num+1] =true;
                queue.add(new Node(now.num+1, now.time+1));
            }
        }

    }
    static class Node{
        int num;
        int time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

}
