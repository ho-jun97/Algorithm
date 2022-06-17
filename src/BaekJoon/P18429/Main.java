package BaekJoon.P18429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18429
 * [18429: 근손실]-Silver3
 */

public class Main {
    static int N,K;
    static int[] kit;
    static boolean[] visited;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kit = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            kit[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr = new int[N];
        dfs(0,arr);
        System.out.println(answer);
    }
    static void dfs(int depth,int[] arr){
        if(depth == N){
            if(check(arr)){
                answer++;
            }
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = kit[i];
                dfs(depth+1,arr);
                visited[i] = false;
            }
        }
    }
    static boolean check(int[] arr){
        int sum = 500;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            sum -= K;
            if(sum<500) return false;
        }
        return true;
    }
}
