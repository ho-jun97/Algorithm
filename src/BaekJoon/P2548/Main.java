package BaekJoon.P2548;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2548
 * [2548번: 대표 자연수]-Sliver3
 */

public class Main {
    static int N;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new int[N];
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int value = 0;
        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=0; j<N; j++){
                int dis = Math.abs(list[i]-list[j]);
                sum += dis;
            }
            if(min > sum) {
                min = sum;
                value = list[i];
            }else if(min==sum){
                value = Math.min(value,list[i]);
            }
        }
        System.out.println(value);
    }
}
