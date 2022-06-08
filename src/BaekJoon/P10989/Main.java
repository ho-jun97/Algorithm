package BaekJoon.P10989;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/10989
 * [10989번: 수 정렬하기 3]-Silver5
 */

public class Main{
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            count[num]++;
        }
        StringBuilder sb = new StringBuilder();
        // Counting sort - 계수 정렬 이용
        for(int i=1; i<10001; i++){
            for(int j=0; j<count[i]; j++){
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
