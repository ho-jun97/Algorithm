package BaekJoon.P2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2012
 * [2012번: 등수 매기기]-Silver3
 */

public class Main {
    static int N;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N+1];

        for(int i=1; i<=N; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list); // 오름차순 정렬

        long answer = 0;
        for(int i=1; i<=N; i++){
            answer += Math.abs(list[i]-i);
        }
        System.out.println(answer);
    }
}
