package BaekJoon.P2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2606
 * [2606번: 바이러스] - Sliver3
 */

public class Main {
    static int N;
    static int M;
    static boolean[] virus;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        virus = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        // computer 연결하기
        StringTokenizer st;
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        System.out.println(BFS());
    }
    static int BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        virus[1] = true;
        int count=0;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : arr[now]){
                if(!virus[next]){ // 바이러스 감염 되지 않은 컴퓨터일 때
                    virus[next] = true; // 감염시키기
                    queue.add(next); // 큐에 저장
                    count++; // 감염된 컴퓨터 수 +
                }
            }
        }
        return count;
    }
}
