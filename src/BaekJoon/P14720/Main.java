package BaekJoon.P14720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14720
 * [14720번: 우유 축제]-Bronze3
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        /*
        0 : 딸기 우유
        1 : 초코 우유
        2 : 바나나 우유
         */
        int type = 0;
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(type==temp){
                count++;
                if(type==2){
                    type=0;
                }else {
                    type++;
                }
            }
        }
        System.out.println(count);
    }
}
