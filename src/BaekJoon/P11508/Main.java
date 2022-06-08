package BaekJoon.P11508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/11508
 * [11508번: 2+1 세일]-Silver4
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Integer[] list = new Integer[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list, Collections.reverseOrder());

        int answer=0;
        for(int i=0; i<N; i++){
            if(!(i%3==2)){
                answer += list[i];
            }
        }
        System.out.println(answer);
    }
}
