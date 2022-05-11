package BaekJoon.P14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14888
 * [14888번: 연산자 끼워넣기]-Sliver1
 */

public class Main {
    static int N;
    static int[] nums;
    static int[] cal;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        cal = new int[4];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void dfs(int depth, int num){
        if(depth == N){
            min = Math.min(min,num);
            max = Math.max(max,num);
            return;
        }
        for(int i=0; i<4; i++){
            if(cal[i]>0){
                cal[i]--;
                switch (i){
                    case 0 :
                        dfs(depth+1,num + nums[depth]);
                        break;
                    case 1 :
                        dfs(depth+1,num - nums[depth]);
                        break;
                    case 2 :
                        dfs(depth+1,num * nums[depth]);
                        break;
                    case 3 :
                        dfs(depth+1,num / nums[depth]);
                        break;
                }
                cal[i]++;
            }
        }
    }
}
