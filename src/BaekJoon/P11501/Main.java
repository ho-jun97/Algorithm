package BaekJoon.P11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11501
 * [11501번: 주식]-Silver2
 */

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] list = new int[n];
            int max = 0;
            long answer = 0;
            for(int i=0; i<n; i++){
                list[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=n-1; i>=0; i--){
                if(max<list[i]){
                    max=list[i];
                }else{
                    answer += (max-list[i]);
                }
            }
            System.out.println(answer);
        }
    }
}