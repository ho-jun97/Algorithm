package BaekJoon.P1758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/1758
 * [1758번: 알바생 강호]-Sliver4
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Integer[] list = new Integer[N];
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list, Collections.reverseOrder());
        long answer = 0;
        for(int i=0; i<N; i++){
            // 음수가 아닐 때만 팁을 받는다.
            if(list[i]-((i+1)-1) > 0){
                answer += list[i] - ((i+1)-1);
            }
        }
        System.out.println(answer);
    }
}
