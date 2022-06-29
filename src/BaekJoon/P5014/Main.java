package BaekJoon.P5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5014
 * [5014번: 스타트링크]-Gold5
 */

public class Main {
    static int F,S,G,U,D;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 건물의 크기
        S = Integer.parseInt(st.nextToken()); // 강호가 있는 위치
        G = Integer.parseInt(st.nextToken()); // 스타트 링크
        U = Integer.parseInt(st.nextToken()); // 위로 올라갈 수 있는 칸 수
        D = Integer.parseInt(st.nextToken()); // 아래로 내려갈 수 있는 칸 수

        arr = new int[F+1];
        int n;
        if((n=bfs(S))==-1){
            System.out.println("use the stairs");
        }else{
            System.out.println(n);
        }

    }
    static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        arr[start] = 1;
        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == G){
                return arr[now]-1;
            }
            if(now + U <= F){
                if(arr[now+U]==0){
                    arr[now+U] = arr[now]+1;
                    queue.add(now+U);
                }
            }
            if(now - D > 0){
                if(arr[now-D]==0){
                    arr[now-D] = arr[now]+1;
                    queue.add(now-D);
                }
            }
        }
        return -1;
    }

}
