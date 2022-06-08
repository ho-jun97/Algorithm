package BaekJoon.P1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1697
 * [1697번: 숨바꼭질]-Silver1
 */

public class Main {
    static int N,K;
    static int[] time = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N);
        System.out.println(time[K]); // 해당 지점 시간 출력
    }
    static void bfs(int num){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(num);
        while(!qu.isEmpty()){
            int n = qu.poll();
            if(n == K){ //K에 도달했을 때
                break;
            }
            if(n-1 >= 0 && time[n-1]==0){ // n-1 0보다 클 때
                time[n-1] = time[n] + 1;
                qu.add(n-1);
            }
            if(n+1 <= 100000 && time[n+1]==0){  //  n+1 최대치를 넘지 않았을 때
                time[n+1] = time[n] + 1;
                qu.add(n+1);
            }
            if(n*2 <= 100000 && time[n*2]==0){ //  n*2 최대치를 넘지 않았을 때
                time[n*2] = time[n] + 1;
                qu.add(n*2);
            }
        }
    }
}
