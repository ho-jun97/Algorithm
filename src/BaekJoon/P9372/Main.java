package BaekJoon.P9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9372
 */
public class Main {
    static int T;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 나라의 수
            int M = Integer.parseInt(st.nextToken()); // 비행기의 종류

            ArrayList<Integer>[] list = new ArrayList[N+1];
            visited = new boolean[N+1];
            for (int j = 1; j <= N; j++) {
                list[j] = new ArrayList<>();
            }

            // 해당 비행기 종류 연결
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(1); // 처음 시작 큐에 저장
            int count=0;
            while(!queue.isEmpty()){
                int now = queue.poll();
                for(Integer next : list[now]){
                    if(!visited[next]){ // 방문하지 않았을 때
                        visited[next] = true;
                        count++;
                        queue.add(next);
                    }
                }
            }
            System.out.println(count-1); // 개수 - 1
        }
    }
}
